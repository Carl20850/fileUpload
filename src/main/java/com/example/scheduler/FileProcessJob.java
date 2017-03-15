package com.example.scheduler;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.manager.FileManager;

@Component
public class FileProcessJob {

	private Logger log = Logger.getLogger(FileProcessJob.class);

	@Autowired
	private FileManager fileManager;

	@Scheduled(fixedRate = 60*60*1000)
	public void processTask() {
		
	    // process file hourly
	    //fileManager.ProcessTaskHourly();

		// No time to write Send Volicity Email 
		
		log.info("schedule job successful");
		
	}

}
