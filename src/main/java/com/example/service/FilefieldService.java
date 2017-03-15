package com.example.service;

import java.util.List;

import com.example.model.Filefield;

public interface FilefieldService {

	List<Filefield> getFiles();
	
	void saveFile(Filefield file);
	
	Filefield getFilefieldByName(String fileName);
	
	List<Filefield> findByRisklevel(Integer id, Integer risk);
	
}
