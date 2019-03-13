package views;

import model.User;

import org.h2.mvstore.MVMap;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class LoginSubmit extends DynamicWebPage
{

	public LoginSubmit(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("loginsubmit"))
		{
			String username = toProcess.params.get("username");
			String password = toProcess.params.get("password");

			MVMap<String, User> users = db.s.openMap("Users");
			
			if(!users.containsKey(username))
			{
				String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<!DOCTYPE html>\n";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "  <head>\n";
				stringToSendToWebBrowser += "    <title>LoginSubmit</title>\n";
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
				stringToSendToWebBrowser += "  </head>\n";
				stringToSendToWebBrowser += "  <body>\n";
				stringToSendToWebBrowser += "    <h1>Unknown Username<h1>\n";
				stringToSendToWebBrowser += "    <h1><a href='/Login.html'>Click here to try again</a><h1>\n";
				stringToSendToWebBrowser += "  </body>\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;

			}
			
			User user = users.get(username);
			
			//if(user.password==password)
			if(!user.getPassword().contentEquals(password))
			{
				String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<!DOCTYPE html>\n";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "  <head>\n";
				stringToSendToWebBrowser += "    <title>LoginSubmit</title>\n";
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
				stringToSendToWebBrowser += "    <h1>Password Incorrect<h1>\n";
				stringToSendToWebBrowser += "    <h1><a href='/Login.html'>Click here to try again</a><h1>\n";
				stringToSendToWebBrowser += "  </body>\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;
			}
			
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "  <head>\n";
			stringToSendToWebBrowser += "    <title>LoginSubmit</title>\n";
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
			stringToSendToWebBrowser += "      function setCookie(cname, cvalue, exdays)\n";
			stringToSendToWebBrowser += "      {\n";
			stringToSendToWebBrowser += "          var d = new Date();\n";
			stringToSendToWebBrowser += "          d.setTime(d.getTime() + (exdays*24*60*60*1000));\n";
			stringToSendToWebBrowser += "          var expires = 'expires='+d.toUTCString();\n";
			stringToSendToWebBrowser += "          document.cookie = cname + '=' + cvalue + ';' + expires + ';path=/';\n";
			stringToSendToWebBrowser += "      }\n";

			stringToSendToWebBrowser += "      function saveLoginCookie()\n";
			stringToSendToWebBrowser += "      {\n";
			stringToSendToWebBrowser += "          setCookie('username','"+username+"',365);\n";
			stringToSendToWebBrowser += "          setCookie('password','"+password+"',365);\n";
			stringToSendToWebBrowser += "      }\n";
			
			stringToSendToWebBrowser += "  </script>\n";

			stringToSendToWebBrowser += "  </head>\n";
			
			
			
			
			stringToSendToWebBrowser += "  <body onload='saveLoginCookie()'>\n";
			//stringToSendToWebBrowser += "  <body>\n";
			stringToSendToWebBrowser += "    <h1>Login Complete<h1>\n";
			stringToSendToWebBrowser += "    <h1><a href='Index.html'>Click here to go to the Front Page</a><h1>\n";
			stringToSendToWebBrowser += "  </body>\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		return false;
	}

}
