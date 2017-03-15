package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Filedata implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7933154602893416820L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer fid;
	
	@Column
	private String  filename;
	
	@Column
	private String  batchname;

	@Column
	private String  data;
	
	@Column	
    private Long size;

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
	

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getBatchname() {
		return batchname;
	}

	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}

    
    
}
