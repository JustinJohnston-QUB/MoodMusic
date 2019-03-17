
package views;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.h2.command.dml.Set;
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
			 		Mood imood0 = new Mood();
					imood0.moodname = "Ecstatic";	
					imood0.shortmooddescription = "Get Happy!";
					imood0.mooddescription ="If you're blissful, you're happy and at peace.<br> You can never have too many blissful moments. <br>If you're feeling blissful, then you're lucky.<br> This is a word for total contentment and major happiness, along with a kind of Zen-like peace.";	
					imood0.moodimage = "images/moodimages/happy.jpg";
					moods.put(imood0.moodname, imood0);
					Mood imood1 = new Mood();
					imood1.moodname = "Rage";	
					imood1.shortmooddescription = "Get Even,Get Angry";
					imood1.mooddescription ="If you're mad about something and you're not going to take it anymore, you're feeling anger, a strong emotion you experience when you think someone has done you wrong.<br> If you want to scream and kick, you're feeling anger.";	
					imood1.moodimage = "images/moodimages/angry.jpg";
					moods.put(imood1.moodname, imood1);
					Mood imood2 = new Mood();
					imood2.moodname = "Melancholy";	
					imood2.shortmooddescription = "Cry it Out";
					imood2.mooddescription ="When you're sad, you feel unhappy. ... You might use the adjective sad informally to describe something that's pathetic or that you feel scornful or disdainful about.<br>For example, you might comment on your friend's elaborate homemade hat by saying, \"That hat is just sad,\" though it wouldn't be very nice of you to say it.";	
					imood2.moodimage = "images/moodimages/Melancholy.jpg";
					moods.put(imood2.moodname, imood2);
			 		Mood imood4= new Mood();
					imood4.moodname = "Romance";	
					imood4.shortmooddescription = "Love is in the Air";
					imood4.mooddescription ="Love encompasses a range of strong and positive emotional and mental states, from the most sublime virtue or good habit, the deepest interpersonal affection and to the simplest pleasure.<br>Love is unconditional. The word unconditional means that there are no expectations or limitations set. To love unconditionally is a difficult thing, and most humans aren't good at that.<br>But true love really does love without trying to change the other person";	
					imood4.moodimage = "images/moodimages/Romantic.jpg";
					moods.put(imood4.moodname, imood4);
					db.commit();
			 	}
			 		for(int i = 0; i<moodkeys.size();i++) {
						String moodUniqueID = moodkeys.get(i);
							imood = moods.get(moodUniqueID);
						
								
									  if(imood.moodimage != null && imood.moodimage != "" ) {
											stringToSendToWebBrowser +="<a href = \"../moodpage.html?mood="+imood.moodname+"\">"+"<div class=\"col s3\"><img class=\"circle responsive-img\" src=\""+imood.moodimage+"\"></a>";
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

				

			 	stringToSendToWebBrowser +=
					"      </div>\n" + 

					"      </div>\n" + 
					"    </div>\n" + 
					"  </div>\n";
			stringToSendToWebBrowser += PageElements.scripts() + PageElements.footer();
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
					"    <div class=\"row\">\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6\"> <!Right Hand Side Panel-->\r\n" + 
        			"<img class=\"materialboxed\" width=\"100%\" src=\"images/homepage/addsong.gif\">"+
        			"   </div>\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6 \"> <!-- Left Hand Panel -->\r\n" + 
					"		<h2>Add song</h2>\n" + 
					"			<P class = \"flow-text\">That song you love is missing! Dont worry you can add it right here, if the singer/band is missing, you should head over to the add artist page and add that first.</p>\n" + 
					"		<form action=\"../addsong.html\" role=\"form\" method = \"POST\" id = \"addsong\" enctype=\"multipart/form-data\">\n" + 
					"  			Song Title " + 
					"  			<input type=\"text\" name=\"songtitle\" placeholder=\"title\" required>\n" + 
					"  			<br>\n" + 
					" 			song Length <input type=\"time\" name=\"songlength\" default value=\"00:00\"required>\n" + 
					"  			<br>\n" + 
					" 			<br>Upload Song Image\n" + 
					"			<div class=\"form-group\">\n"+
					"                    <div class=\"col s12\">\n"+
					"                      <label for=\"songimage\" class=\"control-label\">Upload an image for this song</label>\n"+
					"                    </div>\n"+
					"                    <div class=\"col s11 offset-s1\">\n"+
					"                      <input type=\"file\" class=\"form-control\" id=\"songimage\" name=\"songimage\" required\n"+
					"                      </div>\n"+
					"      		</div>\n"+
					"  			<br>\n" +
					"      </div>\n"+
					"  			<br>\n" +
					"  			song Link <input type=\"text\" name=\"songlink\" placeholder=\"Enter a link to a YouTube video if one is available \">\n" + 
					"  			<br>\n" +
					"			<div class=\"input-field\"> "+
					"			Artist Name<select name=\"Artist\" class = \"browser-default\" form=\"addsong\"required>\n"+
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
        			//
        			"      </div>\r\n" + 
        			"\r\n" + 
        			"    </div>"+
        			"        <!-- Footer -->\r\n" + PageElements.scripts()+ PageElements.footer()+
        			"\r\n" + 
        			"        \r\n" + 
        			"    </head>\r\n" + 
        			"</html>";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;


			//Page with form for adding Artists           	
		}else if(toProcess.path.equalsIgnoreCase("artist.html")){
			String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
					PageElements.header()+ "<body>\n"  + PageElements.Navbar()+ PageElements.Search()+
					"    <div class=\"row\">\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6\"> <!Right Hand Side Panel-->\r\n" + 
        			"<img class=\"materialboxed\" width=\"100%\" src=\"images/homepage/addartist.gif\">"+
        			"   </div>\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6\"> <!-- Left Hand Panel -->\r\n" + 
        			"			<h2>Add Artist</h2>\n" + 
        			"			<P class = \"flow-text\">Add your favourite artist or if you sing or play an instrument, go ahead and add yourself, we are always looking for artists to add to our ever expending list.<br> Dont forget to add some songs so people can hear the music! </p>\n" + 
					"			<form action=\"../addartist.html\" role=\"form\" method = \"POST\" id = \"addartist\" enctype=\"multipart/form-data\">\n " + 
					" 			 Artist Name " + 
					" 			 <input type=\"text\" name=\"artistname\" placeholder=\"Name\" required>\n" + 
					" 			 <br>\n" + 
					"  			Description<input type=\"text\" name=\"artistdescription\" placeholder=\"description\"required>\n" + 
					" 			 <br><br>Upload Artist Image\n" + 
					"			<div class=\"form-group\">\n"+
					"                    <div class=\"col s12\">\n"+
					"                      <label for=\"artistimage\" class=\"control-label\">Upload an image of the artist</label>\n"+
					"                    </div>\n"+
					"                    <div class=\"col s10\">\n"+
					"                      <input type=\"file\" class=\"form-control\" id=\"artistimage\" name=\"artistimage\"required\n"+
					"                      </div>\n"+
					"      </div>\n"+
					"    </div>\n"+
					"  	<br><br><br><br>"+

					"  			<input class=\"btn waves-effect waves-light deep-orange \" type=\"submit\" value=\"Submit\">\n" + 
					"			</form> \n" + 
        			"    </div>"+
        			"    </div>"+
        			"        <!-- Footer -->\r\n" + PageElements.scripts()+ PageElements.footer()+

        			"\r\n" + 
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
			isong.songImage =  toProcess.params.get("songimage");
			if(!isong.songLink.contains("www.youtube.com/watch?v=")) {
				isong.songLink = null;
			}
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
			//
			File uploaded = new File(isong.songImage);
			int ind = isong.songImage.lastIndexOf('.');
			String extension = isong.songImage.substring(ind);
			uploaded.renameTo(new File("httpdocs/images/songimages/"+isong.uniqueID+extension));
			isong.songImage = "images/songimages/"+isong.uniqueID+extension;
			//
			songs.put(isong.uniqueID, isong);
			artists.put(art1.uniqueID, art1);
			moods.put(mood1.moodname, mood1);
			db.commit();
			//"songpage.html?song ="+isong.uniqueID
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"<body>\n" + 
					"	<h2>song Added</h2>\n";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer();
			stringToSendToWebBrowser +=
					"</body>\n" + 
							"</html>\n" + 
							"";
			//toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			
			String url = "/songpage?song="+isong.uniqueID;
			toProcess.r = new WebResponse( WebResponse.HTTP_REDIRECT, WebResponse.MIME_HTML,
					stringToSendToWebBrowser);
			toProcess.r.addHeader( "Location", url );

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
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer();
			stringToSendToWebBrowser +=
					"</body>\n" + 
							"</html>\n" + 
							"";
			//toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			String url = "/artistpage.html?artist="+iartist.uniqueID;
			toProcess.r = new WebResponse( WebResponse.HTTP_REDIRECT, WebResponse.MIME_HTML,
					stringToSendToWebBrowser);
			toProcess.r.addHeader( "Location", url );

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
						searchresult += "<a href = \"../moodpage.html?mood="+imood.moodname+"\">"+
											"<div class = \"col s12 z-depth-1  \">"+
											"	<div class = \"col s3.hide-on-small-only\" >"+
											"		<img src =\""+imood.moodimage+"\" height = \"150px\">\n"+
											"	</div>"+
											"	<div class = \"col s9\">"+
											"		<h5 class=\"black-text\">"+imood.moodname+"<br></h5>\n"+
											"		<p class=\"black-text truncate\">"+imood.mooddescription+"</p>"+
											"	</div>"+
											"</div></a>";
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
						searchresult += "<a href = \"../artistpage.html?artist="+iartist.uniqueID+"\">"+
										"<div class = \"col s12 z-depth-1  \">"+
										"	<div class = \"col s3.hide-on-small-only\" >"+
										"		<img src =\""+iartist.artistImage+"\" height = \"150px\">\n"+
										"	</div>"+
										"	<div class = \"col s9\">"+
										"		<h5 class=\"black-text\">"+iartist.artistName+"<br></h5>\n"+
										"		<p class=\"black-text truncate\">"+iartist.artistDescription+"</p>"+
										"	</div>"+
										"</div></a>";
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
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer();
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
			String videoString = "";
			String thissong = isong.uniqueID;
			String songtitle = isong.songtitle;
			if(isong.songLink == null) {
				videoString += "                  <p class=\"lead\" style=\"\">" + "video: no youtube video <br></p>\n" ; 
			}else {
					String[] youtubeparts =isong.songLink.split("=");
					String youtubevideono = youtubeparts[1].trim();
					videoString +="			<div class=\"video-container\">\r\n" + 
									"			<iframe src=\"http://www.youtube.com/embed/"+ youtubevideono.trim() +"\"></iframe>"+
									"      </div>\r\n" + 
									"        ";	
			}	

			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search();
					
			stringToSendToWebBrowser +=
										"  <div id=\"index-banner\" class=\"parallax-container\">\r\n" + 
										"    <div class=\"section no-pad-bot\">\r\n" + 
										"      <div class=\"container\">\r\n" + 
										"        <br><br>\r\n" + 
										"        <h1 class=\"header center white-text text-lighten-2\"><b>Song: "+isong.songtitle+"</b></h1>\r\n" + 
										"        <h2 class=\"header center white-text text-lighten-2\"><b>Artist:"+iartist.artistName+"</b></h2>\r\n" + 
										"        <div class=\"row center\">\r\n" + 
										"        </div>\r\n" + 
										"        <div class=\"row center\">\r\n" + 
										"        </div>\r\n" + 
										"        <br><br>\r\n" + 
										"\r\n" + 
										"      </div>\r\n" + 
										"    </div>\r\n" ;
			if(iartist.artistImage != null && iartist.artistImage != "" ) {
			stringToSendToWebBrowser +=	"    <div class=\"parallax\"><img src=\""+isong.songImage+"\" alt=\"Artist Image\"></div>\r\n" +
										"  </div> ";
			}else {
			stringToSendToWebBrowser +=	"    <div class=\"parallax\"><img src=\"https://static.pingendo.com/img-placeholder-3.svg\" alt=\"Artist Image\"></div>\r\n" +
										"  </div> ";			
			}
			stringToSendToWebBrowser+=	"  <div class=\"container\">\r\n" + 
										"    <div class=\"section\">\r\n" + 
										"\r\n" + 
										"      <div class=\"row\">\r\n" + 
										"        <div class=\"col s12 center\">\r\n" + 
										"          <h3><i class=\"mdi-content-send black-text\"></i></h3>\r\n" + 
										"          <h4>Song Information</h4><br>\r\n" + 
										"          <p class=\"left-align light\">Song title: "+isong.songtitle+"</p>\r\n" + 
										"          <a href = \"../artistpage.html?artist="+iartist.uniqueID+"\"><p class=\"left-align blue-text text-darken-2\">Artist: "+iartist.artistName+"</p></a>\r\n" + 
										"          <p class=\"left-align light\">Song Length: "+isong.songlength+"</p>\r\n" + 
										"          <a href = \"../moodpage.html?mood="+imood.moodname+"\"><p class=\"left-align blue-text text-darken-2\">Mood: "+imood.moodname+"</p></a>\r\n" + 
										"        </div>\r\n" + 
										"      </div>\r\n" + 
										"\r\n" + 
										"    </div>\r\n" + 
										"  </div>";    
			stringToSendToWebBrowser += "  <div class=\"container\">\r\n"+
			"         		<h2>"+songtitle+" Music Video</h2>\n"+videoString;
			if (imood.songID == null || imood.songID.size()<=1) {
			stringToSendToWebBrowser += 	"  <div class=\"container\">\r\n" + 
						"    <div class=\"section\">\r\n" + 
						"\r\n" + 
						"      <div class=\"row\">\r\n" + 
						"        <div class=\"col s12 center\">\r\n" + 
						"          <h3><i class=\"mdi-content-send black-text\"></i></h3>\r\n" + 
						"          <h4>You Might also Like</h4><br>\r\n" + 
						"          <a href = \"song.html\"<h4 class=\"left-align blue-text text-darken-2\">We Dont have any similar songs,click here to add one?</h4></a>\r\n" + 
						"        </div>\r\n" + 
						"      </div>\r\n" + 
						"\r\n" + 
						"    </div>\r\n" + 
						"  </div>";    	
			}else {
				
			stringToSendToWebBrowser +=	"  <div class=\"container\">\r\n" + 
					"    <div class=\"section\">\r\n" + 
					"\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col s12 center\">\r\n" + 
					"          <h3><i class=\"mdi-content-send black-text\"></i></h3>\r\n" + 
					"          <h4>You Might also Like</h4><br>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n"; 
			//stringToSendToWebBrowser +=	"  <div class=\"container\">\r\n";
			
			if(imood.songID.size()<3) {
				for(int i = 0; i < imood.songID.size();i++) {  
					String songId = imood.songID.get(i);
					isong = songs.get(songId);
					String songName = isong.uniqueID;	
					for(int j = 0; j < songkeys.size() ;j++) {
						String songUniqueID = songkeys.get(j);
						isong = songs.get(songUniqueID);
						if(songName.equalsIgnoreCase(isong.uniqueID) && !songName.equalsIgnoreCase(thissong)) {
						
						stringToSendToWebBrowser +=	"      <div class=\"row\">\r\n" +
													"    <div class=\"col s10 offset-s1 m6 l4\">\r\n" + 
													"      <div class=\"card small\">\r\n" + 
													"        <div class=\"card-image\">\r\n" + 
													"          <img src=\""+isong.songImage+"\">\r\n" + 
													"          <span class=\"card-title\">Same Mood</span>\r\n" + 
													"        </div>\r\n" + 
													"        <div class=\"card-content\">\r\n" + 
													"          <p class = \"flow-text\">"+isong.songtitle+"</p>\r\n" + 
													"        </div>\r\n" + 
													"        <div class=\"card-action\">\r\n" + 
													"          <a href=\"../songpage?song="+isong.uniqueID+"\">click to View</a>\r\n" + 
													"        </div>\r\n" + 
													"      </div>\r\n" + 
													"    </div>";
						
						
						}
					}
				}
			}else {
				HashSet<Integer> randomSet = new HashSet<Integer>();
				for(int i = 0; i < 3 ;i++) { 
					int r = (int) ((Math.random()*imood.songID.size()));
					randomSet.add(r);
				}
				ArrayList<Integer> randoms = new ArrayList<Integer>(randomSet);
				for(int i = 0; i < randoms.size() ;i++) {  
					
					String songId = imood.songID.get(randoms.get(i));
					isong = songs.get(songId);
					String songName = isong.uniqueID;
					
					for(int j = 0; j < songkeys.size() ;j++) {
						String songUniqueID = songkeys.get(j);
						isong = songs.get(songUniqueID);
						if(songName.equalsIgnoreCase(isong.uniqueID) && !songName.equalsIgnoreCase(thissong)) {
						
						stringToSendToWebBrowser +=	"      <div class=\"row\">\r\n" +
													"    <div class=\"col s10 offset-s1 m6 l4\">\r\n" + 
													"      <div class=\"card small\">\r\n" + 
													"        <div class=\"card-image\">\r\n" + 
													"          <img src=\""+isong.songImage+"\">\r\n" + 
													"          <span class=\"card-title orange darken-3\"><b>More of the Same Mood</b></span>\r\n" + 
													"        </div>\r\n" + 
													"        <div class=\"card-content flow-text\">\r\n" + 
													"          <p class = \"flow-text\">"+isong.songtitle+"</p>\r\n" + 
													"        </div>\r\n" + 
													"        <div class=\"card-action\">\r\n" + 
													"          <a href=\"../songpage?song="+isong.uniqueID+"\">click to View</a>\r\n" + 
													"        </div>\r\n" + 
													"      </div>\r\n" + 
													"    </div>";
						
						
						}
					}
				}
			}
			
			stringToSendToWebBrowser +=				//"    </div>\r\n" +
								"   </div>\r\n" +
								"   </div>\r\n" +
								"   </div>\r\n" +
								"  </div>";
			
			}
			stringToSendToWebBrowser +=			"    </div>\r\n" +
												"    </div>\r\n" +
												"    </div>\r\n" +
												"  </div>\n";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer();
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
			String stringToSendToWebBrowser = 	PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
												"  <div id=\"index-banner\" class=\"parallax-container\">\r\n" + 
												"    <div class=\"section no-pad-bot\">\r\n" + 
												"      <div class=\"container\">\r\n" + 
												"        <br><br>\r\n" + 
												"        <h1 class=\"header center white-text text-lighten-2\"><b>"+iartist.artistName+"</b></h1>\r\n" + 
												"        <div class=\"row center\">\r\n" + 
												"        </div>\r\n" + 
												"        <div class=\"row center\">\r\n" + 
												"        </div>\r\n" + 
												"        <br><br>\r\n" + 
												"\r\n" + 
												"      </div>\r\n" + 
												"    </div>\r\n" ;
					if(iartist.artistImage != null && iartist.artistImage != "" ) {
						stringToSendToWebBrowser +=	"    <div class=\"parallax\"><img src=\""+iartist.artistImage+"\" alt=\"Artist Image\"></div>\r\n" +
													"  </div> ";
					}else {
						stringToSendToWebBrowser +=	"    <div class=\"parallax\"><img src=\"https://static.pingendo.com/img-placeholder-3.svg\" alt=\"Artist Image\"></div>\r\n" +
													"  </div> ";			
					}
					stringToSendToWebBrowser+=	"  <div class=\"container\">\r\n" + 
												"    <div class=\"section\">\r\n" + 
												"\r\n" + 
												"      <div class=\"row\">\r\n" + 
												"        <div class=\"col s12 center\">\r\n" + 
												"          <h3><i class=\"mdi-content-send black-text\"></i></h3>\r\n" + 
												"          <h4>Artist Information</h4><br>\r\n" + 
												"          <p class=\"left-align light\">"+iartist.artistDescription+"</p>\r\n" + 
												"        </div>\r\n" + 
												"      </div>\r\n" + 
												"\r\n" + 
												"    </div>\r\n" + 
												"  </div>";    

			if (iartist.artistSongs == null) {
				stringToSendToWebBrowser += 	"  <div class=\"container\">\r\n" + 
												"    <div class=\"section\">\r\n" + 
												"\r\n" + 
												"      <div class=\"row\">\r\n" + 
												"        <div class=\"col s12 center\">\r\n" + 
												"          <h3><i class=\"mdi-content-send black-text\"></i></h3>\r\n" + 
												"          <h4>"+iartist.artistName+" Songs</h4><br>\r\n" + 
												"          <a href = \"song.html\"<h4 class=\"left-align blue-text text-darken-2\">no songs for this artist in the database,click here to add one?</h4></a>\r\n" + 
												"        </div>\r\n" + 
												"      </div>\r\n" + 
												"\r\n" + 
												"    </div>\r\n" + 
												"  </div>";    	
			}else {
				stringToSendToWebBrowser +=	"  <div class=\"container\">\r\n" + 
											"    <div class=\"section\">\r\n" + 
											"\r\n" + 
											"      <div class=\"row\">\r\n" + 
											"        <div class=\"col s12 center\">\r\n" + 
											"          <h3><i class=\"mdi-content-send black-text\"></i></h3>\r\n" + 
											"          <h4>"+iartist.artistName+" Songs</h4><br>\r\n" + 
											"        </div>\r\n" + 
											"      </div>\r\n" + 
											"\r\n" + 
											"    </div>\r\n" + 
											"  </div>\r\n"; 
				stringToSendToWebBrowser +=	"  <div class=\"container\">\r\n";
				for(int i = 0; i < songkeys.size();i++) {  
					String songId = songkeys.get(i);
					isong = songs.get(songId);
					String songName = isong.uniqueID;

					for(int j = 0; j < iartist.artistSongs.size() ;j++) {
						String artistSong = iartist.artistSongs.get(j);
						if(songName.equalsIgnoreCase(artistSong)) {
							
							stringToSendToWebBrowser +=	"      <div class=\"row\">\r\n" +
										"    <div class=\"col s10 offset-s1 m6 l4\">\r\n" + 
										"      <div class=\"card small\">\r\n" + 
										"        <div class=\"card-image\">\r\n" + 
										"          <img src=\""+isong.songImage+"\">\r\n" + 
										"          <span class=\"card-title\">Song</span>\r\n" + 
										"        </div>\r\n" + 
										"        <div class=\"card-content\">\r\n" + 
										"          <p class = \"flow-text\">"+isong.songtitle+"</p>\r\n" + 
										"        </div>\r\n" + 
										"        <div class=\"card-action\">\r\n" + 
										"          <a href=\"../songpage?song="+isong.uniqueID+"\">click to View</a>\r\n" + 
										"        </div>\r\n" + 
										"      </div>\r\n" + 
										"    </div>";
							
							
						}
					}
				}
				stringToSendToWebBrowser +=				"    </div>\r\n" +
														"   </div>\r\n" +
														"   </div>\r\n" +
														"   </div>\r\n" +
														"  </div>";

			}
			stringToSendToWebBrowser += "  <div class=\"container\">\r\n"+
					//artist images carousel
					"<div class=\"row white\">\n" + 
					"  <div class=\"col s12\">\n" +
					"        <div class=\"col 10 offset-s2 white\">\n" + 
					"         		<h1>"+iartist.artistName+ " Images</h1>\n"+
					"         </div>\n"+
					"  </div>\n";
					if (iartist.artistImages == null ) {
						stringToSendToWebBrowser +=	
						"<div class=\"row white\" >\n" + 
								"  <div class=\"col s12 white \">\n" +
								"        <div class=\"col 9 offset-s3 white\">\n" + 
								"         		<h5>We dont seem to have any images of "+" "+iartist.artistName +"</h5>\n"+
								"         </div>\n"+
								"  </div>\n";


					}else {
						stringToSendToWebBrowser +=
								"<div class=\"carousel carousel-slider\">\r\n" ;
										for(int i = 0; i <iartist.artistImages.size();i++) {
											stringToSendToWebBrowser += 
													"    <a class=\"carousel-item\"\">\r\n" + 
													"      <img src=\""+iartist.artistImages.get(i) + "\">\r\n" + 
													"    </a>\r\n" ; 
										}
										stringToSendToWebBrowser += "  </div>";
					}
					stringToSendToWebBrowser += "<div class=\"row white z-depth-3\">\n" +
												"        <div class=\"col 9 offset-s3 white\">\n" + 
												"         		<h5> Upload a picture below</h5>\n"+
												"         </div>\n"+
												"  <div class=\"col s12 white \" max-height =  \"500px>\"\n" +
												"        <div class=\"col 9 offset-s3 white\">\n" + 
												"			<form action=\"../addartistimages.html\" role=\"form\" method = \"POST\" id = \"addartistimages\" enctype=\"multipart/form-data\">\n " +  
												" 			Upload an Image\n" + 
												"			<input type=\"hidden\" id=\"artistid\" name=\"artistid\" value=\""+iartist.uniqueID+"\">"+
												"			<div class=\"form-group\">\n"+
												"                    <div class=\"col s12\">\n"+
												"                      <label for=\"addartistimages\" class=\"control-label\">Upload an image of the artist</label>\n"+
												"                    </div>\n"+
												"                    <div class=\"col s10\">\n"+
												"                      <input type=\"file\" class=\"form-control\" id=\"addartistimages\" name=\"addartistimages\"\n"+
												"                      </div>\n"+
												"      </div>\n"+
												"    </div>\n"+
												"  	<br><br><br><br>"+

												"  			<input class=\"btn waves-effect waves-light deep-orange \" type=\"submit\" value=\"Submit\">\n" + 
												"  	<br><br><br><br>"+
												"			</form> \n" + 
												"         </div>\n"+
												"  </div>\n";
					

			stringToSendToWebBrowser +=			"    </div>\r\n" +
												"    </div>\r\n" +
												"  </div>\n" + PageElements.scripts()+ PageElements.footer();
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
			imood.moodimage = "images/moodimages/"+imood.moodname+extension;
			moods.put(imood.moodname, imood);
			db.commit();
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"<body>\n" + 
					"	<h2>Mood added</h2>\n";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer();
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
			String stringToSendToWebBrowser = 	PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
												"  <div id=\"index-banner\" class=\"parallax-container\">\r\n" + 
												"    <div class=\"section no-pad-bot\">\r\n" + 
												"      <div class=\"container\">\r\n" + 
												"        <br><br>\r\n" + 
												"        <h1 class=\"header center white-text text-lighten-2\"><b>"+imood.moodname+"</b></h1>\r\n" + 
												"        <div class=\"row center\">\r\n" + 
												"        </div>\r\n" + 
												"        <div class=\"row center\">\r\n" + 
												"        </div>\r\n" + 
												"        <br><br>\r\n" + 
												"\r\n" + 
												"      </div>\r\n" + 
												"    </div>\r\n" ;
					if(imood.moodimage != null && imood.moodimage != "" ) {
						stringToSendToWebBrowser +=	"    <div class=\"parallax\"><img src=\""+imood.moodimage+"\" alt=\"Artist Image\"></div>\r\n" +
													"  </div> ";
					}else {
						stringToSendToWebBrowser +=	"    <div class=\"parallax\"><img src=\"https://static.pingendo.com/img-placeholder-3.svg\" alt=\"Artist Image\"></div>\r\n" +
													"  </div> ";			
					}
					stringToSendToWebBrowser+=	"  <div class=\"container\">\r\n" + 
												"    <div class=\"section\">\r\n" + 
												"\r\n" + 
												"      <div class=\"row\">\r\n" + 
												"        <div class=\"col s12 center\">\r\n" + 
												"          <h3><i class=\"mdi-content-send black-text\"></i></h3>\r\n" + 
												"          <h4>Artist Information</h4><br>\r\n" + 
												"          <p class=\"left-align light\">"+imood.mooddescription+"</p>\r\n" + 
												"        </div>\r\n" + 
												"      </div>\r\n" + 
												"\r\n" + 
												"    </div>\r\n" + 
												"  </div>";    

			if (imood.songID == null) {
				stringToSendToWebBrowser += 	"  <div class=\"container\">\r\n" + 
												"    <div class=\"section\">\r\n" + 
												"\r\n" + 
												"      <div class=\"row\">\r\n" + 
												"        <div class=\"col s12 center\">\r\n" + 
												"          <h3><i class=\"mdi-content-send black-text\"></i></h3>\r\n" + 
												"          <h4>"+imood.moodname+" Songs</h4><br>\r\n" + 
												"          <a href = \"song.html\"<h4 class=\"left-align blue-text text-darken-2\">no songs for this artist in the database,click here to add one?</h4></a>\r\n" + 
												"        </div>\r\n" + 
												"      </div>\r\n" + 
												"\r\n" + 
												"    </div>\r\n" + 
												"  </div>";    	
			}else {
				stringToSendToWebBrowser +=	"  <div class=\"container\">\r\n" + 
											"    <div class=\"section\">\r\n" + 
											"\r\n" + 
											"      <div class=\"row\">\r\n" + 
											"        <div class=\"col s12 center\">\r\n" + 
											"          <h3><i class=\"mdi-content-send black-text\"></i></h3>\r\n" + 
											"          <h4>"+imood.moodname+" Songs</h4><br>\r\n" + 
											"        </div>\r\n" + 
											"      </div>\r\n" + 
											"\r\n" + 
											"    </div>\r\n" + 
											"  </div>\r\n"; 
				stringToSendToWebBrowser +=	"  <div class=\"container\">\r\n";
				for(int i = 0; i < songkeys.size();i++) {  
					String songId = songkeys.get(i);
					isong = songs.get(songId);
					String songName = isong.uniqueID;

					for(int j = 0; j < imood.songID.size() ;j++) {
						String moodsong = imood.songID.get(j);
						if(songName.equalsIgnoreCase(moodsong)) {
							
							stringToSendToWebBrowser +=	"      <div class=\"row\">\r\n" +
										"    <div class=\"col s10 offset-s1 m6 l4\">\r\n" + 
										"      <div class=\"card small\">\r\n" + 
										"        <div class=\"card-image\">\r\n" + 
										"          <img src=\""+isong.songImage+"\">\r\n" + 
										"          <span class=\"card-title\">"+imood.moodname+"</span>\r\n" + 
										"        </div>\r\n" + 
										"        <div class=\"card-content\">\r\n" + 
										"          <p class = \"flow-text\">"+isong.songtitle+"</p>\r\n" + 
										"        </div>\r\n" + 
										"        <div class=\"card-action\">\r\n" + 
										"          <a href=\"../songpage?song="+isong.uniqueID+"\">click to View</a>\r\n" + 
										"        </div>\r\n" + 
										"      </div>\r\n" + 
										"    </div>";
							
							
						}
					}
				}
				stringToSendToWebBrowser +=				"    </div>\r\n" +
														"   </div>\r\n" +
														"   </div>\r\n" +
														"   </div>\r\n" +
														"  </div>";

			}
			
			stringToSendToWebBrowser +=			"    </div>\r\n" +
												"    </div>\r\n" +
												"  </div>\n" + PageElements.scripts()+ PageElements.footer();
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
					stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer();
					stringToSendToWebBrowser += 
        			"</body>\n" + 
        			"</html> ";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;      	
		}else if(toProcess.path.equalsIgnoreCase("addartistimages.html")) {
			MVMap<String, Artist> artists= db.s.openMap("Artist");
			Artist iartist = artists.get(toProcess.params.get("artistid"));
			String newimage = toProcess.params.get("addartistimages");
			File uploaded = new File(newimage);
			int ind = newimage.lastIndexOf('.');
			String extension = newimage.substring(ind);
			if(iartist.artistImages !=null) {
				uploaded.renameTo(new File("httpdocs/images/artistimages/"+"Gallery_"+iartist.uniqueID+iartist.artistImages.size()+extension));
				newimage = "images/artistimages/"+"Gallery_"+iartist.uniqueID+iartist.artistImages.size()+extension;
				iartist.artistImages.add(newimage);
			}else {
				iartist.artistImages = new ArrayList<String>();
				uploaded.renameTo(new File("httpdocs/images/artistimages/"+"Gallery_"+iartist.uniqueID+iartist.artistImages.size()+extension));
				newimage = "images/artistimages/"+"Gallery_"+iartist.uniqueID+iartist.artistImages.size()+extension;
				iartist.artistImages.add(newimage);
			}
			artists.put(iartist.uniqueID, iartist);
			db.commit();
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"<body>\n" + 
					"	<h2>Image Added</h2>\n";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer();
			stringToSendToWebBrowser +=
					"</body>\n" + 
							"</html>\n" + 
							"";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;          		
		}

		return false;   
	}
}