package views;

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
        if(toProcess.path.equalsIgnoreCase("aboutus.html"))
        {
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
			
			if(imood.songID.size()<4) {
				for(int i = 0; i < imood.songID.size();i++) {  
					String songId = imood.songID.get(i);
					isong = songs.get(songId);
					String songName = isong.uniqueID;
					
					for(int j = 0; j < iartist.artistSongs.size() ;j++) {
					String artistSong = iartist.artistSongs.get(j);
						if(songName.equalsIgnoreCase(artistSong) && !songName.equalsIgnoreCase(thissong)) {
						
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
				for(int i = 0; i < 4 ;i++) {  
					int r = (int) ((Math.random()*imood.songID.size())+ 1);
					String songId = imood.songID.get(r);
					isong = songs.get(songId);
					String songName = isong.uniqueID;
					
					for(int j = 0; j < iartist.artistSongs.size() ;j++) {
					String artistSong = iartist.artistSongs.get(j);
						if(songName.equalsIgnoreCase(artistSong) && !songName.equalsIgnoreCase(thissong)) {
						
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
			}
			
			stringToSendToWebBrowser +=			//	"    </div>\r\n" +
								"   </div>\r\n" +
								"   </div>\r\n" +
								"   </div>\r\n" +
								"  </div>";
			
			}
			stringToSendToWebBrowser +=			"    </div>\r\n" +
												"    </div>\r\n" +
												"    </div>\r\n" +
												"  </div>\n";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser +=
					"</body>\n" + 
							"\n" + 
							"</html>";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
			// page which displays artists    
        }
        return false;
	}

}
