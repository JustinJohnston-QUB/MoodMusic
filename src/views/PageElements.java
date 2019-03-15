package views;

public class PageElements {
	
	public PageElements() {
		
	}

	public static String footer() {
		String footerString =  
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
		return footerString;
		}
	
	
	
	public static String Navbar() {
		

	 String stringToSendToWebBrowser = 
			 "<ul id=\"dropdown1\" class=\"dropdown-content\">\r\n" + 
			 "  <li><a href=\"song.html\">Add Song</a></li>\r\n" + 
			 "  <li><a href=\"artist.html\">Add Artist</a></li>\r\n" + 
			 "</ul>" +
			"  <nav class=\"orange\" role=\"navigation\">\r\n" + 
					"    <div class=\"nav-wrapper container\"><a id=\"logo-container\" href=\"homepage\" class=\"brand-logo\">Feelin' It</a>\r\n" + 
					"      <ul class=\"right hide-on-med-and-down\">\r\n" + 
					"		<li><a href=\"webapp\">Music</a></li>\r\n" + 
					"      <li><a class=\"dropdown-trigger\" href=\"#!\" data-target=\"dropdown1\">Contribute<i class=\"material-icons right\">arrow_drop_down</i></a></li>\r\n" + 
					"		<li><a href=\"store\">Store</a></li>\r\n" + 
					"		<li><a href=\"indexview\">About Us</a></li>\r\n" + 
					"		<li><a href=\"login\" class=\"waves-effect waves-light blue lighten-1 btn-small\">Login</a></li>\r\n" + 
					"		<li><a href=\"register\" class=\"waves-effect waves-light blue lighten-1 btn-small\">Sign Up</a></li>\r\n" + 
					"" +
					"      </ul>\r\n" + 
					"      <ul id=\"nav-mobile\" class=\"sidenav\">\r\n" + 
					"		<li><a href=\"homepage\">home</a></li>\r\n" + 
					"		<li><a href=\"webapp\">Music</a></li>\r\n" +
					"		<li><a href=\"song.html\">Add Song</a></li>\r\n" +
					"		<li><a href=\"artist.html\">Add Artist</a></li>\r\n" +
					"		<li><a href=\"store\">Store</a></li>\r\n" + 
					"		<li><a href=\"indexview\">About Us</a></li>\r\n" +
					"      </ul>\r\n" + 
					"      <a href=\"#\" data-target=\"nav-mobile\" class=\"sidenav-trigger orange \"><i class=\"material-icons\">menu</i></a>\r\n" + 
					"    </div>\r\n" +
					"  </nav>\r\n";
	
	return stringToSendToWebBrowser;
	}
	
	public static String Search() {
		

		 String stringToSendToWebBrowser = 	"  <nav class=\"transparent z-depth-0\">\r\n" + 
									 		"    <div class=\"nav-wrapper\">\r\n" + 
									 		"      <form action=\"../search.html\" method=\"GET\">\r\n" + 
									 		"        <div class=\"input-field\">\r\n" + 
									 		"          <input id=\"search\" class = \"center-align\"name = \"Search\" placeholder =\"You can type anywhere in this area and hit the enter key to search for your favourite music\" type=\"search\" required>\r\n" + 
									 		"          <label class=\"label-icon\" for=\"search\" ><i class=\"material-icons\" style=\"color:black\">search</i></label>\r\n" + 
									 		"          <i class=\"material-icons\">close</i>\r\n" + 
									 		"        </div>\r\n" + 
									 		"      </form>\r\n" + 
									 		"    </div>\r\n" + 
									 		"  </nav>"; 
											 							/**
				 							"<div class=\"container-fluid\">\r\n" + 
									 		"  <div class=\"row\">\r\n" + 
									 		"    <div class=\"col-sm-8\">\r\n" + 
									 		"    </div>\r\n" + 
									 		"    <div class=\"col-sm-4\">\r\n" + 		
											"         <form action=\"../search.html\" method=\"GET\" class=\"form-inline\">\n" + 
											"            <div class=\"input-group\"> "						+
											"					<input type=\"text\" class=\"form-control\" name =\"Search\" placeholder =\"Enter Search text here\">\n" + 
											"              <div class=\"input-group-append\">"+
											"					 <input class=\"btn btn-primary\" type=\"submit\" value  = \"Search\"></input> " +
											"				</div>\n" + 
											"            </div>\n" + 
											"          </form>\n" +
									 		"    </div>\r\n" + 
									 		"  </div>\r\n" + 
									 		"</div>";
											**/
		return stringToSendToWebBrowser;
		}
	
	public static String header() {
		 String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
											"<html>\n" + 
											"\n" + 
											"<head>\n" + 
							    			"  <meta charset=\"utf-8\">\n" + 
							    			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
							    			"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n" + 
											"  <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n" + 
											"  <link href=\"../css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
											"  <link href=\"../css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
											//"  <link href=\"../untitled.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
							    			"</head>\n";
		return stringToSendToWebBrowser ;
	}
	
	public static String scripts() {
		
		String stringToSendToWebBrowser = "  <!--  Scripts-->\r\n" + 
				"  <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
				"  <script src=\"js/materialize.js\"></script>\r\n" + 
				"  <script src=\"js/init2.js\"></script>\r\n" + 
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
				"   "
				+ " });\r\n" +
				" $(document).ready(function(){\r\n" + 
				"    $('.materialboxed').materialbox();\r\n" + 
				"  });"
				+ "  $(document).ready(function(){\r\n" + 
				"    $('.tabs').tabs();\r\n" + 
				"  });"+
				"  </script>";
		
		return stringToSendToWebBrowser;
	}
	
	
}