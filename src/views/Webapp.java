package views;

import java.util.ArrayList;
import java.util.List;

import org.h2.mvstore.MVMap;

import model.Artist;
import model.Mood;
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

					"  <div class=\"col s12\" style=\">\n" + 
					"    <div class=\"container\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col s6 offset-s3\">\n" + 
					"          <h3 class=\"center-align\">Search for the Music you love</h3>\n" + 
					"          <p class=\"center-align\"\">Search by Mood, Artist or Song</p>\n" + 
					// Form
					"          <form action=\"../search.html\" method=\"GET\" class=\"col s12\">\n" + 
					"            <div class=\"input-field col s12\"> "
					+ "					<input type=\"text\" class=\"form-control center-align\" name =\"Search\" placeholder =\"Enter Search text here\">\n" + 
					"              <div class=\"input-field col s12 center-align\">"
					+ "					 <input class=\"btn waves-effect waves-light  deep-orange \" type=\"submit\" value  = \"Search\"></input> "
					+ "				</div>\n" + 
					"            </div>\n" + 
					"          </form>\n" + 
					//end of form
					"        </div>\n" + 
					"      </div>\n" + 
					"    </div>\n" + 
					"  </div>\n" + 
					"  <div class=\"col s12 white center-align\">\n" + 
					"    <div class=\"container\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col s12\">\n" + 
					"          <h1 class=\"center-align\">Featured Artists</h1>\n" + 
					"        </div>\n" + 
					"      </div>\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col s3\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-1.svg\" width=\"150\" alt=\"Card image cap\">\n" + 
					"          <h4> <b>J. W. Goethe</b> </h4>\n" + 
					"          <p class=\"mb-0\">CEO and founder</p>\n" + 
					"        </div>\n" + 
					"        <div class=\"col s3\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-2.svg\" width=\"150\" alt=\"Card image cap\">\n" + 
					"          <h4> <b>G. W. John</b> </h4>\n" + 
					"          <p class=\"mb-0\">Co-founder</p>\n" + 
					"        </div>\n" + 
					"        <div class=\"col s3\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-3.svg\" width=\"150\">\n" + 
					"          <h4> <b>J. G. Wolf</b> </h4>\n" + 
					"          <p class=\"mb-0\">CFO</p>\n" + 
					"        </div>\n" + 
					"        <div class=\"col s3\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-4.svg\" width=\"150\">\n" + 
					"          <h4> <b>A. Gang</b> </h4>\n" + 
					"          <p class=\"mb-0\">CTO</p>\n" + 
					"        </div>\n" + 
					"      </div>\n" + 
					"      <div class=\"row d-flex justify-content-center\">\n" + 
					"        <div class=\"col s3\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-4.svg\" width=\"150\" alt=\"Card image cap\">\n" + 
					"          <h4> <b>G. W. John</b> </h4>\n" + 
					"          <p class=\"mb-0\">Co-founder</p>\n" + 
					"        </div>\n" + 
					"        <div class=\"col s3\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-1.svg\" width=\"150\">\n" + 
					"          <h4> <b>J. G. Wolf</b> </h4>\n" + 
					"          <p class=\"mb-0\">CFO</p>\n" + 
					"        </div>\n" + 
					"        <div class=\"col s3\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-4.svg\" width=\"150\">\n" + 
					"          <h4> <b>A. Gang</b> </h4>\n" + 
					"          <p class=\"mb-0\">CTO</p>\n" + 
					"        </div>\n" + 
					"        <div class=\"col s3\"> <img class=\"img-fluid d-block mb-3 mx-auto rounded-circle\" src=\"https://static.pingendo.com/img-placeholder-4.svg\" width=\"150\">\n" + 
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
			MVMap<String, Mood> moods= db.s.openMap("Mood");
			List<String> moodkeys = moods.keyList() ;
			Mood imood = new Mood();
			String stringToSendToWebBrowser = PageElements.header() +
					"<body>\n" + PageElements.Navbar()+ PageElements.Search()+

					"\n" + 

					"<div class=\"container\">\n" + 
					"  <div class=\"row\">\n" + 
					"    <div class=\"col s6\">\n" + 
					"		<h2>Add song</h2>\n" + 
					"		<form action=\"../addsong.html\" method = \"GET\"id = \"addsong\">\n " + 
					"  			Song Title " + 
					"  			<input type=\"text\" name=\"songtitle\" placeholder=\"title\">\n" + 
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
			
			
			stringToSendToWebBrowser +=			 "</select>" + 
												"  </div>"+
												"			<div class=\"input-field\"> "+
												"			Mood<select name=\"mood\" class = \"browser-default\" form=\"addsong\">\n"+
												"			option value=\"\" disabled selected>Choose your option</option>" ;
			for(int i = 0; i < moodkeys.size();i++) {
				String moodUniqueID = moodkeys.get(i);
				imood= moods.get(moodUniqueID);
				stringToSendToWebBrowser += "  <option value=\""+imood.moodname +"\">"+imood.moodname+"</option>\n";
			}

			stringToSendToWebBrowser += "</select>" + 
					"  </div>"+
					"  <br><br>\n" + 
					"  <input type=\"submit\" value=\"Submit\">\n" + 
					"</form> \n" + 
					"    </div>\n" + 
					"    <div class=\"col s6 m0\">\n" + 
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
					"    <div class=\"col s4\">\n" + 
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
					"    <div class=\"col s8\">\n" + 
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
			MVMap<String, Mood> moods= db.s.openMap("Mood");
			List<String> moodkeys = moods.keyList() ;
			Mood imood = new Mood();
			MVMap<String, Artist> artists= db.s.openMap("Artist");
			Artist art1 = artists.get(toProcess.params.get("Artist"));
			Mood mood1 = moods.get(toProcess.params.get("mood"));
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
			if(mood1.songID !=null) {
				mood1.songID.add(isong.uniqueID);
			}else {
				mood1.songID  = new ArrayList<String>();
				mood1.songID .add(isong.uniqueID);
			}
			songs.put(isong.uniqueID, isong);
			artists.put(art1.uniqueID, art1);
			moods.put(mood1.moodname, mood1);
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
			String stringToSendToWebBrowser = PageElements.header()+"<body>" + PageElements.Navbar()+ 
					"  <div class=\"col s12\" style=\">\n" + 
					"    <div class=\"container\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col s6 offset-s3\">\n" + 
					"          <h3 class=\"center-align\">Search for the Music you love</h3>\n" + 
					"          <p class=\"center-align\"\">Search by Mood, Artist or Song</p>\n" + 
					// Form
					"          <form action=\"../search.html\" method=\"GET\" class=\"col s12\">\n" + 
					"            <div class=\"input-field col s12\"> "
					+ "					<input type=\"text\" class=\"form-control center-align\" name =\"Search\" placeholder =\"Enter Search text here\">\n" + 
					"              <div class=\"input-field col s12 center-align\">"
					+ "					 <input class=\"btn waves-effect waves-light  deep-orange \" type=\"submit\" value  = \"Search\"></input> "
					+ "				</div>\n" + 
					"            </div>\n" + 
					"          </form>\n" + 
					//end of form
					"        </div>\n" + 
					"      </div>\n" + 
					"    </div>\n" + 
					"  </div>\n" + 
					"<div class=\"col s12 white\" style=\"\">\n" + 
					"    <div class=\"container-fluid\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col s12\">\n" + 
					"          <div class=\"row\">\n" + 
					"            <div class=\"col s10  offset-s1\">\n" + 
					"              <h1 class=\"\" contenteditable=\"false\" >Search results</h1>\n" + 
					"            </div>\n" + 
					"          </div>\n" + 
					"        </div>\n" + 
					"      </div>\n" + 
					"    </div>";

			//artist Search
			if(artistkeys.size() == 0) {
				stringToSendToWebBrowser += "<div class=\"col s12\">\n" + 
						"      <div class=\"row\">\n" + 
						"        <div class=\"col s121\">\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s10  offset-s1\">\n" + 
						"              <h2 class=\"\">Artist</h2>\n" + 
						"            </div>\n" + 
						"          </div>\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s12\">\n" + 
						"              <div class=\"row\">\n" + 
						"                <div class=\"col s12\">\n" + 
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
						"        <div class=\"col s12\">\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s10  offset-s1\">\n" + 
						"              <h2 class=\"\">Artist</h2>\n" + 
						"            </div>\n" + 
						"          </div>\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s12\">\n" + 
						"              <div class=\"row\">\n" + 
						"                <div class=\"col s10  offset-s1\">";
				int resultcount = 0;
				String searchresult = "";
				for(int i = 0; i<artistkeys.size();i++) {
					String artistUniqueID = artistkeys.get(i);
					iartist = artists.get(artistUniqueID);
					if (iartist.artistName.toLowerCase().contains(searchTerm.toLowerCase())) {
						searchresult += "<a href = \"../artistpage.html?artist="+iartist.uniqueID+"\"><h5>"+iartist.artistName+"</h5></a>\n";
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
						"        <div class=\"col s12\">\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s10  offset-s1\">\n" + 
						"              <h2 class=\"\">Songs</h2>\n" + 
						"            </div>\n" + 
						"          </div>\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s12\">\n" + 
						"              <div class=\"row\">\n" + 
						"                <div class=\"col s10  offset-s1\">\n" + 
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
						"        <div class=\"col s12\">\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s10  offset-s1\">\n" + 
						"              <h2 class=\"\">Songs</h2>\n" + 
						"            </div>\n" + 
						"          </div>\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s12\">\n" + 
						"              <div class=\"row\">\n" + 
						"                <div class=\"col s10  offset-s1\">";
				int resultcount = 0;
				String searchresult = "";
				for(int i = 0; i<songkeys.size();i++) {
					String songUniqueID = songkeys.get(i);
					isong = songs.get(songUniqueID);
					if (isong.songtitle.toLowerCase().contains(searchTerm.toLowerCase())) {
						searchresult += "<a href = \"../songpage?song="+isong.uniqueID+"\"><h5>"+isong.songtitle;
						for(int k = 0; k < artistkeys.size();k++) {	
							String artistUniqueID = artistkeys.get(k);
							iartist = artists.get(artistUniqueID);
							if(iartist.artistSongs != null) {
								for(int j = 0; j < iartist.artistSongs.size() ;j++) {
									String artistSong = iartist.artistSongs.get(j);
									if(artistSong.equalsIgnoreCase(isong.uniqueID.toLowerCase())) {
										searchresult += " - " + iartist.artistName + "</h5></a>";
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
			//start of mood loop   
			MVMap<String, Mood> moods= db.s.openMap("Mood");
			List<String> moodkeys = moods.keyList() ;
			Mood imood = new Mood();
			Mood tempmood = new Mood();
			String moodresult = "";
			for(int k = 0; k < moodkeys.size();k++) {	
				String moodUniqueID = moodkeys.get(k);
				tempmood = moods.get(moodUniqueID);
				if(tempmood.songID != null) {
					for(int j = 0; j < tempmood.songID.size() ;j++) {
						String moodname = tempmood.songID.get(j);
						if(moodname.equalsIgnoreCase(isong.uniqueID.toLowerCase())) {
							imood = moods.get(moodUniqueID);
						}
					}
				}
			}		

			// end of mood loop 
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"  <div class=\" col s12 white\">\n" + 
					"    <div class=\"container-fluid\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col s10 offset-s1 white\">\n" + 
					"          <div class=\"row\">\n" + 
					"            <div class=\"col s2\"></div>\n" + 
					"            <div class=\"col s12\">\n" + 
					"              <h1>"+isong.songtitle +"</h1>\n" + 
					"					<a href = \"../artistpage.html?artist="+iartist.uniqueID+"\"><h3>"+"Artist: "+iartist.artistName+"</h3></a>\n"+
					"            </div>\n" + 
					"          </div>\n" + 
					"          <div class=\"row offset-s1\">\n" + 
					"            <div class=\"col s2 \" style=\"\"><img class=\"circle responsive-img\" src=\"https://static.pingendo.com/img-placeholder-3.svg\" width=\"200px\" height=\"200px\"></div>\n" + 
					"            <div class=\"col s10\">\n" + 
					"              <div class=\"row\" style=\"	min-height: 200px;\">\n" + 
					"                <div class=\"col s12\" style=\"\">\n" + 
					"                  <p class=\"lead\" style=\"\">" + "song length: " + isong.songlength +"<br></p>\n" + 
					"                  <p class=\"lead\" style=\"\">" + "song link: " + isong.songLink +"<br></p>\n" + 
					"                  <p class=\"lead\" style=\"\">" + "song mood: " + imood.moodname +"<br></p>\n" + 
					"                </div>\n" + 
					"              </div>\n" + 
					"					</div>\n" + 
					"                </div>\n" + 
					"              </div>\n" + 
					"            </div>\n" + 
					"          </div>\n" + 
					"        </div>\n" +        				
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
					"  <div class=\"col s12 white\">\n" + 
					"    <div class=\"container-fluid\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col 10 offset-s1 white\">\n" + 
					"          <div class=\"row\">\n" + 
					"            <div class=\"col s2\"></div>\n" + 
					"            <div class=\"col s12\">\n" + 
					"              <h1 class=\"\" style=\"\">"+ iartist.artistName +"</h1>\n" + 
					"            </div>\n" + 
					"          </div>\n" + 
					"          <div class=\"row\" style=\"\">\n" ;
			if(iartist.artistImage != null && iartist.artistImage != "" ) {
				stringToSendToWebBrowser +="            <div class=\"col s2 align-center\" style=\"\"><img class=\"circle responsive-img\" src=\""+iartist.artistImage+"\" width=\"200px\" height=\"200px\"></div>\n";
			}else {
				stringToSendToWebBrowser +="            <div class=\"col s2 align-center\" style=\"\"><img class=\"circle responsive-img\" src=\"https://static.pingendo.com/img-placeholder-3.svg\" width=\"200px\" height=\"200px\"></div>\n";
			}
			stringToSendToWebBrowser+="            <div class=\"col s8 offset-s1\">\n" + 
					"              <div class=\"row\" style=\"	min-height: 200px;\">\n" + 
					"                <div class=\"col-md-12\" style=\"\">\n" + 
					"                  <p class=\"lead\" style=\"\">"+ iartist.artistDescription +"<br></p>\n" + 
					"                </div>\n" + 
					"              </div>\n" + 

            				"              <div class=\"row\">\n" + 
            				"                <div class=\"col s12 \">\n" + 
            				"                  <h3 class=\"\">Songs</h3>\n"+
            				"<div class=\"row\">";       

			if (iartist.artistSongs == null) {
				stringToSendToWebBrowser += 	"                    <div class=\"col s12 \">\n" + 
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
							stringToSendToWebBrowser += 	"                    <div class=\"col s12 \">\n" + 
									"                    <a href = \"../songpage?song="+isong.uniqueID+"\"><h5>"+isong.songtitle +" - " +iartist.artistName+"</h5></a>\n"+
									"                    </div>\n";
						}
					}
				}
			}



			stringToSendToWebBrowser +=
					"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" + 
							"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\n" + 
							"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\"></script>\n" +
							"</body>\n" + 
							"\n" + 
							"</html>";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}else if(toProcess.path.equalsIgnoreCase("mood.html")){
			String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
					PageElements.header()+ "<body>\n"  + PageElements.Navbar()+ PageElements.Search()+
					"\n" + 
					"<div class=\"container\">\n" + 
					"  <div class=\"row\">\n" + 
					"    <div class=\"col s12\">\n" + 
					"			<h2>Add Mood</h2>\n" + 
					"			<form action=\"../addmood.html\" method = \"GET\"id = \"addmood\">\n " + 
					" 			 Mood Name " + 
					" 			 <input type=\"text\" name=\"moodname\" placeholder=\"Name\">\n" + 
					" 			 <br>\n" + 
					"  			Description<input type=\"text\" name=\"mooddescription\" placeholder=\"description\">\n" + 
					"  			<br><br>\n" + 
					"  			<input type=\"submit\" value=\"Submit\">\n" + 
					"			</form> \n" + 
					"    </div>\n" +  
					"  </div>\n" + 
					"</div>"+

        			"\n" + 
        			"</body>\n" + 
        			"</html> ";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;      	
		}else if(toProcess.path.equalsIgnoreCase("addmood.html")) {
			Mood imood = new Mood();
			imood.moodname = toProcess.params.get("moodname");	
			imood.mooddescription = toProcess.params.get("mooddescription");	
			MVMap<String, Mood> moods= db.s.openMap("Mood");
			moods.put(imood.moodname, imood);
			db.commit();
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"<body>\n" + 
					"	<h2>Mood added</h2>\n" + 
					"</body>\n" + 
					"</html>\n" + 
					"";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;


            		
		}

		return false;   
	}

}