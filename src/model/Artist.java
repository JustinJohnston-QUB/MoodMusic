package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Artist implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String artistName;
	public String artistDescription;
	public String artistImage;
	public String uniqueID;
	public ArrayList<String> artistSongs;
	public ArrayList<String> artistImages;

}
