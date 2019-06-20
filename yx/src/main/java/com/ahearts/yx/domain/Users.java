package com.ahearts.yx.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Users {
	private int id;
	private String username;
	private String userpasswd;
	private String useremail;
	private String userphone;
	private int userlevel;
	private Date userbrith;
	private List<Carts> carts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpasswd() {
		return userpasswd;
	}
	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public int getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	public Date getUserbrith() {
		return userbrith;
	}
	public void setUserbrith(Date userbrith) {
		this.userbrith = userbrith;
	}
	public List<Carts> getCarts() {
		return carts;
	}
	public void setCarts(List<Carts> carts) {
		this.carts = carts;
	}	
}
