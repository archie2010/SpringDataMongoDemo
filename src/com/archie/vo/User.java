package com.archie.vo;

public class User {
	private String uname;
	private String upwd;
	
	public User(String uname,String upwd){
		this.uname=uname;
		this.upwd=upwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String toString() {
		return "[用户信息：UName:"+uname+"\tUpwd:"+upwd+"]";
	}
	
}
