package views;

import java.util.List;

import org.h2.mvstore.MVMap;

import model.Product;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class ProductPage extends DynamicWebPage
{
	public ProductPage(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{

		MVMap<String, Product> products = db.s.openMap("products");
		List<String> productKeys = products.keyList();
		
		if (productKeys.size() == 0) {
			Product emptProd = new Product();
			emptProd.title = "There were no products!"; 
		}
		if(toProcess.path.equalsIgnoreCase("productpage")) {
			String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\" />\r\n" + 
					"  <title>Product</title>\r\n" + 
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
					"        <li><a href=\\\"webapp\\\">Music</a></li>\r\n" + 
					"        <li><a href=\"store\">Store</a></li>\r\n" + 
					"        <li><a href=\"aboutus.html\">About Us</a></li>\r\n" + 
					"        <li><a href=\"registration\">Account</a></li>\r\n" + 
					"      </ul>\r\n" + 
					"      <ul id=\"nav-mobile\" class=\"sidenav\">\r\n" + 
					"        <li><a href=\"#\">Navbar Link</a></li>\r\n" + 
					"      </ul>\r\n" + 
					"      <a href=\"#\" data-target=\"nav-mobile\" class=\"sidenav-trigger\"><i class=\"material-icons\">menu</i></a>\r\n" + 
					"    </div>\r\n" + 
					"  </nav>\r\n" + 
					"\r\n" + 
					"  <!--Main body of content-->\r\n" + 
					"  <div class=\"container\">\r\n" + 
					"\r\n" + 
					"  <div class=\"grid-container\">\r\n" + 
					"    <div class=\"item1\">\r\n" + 
					"      <h3>Product Title</h3>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item2\">\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item3\">3</div>\r\n" + 
					"    <div class=\"item4\">\r\n" + 
					"      <image class=\"left\" src=\"../images/tshirt1.png\" alt=\"Picture of tshirt\" width=200px></image>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item5\">\r\n";
			
			String productUniqueID = productKeys.get(0);
			Product product = products.get(productUniqueID);
			
			stringToSendToWebBrowser +=
					"      <p class = \"productDesc\">"+product.description+"</p>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item6\">\r\n" + 
					"      <h5>Review Section</h5>\r\n" + 
					"      <p>How would you rate this T-Shirt out of 5?</p>\r\n" + 
					"      <form action=\"#\">\r\n" + 
					"    <p class=\"range-field\">\r\n" + 
					"      <input type=\"range\" id=\"tshirtReview\" min=\"0\" max=\"5\" />\r\n" + 
					"    </p>\r\n" + 
					"  </form>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item7\">\r\n" + 
					"      <div class=\"colourBtn\">\r\n" + 
					"        <a class='dropdown-trigger btn' href='#' data-target='dropdown1'>Choose Colour</a>\r\n" + 
					"        <ul id='dropdown1' class='dropdown-content'>\r\n" + 
					"          <li><a href=\"#!\" onclick=\"M.toast({html: 'Red Chosen'})\">Red</a></li>\r\n" + 
					"          <li><a href=\"#!\" onclick=\"M.toast({html: 'Blue Chosen'})\">Blue</a></li>\r\n" + 
					"          <li><a href=\"#!\" onclick=\"M.toast({html: 'Yellow Chosen'})\">Yellow</a></li>\r\n" + 
					"        </ul>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item8\">\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item9\">9</div>\r\n" + 
					"  </div>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"  <!--Footer-->\r\n" + 
					"  <footer class=\"page-footer blue\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col l6 s12\">\r\n" + 
					"          <h5 class=\"white-text\">Company Bio</h5>\r\n" + 
					"          <p class=\"grey-text text-lighten-4\"></p>\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"col 20 s12\">\r\n" + 
					"          <form action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\" target=\"_top\">\r\n" + 
					"            <input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\" />\r\n" + 
					"            <input type=\"hidden\" name=\"hosted_button_id\" value=\"JCGQUETZC6DMN\" />\r\n" + 
					"            <input type=\"image\" src=\"https://www.paypalobjects.com/en_GB/i/btn/btn_donate_LG.gif\" border=\"0\" name=\"submit\" title=\"PayPal - The safer, easier way to pay online!\" alt=\"Donate with PayPal button\" />\r\n" + 
					"            <img alt=\"\" border=\"0\" src=\"https://www.paypal.com/en_GB/i/scr/pixel.gif\" width=\"1\" height=\"1\" />\r\n" + 
					"          </form>\r\n" + 
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
					"  <!--  Scripts-->\r\n" + 
					"  <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
					"  <script src=\"../js/materialize.js\"></script>\r\n" + 
					"  <script src=\"../js/init.js\"></script>\r\n" + 
					"  <script>\r\n" + 
					"    $(document).ready(function() {\r\n" + 
					"      $('.dropdown-trigger').dropdown();\r\n" + 
					"\r\n" + 
					"      $('#textarea1').val('New Text');\r\n" + 
					"  M.textareaAutoResize($('#textarea1'));\r\n" + 
					"    });\r\n" + 
					"  </script>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"\r\n" + 
					"</html>\r\n" + 
					"";

			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;

		}
		return false;
	}


}
