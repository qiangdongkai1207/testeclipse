package com.zzzy.vo;

public class studentVO {
	private int Id;
	private String username;
	private String password;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public studentVO(int id, String username, String password) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
	}
	public studentVO() {
		
	}
		
	

}
