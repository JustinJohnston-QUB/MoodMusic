package views;

import org.h2.mvstore.MVMap;

import model.Product;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class StoreTest extends DynamicWebPage
{
	public StoreTest(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public void changeTshirt(int whichShirt, Product itshirt) {
		System.out.println("I is:" + whichShirt);
		switch(whichShirt) {
		case 0:
			itshirt.price = "4.99";
			itshirt.title = "Budget T-Shirt";
			itshirt.filePathToImage = "../images/tshirt1.png";
			itshirt.paypalBtn = "BNY7ML6LGKLDN";
			break;
		case 1:
			itshirt.price = "9.99";
			itshirt.title = "Respectable T-Shirt";
			itshirt.filePathToImage = "../images/tshirt2.jpg";
			itshirt.paypalBtn = "WHVFFLN5E2DPW";
			break;
		case 2:
			itshirt.price = "15.99";
			itshirt.title = "Premium T-Shirt";
			itshirt.filePathToImage = "../images/tshirt3.jpg";
			itshirt.paypalBtn = "WBUXQ3A283W3W";
			break;
		default:
			itshirt.price = "N/A";
			itshirt.title = "T-shirt Not Found";
			itshirt.filePathToImage = "../images/tshirt1.jpg";
			break;
		}
	}
	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("storetest"))
		{
			Product itshirt = new Product();

			//start of html and imports of materialize cs
			String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\"/>\r\n" + 
					"  <title>Store</title>\r\n" + 
					"\r\n" + 
					"  <!-- CSS  -->\r\n" + 
					"  <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n" + 
					"  <link href=\"../css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
					"  <link href=\"../css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body>\r\n";
			//navbar
			stringToSendToWebBrowser +=  
					"  <nav class=\"orange\" role=\"navigation\">\r\n" + 
							"    <div class=\"nav-wrapper container\"><a id=\"logo-container\" href=\"home\" class=\"brand-logo\">Feelin' It</a>\r\n" + 
							"      <ul class=\"right hide-on-med-and-down\">\r\n" + 
							"		<li><a href=\"webapp\">Music</a></li>\r\n" + 
							"		<li><a href=\"store\">Store</a></li>\r\n" + 
							"		<li><a href=\"aboutus.jhtm\">About Us</a></li>\r\n" + 
							"		<li><a href=\"account\">Account</a></li>\r\n" + 
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
							"  </nav>\r\n";

			//Carousel
			stringToSendToWebBrowser +=
					"<div class=\"carousel carousel-slider\">\r\n" + 
							"    <div class=\"carousel-fixed-item\">\r\n" + 
							"      <a href=\"#tshirts\">\r\n" + 
							"        <h2 class=\"black-text\">Store</h2>\r\n" + 
							"      </a>\r\n" + 
							"      <h5 class=\"black-text\">Support our emotion based music site <br /> and look damn good doing it! </h5>\r\n" + 
							"\r\n" + 
							"    </div>\r\n" + 
							"    <a class=\"carousel-item\" href=\"#one!\">\r\n" + 
							"      <img src=\"../images/sampleDeal.png\">\r\n" + 
							"    </a>\r\n" + 
							"    <a class=\"carousel-item\" href=\"#two!\">\r\n" + 
							"      <img src=\"../images/sampleDeal.png\">\r\n" + 
							"    </a>\r\n" + 
							"    <a class=\"carousel-item\" href=\"#three!\">\r\n" + 
							"      <img src=\"../images/sampleDeal.png\">\r\n" + 
							"    </a>\r\n" + 
							"    <a class=\"carousel-item\" href=\"#four!\">\r\n" + 
							"      <img src=\"../images/sampleDeal.png\">\r\n" + 
							"    </a>\r\n" + 
							"    <a class=\"carousel-item\" href=\"#five!\">\r\n" + 
							"      <img src=\"../images/sampleDeal.png\">\r\n" + 
							"    </a>\r\n" + 
							"  </div>" + 
							"  <div class=\"container\">\r\n" +
							"    <h4>T-Shirts</h4>\r\n" + 
							"    <div class=\"section\">\r\n" + 
							"\r\n" + 
							"      <!--   Icon Section   -->\r\n" + 
							"      <div class=\"row\">\r\n"; 

			for (int i = 0; i < 3; i++) {
				changeTshirt(i, itshirt);
				stringToSendToWebBrowser += "        <div class=\"col s12 m4\">\r\n" + 
						"          <div class=\"icon-block\">\r\n" + 
						"            <a href=\"checkout.html\">\r\n" + 
						"              <image class=\"left\" src=\""+itshirt.filePathToImage+"\" alt=\"Picture of tshirt\" width=200px></image>\r\n" + 
						"            </a>\r\n" + 
						"            <h5 class=\"heavy left\">"+itshirt.title+"<br />Only &pound"+itshirt.price+"</h5>\r\n" + 
						"            <!--Dropdown button to choose colour-->\r\n" + 
						"            <div class=\"colourBtn\">\r\n" + 
						"              <a class='dropdown-trigger btn' href='#' data-target='dropdown1'>Choose Colour</a>\r\n" + 
						"              <ul id='dropdown1' class='dropdown-content'>\r\n" + 
						"                <li><a href=\"#!\" onclick=\"M.toast({html: 'Red Chosen'})\">Red</a></li>\r\n" + 
						"                <li><a href=\"#!\" onclick=\"M.toast({html: 'Blue Chosen'})\">Blue</a></li>\r\n" + 
						"                <li><a href=\"#!\" onclick=\"M.toast({html: 'Yellow Chosen'})\">Yellow</a></li>\r\n" + 
						"              </ul>\r\n" + 
						"            </div>\r\n" + 
						"            <!--Paypal button-->\r\n" + 
						"\r\n" + 
						"            <form class = \"paypalBtn\"target=\"paypal\" action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\">\r\n" + 
						"              <input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\">\r\n" +itshirt.paypalBtn+"\">\r\n" + 
						"              <input type=\"image\" src=\"https://www.paypalobjects.com/en_GB/i/btn/btn_cart_LG.gif\" border=\"0\" name=\"submit\" alt=\"PayPal – The safer, easier way to pay online!\">\r\n" + 
						"              <img alt=\"\" border=\"0\" src=\"https://www.paypalobjects.com/en_GB/i/scr/pixel.gif\" width=\"1\" height=\"1\">\r\n" + 
						"            </form>\r\n" + 
						"\r\n" + 
						"          </div>\r\n" + 
						"        </div>"; 
			}
			//This is the footer
			stringToSendToWebBrowser += "</div>\r\n" + 
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
					"		<h5>&copy 2019 Feelin' It</h5>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </footer>\r\n" + 
					"\r\n" + 
					"\r\n";
			//Scripts
			stringToSendToWebBrowser +="  <!--  Scripts-->\r\n" + 
					"  <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
					"  <script src=\"js/materialize.js\"></script>\r\n" + 
					"  <script src=\"js/init.js\"></script>\r\n" + 
					"\r\n" + 
					"<script>\r\n" + 
					"    $(document).ready(function() {\r\n" + 
					"      $('.carousel').carousel();\r\n" + 
					"\r\n" + 
					"      $('.carousel.carousel-slider').carousel({\r\n" + 
					"        fullWidth: true,\r\n" + 
					"        indicators: true\r\n" + 
					"      });\r\n" + 
					"\r\n" + 
					"      autoplay();\r\n" + 
					"\r\n" + 
					"      function autoplay() {\r\n" + 
					"        $('.carousel').carousel('next');\r\n" + 
					"        setTimeout(autoplay, 4500);\r\n" + 
					"      }\r\n" +
					"      $('.dropdown-trigger').dropdown();\r\n" + 
					"    });\r\n" + 
					"  </script>" +
					"  </body>\r\n" + 
					"</html>\r\n"; 


			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

			return true;
		}
		else
			if(toProcess.path.equalsIgnoreCase("addproduct"))
			{


				//start of html and imports of materialize cs
				String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
						"<html lang=\"en\" dir=\"ltr\">\r\n" + 
						"  <head>\r\n" + 
						"    <meta charset=\"utf-8\">\r\n" + 
						"    <title>Adding Product</title>\r\n" + 
						"  </head>\r\n" + 
						"  <body>\r\n" + 
						"    <form action=\"productprocess\" method=\"GET\">\r\n" + 
						"      <p>Product Title</p>\r\n" + 
						"      <input type=\"text\" name=\"ProdTitle\" value=\"\">\r\n" + 
						"      <p>File Path To Image</p>\r\n" + 
						"      <input type=\"text\" name=\"filePathToImage\" value=\"\">\r\n" + 
						"      <p>Price</p>\r\n" + 
						"      <input type=\"text\" name=\"price\" value=\"\">\r\n" + 
						"      <p>Paypal Button Link</p>\r\n" + 
						"      <input type=\"text\" name=\"paypalBtn\" value=\"\">\r\n" + 
						"      <input type=\"submit\" value=\"Submit\">\r\n" + 
						"    </form>\r\n" + 
						"  </body>\r\n" + 
						"</html>\r\n" + 
						""; 


				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

				return true;
			}
			else if(toProcess.path.equalsIgnoreCase("productprocess")) {
				Product iTshirt = new Product();
				iTshirt.uniqueid = "shirt_"+System.currentTimeMillis();
				iTshirt.title = toProcess.params.get("ProdTitle");
				iTshirt.price = toProcess.params.get("price");
				iTshirt.paypalBtn = toProcess.params.get("paypalBtn");
				iTshirt.filePathToImage = toProcess.params.get("filePathToImage");

				MVMap<String, Product> products = db.s.openMap("products");
				products.put(iTshirt.uniqueid, iTshirt);
				
				db.commit();
				String stringToSendToWebBrowser = "“<html><body><p>Product added</p><a\r\n" + 
						"href=\\”index.html\\”>Home</a></body></html>";
				
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );



				return true;
			}
			else
				if(toProcess.path.equalsIgnoreCase("addprodpage")) {

					String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
							"<html lang=\"en\" dir=\"ltr\">\r\n" + 
							"  <head>\r\n" + 
							"    <meta charset=\"utf-8\">\r\n" + 
							"    <title>Adding Shirt</title>\r\n" + 
							"  </head>\r\n" + 
							"  <body>\r\n" + 
							"    <form action=\"productprocess\" method=\"GET\">\r\n" + 
							"      <p>Product Title</p>\r\n" + 
							"      <input type=\"text\" name=\"ShirtTitle\" value=\"\">\r\n" + 
							"      <p>File Path To Image</p>\r\n" + 
							"      <input type=\"text\" name=\"filePathToImage\" value=\"\">\r\n" + 
							"      <p>Price</p>\r\n" + 
							"      <input type=\"text\" name=\"price\" value=\"\">\r\n" + 
							"      <p>Paypal Button Link</p>\r\n" + 
							"      <input type=\"text\" name=\"paypalBtn\" value=\"\">\r\n" + 
							"      <input type=\"submit\" value=\"Submit\">\r\n" + 
							"    </form>\r\n" + 
							"  </body>\r\n" + 
							"</html>\r\n" + 
							"";

					toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

					return true;
				}

		return false;
	}

}
