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
		if(toProcess.path.equalsIgnoreCase("use"))
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
					"<body>\r\n";
			//Nav Bar 
			stringToSendToWebBrowser += PageElements.Navbar();

			//Main body
			stringToSendToWebBrowser +=
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
							"\r\n";
			//footer
			stringToSendToWebBrowser+= PageElements.footer();

			stringToSendToWebBrowser +=
					PageElements.scripts();
			stringToSendToWebBrowser +=
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
		else if(toProcess.path.equalsIgnoreCase("register")){
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
					"<body>\r\n"; 
			//NavBar
			stringToSendToWebBrowser += PageElements.Navbar();
			//Main Body
			stringToSendToWebBrowser += 
					"  \r\n" + 
							"  <!--Registration Form-->\r\n" + 
							"\r\n" + 
							"                    <div class=\"card-panel teal lighten-2\" style=\"width:10000px\"><h2 class=\"header\" style=\"color:#1565c0\"><b>Registration</b></h2></div>\r\n" + 
							"                    \r\n" + 
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
							"            \r\n" + 
							"            <div class=\"row\">\r\n" + 
							"            <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Register\r\n" + 
							"              <i class=\"material-icons right\">send</i>\r\n" + 
							"              </button>\r\n" + 
							"            <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Cancel\r\n" + 
							"              <i class=\"material-icons right\">clear</i>\r\n" + 
							"              </button>	\r\n" + 
							"             <h6><a href=\"login\" style=\"color:#1976d2\">Already registered? Click to Log in.</a></h6>\r\n" +
							"              \r\n" + 
							"              </div>\r\n" + 
							"            </form>\r\n" + 
							"          </div>\r\n" + 
							"        </div>\r\n" + 
							"            \r\n" + 
							"  \r\n" + 
							"\r\n";
			//footer
			stringToSendToWebBrowser+= PageElements.footer();
			//scripts
			stringToSendToWebBrowser += PageElements.scripts();
			stringToSendToWebBrowser += 
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
			
			MVMap<String, User> users = db.s.openMap("User");
			
			if(users.containsKey(newUser.username))
			{
				String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<!DOCTYPE html>\n";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "  <head>\n";
				stringToSendToWebBrowser += "    <title>SignUpSubmit</title>\n";
				stringToSendToWebBrowser += "    <meta charset=\"utf-8\">\n";
				stringToSendToWebBrowser += "    <meta  name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";
				stringToSendToWebBrowser += "    <link href=\"/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"/css/font-awesome.min.css\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <link href=\"/css/blocks.css\" rel=\"stylesheet\">\n";
				stringToSendToWebBrowser += "    <!--[if lt IE 9]>\n";
				stringToSendToWebBrowser += "      <script src=\"/js/html5shiv.js\"></script>\n";
				stringToSendToWebBrowser += "      <script src=\"/js/respond.min.js\"></script>\n";
				stringToSendToWebBrowser += "    <![endif]-->\n";
				stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\n";
				stringToSendToWebBrowser += "    <script type=\"text/javascript\" src=\"/js/bootstrap.min.js\"></script>\n";
				stringToSendToWebBrowser += "  </head>\n";
				stringToSendToWebBrowser += "  <body>\n";
				stringToSendToWebBrowser += "    <h1>Username Already Taken<h1>\n";
				stringToSendToWebBrowser += "    <h1><a href='/SignUp.html'>Click here to choose another</a><h1>\n";
				stringToSendToWebBrowser += "  </body>\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;

			}
			
			users.put(newUser.username, newUser);
			db.commit();

			String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
					"<html>\n" + 
					"<body>\n" + 
					"	<h2>User has been successfully created.</h2>\n" + 
					"    <h1><a href='login'>Click here to log in!</a><h1>\n" +
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
				stringToSendToWebBrowser += "<p> no users in database</p>";
			}else {
				stringToSendToWebBrowser += "<div>";
				for(int i = 0; i<userList.size();i++) {
					String userUniqueID = userList.get(i);
					newUser = users.get(userUniqueID);
					stringToSendToWebBrowser += "<h4>First Name:</h4> <p>"+ newUser.firstname +"</p>" + 
							"<h4>Surname:</h4> <p>"+ newUser.surname +"</p>\n" + 
							"<h4>Username:</h4> <p>"+newUser.username+"</p>\n" +
							"<h4>Email:</h4> <p>"+newUser.email+"</p>\n" +
							"<h4>Password:</h4> <p>"+newUser.getPassword()+"</p>\n" +
							"<h4> -------- </h4>";
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
