package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Mood implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String moodname;
	public String mooddescription;
	public String uniqueID;
	public ArrayList<String> songID;


}
