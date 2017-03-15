package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Filedata;
import com.example.repositories.FiledataRepository;

@Service
public class FiledataServiceImpl implements FiledataService {

	private Logger log = Logger.getLogger(FiledataServiceImpl.class);

	@Autowired
	private FiledataRepository filedataRepository;

	// get file data from database
	@Transactional
	public List<Filedata> getdata() {

		Iterable<Filedata> it = filedataRepository.findAll();
		List<Filedata> plist = new ArrayList<Filedata>();
		for (Filedata p : it) {
			plist.add(p);
		}
		return plist;
	}

	// save file data string into database for further processing
	@Transactional
	public void savedata(Filedata data) {

		filedataRepository.saveAndFlush(data);

	};

}
