package com.example.loader;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.model.Filefield;
import com.example.repositories.FilefieldRepository;

@Component
public class FilefieldLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private FilefieldRepository filefieldRepository;

	private Logger log = Logger.getLogger(FilefieldLoader.class);

	// insert data into db

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Filefield file1 = new Filefield();
		file1.setId(1);
		file1.setFilename("we love spring roll");
		file1.setBalance(34);
		file1.setIncome(23);
		file1.setRisklevel(90);
		filefieldRepository.save(file1);

		log.info("Saved file1 - id: " + file1.getId());

		Filefield file2 = new Filefield();
		file2.setId(2);
		file2.setFilename("we are the world");
		file2.setBalance(3467887);
		file2.setIncome(238768);
		file2.setRisklevel(90897);
		filefieldRepository.save(file2);

		log.info("Saved file2 - id:" + file2.getId());

		Filefield file3 = new Filefield();
		file3.setId(3);
		file3.setFilename("some day dream");
		file3.setBalance(7686);
		file3.setIncome(67);
		file3.setRisklevel(345);
		filefieldRepository.save(file3);

		log.info("Saved file3 - id: " + file3.getId());

		Filefield file4 = new Filefield();
		file4.setId(4);
		file4.setFilename("only this time");
		file4.setBalance(67);
		file4.setIncome(4);
		file4.setRisklevel(78);
		filefieldRepository.save(file4);

		log.info("Saved file4 - id:" + file4.getId());
	}
}
