package com.SE480.group8.wordleclone.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	private String email;
	private String pass;
	
	
	 
	public Account() {
		super();
	}
	public Account(Long uid, String email, String pass) {
		super();
		this.uid = uid;
		this.email = email;
		this.pass = pass;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Account [uid=" + uid + ", email=" + email + ", pass=" + pass + "]";
	}
	
	
	


}
