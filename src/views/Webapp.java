package views;

import java.util.List;

import org.h2.mvstore.MVMap;

import model.Artist;
import model.Song;
import model.Tshirt;
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
        if(toProcess.path.equalsIgnoreCase("webapp.html"))
        {
        	//Lab 1 Task 4
        	//Change this string so that it contains HTML from a page you created in Pingendo 
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
        			"<html>\n" + 
        			"\n" + 
        			"<head>\n" + 
        			"  <meta charset=\"utf-8\">\n" + 
        			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
        			"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n" + 
        			"  <link rel=\"stylesheet\" href=\"Untitled.css\">\n" + 
        			"</head>\n" + 
        			"\n" + 
        			"<body style=\"\" >\n" + 
        			"  <nav class=\"navbar navbar-expand-md navbar-dark bg-primary\">\n" + 
        			"    <div class=\"container\"> <a class=\"navbar-brand\" href=\"#\">\n" + 
        			"        <i class=\"fa d-inline fa-lg fa-stop-circle\"></i>\n" + 
        			"        <b> Feelin' it</b>\n" + 
        			"      </a> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar16\">\n" + 
        			"        <span class=\"navbar-toggler-icon\"></span>\n" + 
        			"      </button>\n" + 
        			"      <div class=\"collapse navbar-collapse\" id=\"navbar16\">\n" + 
        			"        <ul class=\"navbar-nav ml-auto\">\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Features</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Pricing</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">About</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">FAQ</a> </li>\n" + 
        			"        </ul> <a class=\"btn navbar-btn ml-md-2 btn-light text-dark\">Contact us</a>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </nav>\n" + 
        			"  <div class=\"py-5 text-center\" style=\"	background-image: linear-gradient(to top, rgb(249, 99, 50), #FFFFFF);	background-size: 100%;	background-position: left top;	background-repeat: repeat;\">\n" + 
        			"    <div class=\"container\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"mx-auto col-md-6\">\n" + 
        			"          <h1>Search for the Music you love</h1>\n" + 
        			"          <p class=\"mb-4\">Search by Mood, Artist or Song</p>\n" + 
 // Form
        			"          <form action=\"../search.html\" method=\"GET\" class=\"form-inline d-flex justify-content-center\">\n" + 
        			"            <div class=\"input-group\"> "
        			+ "					<input type=\"text\" class=\"form-control\" name =\"Search\" placeholder =\"Enter Search text here\">\n" + 
        			"              <div class=\"input-group-append\">"
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
//
        	return true;
        }else if(toProcess.path.equalsIgnoreCase("song.html")){
        	MVMap<String, Artist> artists= db.s.openMap("Artist");
        	List<String> artistkeys = artists.keyList() ;
        	Artist iartist = new Artist();
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
        			"<html>\n" + 
        			"<body>\n" + 
        			"\n" + 
        			"<h2>Add song</h2>\n" + 
        			"<form action=\"../addsong.html\" method = \"GET\"id = \"addsong\">\n " + 
        			"  Song Title " + 
        			"  <input type=\"text\" name=\"songtitle\" value=\"title\">\n" + 
        			"  <br>\n" + 
        			" song Length <input type=\"time\" name=\"songtlength\" value=\"time\">\n" + 
        			"  <br>\n" + 
        			"  song Link <input type=\"text\" name=\"songLink\" placeholder=\"Enter a link to the music if one is available \">\n" + 
        			"  <br>\n" + 
        			"Artist Name<select name=\"Artist\" form=\"addsong\">\n";
        			for(int i = 0; i < artistkeys.size();i++) {
        				String artistUniqueID = artistkeys.get(i);
        				iartist = artists.get(artistUniqueID);
        				stringToSendToWebBrowser += "  <option value=\""+ iartist.uniqueID +"\">"+iartist.artistName+"</option>\n";
        			}
        			
        			stringToSendToWebBrowser += "</select>" +
        			"  <br><br>\n" + 
        			"  <input type=\"submit\" value=\"Submit\">\n" + 
        			"</form> \n" + 
        			"\n" + 
        			"</body>\n" + 
        			"</html> ";
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        	return true;
        }else if(toProcess.path.equalsIgnoreCase("artist.html")){
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
        			"<html>\n" + 
        			"<body>\n" + 
        			"\n" + 
        			"<h2>Add Artist</h2>\n" + 
        			"<form action=\"../addartist.html\" method = \"GET\"id = \"addartist\">\n " + 
        			"  Artist Name " + 
        			"  <input type=\"text\" name=\"artistname\" placeholder=\"Name\">\n" + 
        			"  <br>\n" + 
        			"  Description<input type=\"text\" name=\"artistdescription\" placeholder=\"description\">\n" + 
        			"  <br>\n" + 
        			"  song Link <input type=\"text\" name=\"Artist Image\" placeholder=\"link to an image\">\n" + 
        			"  <br>\n" + 
        			"  <br><br>\n" + 
        			"  <input type=\"submit\" value=\"Submit\">\n" + 
        			"</form> \n" + 
        			"\n" + 
        			"</body>\n" + 
        			"</html> ";
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        	return true;
        	
        	}else if(toProcess.path.equalsIgnoreCase("addsong.html")) {
        		Song isong = new Song();
        		isong.uniqueID = "song_"+System.currentTimeMillis();
        		isong.songtitle= toProcess.params.get("songtitle");	
        		
        		MVMap<String, Song> songs= db.s.openMap("Song");
        		songs.put(isong.uniqueID, isong);
        		db.commit();
        		String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
        				"<html>\n" + 
        				"<body>\n" + 
        				"	<h2>song Added</h2>\n" + 
        				"</body>\n" + 
        				"</html>\n" + 
        				"";
        		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        		return true;
        		
        	}else if(toProcess.path.equalsIgnoreCase("addartist.html")) {
        		Artist iartist = new Artist();
        		iartist.uniqueID= "Artist_"+System.currentTimeMillis();
        		iartist.artistName = toProcess.params.get("artistname");	
        		iartist.artistDescription = toProcess.params.get("artistdescription");		
        		MVMap<String, Artist> artists= db.s.openMap("Artist");
        		artists.put(iartist.uniqueID, iartist);
        		db.commit();
        		String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
        				"<html>\n" + 
        				"<body>\n" + 
        				"	<h2>artist Added</h2>\n" + 
        				"</body>\n" + 
        				"</html>\n" + 
        				"";
        		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        		return true;
        	}else if(toProcess.path.equalsIgnoreCase("search.html")){
        		String searchTerm = toProcess.params.get("Search").toLowerCase();
            	Song isong = new Song();
            	Artist iartist = new Artist();
            	MVMap<String, Song> songs= db.s.openMap("Song");
            	List<String> songkeys = songs.keyList() ;
            	MVMap<String, Artist> artists= db.s.openMap("Artist");
            	List<String> artistkeys = artists.keyList() ;
            	String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
            			"<html>\n" + 
            			"\n" + 
            			"<head>\n" + 
            			"  <meta charset=\"utf-8\">\n" + 
            			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
            			"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n" + 
            			"  <link rel=\"stylesheet\" href=\"/Untitled.css\">\n" + 
            			"</head>\n" + 
            			"\n" + 
            			"<body style=\"\">\n" + 
            			"  <nav class=\"navbar navbar-expand-md navbar-dark bg-primary\">\n" + 
            			"    <div class=\"container\"> <a class=\"navbar-brand\" href=\"#\">\n" + 
            			"        <i class=\"fa d-inline fa-lg fa-stop-circle\"></i>\n" + 
            			"        <b> Feelin' it</b>\n" + 
            			"      </a> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar16\">\n" + 
            			"        <span class=\"navbar-toggler-icon\"></span>\n" + 
            			"      </button>\n" + 
            			"      <div class=\"collapse navbar-collapse\" id=\"navbar16\">\n" + 
            			"        <ul class=\"navbar-nav ml-auto\">\n" + 
            			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Features</a> </li>\n" + 
            			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Pricing</a> </li>\n" + 
            			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">About</a> </li>\n" + 
            			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">FAQ</a> </li>\n" + 
            			"        </ul> <a class=\"btn navbar-btn ml-md-2 btn-light text-dark\">Contact us</a>\n" + 
            			"      </div>\n" + 
            			"    </div>\n" + 
            			"  </nav>\n" + 
            			"  <div class=\"py-5 text-center\" style=\"	background-image: linear-gradient(to top, rgb(249, 99, 50), #FFFFFF);	background-size: 100%;	background-position: left top;	background-repeat: repeat;\">\n" + 
            			"    <div class=\"container\">\n" + 
            			"      <div class=\"row\">\n" + 
            			"        <div class=\"mx-auto col-md-6\">\n" + 
            			"          <h1>Search for the Music you love</h1>\n" + 
            			"          <p class=\"mb-4\">Search by Mood, Artist or Song</p>\n" + 
            			 // Form
             			"          <form action=\"../search.html\" method=\"GET\" class=\"form-inline d-flex justify-content-center\">\n" + 
             			"            <div class=\"input-group\"> "
             			+ "					<input type=\"text\" class=\"form-control\" name =\"Search\" placeholder =\"Enter Search text here\">\n" + 
             			"              <div class=\"input-group-append\">"
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
        					searchresult += "<a href = \"../artistpage?artist="+iartist.uniqueID+"\"><p class=\"lead\">"+iartist.artistName+"</p></a>\n";
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
        					searchresult += "<a href = \"../songpage?song="+isong.uniqueID+"\"><p class=\"lead\">"+iartist.artistName+"</p></a>\n";
        					resultcount++;
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
//end of song  Search  
            	stringToSendToWebBrowser += "</body>\n" + 
        				"</html>\n" + 
        				"";
            	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
            	return true;
            	}
		return false;   
	}

}