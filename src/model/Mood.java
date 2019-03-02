package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Mood implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String moodname;
	public String shortmooddescription;
	public String mooddescription;
	public String moodimage;
	public ArrayList<String> songID;


}
