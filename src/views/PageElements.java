package views;

public class PageElements {
	
	public PageElements() {
		
	}

	public String header() {
		String headerString = "<nav class=\"orange\" role=\"navigation\">\r\n" + 
				"    <div class=\"nav-wrapper container\"><a id=\"logo-container\" href=\"home\" class=\"brand-logo\">Feelin' It</a>\r\n" + 
				"      <ul class=\"right hide-on-med-and-down\">\r\n" + 
				"        <li><a href=\"webapp\">Music</a></li>\r\n" + 
				"        <li><a href=\"store\">Store</a></li>\r\n" + 
				"        <li><a href=\"aboutus.html\">About Us</a></li>\r\n" + 
				"        <li><a href=\"registration\">Account</a></li>\r\n" + 
				"      </ul>\r\n" + 
				"      <ul id=\"nav-mobile\" class=\"sidenav\">\r\n" + 
				"        <li><a href=\\\"webapp.html\\\">Music</a></li>\r\n" + 
				"        <li><a href=\"store.html\">Store</a></li>\r\n" + 
				"        <li><a href=\"aboutus.html\">About Us</a></li>\r\n" + 
				"        <li><a href=\"account.html\">Account</a></li>\r\n" + 
				"      </ul>\r\n" + 
				"      <a href=\"#\" data-target=\"nav-mobile\" class=\"sidenav-trigger\"><i class=\"material-icons\">menu</i></a>\r\n" + 
				"    </div>\r\n" + 
				"\r\n" + 
				"  </nav>";
		return headerString;
		
	}
	
	public String footer() {
		String footerString = "</div>\r\n" + 
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
		return footerString;
	}
}
