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
public class Filefield implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7901907947129917597L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String filename;

	@Column
	private Integer balance;
	
	@Column
	private Integer income;
	
	@Column
	private Integer risklevel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Integer getRisklevel() {
		return risklevel;
	}

	public void setRisklevel(Integer risklevel) {
		this.risklevel = risklevel;
	}


}
