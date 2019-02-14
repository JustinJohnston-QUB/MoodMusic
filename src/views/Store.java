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
        			"  <link href=\"../css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
        			"  <link href=\"../css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
        			"</head>\r\n" + 
        			"\r\n" + 
        			"<body>\r\n" + 
        			"  <nav class=\"orange\" role=\"navigation\">\r\n" + 
        			"    <div class=\"nav-wrapper container\"><a id=\"logo-container\" href=\"home\" class=\"brand-logo\">Feelin' It</a>\r\n" + 
        			"      <ul class=\"right hide-on-med-and-down\">\r\n" + 
        			"		<li><a href=\\\"webapp.html\\\">Music</a></li>\r\n" + 
        			"		<li><a href=\"store.html\">Store</a></li>\r\n" + 
        			"		<li><a href=\"aboutus.html\">About Us</a></li>\r\n" + 
        			"		<li><a href=\"account.html\">Account</a></li>\r\n" + 
        			"\r\n" + 
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
        			"            <image class = \"left\" src = \"../images/tshirt1.png\" alt = \"Picture of tshirt\" width = 200px></image>\r\n" + 
        			"\r\n" + 
        			"            <h5 class=\"heavy left\">Budget T-shirt<br/>Only &pound4.99</h5>\r\n" + 
        			"			<form target=\"paypal\" action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\">\r\n" + 
        			"				<input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\">\r\n" + 
        			"				<input type=\"hidden\" name=\"hosted_button_id\" value=\"BNY7ML6LGKLDN\">\r\n" + 
        			"				<input type=\"image\" src=\"https://www.paypalobjects.com/en_GB/i/btn/btn_cart_LG.gif\" border=\"0\" name=\"submit\" alt=\"PayPal – The safer, easier way to pay online!\">\r\n" + 
        			"				<img alt=\"\" border=\"0\" src=\"https://www.paypalobjects.com/en_GB/i/scr/pixel.gif\" width=\"1\" height=\"1\">\r\n" + 
        			"			</form>\r\n" + 
        			"\r\n" + 
        			"          </div>\r\n" + 
        			"        </div>\r\n" + 
        			"\r\n" + 
        			"        <div class=\"col s12 m4\">\r\n" + 
        			"          <div class=\"icon-block\">\r\n" + 
        			"			<image class = \"left\" src = \"../images/tshirt2.jpg\" alt = \"Picture of tshirt\" width = 200px></image>\r\n" + 
        			"            <h5 class=\"heavy left\">Premium T-shirt<br/>Only &pound9.99</h5>\r\n" + 
        			"			<form target=\"paypal\" action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\">\r\n" + 
        			"				<input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\">\r\n" + 
        			"				<input type=\"hidden\" name=\"hosted_button_id\" value=\"WHVFFLN5E2DPW\">\r\n" + 
        			"				<input type=\"image\" src=\"https://www.paypalobjects.com/en_GB/i/btn/btn_cart_LG.gif\" border=\"0\" name=\"submit\" alt=\"PayPal – The safer, easier way to pay online!\">\r\n" + 
        			"				<img alt=\"\" border=\"0\" src=\"https://www.paypalobjects.com/en_GB/i/scr/pixel.gif\" width=\"1\" height=\"1\">\r\n" + 
        			"			</form>\r\n" + 
        			"\r\n" + 
        			"\r\n" + 
        			"          </div>\r\n" + 
        			"        </div>\r\n" + 
        			"\r\n" + 
        			"        <div class=\"col s12 m4\">\r\n" + 
        			"          <div class=\"icon-block\">\r\n" + 
        			"			<image class = \"left\" src = \"../images/tshirt3.jpg\" alt = \"Picture of tshirt\" width = 200px></image>\r\n" + 
        			"\r\n" + 
        			"            <h5 class=\"heavy left\">Rock On T-shirt<br/>Only &pound15.99<br/></h5>\r\n" + 
        			"			<form target=\"paypal\" action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\">\r\n" + 
        			"				<input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\">\r\n" + 
        			"				<input type=\"hidden\" name=\"hosted_button_id\" value=\"WBUXQ3A283W3W\">\r\n" + 
        			"				<input type=\"image\" src=\"https://www.paypalobjects.com/en_GB/i/btn/btn_cart_LG.gif\" border=\"0\" name=\"submit\" alt=\"PayPal – The safer, easier way to pay online!\">\r\n" + 
        			"				<img alt=\"\" border=\"0\" src=\"https://www.paypalobjects.com/en_GB/i/scr/pixel.gif\" width=\"1\" height=\"1\">\r\n" + 
        			"			</form>\r\n" + 
        			"\r\n" + 
        			"			\r\n" + 
        			"\r\n" + 
        			"          </div>\r\n" + 
        			"        </div>\r\n" + 
        			"      </div>\r\n" + 
        			"\r\n" + 
        			"    </div>\r\n" + 
        			"    <br><br>\r\n" + 
        			"  </div>\r\n" + 
        			"\r\n" + 
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
        			"				<input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\" />\r\n" + 
        			"				<input type=\"hidden\" name=\"hosted_button_id\" value=\"JCGQUETZC6DMN\" />\r\n" + 
        			"				<input type=\"image\" src=\"https://www.paypalobjects.com/en_GB/i/btn/btn_donate_LG.gif\" border=\"0\" name=\"submit\" title=\"PayPal - The safer, easier way to pay online!\" alt=\"Donate with PayPal button\" />\r\n" + 
        			"				<img alt=\"\" border=\"0\" src=\"https://www.paypal.com/en_GB/i/scr/pixel.gif\" width=\"1\" height=\"1\" />\r\n" + 
        			"			</form>\r\n" + 
        			"\r\n" + 
        			"        </div>\r\n" + 
        			"      </div>\r\n" + 
        			"    </div>\r\n" + 
        			"    <div class=\"footer-copyright\">\r\n" + 
        			"      <div class=\"container\">\r\n" + 
        			"		<h5>© 2019 Feelin' It</h5>\r\n" + 
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
