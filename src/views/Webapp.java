
package views;

import java.io.File;
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
			MVMap<String, Mood> moods= db.s.openMap("Mood");
			List<String> moodkeys = moods.keyList() ;
			Mood imood = new Mood();
			String stringToSendToWebBrowser = PageElements.header()  +
					"<body >\n" + PageElements.Navbar()+

					"  <div class=\"col s12\" style=\">\n" + 
					"    <div class=\"container\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col s6 offset-s3\">\n" + 
					"          <h3 class=\"center-align\">Search for the Music you love</h3>\n" + 
					"          <p class=\"center-align\">Search by Mood, Artist or Song</p>\n" + 
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
					//start of moods
					"  <div class=\"col s12 white center-align\">\n" + 
					"    <div class=\"container\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col s12\">\n" + 
					"          <h1 class=\"center-align\">Choose Your Mood</h1>\n" + 
					"        </div>\n" + 
					"      </div>\n"+
					"      <div class=\"row\">\n" ;
			 	int moodcount = 1;
			 	if(moodkeys.size() == 0) {
					stringToSendToWebBrowser +=
							"        <div class=\"col s12\"> <img class=\"circle responsive-img\" src=\"https://static.pingendo.com/img-placeholder-1.svg\" width=\"150\" alt=\"Card image cap\">\n" + 
									"<h5 class=\" flow-text blue-text text-darken-2\">Moods Missing</h5><br>\n"+ 
							"          <p class=\"flow-text\">there are no moods only xanax</p>\n" + 
							"        </div>\n";
			 	}else {
			 		for(int i = 0; i<moodkeys.size();i++) {
						String moodUniqueID = moodkeys.get(i);
							imood = moods.get(moodUniqueID);
						
								
									  if(imood.moodimage != null && imood.moodimage != "" ) {
											stringToSendToWebBrowser +="<div class=\"col s3\"><img class=\"circle responsive-img\" src=\""+imood.moodimage+"\">";
										}else {
											stringToSendToWebBrowser +=" div class=\"col s3\"> <img class=\"circle responsive-img\" src=\"https://static.pingendo.com/img-placeholder-1.svg\" width=\"150\" alt=\"Card image cap\">\n" ;
										}
								
									
									
									  stringToSendToWebBrowser +=
																	"<a href = \"../moodpage.html?mood="+imood.moodname+"\"><h5 class=\" flow-text blue-text text-darken-2\">"+imood.moodname+"</h5></a>\n"+ 
																	"          <p class=\"flow-text\">"+imood.shortmooddescription+"</p>\n" + 
																	"        </div>\n";
									if(moodcount < 4) {
										moodcount++;
									}else {
										stringToSendToWebBrowser +=	"        </div>\n"+
																	"      <div class=\"row\">\n" ;
										 moodcount = 1;
									}
									
					}
			 	}
				

			 	stringToSendToWebBrowser +=
					"      </div>\n" + 

					"      </div>\n" + 
					"    </div>\n" + 
					"  </div>\n";
			stringToSendToWebBrowser += PageElements.scripts() + PageElements.footer2();
			stringToSendToWebBrowser += "</body>\n" + 
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
					"  <input class=\"btn waves-effect waves-light  deep-orange \" type=\"submit\" value=\"Submit\">\n" + 
					"</form> \n" + 
					"    </div>\n" + 
					"    <div class=\"col s6 m0\">\n" + 
					"      <h3>We are always looking for more artists</h3> \n" + 
					"      <p style = lead>Add an artist on this page</p>\n" + 
					"      <bt><p>more text...</p>\n" + 
					"    </div>\n" + 
					"  </div>\n" + 
					"</div>";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer2();

			stringToSendToWebBrowser += 
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
					"    <div class=\"col s8\">\n" + 
					"			<h2>Add Artist</h2>\n" + 
					"			<form action=\"../addartist.html\" role=\"form\" method = \"POST\" id = \"addartist\" enctype=\"multipart/form-data\">\n " + 
					" 			 Artist Name " + 
					" 			 <input type=\"text\" name=\"artistname\" placeholder=\"Name\" required>\n" + 
					" 			 <br>\n" + 
					"  			Description<input type=\"text\" name=\"artistdescription\" placeholder=\"description\">\n" + 
					" 			 <br><br>Upload Artist Image\n" + 
					"			<div class=\"form-group\">\n"+
					"                    <div class=\"col s12\">\n"+
					"                      <label for=\"artistimage\" class=\"control-label\">Upload an image of the artist</label>\n"+
					"                    </div>\n"+
					"                    <div class=\"col s10\">\n"+
					"                      <input type=\"file\" class=\"form-control\" id=\"artistimage\" name=\"artistimage\"\n"+
					"                      </div>\n"+
					"      </div>\n"+
					"    </div>\n"+
					"  	<br><br><br><br>"+

					"  			<input class=\"btn waves-effect waves-light deep-orange \" type=\"submit\" value=\"Submit\">\n" + 
					"			</form> \n" + 
					"    </div>\n" + 
					"    <div class=\"col s4\">\n" + 
					"      <h3>We are always looking for more artists</h3> \n" + 
					"      <p style = lead>Add an artist on this page</p>\n" + 
					"      <bt><p>more text...</p>\n" + 
					"    </div>\n" + 
					"  </div>\n" + 
					"</div>";
			stringToSendToWebBrowser +=	PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser +=
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
					"	<h2>song Added</h2>\n";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser +=
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
			File uploaded = new File(iartist.artistImage);
			int ind = iartist.artistImage.lastIndexOf('.');
			String extension = iartist.artistImage.substring(ind);
			uploaded.renameTo(new File("httpdocs/images/artistimages/"+iartist.uniqueID+extension));
			iartist.artistImage = "images/artistimages/"+iartist.uniqueID+extension;
			artists.put(iartist.uniqueID, iartist);
			db.commit();
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"<body>\n" + 
					"	<h2>artist Added</h2>\n";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser +=
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
			MVMap<String, Mood> moods= db.s.openMap("Mood");
			List<String> moodkeys = moods.keyList() ;
			Mood imood = new Mood();
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
					"<div class=\"col s12\" style=\"\">\n" + 
					"    <div class=\"container-fluid\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col s12 white\">\n" + 
					"          <div class=\"row\">\n" + 
					"            <div class=\"col s10  offset-s1\">\n" + 
					"              <h1 class=\"center-align\" contenteditable=\"false\" >Search results</h1>\n" + 
					"            </div>\n" + 
					"          </div>\n" + 
					"        </div>\n" + 
					"      </div>\n" + 
					"    </div>";
			//mood Search
			if(moodkeys.size() == 0) {
				stringToSendToWebBrowser += "<div class=\"col s12 white\">\n" + 
						"      <div class=\"row\">\n" + 
						"        <div class=\"col s12\">\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s10  offset-s1\">\n" + 
						"              <h2 class=\"\">Moods</h2>\n" + 
						"            </div>\n" + 
						"          </div>\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s12\">\n" + 
						"              <div class=\"row\">\n" + 
						"                <div class=\"col s10  offset-s1\">\n" + 
						"                  <p class=\"lead\">No Moods in Database</p>\n" + 
						"                </div>\n" + 
						"              </div>\n" + 
						"            </div>\n" + 
						"          </div>\n" + 
						"        </div>\n" + 
						"      </div>\n" + 
						"    </div>\n" + 
						"  </div>";
			}else {
				stringToSendToWebBrowser += "    <div class=\"col s12 white\">\n" + 
						"      <div class=\"row\">\n" + 
						"        <div class=\"col s12\">\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s10  offset-s1\">\n" + 
						"              <h2 class=\"\">Mood</h2>\n" + 
						"            </div>\n" + 
						"          </div>\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s12\">\n" + 
						"              <div class=\"row\">\n" + 
						"                <div class=\"col s10  offset-s1\">";
				int resultcount = 0;
				String searchresult = "";
				for(int i = 0; i<moodkeys.size();i++) {
					String moodName = moodkeys.get(i);
					imood = moods.get(moodName);
					if (imood.moodname.toLowerCase().contains(searchTerm.toLowerCase())) {
						searchresult += "<a href = \"../moodpage.html?mood="+imood.moodname+"\"><h5 class=\"blue-text text-darken-2\">"+imood.moodname+"</h5></a>\n";
						resultcount++;
					}        				
				}
				if(resultcount == 0) {
					searchresult += "<p class=\"lead\">No Moods found</p>\n";
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
			//end of mood Search      
			//artist Search
			if(artistkeys.size() == 0) {
				stringToSendToWebBrowser += "<div class=\"col s12 white\">\n" + 
						"      <div class=\"row\">\n" + 
						"        <div class=\"col s12\">\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s10  offset-s1\">\n" + 
						"              <h2 class=\"\">Artist</h2>\n" + 
						"            </div>\n" + 
						"          </div>\n" + 
						"          <div class=\"row\">\n" + 
						"            <div class=\"col s10  offset-s1\">\n" + 
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
				stringToSendToWebBrowser += "    <div class=\"col s12 white\">\n" + 
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
						searchresult += "<a href = \"../artistpage.html?artist="+iartist.uniqueID+"\"><h5 class=\"blue-text text-darken-2\">"+iartist.artistName+"</h5></a>\n";
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
				stringToSendToWebBrowser += "<div class=\"col s12 white\">\n" + 
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
				stringToSendToWebBrowser += "    <div class=\"col s12 white\">\n" + 
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
						searchresult += "<a href = \"../songpage?song="+isong.uniqueID+"\"><h5 class=\"blue-text text-darken-2\">"+isong.songtitle;
						resultcount++;
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
				
			//scripts
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer2();
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
					"					<a href = \"../artistpage.html?artist="+iartist.uniqueID+"\"><h3 class=\"blue-text text-darken-2\">"+"Artist: "+iartist.artistName+"</h3></a>\n"+
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
					"        </div>\n" ;
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser +=
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
				stringToSendToWebBrowser +="            <div class=\"col s2 align-center\" style=\"\"><img class=\"circle responsive-img\" src=\""+iartist.artistImage+"\" width=\"1600px\" height=\"1600px\"></div>\n";
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
									"                    <a href = \"../songpage?song="+isong.uniqueID+"\"><h5 class=\"blue-text text-darken-2\">"+isong.songtitle +" - " +iartist.artistName+"</h5></a>\n"+
									"                    </div>\n";
						}
					}
				}
			}

			stringToSendToWebBrowser += "                    </div>\n"+
					"                    </div>\n"+
					"                    </div>\n"+
					"                    </div>\n"+
					"                    </div>\n"+
					"                    </div>\n"+
					"                    </div>\n"+
					"                    </div>\n"+
					"                    </div>\n"+
					"                    </div>\n"+
					"                    </div>\n"+
					PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser +="</body>\n" + 
					"\n" + 
					"</html>";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}else if(toProcess.path.equalsIgnoreCase("addmood.html")) {
			Mood imood = new Mood();
			imood.moodname = toProcess.params.get("moodname");	
			imood.moodimage = toProcess.params.get("moodimage");
			imood.shortmooddescription = toProcess.params.get("shortmooddescription");
			imood.mooddescription = toProcess.params.get("mooddescription");	
			MVMap<String, Mood> moods= db.s.openMap("Mood");
			File uploaded = new File(imood.moodimage);
			int ind = imood.moodimage.lastIndexOf('.');
			String extension =imood.moodimage.substring(ind);
			uploaded.renameTo(new File("httpdocs/images/moodimages/"+imood.moodname+extension));
			imood.moodimage = "images/artistimages/"+imood.moodname+extension;
			moods.put(imood.moodname, imood);
			db.commit();
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"<body>\n" + 
					"	<h2>Mood added</h2>\n";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser += 
					"</body>\n" + 
					"</html>\n" + 
					"";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;



		}else if(toProcess.path.equalsIgnoreCase("moodpage.html")) {
			String mood;
			mood = toProcess.params.get("mood").toLowerCase();
			Song isong = new Song();
			Artist iartist = new Artist();
			MVMap<String, Song> songs= db.s.openMap("Song");
			List<String> songkeys = songs.keyList() ;
			MVMap<String, Artist> artists= db.s.openMap("Artist");
			List<String> artistkeys = artists.keyList() ;
			MVMap<String, Mood> moods= db.s.openMap("Mood");
			List<String> moodkeys = moods.keyList() ;
			Mood imood = new Mood();
			for(int i = 0; i<moodkeys.size();i++) {
				String moodUniqueID = moodkeys.get(i);
				if(mood.equalsIgnoreCase(moodUniqueID)) {
					imood = moods.get(moodUniqueID);
				}
			}
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"  <div class=\"col s12 white\">\n" + 
					"    <div class=\"container-fluid\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col 10 offset-s1 white\">\n" + 
					"          <div class=\"row \">\n" + 
					"            <div class=\"col s2 white\"></div>\n" + 
					"            <div class=\"col s12\">\n" + 
					"              <h1 class=\"\" style=\"\">"+ imood.moodname +"</h1>\n" + 
					"            </div>\n" + 
					"          </div>\n" + 
					"          <div class=\"row\" style=\"\">\n" ;
			  if(imood.moodimage != null && imood.moodimage != "" ) {
					stringToSendToWebBrowser +="<div class=\"col s3\"><img class=\"circle responsive-img\" src=\""+imood.moodimage+"\"width=\"1600px\" height=\"1600px\" ></div>";
				}else {
					stringToSendToWebBrowser +=" div class=\"col s3\"> <img class=\"circle responsive-img\" src=\"https://static.pingendo.com/img-placeholder-1.svg\" width=\"150\" alt=\"Card image cap\"></div>\n" ;
				}
			stringToSendToWebBrowser+="            <div class=\"col s8 offset-s1\">\n" + 
					"              <div class=\"row\" style=\"	min-height: 200px;\">\n" + 
					"                <div class=\"col-md-12\" style=\"\">\n" + 
					"                  <p class=\"lead\" style=\"\">"+ imood.mooddescription +"<br></p>\n" + 
					"                </div>\n" + 
					"              </div>\n" + 

            				"              <div class=\"row\">\n" + 
            				"                <div class=\"col s12 \">\n" + 
            				"                  <h3 class=\"\">Songs</h3>\n"+
            				"<div class=\"row\">";       

			if (imood.songID == null) {
				stringToSendToWebBrowser += 	"                    <div class=\"col s12 \">\n" + 
						"                      <p class=\"lead\">no songs found for this mood</p>\n" +
						"                    </div>\n";
			}else {
				for(int i = 0; i < songkeys.size();i++) {

					String songId = songkeys.get(i);
					isong = songs.get(songId);
					String songID = isong.uniqueID;
					for(int j = 0; j < imood.songID.size() ;j++) {
						String moodSong = imood.songID.get(j);
						if(songID.equalsIgnoreCase(moodSong)) {
							//
							for(int q  = 0 ; q< artistkeys.size();q++) {
								String artistname = artistkeys.get(q);
								iartist = artists.get(artistname);
								if(iartist.artistSongs != null) {
									for(int k = 0; k < iartist.artistSongs.size() ;k++) {
									String artistSong = iartist.artistSongs.get(k);
									if(songID.equalsIgnoreCase(artistSong)) {
										stringToSendToWebBrowser += 	"                    <div class=\"col s12 \">\n" + 
												"                    <a href = \"../songpage?song="+isong.uniqueID+"\"><h5 class=\"blue-text text-darken-2\">"+isong.songtitle +" - " +iartist.artistName+"</h5></a>\n"+
												"                    </div>\n";
									}
								}
								}
							}
							
							}

							//

						}
					}
				}
			

			stringToSendToWebBrowser += "                    </div>\n"+
					 "                    </div>\n"+
					 "                    </div>\n"+
					 "                    </div>\n"+
					 "                    </div>\n"+
					 "                    </div>\n"+
					 "                    </div>\n"+
					 "                    </div>\n"+
					 "                    </div>\n"+
					 "                    </div>\n"+
					 "                    </div>\n"+
					 
			PageElements.scripts()+ PageElements.footer2()+"                    </div>\n";
			stringToSendToWebBrowser +="</body>\n" + 
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
					"			<form action=\"../addmood.html\" role=\"form\" method = \"POST\"id = \"addmood\" enctype=\"multipart/form-data\">\n " + 
					" 			 Mood Name<input type=\"text\" name=\"moodname\" placeholder=\"Name\">\n" + 
					" 			 <br>image\n" + 
					//" 			 Mood Image <input type=\"text\" name=\"moodimage\" placeholder=\"image\">\n" + 
					"			<div class=\"form-group\">\n"+
					"                    <div class=\"col s12\">\n"+
					"                      <label for=\"moodimage\" class=\"control-label\">Upload an image for the mood</label>\n"+
					"                    </div>\n"+
					"                    <div class=\"col s10\">\n"+
					"                      <input type=\"file\" class=\"form-control\" id=\"moodimage\" name=\"moodimage\"\n"+
					"                      </div>\n"+
					"      </div>\n"+
					"  </div>\n"+
					" 			 <br>\n" + 
					" 			 <br>\n" + 
					"  			<br>short Description<input type=\"text\" name=\"shortmooddescription\" placeholder=\"short description\">\n" + 
					"  			<br><br>\n" + 
					"  			Description<input type=\"text\" name=\"mooddescription\" placeholder=\"description\">\n" + 
					"  			<br><br>\n" + 
					"  			<input type=\"submit\" value=\"Submit\">\n" + 
					"			</form> \n" + 
					"    </div>\n" +  
					"  </div>\n" + 
					"</div>"+
        			"\n" ;
					stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer2();
					stringToSendToWebBrowser += 
        			"</body>\n" + 
        			"</html> ";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;      	
		}

		return false;   
	}
}