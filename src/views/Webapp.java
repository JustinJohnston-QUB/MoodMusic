package views;

import java.util.ArrayList;
import java.util.List;

import org.h2.mvstore.MVMap;

import model.Artist;
import model.Song;
import model.Product;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class Webapp extends DynamicWebPage
{
	public Webapp(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
//WebApp Page
        if(toProcess.path.equalsIgnoreCase("webapp"))
        
        {
        	String stringToSendToWebBrowser = PageElements.header()  +
        			"<body >\n" + PageElements.Navbar()+

        			"  <div class=\"py-5 text-center\" style=\">\n" + 
        			"    <div class=\"container\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"mx-auto col-md-6\">\n" + 
        			"          <h1>Search for the Music you love</h1>\n" + 
        			"          <p class=\"mb-4\">Search by Mood, Artist or Song</p>\n" + 
 // Form
        			"          <form action=\"../search.html\" method=\"GET\" class=\"col s12\">\n" + 
        			"            <div class=\"input-field col s12\"> "
        			+ "					<input type=\"text\" class=\"form-control center-align\" name =\"Search\" placeholder =\"Enter Search text here\">\n" + 
        			"              <div class=\"input-field col s12\">"
        			+ "					 <input class=\"btn btn-primary\" type=\"submit\" value  = \"Search\"></input> "
        			+ "				</div>\n" + 
        			"            </div>\n" + 
        			"          </form>\n" + 
//end of form
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <div class=\"py-5 text-center\">\n" + 
        			"    <div class=\"container\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"mx-auto col-md-12\">\n" + 
        			"          <h1 class=\"mb-3\">Featured Artists</h1>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"col-lg-3 col-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-1.svg\" width=\"150\" alt=\"Card image cap\">\n" + 
        			"          <h4> <b>J. W. Goethe</b> </h4>\n" + 
        			"          <p class=\"mb-0\">CEO and founder</p>\n" + 
        			"        </div>\n" + 
        			"        <div class=\"col-lg-3 col-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-2.svg\" width=\"150\" alt=\"Card image cap\">\n" + 
        			"          <h4> <b>G. W. John</b> </h4>\n" + 
        			"          <p class=\"mb-0\">Co-founder</p>\n" + 
        			"        </div>\n" + 
        			"        <div class=\"col-lg-3 col-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-3.svg\" width=\"150\">\n" + 
        			"          <h4> <b>J. G. Wolf</b> </h4>\n" + 
        			"          <p class=\"mb-0\">CFO</p>\n" + 
        			"        </div>\n" + 
        			"        <div class=\"col-lg-3 col-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-4.svg\" width=\"150\">\n" + 
        			"          <h4> <b>A. Gang</b> </h4>\n" + 
        			"          <p class=\"mb-0\">CTO</p>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"      <div class=\"row d-flex justify-content-center\">\n" + 
        			"        <div class=\"col-lg-3 col-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-4.svg\" width=\"150\" alt=\"Card image cap\">\n" + 
        			"          <h4> <b>G. W. John</b> </h4>\n" + 
        			"          <p class=\"mb-0\">Co-founder</p>\n" + 
        			"        </div>\n" + 
        			"        <div class=\"col-lg-3 col-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-1.svg\" width=\"150\">\n" + 
        			"          <h4> <b>J. G. Wolf</b> </h4>\n" + 
        			"          <p class=\"mb-0\">CFO</p>\n" + 
        			"        </div>\n" + 
        			"        <div class=\"col-lg-3 col-6 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-4.svg\" width=\"150\">\n" + 
        			"          <h4> <b>A. Gang</b> </h4>\n" + 
        			"          <p class=\"mb-0\">CTO</p>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" + 
        			"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\n" + 
        			"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\n" + 
        			"</body>\n" + 
        			"\n" + 
        			"</html>";
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        	return true;
    
//Page with form for adding songs       	
    
        }else if(toProcess.path.equalsIgnoreCase("song.html")){
        	MVMap<String, Artist> artists= db.s.openMap("Artist");
        	List<String> artistkeys = artists.keyList() ;
        	Artist iartist = new Artist();
        	String stringToSendToWebBrowser = PageElements.header() +
        			"<body>\n" + PageElements.Navbar()+ PageElements.Search()+
					        			
					"\n" + 
					        			
					"<div class=\"container\">\n" + 
					"  <div class=\"row\">\n" + 
					"    <div class=\"col-sm-4\">\n" + 
					"		<h2>Add song</h2>\n" + 
					"		<form action=\"../addsong.html\" method = \"GET\"id = \"addsong\">\n " + 
					"  			Song Title " + 
					"  			<input type=\"text\" name=\"songtitle\" value=\"title\">\n" + 
					"  			<br>\n" + 
					" 			song Length <input type=\"time\" name=\"songlength\" value=\"time\">\n" + 
					"  			<br>\n" + 
					"  			song Link <input type=\"text\" name=\"songlink\" placeholder=\"Enter a link to the music if one is available \">\n" + 
					"  			<br>\n" +
					"			<div class=\"input-field\"> "+
					"			Artist Name<select name=\"Artist\" class = \"browser-default\" form=\"addsong\">\n"+
					"			option value=\"\" disabled selected>Choose your option</option>" ;
					for(int i = 0; i < artistkeys.size();i++) {
						String artistUniqueID = artistkeys.get(i);
						iartist = artists.get(artistUniqueID);
						stringToSendToWebBrowser += "  <option value=\""+iartist.uniqueID +"\">"+iartist.artistName+"</option>\n";
					}
					
					stringToSendToWebBrowser += "</select>" + 
					"  </div>"+
					"  <br><br>\n" + 
					"  <input type=\"submit\" value=\"Submit\">\n" + 
					"</form> \n" + 
					"    </div>\n" + 
					"    <div class=\"col-sm-8\">\n" + 
					"      <h3>We are always looking for more artists</h3> \n" + 
					"      <p style = lead>Add an artist on this page</p>\n" + 
					"      <bt><p>more text...</p>\n" + 
					"    </div>\n" + 
					"  </div>\n" + 
					"</div>"+
        			
        			
        	
        			"\n" + 
        			"</body>\n" + 
        			"</html> ";
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        	return true;
        	
        	
        	
//Page with form for adding Artists           	
        }else if(toProcess.path.equalsIgnoreCase("artist.html")){
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
        			PageElements.header()+ "<body>\n"  + PageElements.Navbar()+ PageElements.Search()+
        			"\n" + 
        			"<div class=\"container\">\n" + 
        			"  <div class=\"row\">\n" + 
        			"    <div class=\"col-sm-4\">\n" + 
        			"			<h2>Add Artist</h2>\n" + 
        			"			<form action=\"../addartist.html\" method = \"GET\"id = \"addartist\">\n " + 
        			" 			 Artist Name " + 
        			" 			 <input type=\"text\" name=\"artistname\" placeholder=\"Name\">\n" + 
        			" 			 <br>\n" + 
        			"  			Description<input type=\"text\" name=\"artistdescription\" placeholder=\"description\">\n" + 
        			" 			 <br>\n" + 
        			" 			 image Link <input type=\"text\" name=\"artistimage\" placeholder=\"link to an image\">\n" + 
        			"  			<br>\n" + 
        			"  			<br><br>\n" + 
        			"  			<input type=\"submit\" value=\"Submit\">\n" + 
        			"			</form> \n" + 
        			"    </div>\n" + 
        			"    <div class=\"col-sm-8\">\n" + 
        			"      <h3>We are always looking for more artists</h3> \n" + 
        			"      <p style = lead>Add an artist on this page</p>\n" + 
        			"      <bt><p>more text...</p>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"</div>"+
        			
        			"\n" + 
        			"</body>\n" + 
        			"</html> ";
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        	return true;
 
//Page which adds songs to the database        	
        	}else if(toProcess.path.equalsIgnoreCase("addsong.html")) {
        	 	MVMap<String, Artist> artists= db.s.openMap("Artist");
        	 	Artist art1 = artists.get(toProcess.params.get("Artist"));
        		Song isong = new Song();
        		isong.uniqueID = "song_"+System.currentTimeMillis();
        		isong.songtitle= toProcess.params.get("songtitle");	
        		isong.songlength =  toProcess.params.get("songlength");	
        		isong.songLink =  toProcess.params.get("songlink");	
        		MVMap<String, Song> songs= db.s.openMap("Song");
        		if(art1.artistSongs !=null) {
        			art1.artistSongs.add(isong.uniqueID);
        		}else {
        			art1.artistSongs = new ArrayList<String>();
        			art1.artistSongs.add(isong.uniqueID);
        		}
        		
        		songs.put(isong.uniqueID, isong);
        		artists.put(art1.uniqueID, art1);
        		db.commit();
        		String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
        				"<body>\n" + 
        				"	<h2>song Added</h2>\n" + 
        				"</body>\n" + 
        				"</html>\n" + 
        				"";
        		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        		return true;
        		
//Page which adds Artists to the database             		
        	}else if(toProcess.path.equalsIgnoreCase("addartist.html")) {
        		Artist iartist = new Artist();
        		iartist.uniqueID= "Artist_"+System.currentTimeMillis();
        		iartist.artistName = toProcess.params.get("artistname");	
        		iartist.artistDescription = toProcess.params.get("artistdescription");	
        		iartist.artistImage = toProcess.params.get("artistimage");
        		MVMap<String, Artist> artists= db.s.openMap("Artist");
        		artists.put(iartist.uniqueID, iartist);
        		db.commit();
        		String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
        				"<body>\n" + 
        				"	<h2>artist Added</h2>\n" + 
        				"</body>\n" + 
        				"</html>\n" + 
        				"";
        		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        		return true;
        		
        		
//Search results page              		
        	}else if(toProcess.path.equalsIgnoreCase("search.html")){
        		String searchTerm = toProcess.params.get("Search").toLowerCase();
            	Song isong = new Song();
            	Artist iartist = new Artist();
            	MVMap<String, Song> songs= db.s.openMap("Song");
            	List<String> songkeys = songs.keyList() ;
            	MVMap<String, Artist> artists= db.s.openMap("Artist");
            	List<String> artistkeys = artists.keyList() ;
            	String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ 
            			"\n" + 
            			"<body style=\"\">\n" + 
 
            			"  <div class=\"py-5 text-center\">\n" + 
            			"    <div class=\"container\">\n" + 
            			"      <div class=\"row\">\n" + 
            			"        <div class=\"mx-auto col-md-6\">\n" + 
            			"          <h1>Search for the Music you love</h1>\n" + 
            			"          <p class=\"mb-4\">Search by Mood, Artist or Song</p>\n" + 
 // Form
             			"          <form action=\"../search.html\" method=\"GET\" class=\"col s12\">\n" + 
             			"            <div class=\"input-field col s12\"> "
             			+ "					<input type=\"text\" class=\"form-control center-align\" name =\"Search\" placeholder =\"Enter Search text here\">\n" + 
             			"              <div class=\"input-field col s12\">"
             			+ "					 <input class=\"btn btn-primary\" type=\"submit\" value  = \"Search\"></input> "
             			+ "				</div>\n" + 
             			"            </div>\n" + 
             			"          </form>\n" + 
     //end of form
            			"        </div>\n" + 
            			"      </div>\n" + 
            			"    </div>\n" + 
            			"  </div>"+
            			"<div class=\"py-1\" style=\"\">\n" + 
            			"    <div class=\"container-fluid px-3\">\n" + 
            			"      <div class=\"row\">\n" + 
            			"        <div class=\"col-md-12\">\n" + 
            			"          <div class=\"row\">\n" + 
            			"            <div class=\"col-md-12\">\n" + 
            			"              <h1 class=\"\" contenteditable=\"false\" >Search results</h1>\n" + 
            			"            </div>\n" + 
            			"          </div>\n" + 
            			"        </div>\n" + 
            			"      </div>\n" + 
            			"    </div>";
            	
//artist Search
        		if(artistkeys.size() == 0) {
        			stringToSendToWebBrowser += "<div class=\"container-fluid px-3\">\n" + 
        					"      <div class=\"row\">\n" + 
        					"        <div class=\"col-md-12\">\n" + 
        					"          <div class=\"row\">\n" + 
        					"            <div class=\"col-md-12\">\n" + 
        					"              <h2 class=\"\">Artist</h2>\n" + 
        					"            </div>\n" + 
        					"          </div>\n" + 
        					"          <div class=\"row\">\n" + 
        					"            <div class=\"col-md-12\">\n" + 
        					"              <div class=\"row\">\n" + 
        					"                <div class=\"col-md-12\">\n" + 
        					"                  <p class=\"lead\">No Artists in Database</p>\n" + 
        					"                </div>\n" + 
        					"              </div>\n" + 
        					"            </div>\n" + 
        					"          </div>\n" + 
        					"        </div>\n" + 
        					"      </div>\n" + 
        					"    </div>\n" + 
        					"  </div>";
        		}else {
        			stringToSendToWebBrowser += "    <div class=\"container-fluid px-3\">\n" + 
        					"      <div class=\"row\">\n" + 
        					"        <div class=\"col-md-12\">\n" + 
        					"          <div class=\"row\">\n" + 
        					"            <div class=\"col-md-12\">\n" + 
        					"              <h2 class=\"\">Artist</h2>\n" + 
        					"            </div>\n" + 
        					"          </div>\n" + 
        					"          <div class=\"row\">\n" + 
        					"            <div class=\"col-md-12\">\n" + 
        					"              <div class=\"row\">\n" + 
        					"                <div class=\"col-md-12\">";
        			int resultcount = 0;
        			String searchresult = "";
        			for(int i = 0; i<artistkeys.size();i++) {
        				String artistUniqueID = artistkeys.get(i);
        				iartist = artists.get(artistUniqueID);
        				if (iartist.artistName.toLowerCase().contains(searchTerm.toLowerCase())) {
        					searchresult += "<a href = \"../artistpage.html?artist="+iartist.uniqueID+"\"><p class=\"lead\">"+iartist.artistName+"</p></a>\n";
        					resultcount++;
        				}        				
        			}
        			if(resultcount == 0) {
        				searchresult += "<p class=\"lead\">No Artists found</p>\n";
        			}
        			stringToSendToWebBrowser += searchresult;
        			stringToSendToWebBrowser += "</div>\n" + 
        					"              </div>\n" + 
        					"            </div>\n" + 
        					"          </div>\n" + 
        					"        </div>\n" + 
        					"      </div>\n" + 
        					"    </div>\n" + 
        					"  </div>";
        		}
//end of artist Search      
     		
 //Song Search
        		if(songkeys.size() == 0) {
        			stringToSendToWebBrowser += "<div class=\"container-fluid px-3\">\n" + 
        					"      <div class=\"row\">\n" + 
        					"        <div class=\"col-md-12\">\n" + 
        					"          <div class=\"row\">\n" + 
        					"            <div class=\"col-md-12\">\n" + 
        					"              <h2 class=\"\">Songs</h2>\n" + 
        					"            </div>\n" + 
        					"          </div>\n" + 
        					"          <div class=\"row\">\n" + 
        					"            <div class=\"col-md-12\">\n" + 
        					"              <div class=\"row\">\n" + 
        					"                <div class=\"col-md-12\">\n" + 
        					"                  <p class=\"lead\">No Songs in Database</p>\n" + 
        					"                </div>\n" + 
        					"              </div>\n" + 
        					"            </div>\n" + 
        					"          </div>\n" + 
        					"        </div>\n" + 
        					"      </div>\n" + 
        					"    </div>\n" + 
        					"  </div>";
        		}else {
        			stringToSendToWebBrowser += "    <div class=\"container-fluid px-3\">\n" + 
        					"      <div class=\"row\">\n" + 
        					"        <div class=\"col-md-12\">\n" + 
        					"          <div class=\"row\">\n" + 
        					"            <div class=\"col-md-12\">\n" + 
        					"              <h2 class=\"\">Songs</h2>\n" + 
        					"            </div>\n" + 
        					"          </div>\n" + 
        					"          <div class=\"row\">\n" + 
        					"            <div class=\"col-md-12\">\n" + 
        					"              <div class=\"row\">\n" + 
        					"                <div class=\"col-md-12\">";
        			int resultcount = 0;
        			String searchresult = "";
        			for(int i = 0; i<songkeys.size();i++) {
        				String songUniqueID = songkeys.get(i);
        				isong = songs.get(songUniqueID);
        				if (isong.songtitle.toLowerCase().contains(searchTerm.toLowerCase())) {
        					searchresult += "<a href = \"../songpage?song="+isong.uniqueID+"\"><p class=\"lead\">"+isong.songtitle;
        					for(int k = 0; k < artistkeys.size();k++) {	
                				String artistUniqueID = artistkeys.get(k);
                				iartist = artists.get(artistUniqueID);
                				if(iartist.artistSongs != null) {
	            					for(int j = 0; j < iartist.artistSongs.size() ;j++) {
	            						String artistSong = iartist.artistSongs.get(j);
	            						if(artistSong.equalsIgnoreCase(isong.uniqueID.toLowerCase())) {
	            							searchresult += " - " + iartist.artistName + "</p></a>";
	            						}
	            					}
                				}
            				}
        				}
        						
        					resultcount++;
        				}        				
        			
					if(resultcount == 0) {
        				searchresult += "<p class=\"lead\">No songs found</p>\n";
        			}
        			stringToSendToWebBrowser += searchresult;
        			stringToSendToWebBrowser += "</div>\n" + 
        					"              </div>\n" + 
        					"            </div>\n" + 
        					"          </div>\n" + 
        					"        </div>\n" + 
        					"      </div>\n" + 
        					"    </div>\n" + 
        					"  </div>";
        		}
        	
//end of song  Search  
            	stringToSendToWebBrowser += "</body>\n" + 
        				"</html>\n" + 
        				"";
            	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
            	return true;
            	
// page which displays songs          	
            	}else if(toProcess.path.equalsIgnoreCase("songpage")) {
            		String song;
            		song = toProcess.params.get("song").toLowerCase();
                	Song isong = new Song();
                	Artist iartist = new Artist();
                	Artist tempartist = new Artist();
                	MVMap<String, Song> songs= db.s.openMap("Song");
                	List<String> songkeys = songs.keyList() ;
                	MVMap<String, Artist> artists= db.s.openMap("Artist");
                	List<String> artistkeys = artists.keyList() ;
        			for(int i = 0; i<songkeys.size();i++) {
        				String songUniqueID = songkeys.get(i);
        				if(song.equalsIgnoreCase(songUniqueID)) {
        					isong = songs.get(songUniqueID);
        				}
        			}
 //start of artist loop        
   					String searchresult = "";
    				for(int k = 0; k < artistkeys.size();k++) {	
        				String artistUniqueID = artistkeys.get(k);
        				tempartist = artists.get(artistUniqueID);
        				if(tempartist.artistSongs != null) {
        					for(int j = 0; j < tempartist.artistSongs.size() ;j++) {
        						String artistSong = tempartist.artistSongs.get(j);
        						if(artistSong.equalsIgnoreCase(isong.uniqueID.toLowerCase())) {
        							iartist = artists.get(artistUniqueID);
        						}
        					}
        				}
    				}		

// end of artist loop 
            		String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
            				"  <div class=\"py-0 pl-3 pr-3 pt-3 pb-0\">\n" + 
            				"    <div class=\"container-fluid\">\n" + 
            				"      <div class=\"row\">\n" + 
            				"        <div class=\"col-md-8\">\n" + 
            				"          <div class=\"row\">\n" + 
            				"            <div class=\"col-md-2\"></div>\n" + 
            				"            <div class=\"col-md-10\">\n" + 
            				"              <h1 class=\"\" style=\"\">"+ isong.songtitle +"</h1>\n" + 
            				"					<a href = \"../artistpage.html?artist="+iartist.uniqueID+"\"><h3 class>"+"      Artist: "+iartist.artistName+"</p></a>\n"+
            				"            </div>\n" + 
            				"          </div>\n" + 
            				"          <div class=\"row\" style=\"\">\n" + 
            				"            <div class=\"col-md-2\" style=\"\"><img class=\"img-fluid d-block rounded-circle mx-auto\" src=\"https://static.pingendo.com/img-placeholder-3.svg\" width=\"300\" height=\"300\"></div>\n" + 
            				"            <div class=\"col-md-10\">\n" + 
            				"              <div class=\"row\" style=\"	min-height: 200px;\">\n" + 
            				"                <div class=\"col-md-12\" style=\"\">\n" + 
            				"                  <p class=\"lead\" style=\"\">" + "song length: " + isong.songlength +"<br></p>\n" + 
            				"                  <p class=\"lead\" style=\"\">" + "song link: " + isong.songLink +"<br></p>\n" + 
            				"                </div>\n" + 
            				"              </div>\n" + 

            				"              <div class=\"row\">\n" + 
            				"                <div class=\"col-md-12\">\n" + 
            				"                  <h3 class=\"\">Artist</h3>\n"+
            				"<div class=\"row\">";
   
            				stringToSendToWebBrowser += "</div>\n" + 
            				"                </div>\n" + 
            				"              </div>\n" + 
            				"            </div>\n" + 
            				"          </div>\n" + 
            				"        </div>\n" +        				
            				"        <div class=\"col-md-4 bg-light\">\n" + 
            				"          <div class=\"row\">\n" + 
            				"            <div class=\"col-md-12 bg-light\">\n" + 
            				"              <h1 class=\"\" contenteditable=\"true\">Comments</h1>\n" + 
            				"            </div>\n" + 
            				"          </div>\n" + 
            				"          <div class=\"row\">\n" + 
            				"            <div class=\"col-md-12\">\n" + 
            				"              <p class=\"\">This is where a comment goes - the username is appended</p>\n" + 
            				"            </div>\n" + 
            				"          </div>\n" + 
            				"          <div class=\"row\">\n" + 
            				"            <div class=\"col-md-12\">\n" + 
            				"              <form id=\"c_form-h\" class=\"\">\n" + 
            				"                <div class=\"form-group row\"> <label for=\"inputmailh\" class=\"col-2 col-form-label\">user</label>\n" + 
            				"                  <div class=\"col-10\">\n" + 
            				"                    <input type=\"email\" class=\"form-control\" id=\"inputmailh\" placeholder=\"mail@example.com\"> </div>\n" + 
            				"                </div>\n" + 
            				"                <div class=\"form-group row\"> <label for=\"inputpasswordh\" class=\"col-2 col-form-label\">Comment</label>\n" + 
            				"                  <div class=\"col-10\">\n" + 
            				"                    <input type=\"text\" class=\"form-control form-control-sm\" id=\"comment\" placeholder=\"Comment\" required=\"required\" style=\"	min-height: 100px;\"> </div>\n" + 
            				"                </div>\n" + 
            				"                <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" + 
            				"              </form>\n" + 
            				"            </div>\n" + 
            				"          </div>\n" + 
            				"        </div>\n" + 
            				"      </div>\n" + 
            				"    </div>\n" + 
            				"  </div>\n" + 
            				"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" + 
            				"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\n" + 
            				"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\n" +
            				"</body>\n" + 
            				"\n" + 
            				"</html>";
            		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
            		return true;
// page which displays artists            	
            	}else if(toProcess.path.equalsIgnoreCase("artistpage.html")) {
            		String artist;
            		artist = toProcess.params.get("artist").toLowerCase();
                	Song isong = new Song();
                	Artist iartist = new Artist();
                	MVMap<String, Song> songs= db.s.openMap("Song");
                	List<String> songkeys = songs.keyList() ;
                	MVMap<String, Artist> artists= db.s.openMap("Artist");
                	List<String> artistkeys = artists.keyList() ;
        			for(int i = 0; i<artistkeys.size();i++) {
        				String artistUniqueID = artistkeys.get(i);
        				if(artist.equalsIgnoreCase(artistUniqueID)) {
        					iartist = artists.get(artistUniqueID);
        				}
        			}
            		String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
            				"  <div class=\"py-0 pl-3 pr-3 pt-3 pb-0\">\n" + 
            				"    <div class=\"container-fluid\">\n" + 
            				"      <div class=\"row\">\n" + 
            				"        <div class=\"col-md-8\">\n" + 
            				"          <div class=\"row\">\n" + 
            				"            <div class=\"col-md-2\"></div>\n" + 
            				"            <div class=\"col-md-10\">\n" + 
            				"              <h1 class=\"\" style=\"\">"+ iartist.artistName +"</h1>\n" + 
            				"            </div>\n" + 
            				"          </div>\n" + 
            				"          <div class=\"row\" style=\"\">\n" ;
            				if(iartist.artistImage != null && iartist.artistImage != "" ) {
            					stringToSendToWebBrowser +="            <div class=\"col-md-2\" style=\"\"><img class=\"img-fluid d-block rounded-circle mx-auto\" src=\""+iartist.artistImage+"\" width=\"300\" height=\"300\"></div>\n";
            				}else {
            					stringToSendToWebBrowser +="            <div class=\"col-md-2\" style=\"\"><img class=\"img-fluid d-block rounded-circle mx-auto\" src=\"https://static.pingendo.com/img-placeholder-3.svg\" width=\"300\" height=\"300\"></div>\n";
            				}
            				stringToSendToWebBrowser+="            <div class=\"col-md-10\">\n" + 
            				"              <div class=\"row\" style=\"	min-height: 200px;\">\n" + 
            				"                <div class=\"col-md-12\" style=\"\">\n" + 
            				"                  <p class=\"lead\" style=\"\">"+ iartist.artistDescription +"<br></p>\n" + 
            				"                </div>\n" + 
            				"              </div>\n" + 

            				"              <div class=\"row\">\n" + 
            				"                <div class=\"col-md-12\">\n" + 
            				"                  <h3 class=\"\">Songs</h3>\n"+
            				"<div class=\"row\">";       
            				
            				if (iartist.artistSongs == null) {
            					stringToSendToWebBrowser += 	"                    <div class=\"col-md-12\">\n" + 
            													"                      <p class=\"lead\">no songs found</p>\n" +
            													"                    </div>\n";
            				}else {
            					for(int i = 0; i < songkeys.size();i++) {
            						
                					String songId = songkeys.get(i);
                					isong = songs.get(songId);
                					String songName = isong.uniqueID;
                					for(int j = 0; j < iartist.artistSongs.size() ;j++) {
                						String artistSong = iartist.artistSongs.get(j);
                						if(songName.equalsIgnoreCase(artistSong)) {
                            				stringToSendToWebBrowser += 	"                    <div class=\"col-md-12\">\n" + 
                                    										"                    <a href = \"../songpage?song="+isong.uniqueID+"\"><p class=\"lead\">"+isong.songtitle +" - " +iartist.artistName+"</p></a>\n"+
                                    										"                    </div>\n";
                						}
                					}
                				}
            				}
            				


            				stringToSendToWebBrowser += "</div>\n" + 
            				"                </div>\n" + 
            				"              </div>\n" + 
            				"            </div>\n" + 
            				"          </div>\n" + 
            				"        </div>\n" +        				
            				"        <div class=\"col-md-4 bg-light\">\n" + 
            				"          <div class=\"row\">\n" + 
            				"            <div class=\"col-md-12 bg-light\">\n" + 
            				"              <h1 class=\"\" contenteditable=\"true\">Comments</h1>\n" + 
            				"            </div>\n" + 
            				"          </div>\n" + 
            				"          <div class=\"row\">\n" + 
            				"            <div class=\"col-md-12\">\n" + 
            				"              <p class=\"\">This is where a comment goes - the username is appended</p>\n" + 
            				"            </div>\n" + 
            				"          </div>\n" + 
            				"          <div class=\"row\">\n" + 
            				"            <div class=\"col-md-12\">\n" + 
            				"              <form id=\"c_form-h\" class=\"\">\n" + 
            				"                <div class=\"form-group row\"> <label for=\"inputmailh\" class=\"col-2 col-form-label\">user</label>\n" + 
            				"                  <div class=\"col-10\">\n" + 
            				"                    <input type=\"email\" class=\"form-control\" id=\"inputmailh\" placeholder=\"mail@example.com\"> </div>\n" + 
            				"                </div>\n" + 
            				"                <div class=\"form-group row\"> <label for=\"inputpasswordh\" class=\"col-2 col-form-label\">Comment</label>\n" + 
            				"                  <div class=\"col-10\">\n" + 
            				"                    <input type=\"text\" class=\"form-control form-control-sm\" id=\"comment\" placeholder=\"Comment\" required=\"required\" style=\"	min-height: 100px;\"> </div>\n" + 
            				"                </div>\n" + 
            				"                <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" + 
            				"              </form>\n" + 
            				"            </div>\n" + 
            				"          </div>\n" + 
            				"        </div>\n" + 
            				"      </div>\n" + 
            				"    </div>\n" + 
            				"  </div>\n" + 
            				"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" + 
            				"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\n" + 
            				"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\n" +
            				"</body>\n" + 
            				"\n" + 
            				"</html>";
            		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
            		return true;
            	}
        
		return false;   
	}

}