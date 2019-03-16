package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.h2.mvstore.MVMap;

import model.Artist;
import model.Mood;
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
        if(toProcess.path.equalsIgnoreCase("test"))
        {
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

        }
        return false;
	}

}
