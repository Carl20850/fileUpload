package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loader.FilefieldLoader;
import com.example.model.Filefield;
import com.example.repositories.FilefieldRepository;

@Service
public class FilefieldServiceImpl implements FilefieldService {

	private Logger log = Logger.getLogger(FilefieldServiceImpl.class);

	@Autowired
	private FilefieldRepository filefieldRepository;

	@Transactional
	public List<Filefield> getFiles() {

		Iterable<Filefield> it = filefieldRepository.findAll();
		List<Filefield> flist = new ArrayList<Filefield>();
		for (Filefield f : it) {
			flist.add(f);
		}
		return flist;
	}

	@Transactional
	public Filefield getFilefieldByName(String fileName) {

		Filefield file = filefieldRepository.findByFilename(fileName).get(0);

		return file;
	}

	@Transactional
	public List<Filefield> findByRisklevel(Integer id, Integer risk) {

		Iterable<Filefield> it = filefieldRepository.findByRisklevel(id, risk);
		List<Filefield> flist = new ArrayList<Filefield>();
		for (Filefield f : it) {
			flist.add(f);
		}
		return flist;
	}

	@Transactional
	public void saveFile(Filefield file) {

		filefieldRepository.save(file);

		log.info("Saved file - id: " + file.getId());
	}

}
