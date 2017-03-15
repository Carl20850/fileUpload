package com.example.service;

import java.util.List;

import com.example.model.Filedata;

public interface FiledataService {

	List<Filedata> getdata();
	
	void savedata(Filedata data);
}
