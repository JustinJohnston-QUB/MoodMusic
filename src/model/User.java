package model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String uniqueID;
	public String firstname;
	public String surname;
	public String username;
	private String password;
	public String email;
	public String dob;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
