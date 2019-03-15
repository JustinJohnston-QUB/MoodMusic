package views;
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
					"                          <a class=\"collection-item\"><span class=\"new badge\" data-badge-caption=\"\" id=\"onlineUsers\">4</span>Online Users</a>\r\n" + 
					"                          <a class=\"collection-item\"><span class=\"new badge\" data-badge-caption=\"\" id=\"offlineUsers\" style=\"background-color:crimson\">4</span>Offline Users</a>\r\n" + 
					"                          <a class=\"collection-item\"><span class=\"new badge\" data-badge-caption=\"\" id=\"totalUsers\" style=\"background-color:blue\">4</span>Total Users</a>\r\n" + 
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
        return false;
	}

}