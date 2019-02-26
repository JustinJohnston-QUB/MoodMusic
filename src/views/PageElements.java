package views;

public class PageElements {
	
	public static String Navbar() {
		

	 String stringToSendToWebBrowser =  
			"  <nav class=\"orange\" role=\"navigation\">\r\n" + 
					"    <div class=\"nav-wrapper container\"><a id=\"logo-container\" href=\"homepage.html\" class=\"brand-logo\">Feelin' It</a>\r\n" + 
					"      <ul class=\"right hide-on-med-and-down\">\r\n" + 
					"		<li><a href=\"webapp\">Music</a></li>\r\n" + 
					"		<li><a href=\"song.html\">add Song</a></li>\r\n" + 
					"		<li><a href=\"artist.html\">add musician</a></li>\r\n" + 
					"		<li><a href=\"store\">Store</a></li>\r\n" + 
					"		<li><a href=\"indexview\">About Us</a></li>\r\n" + 
					"		<li><a href=\"user\">Account</a></li>\r\n" + 
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
	
	return stringToSendToWebBrowser;
	}
	
	public static String Search() {
		

		 String stringToSendToWebBrowser =  "<div class=\"container\">\r\n" + 
									 		"  <div class=\"row\">\r\n" + 
									 		"    <div class=\"col-sm-8\">\r\n" + 
									 		"    </div>\r\n" + 
									 		"    <div class=\"col-sm-4\">\r\n" + 
											"         <form action=\"../search.html\" method=\"GET\" class=\"form-inline d-flex justify-content-center\">\n" + 
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
											"  <link href=\"../untitled.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n" + 
							    			"</head>\n";
		return stringToSendToWebBrowser ;
		
	}
}
