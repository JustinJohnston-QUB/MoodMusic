package views;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class AboutUsView extends DynamicWebPage{

	public AboutUsView(DatabaseInterface db, FileStoreInterface fs) 
	{
		super(db, fs);
		// TODO Auto-generated constructor stub
	}
	
	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("indexview"))
		{
			
			String exampleUserName = "Ellen";
			String stringToSendToWebBrowser = PageElements.header()+
					"\r\n" + 
					"<body >\r\n" + PageElements.Navbar()+PageElements.Search()+
					"  <div class=\"py-5 bg-primary\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-12\">\r\n" + 
					"          <h1 class=\"text-center bg-primary text-white display-1\" style=\"\">About us</h1>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"  <div class=\"py-2 bg-primary\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-12\">\r\n" + 
					"          <h1 class=\"display-4 bg-primary text-white\">Our mission" +exampleUserName+ "</h1>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"  <div class=\"py-5 bg-primary\" style=\"\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-md-12\">\r\n" + 
					"          <p class=\"lead\">It is our mission to deliver the best quality songs, categorised by their emotion to our audience. We want to give music lovers a place to share, interact and indulge in their passion.&nbsp;&nbsp;</p>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"  <div class=\"py-5 text-center bg-light\" style=\"\">\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"mx-auto col-md-12\">\r\n" + 
					"          <h1 class=\"mb-3 shadow-none text-dark\">Meet the team who made this website possible&nbsp;</h1>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto py-4\" src=\"../Pigendo/male.png\" width=\"200\" alt=\"Card image cap\">\r\n" + 
					"          <h4 style=\"\" class=\"text-dark\"> <b>Justin Johnson</b></h4>\r\n" + 
					"          <div class=\"row\">\r\n" + 
					"            <div class=\"col-md-12\" style=\"\"><a class=\"btn text-white\" href=\"#\" style=\"background: rgb(85, 172, 238);\" target=\"_blank\"><i class=\"fa fa-twitter fa-fw fa-1x py-1\"></i> Tweet</a></div>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto py-4\" src=\"../Pigendo/male.png\" width=\"200\" alt=\"Card image cap\">\r\n" + 
					"          <h4> <b>Karolis Katauskas</b></h4>\r\n" + 
					"          <div class=\"row\">\r\n" + 
					"            <div class=\"col-md-12\"><a class=\"btn text-white\" href=\"#\" style=\"background: rgb(85, 172, 238);\" target=\"_blank\"><i class=\"fa fa-twitter fa-fw fa-1x py-1\"></i> Tweet</a></div>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"col-6 col-lg-3 p-4\"> <img class=\"img-fluid d-block mb-3 mx-auto py-4\" src=\"../Pigendo/male.png\" width=\"200\">\r\n" + 
					"          <h4> <b>Johnny Hume</b></h4>\r\n" + 
					"          <div class=\"row\">\r\n" + 
					"            <div class=\"col-md-12\"><a class=\"btn text-white\" href=\"#\" style=\"background: rgb(85, 172, 238);\" target=\"_blank\"><i class=\"fa fa-twitter fa-fw fa-1x py-1\"></i> Tweet</a></div>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"col-6 col-lg-3 p-4\" style=\"\"> <img class=\"img-fluid d-block mb-3 mx-auto py-4 pb-3\" src=\"../Pigendo/4c2e357b569a0f54f45dbad7a268ffbe--siluett-tag-templates.jpg\" width=\"200\">\r\n" + 
					"          <h4> <b>Ellen Kerr</b></h4>\r\n" + 
					"          <div class=\"row\">\r\n" + 
					"            <div class=\"col-md-12\" style=\"\"><a class=\"btn text-white\" href=\"#\" style=\"background:#55acee\" target=\"_blank\"><i class=\"fa fa-twitter fa-fw fa-1x py-1\"></i> Tweet</a></div>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + PageElements.footer2()+PageElements.scripts()+
					"</body>\r\n" + 
					"\r\n" + 
					"</html>";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK,
			WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
	return false;
	}
}
	
			
	
	
	
	
	

