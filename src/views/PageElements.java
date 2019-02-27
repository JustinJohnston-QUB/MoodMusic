package views;

public class PageElements {
	
	public static String Navbar() {
		

	 String stringToSendToWebBrowser =  
			"  <nav class=\"orange\" role=\"navigation\">\r\n" + 
					"    <div class=\"nav-wrapper container\"><a id=\"logo-container\" href=\"homepage.html\" class=\"brand-logo\">Feelin' It</a>\r\n" + 
					"      <ul class=\"right hide-on-med-and-down\">\r\n" + 
					"		<li><a href=\"webapp\">Music</a></li>\r\n" + 
					"		<li><a href=\"song.html\">Add Song</a></li>\r\n" + 
					"		<li><a href=\"artist.html\">Add musician</a></li>\r\n" + 
					"		<li><a href=\"store\">Store</a></li>\r\n" + 
					"		<li><a href=\"indexview\">About Us</a></li>\r\n" + 
					"		<li><a href=\"user\">Account</a></li>\r\n" + 
					"      </ul>\r\n" + 
					"      <ul id=\"nav-mobile\" class=\"sidenav\">\r\n" + 
					"        <li><a href=\"#\">Navbar Link</a></li>\r\n" + 
					"      </ul>\r\n" + 
					"      <a href=\"#\" data-target=\"nav-mobile\" class=\"sidenav-trigger\"><i class=\"material-icons\">menu</i></a>\r\n" + 
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
}
