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
			String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"  <meta charset=\"utf-8\">\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"theme.css\" type=\"text/css\">\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body >\r\n" + 
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
					"  </div>\r\n" + 
					"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
					"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n" + 
					"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
					"  <pingendo onclick=\"window.open('https://pingendo.com/', '_blank')\" style=\"cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white\">Made with Pingendo Free&nbsp;&nbsp;<img src=\"https://pingendo.com/site-assets/Pingendo_logo_big.png\" class=\"d-block\" alt=\"Pingendo logo\" height=\"16\"></pingendo>\r\n" + 
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
	
			
	
	
	
	
	

