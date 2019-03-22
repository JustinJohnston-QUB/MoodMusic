package views;
import org.h2.mvstore.MVMap;

import model.User;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class Login extends DynamicWebPage
{
	public Login(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
        if(toProcess.path.equalsIgnoreCase("login"))
        {
        	MVMap<String, User> users = db.s.openMap("Users");
        	int totalUsers = users.size();
        	int onlineUsers;
        	String username = toProcess.cookies.get("username"); 
        	if(username!=null)
        	{
        		onlineUsers = 1;
        	}
        	else {
        	    onlineUsers = 0;
        	}
        	int offlineUsers = totalUsers - onlineUsers;
   	
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
					"  <<!--Login Form-->\r\n" + 
					"               <div class=\"row\">\r\n" + 
					"              <form class=\"col s12\" method=\"POST\" action=\"loginsubmit\" name=\"logForm\">\r\n" + 
					"                  <div class=\"col s5\">\r\n" + 
					"                      <div class=\"card-panel teal lighten-2\" style=\"width:470px\"><h2 class=\"header\" style=\"color:#1565c0\"><b>Community</b></h2></div>\r\n" + 
					"\r\n" + 
					"                      \r\n" + 
					"                      <div class=\"collection\" style=\"width:470px\">\r\n" + 
					"                          <a class=\"collection-item\"><span class=\"new badge\" data-badge-caption=\"\" id=\"onlineUsers\">"+onlineUsers+"</span>Online Users</a>\r\n" + 
					"                          <a class=\"collection-item\"><span class=\"new badge\" data-badge-caption=\"\" id=\"offlineUsers\" style=\"background-color:crimson\">"+offlineUsers+"</span>Offline Users</a>\r\n" + 
					"                          <a class=\"collection-item\"><span class=\"new badge\" data-badge-caption=\"\" id=\"totalUsers\" style=\"background-color:blue\">"+totalUsers+"</span>Total Users</a>\r\n" + 
					"                        </div>\r\n" + 
					"                                  \r\n" + 
					"              \r\n" + 
					"                      \r\n" + 
					"                  </div>\r\n" + 
					"                  \r\n" + 
					"\r\n" + 
					"                 <div class=\"col s4\">\r\n" + 
					"                    <div class=\"card-panel teal lighten-2\" style=\"width:470px\"><h2 class=\"header\" style=\"color:#1565c0\"><b>Login</b></h2></div>\r\n" + 
					"                    \r\n" + 
					"\r\n" + 
					"                    <div class=\"row\">\r\n" + 
					"                        <div class=\"col s12 m7\">\r\n" + 
					"                          <div class=\"card\" style=\"width:460px\">\r\n" + 
					"                            <div class=\"card-image\">\r\n" + 
					"                              <img src=\"images/acc.png\">\r\n" + 
					"                              <span class=\"card-title\">Login</span>\r\n" + 
					"                            </div>\r\n" + 
					"                            <div class=\"card-content\">\r\n" + 
					"                              <p> <div class=\"row\">\r\n" + 
					"                                <form role=\"form\" action=\"loginsubmit\" method=\"GET\">\r\n" + 
					"                  \r\n" + 
					"                                  <div class=\"input-field col s6\">\r\n" + 
					"                                    <input id=\"username\" name=\"username\" type=\"text\" class=\"validate\" placeholder=\"Username\">\r\n" + 
					"                                   <label for=\"username\" class=\"active\"><i class=\"material-icons\">account_circle</i></label> \r\n" + 
					"                                  </div>\r\n" + 
					"                                  </div>\r\n" + 
					"                    \r\n" + 
					"                                <div class=\"row\">\r\n" + 
					"                                    <div class=\"input-field col s6\">\r\n" + 
					"                                      <input id=\"password\" name=\"password\" type=\"password\" class=\"validate\" placeholder=\"Password\">\r\n" + 
					"                                     <label for=\"password\" class=\"active\"><i class=\"material-icons\">portrait</i></label> \r\n" + 
					"                                    </div>\r\n" + 
					"                                </div></p>\r\n" +  
					"                            </div>\r\n" + 
					"                            <div class=\"card-action\">\r\n" + 
					"                               <div class=\"row\">\r\n" + 
					"                                  <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Login<i class=\"material-icons right\">send</i></button>\r\n" + 
					"                                  <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Forgot Password?</button>\r\n" + 
					"                            </div>\r\n" + 
					"                          </div>\r\n" + 
					"                              </form>\r\n" +
					"                          \r\n" + 
					"                        </div>\r\n" + 
					"                      </div>";
			
			stringToSendToWebBrowser += "</div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"\r\n" + 
					"    </div>\r\n" + 
					"    <br><br>\r\n" + 
					"  </div>\r\n" + 
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
//
        	return true;
        }
        
        else if (toProcess.path.equalsIgnoreCase("logout")) {
        
        String username = toProcess.cookies.get("username"); 
		String password = toProcess.cookies.get("password"); 
//	   toProcess.cookies.clear();
			
				String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<!DOCTYPE html>\n";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "  <head>\n";
				stringToSendToWebBrowser += "    <title>Session Error</title>\n";
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
				stringToSendToWebBrowser += "  <script>\n";
				stringToSendToWebBrowser += "      function clearLoginCookie()\n";
				stringToSendToWebBrowser += "      {\n";
				stringToSendToWebBrowser += "          document.cookie='username=;expires=' + new Date(0).toGMTString();\n";
				stringToSendToWebBrowser += "          document.cookie='password=;expires=' + new Date(0).toGMTString();\n";
				stringToSendToWebBrowser += "      }\n";
				stringToSendToWebBrowser += "  </script>\n";
				stringToSendToWebBrowser += "  </head>\n";
				

				
				stringToSendToWebBrowser += "  <body onload=\"clearLoginCookie()\">\n";
				stringToSendToWebBrowser += "    <h1>Logged out successfully!<h1>\n";
				stringToSendToWebBrowser += "    <h1><a href='/homepage'>Click here to continue</a><h1>\n";
				stringToSendToWebBrowser += "  </body>\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;

			
		}
        
        else if(toProcess.path.equalsIgnoreCase("myaccount"))
        {
        	User currentUser = new User();
        	String username = toProcess.cookies.get("username"); 
			String password = toProcess.cookies.get("password"); 
			
			
			
			MVMap<String, User> users = db.s.openMap("Users");
			currentUser = users.get(username);
			
			
			
			
			
			
			 

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
			stringToSendToWebBrowser += PageElements.NavBarLoggedIn(toProcess);

			//Main body
			stringToSendToWebBrowser +=
					"    <!--Account Management-->\r\n" + 
					"<div class=\"row\"></div>\r\n" + 
					" <div class=\"card-panel teal lighten-2\" style=\"width:10000px\"><h2 class=\"header\" style=\"color:#1565c0\"><b>My Account</b></h2></div>\r\n" + 
					"</div>\r\n" + 
					"                    \r\n" + 
					"  <form role=\"form\" action=\"savechanges\" method=\"GET\">\r\n" + 
					"      <div class=\"form-group editField\">\r\n" + 
					"          <label for=\"name\">First Name</label>\r\n" + 
					"          <div class=\"input-group\">\r\n" + 
					"              <input type=\"text\" class=\"form-control editField\" name=\"firstname\" value=\""+currentUser.firstname+"\" readonly>\r\n" + 
					"              <label for=\"name\">Surname</label>\r\n" + 
					"              <input type=\"text\" class=\"form-control editField\" name=\"surname\" value=\""+currentUser.surname+"\" readonly>\r\n" + 
					"              <label for=\"name\">Username</label>\r\n" + 
					"              <input type=\"text\" class=\"form-control editField\" name=\"username\" value=\""+username+"\" readonly>\r\n" + 
					"              <label for=\"name\">Password</label>\r\n" + 
					"              <input type=\"password\" class=\"form-control editField\" name=\"password\" value=\""+password+"\" readonly>\r\n" + 
					"              <label for=\"name\">Email</label>\r\n" + 
					"              <input type=\"text\" class=\"form-control editField\" name=\"email\" value=\""+currentUser.email+"\" readonly>\r\n" + 
					"          </div>\r\n" + 
					"      </div>\r\n" + 
					"      \r\n" + 
					"      <div class='row text-center'>\r\n" + 
					"          <a class=\"btn btn-danger editBtn\">Edit Off</a>\r\n" + 
					"      </div>\r\n" + 
					"      <label for=\"name\">Plase Confirm Your Password</label>\r\n" + 
					"              <input type=\"Password\" class=\"form-control passConf\" value=\"\" name=\"passwordConfirm\" readonly>\r\n" + 
					"\r\n" + 
					"            <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Save Changes\r\n" + 
					"  </form><br>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"  \r\n" + 
					" \r\n";

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
        else if(toProcess.path.equalsIgnoreCase("savechanges"))
        {
        String usernameLoggedIn = toProcess.cookies.get("username"); ; 
        String confirmPassword = toProcess.params.get("passwordConfirm");
        User currentUser = new User();
        
        MVMap<String, User> users = db.s.openMap("Users");
        
        currentUser = users.get(usernameLoggedIn);
        
        	
		if(confirmPassword.contains(currentUser.getPassword()))
		{
			currentUser.firstname = toProcess.params.get("firstname");
		    currentUser.surname = toProcess.params.get("surname");
		    currentUser.username = toProcess.params.get("username");
		    currentUser.setPassword(toProcess.params.get("password"));
		    currentUser.email = toProcess.params.get("email");
		    toProcess.cookies.clear();
		    
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
			stringToSendToWebBrowser += "    <h1>Changes have been saved successfully<h1>\n";
			stringToSendToWebBrowser += "    <h1><a href='/myaccount'>Click here to continue</a><h1>\n";
			stringToSendToWebBrowser += "  </body>\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
	
		else {
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
				stringToSendToWebBrowser += "    <h1>Password was incorrect, changes have not been made!<h1>\n";
				stringToSendToWebBrowser += "    <h1><a href='/myaccount'>Click here to try again</a><h1>\n";
				stringToSendToWebBrowser += "  </body>\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;
		}

        
	}
	return false;
	}

}