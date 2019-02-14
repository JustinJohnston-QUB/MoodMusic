package views;

import model.Tshirt;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class Store extends DynamicWebPage
{
	public Store(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
        if(toProcess.path.equalsIgnoreCase("store.html"))
        {
        	Tshirt newTshirt = new Tshirt();
        	newTshirt.price = "£1.00";
        	newTshirt.title = "Budget T-Shirt";
        	newTshirt.filePathToImage = "../images/tshirt4.jpeg";
        	
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
        			"<html lang=\"en\">\r\n" + 
        			"<head>\r\n" + 
        			"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n" + 
        			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\"/>\r\n" + 
        			"  <title>Starter Template - Materialize</title>\r\n" + 
        			"\r\n" + 
        			"  <!-- CSS  -->\r\n" + 
        			"  <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n" + 
        			"  <link href=\"css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
        			"  <link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
        			"</head>\r\n" + 
        			"<body>\r\n" + 
        			"  <nav class=\"blue lighten-1\" role=\"navigation\">\r\n" + 
        			"    <div class=\"nav-wrapper container\"><a id=\"logo-container\" href=\"homepage.html\" class=\"brand-logo\">CornDogMusic</a>\r\n" + 
        			"      <ul class=\"right hide-on-med-and-down\">\r\n" + 
        			"        <li><a href=\"account.html\">Account</a></li>\r\n" + 
        			"		<li><a href=\"aboutus.html\">About Us</a></li>\r\n" + 
        			"		<li><a href=\"webapp.html\">Music</a></li>\r\n" + 
        			"        <li><a href=\"store.html\">Store</a></li>\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"      </ul>\r\n" + 
        			"\r\n" + 
        			"      <ul id=\"nav-mobile\" class=\"sidenav\">\r\n" + 
        			"        <li><a href=\"#\">Navbar Link</a></li>\r\n" + 
        			"      </ul>\r\n" + 
        			"      <a href=\"#\" data-target=\"nav-mobile\" class=\"sidenav-trigger\"><i class=\"material-icons\">menu</i></a>\r\n" + 
        			"    </div>\r\n" + 
        			"  </nav>\r\n" + 
        			"  <div class=\"section no-pad-bot\" id=\"index-banner\">\r\n" + 
        			"    <div class=\"container\">\r\n" + 
        			"      <br><br>\r\n" + 
        			"      <h1 class=\"header center black-text\">Store Page</h1>\r\n" + 
        			"      <div class=\"row center\">\r\n" + 
        			"        <h5 class=\"header col s12 light\">Support our emotion based music site, <br/> And look damn good doing it!	</h5>\r\n" + 
        			"      </div>\r\n" + 
        			"      <div class=\"row center\">\r\n" + 
        			"      </div>\r\n" + 
        			"      <br><br>\r\n" + 
        			"\r\n" + 
        			"    </div>\r\n" + 
        			"  </div>\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"  <div class=\"container\">\r\n" + 
        			"    <div class=\"section\">\r\n" + 
        			"\r\n" + 
        			"      <!--   Icon Section   -->\r\n" + 
        			"      <div class=\"row\">\r\n" + 
        			"        <div class=\"col s12 m4\">\r\n" + 
        			"          <div class=\"icon-block\">\r\n" + 
        			"            <image class = \"left\" src = \"../images/tshirt1.png\" width = 200px></image>\r\n" + 
        			"\r\n" + 
        			"            <h5 class=\"heavy left\">Premium T-shirt<br/>Only &pound9.99</h5>\r\n" + 
        			"          </div>\r\n" + 
        			"        </div>\r\n" + 
        			"\r\n" + 
        			"        <div class=\"col s12 m4\">\r\n" + 
        			"          <div class=\"icon-block\">\r\n" + 
        			"            <image class = \"left\" src = \"../images/tshirt2.jpg\" width = 210px></image>\r\n" +
        			"\r\n" +
        			"            <h5 class=\"heavy left\">Budget T-shirt<br/>Only &pound4.99</h5>\r\n" + 
        			"          </div>\r\n" + 
        			"        </div>\r\n" + 
        			"\r\n" + 
        			"        <div class=\"col s12 m4\">\r\n" + 
        			"          <div class=\"icon-block\">\r\n" + 
        			"            <image class = \"left\" src = \"../images/tshirt2.jpg\" width = 210px></image>\r\n" + 
        			"\r\n" + 
        			"            <p class=\"heavy left\">We have provided detailed documentation as well as specific code examples to help new users get started. We are also always open to feedback and can answer any questions a user may have about Materialize.</p>\r\n" + 
        			"          </div>\r\n" + 
        			"        </div>\r\n" + 
        			"      </div>\r\n" + 
        			"\r\n" + 
        			"    </div>\r\n" + 
        			"    <br><br>\r\n" + 
        			"  </div>\r\n" + 
        			"\r\n" + 
        			"  <footer class=\"page-footer orange\">\r\n" + 
        			"    <div class=\"container\">\r\n" + 
        			"      <div class=\"row\">\r\n" + 
        			"        <div class=\"col l6 s12\">\r\n" + 
        			"          <h5 class=\"white-text\">Company Bio</h5>\r\n" + 
        			"          <p class=\"grey-text text-lighten-4\">This is the footer where we will have contact us and donation button</p>\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"        </div>\r\n" + 
        			"        <div class=\"col l3 s12\">\r\n" + 
        			"          <h5 class=\"white-text\">Settings</h5>\r\n" + 
        			"          <ul>\r\n" + 
        			"            <li><a class=\"white-text\" href=\"#!\">Link 1</a></li>\r\n" + 
        			"            <li><a class=\"white-text\" href=\"#!\">Link 2</a></li>\r\n" + 
        			"            <li><a class=\"white-text\" href=\"#!\">Link 3</a></li>\r\n" + 
        			"            <li><a class=\"white-text\" href=\"#!\">Link 4</a></li>\r\n" + 
        			"          </ul>\r\n" + 
        			"        </div>\r\n" + 
        			"        <div class=\"col l3 s12\">\r\n" + 
        			"          <h5 class=\"white-text\">Connect</h5>\r\n" + 
        			"          <ul>\r\n" + 
        			"            <li><a class=\"white-text\" href=\"#!\">Link 1</a></li>\r\n" + 
        			"            <li><a class=\"white-text\" href=\"#!\">Link 2</a></li>\r\n" + 
        			"            <li><a class=\"white-text\" href=\"#!\">Link 3</a></li>\r\n" + 
        			"            <li><a class=\"white-text\" href=\"#!\">Link 4</a></li>\r\n" + 
        			"          </ul>\r\n" + 
        			"        </div>\r\n" + 
        			"      </div>\r\n" + 
        			"    </div>\r\n" + 
        			"    <div class=\"footer-copyright\">\r\n" + 
        			"      <div class=\"container\">\r\n" + 
        			"      </div>\r\n" + 
        			"    </div>\r\n" + 
        			"  </footer>\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"  <!--  Scripts-->\r\n" + 
        			"  <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
        			"  <script src=\"js/materialize.js\"></script>\r\n" + 
        			"  <script src=\"js/init.js\"></script>\r\n" + 
        			"\r\n" + 
        			"  </body>\r\n" + 
        			"</html>\r\n" + 
        			"";
        	
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

        	return true;
        }
        return false;
	}

}
