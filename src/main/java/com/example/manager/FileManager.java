package com.example.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.apache.log4j.Logger;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Filefield;
import com.example.service.FiledataService;
import com.example.service.FilefieldService;
import com.example.service.FilefieldServiceImpl;
import com.example.utils.Constants;
import com.example.utils.FileFilter;
import com.example.utils.FileUtil;
import com.example.validator.FileValidator;

@Component
public class FileManager {

	@Autowired
	private FilefieldService filefieldService;
	
	@Autowired
	private FileValidator fileValidator;
	
	private Logger log = Logger.getLogger(FileManager.class);


	// get files in the path
	public List<Filefield> getFileList(String path)
			throws FileNotFoundException, MarshalException, ValidationException {

		File dir = new File(path);

		List<Filefield> fList = new ArrayList<Filefield>();

		for (File file : dir.listFiles(new FileFilter())) {
			FileReader reader;

			// Valid xml file, proceed if successful ......
			reader = new FileReader(file);
			Filefield fileField;
			fileField = (Filefield) Unmarshaller.unmarshal(Filefield.class, reader);
		
			boolean valid = fileValidator.validate(fileField);
			
			if (valid){
			fList.add(fileField);
			}
		}
		return fList;
	}

	// for stream process

	public boolean processFileStream(MultipartFile multipartFile) {

		boolean success = false;

		// MultipartFile stream process and call FileUtil.readStream(...),
		// process successful return success = true, else false.

		return success;
	}

	// for hourly job
	public boolean ProcessTaskHourly() throws FileNotFoundException, MarshalException, ValidationException {
		boolean success = false;

		// test file path
		String hourlyPath = "some path";
		
		File dir = new File(hourlyPath);

		for (File file : dir.listFiles(new FileFilter())) {
			FileReader reader;

			reader = new FileReader(file);
			Filefield fileField;
			fileField = (Filefield) Unmarshaller.unmarshal(Filefield.class, reader);

			filefieldService.saveFile(fileField);
			
			// delete the processed(saved to db) file so next hour files in dir are new files.
			file.delete();

		}

		return success;
	}

}
