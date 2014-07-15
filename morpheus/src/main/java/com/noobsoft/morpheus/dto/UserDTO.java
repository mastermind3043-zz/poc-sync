package com.noobsoft.morpheus.dto;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class UserDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 649963040118085888L;

	/**
	 * 
	 */
	
	private int userId;
	
	private String userName;
	
	private String userPass;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public UserDTO(int userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}
	
	public UserDTO(){
		super();
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	
	
}
