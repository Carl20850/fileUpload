package com.example.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.example.model.Filedata;

@Component
public class FileUtil {

	private static final int BUFFER = 2048;

	private Logger log = Logger.getLogger(FileUtil.class);

	// read stream and get each file data
	public Filedata readStream(InputStream zipInputStream, ZipEntry zipEntry, String filename) {

		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		Filedata bean = null;

		try {
			bis = new BufferedInputStream(zipInputStream);
			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			int size;
			byte[] buffer = new byte[BUFFER];
			bos = new BufferedOutputStream(bao);

			while ((size = bis.read(buffer, 0, buffer.length)) != -1) {
				bos.write(buffer, 0, size);
			}
			bos.flush();
			bean = createBean(new String(bao.toByteArray()), zipEntry.getName(), filename, zipEntry.getSize());
			buffer = null;

		} catch (Exception e) {
			log.error(e.getMessage(), e);

		} finally {
			closeStreams(bos);
		}
		return bean;
	}

	private Filedata createBean(String data, String batchname, String filename, Long size) {

		Filedata bean = new Filedata();
		bean.setData(data);
		bean.setFilename(filename);
		bean.setBatchname(batchname);
		bean.setSize(size);
		log.info("Added to Upload List: " + bean.getFilename());

		return bean;
	}

	private void closeStreams(OutputStream os) {
		try {
			if (os != null) {
				os.close();
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

}
