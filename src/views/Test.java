package views;

import java.util.List;

import org.h2.mvstore.MVMap;

import model.Artist;
import model.Product;
import model.Song;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class Test extends DynamicWebPage
{
	public Test(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
        if(toProcess.path.equalsIgnoreCase("aboutus.html"))
        {
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
				int rowcount = 0;
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
												"  </div>\n" + PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser +="</body>\n" + 
					"\n" + 
					"</html>";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
        }
        return false;
	}

}
