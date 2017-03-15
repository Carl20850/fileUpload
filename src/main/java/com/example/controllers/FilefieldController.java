package com.example.controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manager.FileManager;
import com.example.model.Filefield;
import com.example.service.FilefieldService;
import com.example.utils.Constants;

@RestController
public class FilefieldController {

	private Logger log = Logger.getLogger(FilefieldController.class);

	@Autowired
	private FilefieldService filefieldService;

	@Autowired
	private FileManager fileManager;

	// Retrieve all file fields saved in database
	@RequestMapping("/files")
	public List<Filefield> findAllFilefield() {
		List<Filefield> users = filefieldService.getFiles();
		return users;
	}

	// get file with certain file name
	@RequestMapping("/files/{name}")
	public Filefield findFilefieldByName(@PathVariable String name) {
		Filefield file = filefieldService.getFilefieldByName(name);
		return file;
	}

	// get file with id and certain risk level
	@RequestMapping("fileId/{id}/risk/{risklevel}")
	public List<Filefield> findFilefieldByRisklevel(@PathVariable Integer id, @PathVariable Integer risklevel) {
		List<Filefield> files = filefieldService.findByRisklevel(id, risklevel);
		return files;
	}

	// upload file and save file field into database
	@RequestMapping("/readFile")
	public void readFile() {

		List<Filefield> files = new ArrayList<Filefield>();

		// test file path
		String path = System.getProperty("user.dir") + "/" + Constants.testPath;

		try {
			files = fileManager.getFileList(path);
		} catch (MarshalException e) {
			log.info("Read file -  " + e.getMessage());
		} catch (ValidationException e) {
			log.info("Read file -  " + e.getMessage());
		} catch (FileNotFoundException e) {
			log.info("Read file -  " + e.getMessage());
		}

		// save file fields to database table filefield

		for (Filefield file : files) {

			filefieldService.saveFile(file);

		}

	}

}
