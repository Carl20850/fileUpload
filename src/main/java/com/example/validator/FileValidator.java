package com.example.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.example.model.Filefield;

@Component
public class FileValidator {
	private Logger log = Logger.getLogger(FileValidator.class);
	public boolean validate(Filefield fe){
		
		// log if failed
		
		return true;
	}

}
