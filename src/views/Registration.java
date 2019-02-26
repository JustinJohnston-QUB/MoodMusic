package views;

import java.util.List;

import org.h2.mvstore.MVMap;

import model.Song;
import model.User;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class Registration extends DynamicWebPage
{
	public Registration(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
        if(toProcess.path.equalsIgnoreCase("registration"))
        {
        	//Lab 1 Task 4
        	//Change this string so that it contains HTML from a page you created in Pingendo 
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
        			"<html lang=\"en\">\r\n" + 
        			"\r\n" + 
        			"<head>\r\n" + 
        			"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
        			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\" />\r\n" + 
        			"  <title>Store</title>\r\n" + 
        			"\r\n" + 
        			"  <!-- CSS  -->\r\n" + 
        			"  <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n" + 
        			"  <link href=\"../css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\" />\r\n" + 
        			"  <link href=\"../css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\" />\r\n" + 
        			"</head>\r\n" + 
        			"\r\n" + 
        			"<body>\r\n" + 
        			"  <!--Navigation Bar-->\r\n" + 
        			"  <nav class=\"orange\" role=\"navigation\">\r\n" + 
        			"    <div class=\"nav-wrapper container\"><a id=\"logo-container\" href=\"home\" class=\"brand-logo\">Feelin' It</a>\r\n" + 
        			"      <ul class=\"right hide-on-med-and-down\">\r\n" + 
        			"        <li><a href=\"webapp\">Music</a></li>\r\n" + 
        			"        <li><a href=\"store\">Store</a></li>\r\n" + 
        			"        <li><a href=\"indexview\">About Us</a></li>\r\n" + 
        			"        <li><a href=\"registration\">Account</a></li>\r\n" + 
        			"      </ul>\r\n" + 
        			"      <ul id=\"nav-mobile\" class=\"sidenav\">\r\n" + 
        			"        <li><a href=\"#\">Navbar Link</a></li>\r\n" + 
        			"      </ul>\r\n" + 
        			"      <a href=\"#\" data-target=\"nav-mobile\" class=\"sidenav-trigger\"><i class=\"material-icons\">menu</i></a>\r\n" + 
        			"    </div>\r\n" + 
        			"\r\n" + 
        			"  </nav>\r\n" + 
        			"  \r\n" + 
        			"  <!--Registration Form-->\r\n" + 
        			"\r\n" + 
        			"  <div class=\"col s12 m7\">\r\n" + 
        			"    <h2 class=\"header\">Registration</h2>\r\n" + 
        			"    <div class=\"card horizontal\">\r\n" + 
        			"      <div class=\"card-stacked\">\r\n" + 
        			"        <div class=\"card-content\">\r\n" + 
        			"          <p>   <div class=\"row\">\r\n" + 
        			"            <form class=\"col s12\" method=\"GET\" action=\"/adduser\" name=\"regForm\">\r\n" + 
        			"              <div class=\"row\">\r\n" + 
        			"                <div class=\"input-field col s6\">\r\n" + 
        			"                  <input id=\"firstname\" type=\"text\" class=\"validate\" placeholder=\"First Name\">\r\n" + 
        			"                  <label for=\"firstname\" class=\"active\"><i class=\"material-icons\">person</i></label>\r\n" + 
        			"                </div>\r\n" + 
        			"                <div class=\"input-field col s6\">\r\n" + 
        			"                  <input id=\"lastname\" type=\"text\" class=\"validate\" placeholder=\"Last Name\">\r\n" + 
        			"                  <label for=\"lastname\" class=\"active\"><i class=\"material-icons\">person</i></label>\r\n" + 
        			"                </div>\r\n" + 
        			"              </div>\r\n" + 
        			"              <div class=\"row\">\r\n" + 
        			"                <div class=\"input-field col s12\">\r\n" + 
        			"                  <input id=\"username\" type=\"text\" class=\"validate\" placeholder=\"Username\">\r\n" + 
        			"                  <label for=\"username\" class=\"active\"><i class=\"material-icons\">account_circle</i></label>\r\n" + 
        			"                </div>\r\n" + 
        			"              </div>\r\n" + 
        			"              <div class=\"row\">\r\n" + 
        			"                <div class=\"input-field col s12\">\r\n" + 
        			"                  <input id=\"password\" type=\"password\" class=\"validate\" placeholder=\"Password\">\r\n" + 
        			"                  <label for=\"password\" class=\"active\"><i class=\"material-icons\">portrait</i></label>\r\n" + 
        			"                </div>\r\n" + 
        			"              </div>\r\n" + 
        			"              <div class=\"row\">\r\n" + 
        			"                <div class=\"input-field col s12\">\r\n" + 
        			"                  <input id=\"email\" type=\"email\" class=\"validate\" placeholder=\"Email\">\r\n" + 
        			"                  <label for=\"email\" class=\"active\"><i class=\"material-icons\">email</i></label>\r\n" + 
        			"                </div>	\r\n" + 
        			"              </div>\r\n" + 
        			"             <div class=\"row\">\r\n" + 
        			"                <div class=\"input-field col s12\">\r\n" + 
        			"                  <input id=\"dob\" type=\"text\" class=\"validate\" placeholder=\"D.O.B\">\r\n" + 
        			"                  <label for=\"dob\" class=\"active\"><i class=\"material-icons\">date_range</i></label>\r\n" + 
        			"                </div>\r\n" + 
        			"              </div>\r\n" + 
        			"            \r\n" + 
        			"            <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Register\r\n" + 
        			"              <i class=\"material-icons right\">send</i>\r\n" + 
        			"              </button>\r\n" + 
        			"            <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Cancel\r\n" + 
        			"              <i class=\"material-icons right\">clear</i>\r\n" + 
        			"              </button>	\r\n" + 
        			"              \r\n" + 
        			"            </form>\r\n" + 
        			"          </div></p>\r\n" + 
        			"        </div>\r\n" + 
        			"        <div class=\"card-action\">\r\n" + 
        			"          <a href=\"#\">Already registered? Click here to login</a>\r\n" + 
        			"        </div>\r\n" + 
        			"      </div>\r\n" + 
        			"    </div>\r\n" + 
        			"  </div>\r\n" + 
        			"            \r\n" + 
        			"  \r\n" + 
        			"\r\n" + 
        			"  <!--Footer-->\r\n" + 
        			"  <footer class=\"page-footer blue\">\r\n" + 
        			"    <div class=\"container\">\r\n" + 
        			"      <div class=\"row\">\r\n" + 
        			"        <div class=\"col l6 s12\">\r\n" + 
        			"          <h5 class=\"white-text\">Company Bio</h5>\r\n" + 
        			"          <p class=\"grey-text text-lighten-4\"></p>\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"        </div>\r\n" + 
        			"        <div class=\"col 20 s12\">\r\n" + 
        			"          <form action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\" target=\"_top\">\r\n" + 
        			"            <input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\" />\r\n" + 
        			"            <input type=\"hidden\" name=\"hosted_button_id\" value=\"JCGQUETZC6DMN\" />\r\n" + 
        			"            <input type=\"image\" src=\"https://www.paypalobjects.com/en_GB/i/btn/btn_donate_LG.gif\" border=\"0\" name=\"submit\" title=\"PayPal - The safer, easier way to pay online!\" alt=\"Donate with PayPal button\" />\r\n" + 
        			"            <img alt=\"\" border=\"0\" src=\"https://www.paypal.com/en_GB/i/scr/pixel.gif\" width=\"1\" height=\"1\" />\r\n" + 
        			"          </form>\r\n" + 
        			"\r\n" + 
        			"        </div>\r\n" + 
        			"      </div>\r\n" + 
        			"    </div>\r\n" + 
        			"    <div class=\"footer-copyright\">\r\n" + 
        			"      <div class=\"container\">\r\n" + 
        			"        <h5>&copy 2019 Feelin' It</h5>\r\n" + 
        			"      </div>\r\n" + 
        			"    </div>\r\n" + 
        			"  </footer>\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"  <!--  Scripts-->\r\n" + 
        			"  <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
        			"  <script src=\"../js/materialize.js\"></script>\r\n" + 
        			"  <script src=\"../js/init.js\"></script>\r\n" + 
        			"  \r\n" + 
        			"  \r\n" + 
        			"</body>\r\n" + 
        			"\r\n" + 
        			"</html>\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"    \r\n" + 
        			"" + 
        			"</html>";
        	
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

        	return true;
        }
	    else if(toProcess.path.equalsIgnoreCase("user")){
    	User newUser = new User();
    	String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
    			"<html lang=\"en\">\r\n" + 
    			"\r\n" + 
    			"<head>\r\n" + 
    			"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
    			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\" />\r\n" + 
    			"  <title>Store</title>\r\n" + 
    			"\r\n" + 
    			"  <!-- CSS  -->\r\n" + 
    			"  <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n" + 
    			"  <link href=\"../css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\" />\r\n" + 
    			"  <link href=\"../css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\" />\r\n" + 
    			"</head>\r\n" + 
    			"\r\n" + 
    			"<body>\r\n" + 
    			"  <!--Navigation Bar-->\r\n" + 
    			"  <nav class=\"orange\" role=\"navigation\">\r\n" + 
    			"    <div class=\"nav-wrapper container\"><a id=\"logo-container\" href=\"home\" class=\"brand-logo\">Feelin' It</a>\r\n" + 
    			"      <ul class=\"right hide-on-med-and-down\">\r\n" + 
    			"        <li><a href=\\\"webapp.html\\\">Music</a></li>\r\n" + 
    			"        <li class=\"active\"><a href=\"store.html\">Store</a></li>\r\n" + 
    			"        <li><a href=\"aboutus.html\">About Us</a></li>\r\n" + 
    			"        <li><a href=\"account.html\">Account</a></li>\r\n" + 
    			"      </ul>\r\n" + 
    			"      <ul id=\"nav-mobile\" class=\"sidenav\">\r\n" + 
    			"        <li><a href=\"#\">Navbar Link</a></li>\r\n" + 
    			"      </ul>\r\n" + 
    			"      <a href=\"#\" data-target=\"nav-mobile\" class=\"sidenav-trigger\"><i class=\"material-icons\">menu</i></a>\r\n" + 
    			"    </div>\r\n" + 
    			"\r\n" + 
    			"  </nav>\r\n" + 
    			"  \r\n" + 
    			"  <!--Registration Form-->\r\n" + 
    			"\r\n" + 
    			"  <div class=\"col s12 m7\">\r\n" + 
    			"    <h2 class=\"header\">Registration</h2>\r\n" + 
    			"    <div class=\"card horizontal\">\r\n" + 
    			"      <div class=\"card-stacked\">\r\n" + 
    			"        <div class=\"card-content\">\r\n" + 
    			"          <p>   <div class=\"row\">\r\n" + 
    			"            <form class=\"col s12\" method=\"GET\" action=\"/adduser\" name=\"regForm\">\r\n" + 
    			"              <div class=\"row\">\r\n" + 
    			"                <div class=\"input-field col s6\">\r\n" + 
    			"                  <input id=\"firstname\" name=\"firstname\" type=\"text\" class=\"validate\" placeholder=\"First Name\">\r\n" + 
    			"                  <label for=\"firstname\" class=\"active\"><i class=\"material-icons\">person</i></label>\r\n" + 
    			"                </div>\r\n" + 
    			"                <div class=\"input-field col s6\">\r\n" + 
    			"                  <input id=\"lastname\" name=\"surname\" type=\"text\" class=\"validate\" placeholder=\"Last Name\">\r\n" + 
    			"                  <label for=\"lastname\" class=\"active\"><i class=\"material-icons\">person</i></label>\r\n" + 
    			"                </div>\r\n" + 
    			"              </div>\r\n" + 
    			"              <div class=\"row\">\r\n" + 
    			"                <div class=\"input-field col s12\">\r\n" + 
    			"                  <input id=\"username\" name=\"username\" type=\"text\" class=\"validate\" placeholder=\"Username\">\r\n" + 
    			"                  <label for=\"username\" class=\"active\"><i class=\"material-icons\">account_circle</i></label>\r\n" + 
    			"                </div>\r\n" + 
    			"              </div>\r\n" + 
    			"              <div class=\"row\">\r\n" + 
    			"                <div class=\"input-field col s12\">\r\n" + 
    			"                  <input id=\"password\" name=\"password\" type=\"password\" class=\"validate\" placeholder=\"Password\">\r\n" + 
    			"                  <label for=\"password\" class=\"active\"><i class=\"material-icons\">portrait</i></label>\r\n" + 
    			"                </div>\r\n" + 
    			"              </div>\r\n" + 
    			"              <div class=\"row\">\r\n" + 
    			"                <div class=\"input-field col s12\">\r\n" + 
    			"                  <input id=\"email\" name=\"email\" type=\"email\" class=\"validate\" placeholder=\"Email\">\r\n" + 
    			"                  <label for=\"email\" class=\"active\"><i class=\"material-icons\">email</i></label>\r\n" + 
    			"                </div>	\r\n" + 
    			"              </div>\r\n" + 
    			"             <div class=\"row\">\r\n" + 
    			"                <div class=\"input-field col s12\">\r\n" + 
    			"                  <input id=\"dob\" name=\"dob\" type=\"text\" class=\"validate\" placeholder=\"D.O.B\">\r\n" + 
    			"                  <label for=\"dob\" class=\"active\"><i class=\"material-icons\">date_range</i></label>\r\n" + 
    			"                </div>\r\n" + 
    			"              </div>\r\n" + 
    			"            \r\n" + 
    			"            <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Register\r\n" + 
    			"              <i class=\"material-icons right\">send</i>\r\n" + 
    			"              </button>\r\n" + 
    			"            <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Cancel\r\n" + 
    			"              <i class=\"material-icons right\">clear</i>\r\n" + 
    			"              </button>	\r\n" + 
    			"              \r\n" + 
    			"            </form>\r\n" + 
    			"          </div></p>\r\n" + 
    			"        </div>\r\n" + 
    			"        <div class=\"card-action\">\r\n" + 
    			"          <a href=\"#\">Already registered? Click here to login</a>\r\n" + 
    			"        </div>\r\n" + 
    			"      </div>\r\n" + 
    			"    </div>\r\n" + 
    			"  </div>\r\n" + 
    			"            \r\n" + 
    			"  \r\n" + 
    			"\r\n" + 
    			"  <!--Footer-->\r\n" + 
    			"  <footer class=\"page-footer blue\">\r\n" + 
    			"    <div class=\"container\">\r\n" + 
    			"      <div class=\"row\">\r\n" + 
    			"        <div class=\"col l6 s12\">\r\n" + 
    			"          <h5 class=\"white-text\">Company Bio</h5>\r\n" + 
    			"          <p class=\"grey-text text-lighten-4\"></p>\r\n" + 
    			"\r\n" + 
    			"\r\n" + 
    			"        </div>\r\n" + 
    			"        <div class=\"col 20 s12\">\r\n" + 
    			"          <form action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\" target=\"_top\">\r\n" + 
    			"            <input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\" />\r\n" + 
    			"            <input type=\"hidden\" name=\"hosted_button_id\" value=\"JCGQUETZC6DMN\" />\r\n" + 
    			"            <input type=\"image\" src=\"https://www.paypalobjects.com/en_GB/i/btn/btn_donate_LG.gif\" border=\"0\" name=\"submit\" title=\"PayPal - The safer, easier way to pay online!\" alt=\"Donate with PayPal button\" />\r\n" + 
    			"            <img alt=\"\" border=\"0\" src=\"https://www.paypal.com/en_GB/i/scr/pixel.gif\" width=\"1\" height=\"1\" />\r\n" + 
    			"          </form>\r\n" + 
    			"\r\n" + 
    			"        </div>\r\n" + 
    			"      </div>\r\n" + 
    			"    </div>\r\n" + 
    			"    <div class=\"footer-copyright\">\r\n" + 
    			"      <div class=\"container\">\r\n" + 
    			"        <h5>&copy 2019 Feelin' It</h5>\r\n" + 
    			"      </div>\r\n" + 
    			"    </div>\r\n" + 
    			"  </footer>\r\n" + 
    			"\r\n" + 
    			"\r\n" + 
    			"  <!--  Scripts-->\r\n" + 
    			"  <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
    			"  <script src=\"../js/materialize.js\"></script>\r\n" + 
    			"  <script src=\"../js/init.js\"></script>\r\n" + 
    			"  \r\n" + 
    			"  \r\n" + 
    			"</body>\r\n" + 
    			"\r\n" + 
    			"</html>\r\n" + 
    			"\r\n" + 
    			"\r\n" + 
    			"    \r\n" + 
    			"" + 
    			"</html>";
    	
    	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
    	return true;
	    }
        
        else if (toProcess.path.equalsIgnoreCase("adduser")) {
        	
         User newUser = new User();
             
            newUser.uniqueID = "user_"+System.currentTimeMillis();
         	newUser.firstname = toProcess.params.get("firstname");
         	newUser.surname = toProcess.params.get("surname");
         	newUser.username = toProcess.params.get("username");
         	newUser.setPassword(toProcess.params.get("password"));
         	newUser.email = toProcess.params.get("email");
         	newUser.dob = toProcess.params.get("dob");
        	
        	MVMap<String, User> users = db.s.openMap("User");
        	users.put(newUser.uniqueID, newUser);
        	db.commit();
        	
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
    				"<html>\n" + 
    				"<body>\n" + 
    				"	<h2>User has been successfully created.</h2>\n" + 
    				"</body>\n" + 
    				"</html>\n" + 
    				"";
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        	
        	return true;
        	
        }
        
        else if (toProcess.path.equalsIgnoreCase("displayuser")) {
        	
        	User newUser = new User();
        	MVMap<String, User> users= db.s.openMap("User");
        	List<String> userList = users.keyList() ;
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
    				"<html>\n" + 
    				"<body>\n";
    		if(userList.size() == 0) {
    			stringToSendToWebBrowser += "<p> no songs in database</p>";
    		}else {
    			stringToSendToWebBrowser += "<div>";
    			for(int i = 0; i<userList.size();i++) {
    				String userUniqueID = userList.get(i);
    				newUser = users.get(userUniqueID);
    				stringToSendToWebBrowser += "<h4>First Name:</h4> <p>"+ newUser.firstname +"</p><\n" + 
    						"<h4>Surname:</h4> <p>"+ newUser.surname +"</p>\n" + 
    						"<h4>Username:</h4> <p>"+newUser.username+"</p>\n" +
    						"<h4>Email:</h4> <p>"+newUser.email+"</p>\n" +
    						"<h4>Date of birth:</h4> <p>"+newUser.dob+"</p>\n";
    			}
    			stringToSendToWebBrowser += "</div>";
    		}
        	stringToSendToWebBrowser += "</body>\n" + 
    				"</html>\n" + 
    				"";
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
        	return true;
        	
        	
        	
        }
        else {
        	
        	
        }
        return false;
	}

}
