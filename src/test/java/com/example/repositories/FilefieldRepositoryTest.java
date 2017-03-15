package com.example.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.configuration.RepositoryConfiguration;
import com.example.model.Filefield;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { RepositoryConfiguration.class })
public class FilefieldRepositoryTest {

	@Autowired
	public FilefieldRepository filefieldRepository;

	@Test
	public void testSaveFilefield() {

		Filefield fe = new Filefield();

		fe.setFilename("test name");
		fe.setBalance(45);
		fe.setIncome(39);
		fe.setRisklevel(2);

		// save file, verify there is a file after save in db
		assertNull(fe.getId());
		filefieldRepository.save(fe);
		assertNotNull(fe.getId());

		// fetch from db

		Filefield fetchFe = filefieldRepository.findOne(fe.getId());

		// tow object should be same
		assertEquals(fe.getId(), fetchFe.getId());
		assertEquals(fe.getFilename(), fetchFe.getFilename());

	}

}
