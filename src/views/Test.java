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
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"  <div class=\"col s12 white\">\n" + 
					"    <div class=\"container-fluid\">\n" + 
					"      <div class=\"row\">\n" + 
					"        <div class=\"col 10 offset-s1 white\">\n" + 
					"          <div class=\"row\">\n" + 
					"            <div class=\"col s1\"></div>\n" + 
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
					//artist images carousel
					"<div class=\"row white\">\n" + 
					"  <div class=\"col s12 white \">\n" +
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
					

			stringToSendToWebBrowser +="  </div>\n" + PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser +="</body>\n" + 
					"\n" + 
					"</html>";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
        }
        return false;
	}

}
