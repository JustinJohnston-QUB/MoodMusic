package views;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class HomePage extends DynamicWebPage
{
	public HomePage(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
        if(toProcess.path.equalsIgnoreCase("homepage"))
        {
        	//Lab 1 Task 4
        	//Change this string so that it contains HTML from a page you created in Pingendo 
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
        			"<html>\r\n" + 
        			"    <head>\r\n" + 
        			"\r\n" + 
        			"            <meta charset=\"utf-8\">\r\n" + 
        			"            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
        			"  			<link href=\"../css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
        			//"            <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
        			"\r\n" + 
        			"  			<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n" + 
        			"            <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n" + 
        			"            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n" + 
        			//"            <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n" + 
        			"            <script>$(function () {\r\n" + 
        			"                $('[data-toggle=\"popover\"]').popover()\r\n" + 
        			"              })</script>\r\n" + 
        			"\r\n" + 
        			"        <body>\r\n" + 
        			"\r\n" + PageElements.Navbar()+PageElements.scripts()+
        			
        			"\r\n" + 
        			"                      <div class=\"row\">\r\n" + 
        			"\r\n" + 
        			"                        <div class=\"col-sm-4\">\r\n" + 
        			"                          \r\n" + 
        			"                          <div class=\"card text-center\">\r\n" + 
        			"                            <div class=\"card-header\">\r\n" + 
        			"                              <ul class=\"nav nav-tabs card-header-tabs\">\r\n" + 
        			"                                <li class=\"nav-item\">\r\n" + 
        			"                                  <a class=\"nav-link active\" href=\"#\"><span class=\"badge badge-primary\">Featured</span></a>\r\n" + 
        			"                                </li>\r\n" + 
        			"                                <li class=\"nav-item\">\r\n" + 
        			"                                  <a class=\"nav-link\" href=\"#\"><span class=\"badge badge-success\">Recent</span></a>\r\n" + 
        			"                                </li>\r\n" + 
        			"                                <li class=\"nav-item\">\r\n" + 
        			"                                  <a class=\"nav-link\" href=\"#\"><span class=\"badge badge-danger\">Trending</span></a>\r\n" + 
        			"                                </li>\r\n" + 
        			"                              </ul>\r\n" + 
        			"                            </div>\r\n" + 
        			"                            <div class=\"card-body\">\r\n" + 
        			"                              <h5 class=\"card-title\">Song Name</h5>\r\n" + 
        			"                              <p class=\"card-text\">Song Artist</p>\r\n" + 
        			"                              <a href=\"#\" class=\"btn btn-primary\">Listen</a>\r\n" + 
        			"                              <button type=\"button\" class=\"btn btn-sm btn-danger\" data-toggle=\"popover\" title=\"User Not Logged In\" data-content=\"You are not logged in. Please Login to add the song to your playlist.\">+</button>\r\n" + 
        			"\r\n" + 
        			"                              <h5 class=\"card-title\">Song Name</h5>\r\n" + 
        			"                              <p class=\"card-text\">Song Artist</p>\r\n" + 
        			"                              <a href=\"#\" class=\"btn btn-primary\">Listen</a>\r\n" + 
        			"                              <button type=\"button\" class=\"btn btn-sm btn-danger\" data-toggle=\"popover\" title=\"User Not Logged In\" data-content=\"You are not logged in. Please Login to add the song to your playlist.\">+</button>\r\n" + 
        			"\r\n" + 
        			"                              <h5 class=\"card-title\">Song Name</h5>\r\n" + 
        			"                              <p class=\"card-text\">Song Artist</p>\r\n" + 
        			"                              <a href=\"#\" class=\"btn btn-primary\">Listen</a>\r\n" + 
        			"                              <button type=\"button\" class=\"btn btn-sm btn-danger\" data-toggle=\"popover\" title=\"User Not Logged In\" data-content=\"You are not logged in. Please Login to add the song to your playlist.\">+</button>\r\n" + 
        			"                            </div>\r\n" + 
        			"                          </div>\r\n" + 
        			"                        </div>\r\n" + 
        			"                        <div class=\"col-sm-4\">\r\n" + 
        			"\r\n" + 
        			"                            <div style=\"background:transparent !important\" class=\"jumbotron\">\r\n" + 
        			"                                <h1>Welcome to Website!</h1>\r\n" + 
        			"                                <p>Blablabla, join us now and start making your slick playlist today!.\r\n" + 
        			"                                  (Might make this a slideshow featuring some updates and other various things.)\r\n" + 
        			"                                </p>\r\n" + 
        			"                                <a class=\"btn btn-primary\">Register</a>\r\n" + 
        			"                            </div>\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"                        </div>\r\n" + 
        			"                        <div class=\"col-sm-4\">Test3</div>\r\n" + 
        			"                      </div>\r\n" + 
        			"\r\n" + 
        			"                   \r\n" + 
        			"                          </div>\r\n" + 
        			"\r\n" + 
        			"                          \r\n" + 
        			"\r\n" + 
        			"                     \r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"        </body>\r\n" + 
        			"\r\n" + 
        			"        <!-- Footer -->\r\n" + PageElements.footer2()+
        	
        			"  <!-- Footer -->\r\n" + 
        			"\r\n" + 
        			"        \r\n" + 
        			"    </head>\r\n" + 
        			"</html>";
        	
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

        	return true;
        }
        return false;
	}

}
