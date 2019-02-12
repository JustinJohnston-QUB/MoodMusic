package views;

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
        	//Lab 1 Task 4
        	//Change this string so that it contains HTML from a page you created in Pingendo 
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
        			"<html>\r\n" + 
        			"\r\n" + 
        			"<head>\r\n" + 
        			"  <meta charset=\"utf-8\">\r\n" + 
        			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
        			"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\r\n" + 
        			"  <link rel=\"stylesheet\" href=\"https://static.pingendo.com/bootstrap/bootstrap-4.2.1.css\">\r\n" + 
        			"</head>\r\n" + 
        			"\r\n" + 
        			"<body>\r\n" + 
        			"  <nav class=\"navbar navbar-expand-lg navbar-light\">\r\n" + 
        			"    <div class=\"container\"> <a class=\"navbar-brand text-primary\" href=\"#\">\r\n" + 
        			"        <i class=\"fa d-inline fa-lg fa-circle-o\"></i>\r\n" + 
        			"        <b>CornDogMusic</b>\r\n" + 
        			"      </a> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar5\">\r\n" + 
        			"        <span class=\"navbar-toggler-icon\"></span>\r\n" + 
        			"      </button>\r\n" + 
        			"      <div class=\"collapse navbar-collapse\" id=\"navbar5\">\r\n" + 
        			"        <ul class=\"navbar-nav mr-auto\">\r\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"homepage.html\">Home</a> </li>\r\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"webapp.html\">Music</a> </li>\r\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"store.html\">Store</a> </li>\r\n" + 
        			"        </ul>\r\n" + 
        			"        <ul class=\"navbar-nav ml-auto\">\r\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"aboutus\">About us</a> </li>\r\n" + 
        			"        </ul> <a class=\"btn btn-outline-primary navbar-btn ml-md-2\" href=\"account.html\">Account</a>\r\n" + 
        			"      </div>\r\n" + 
        			"    </div>\r\n" + 
        			"  </nav>\r\n" + 
        			"  <div class=\"py-5\">\r\n" + 
        			"    <div class=\"container\">\r\n" + 
        			"      <div class=\"row\">\r\n" + 
        			"        <div class=\"col-md-12\">\r\n" + 
        			"          <h1 class=\"display-1 text-center shadow-none border-bottom border-info\" contenteditable=\"true\">CornDogStore</h1>\r\n" + 
        			"        </div>\r\n" + 
        			"      </div>\r\n" + 
        			"    </div>\r\n" + 
        			"  </div>\r\n" + 
        			"  <div class=\"py-5\">\r\n" + 
        			"    <div class=\"container\">\r\n" + 
        			"      <div class=\"row\">\r\n" + 
        			"        <div class=\"col-md-4  \" style=\"\">\r\n" + 
        			"          <a href = \"checkout.html\">\r\n" + 
        			"            <img class=\"img-fluid d-block mx-auto\" src=\"../images/tshirt4.jpeg\" >\r\n" + 
        			"          </a>\r\n" + 
        			"          <div class=\"row\">\r\n" + 
        			"            <div class=\"col-md-12\">\r\n" + 
        			"              <h2 class=\"\">Budget T-Shirt<br>£15.00</h2>\r\n" + 
        			"            </div>\r\n" + 
        			"          </div>\r\n" + 
        			"        </div>\r\n" + 
        			"        <div class=\"col-md-4\" style=\"\">\r\n" + 
        			"          <a href = \"checkout.html\">\r\n" + 
        			"          	<img class=\"img-fluid d-block\" src=\"../images/tshirt2.jpg\">\r\n" + 
        			"          </a>\r\n" + 
        			"          <div class=\"row\">\r\n" + 
        			"            <div class=\"col-md-12\" style=\"\">\r\n" + 
        			"              <h2 class=\"\">T-Shirt<br>£40.00</h2>\r\n" + 
        			"            </div>\r\n" + 
        			"          </div>\r\n" + 
        			"        </div>\r\n" + 
        			"        <div class=\"col-md-4\" style=\"\">\r\n" + 
        			"          <a href = \"checkout.html\"><img class=\"img-fluid d-block\" src=\"../images/tshirt3.jpg\"></a>\r\n" + 
        			"          <div class=\"row\">\r\n" + 
        			"            <div class=\"col-md-12\">\r\n" + 
        			"              <h2 class=\"\">Premium T-Shirt<br>£60.00</h2>\r\n" + 
        			"            </div>\r\n" + 
        			"          </div>\r\n" + 
        			"        </div>\r\n" + 
        			"      </div>\r\n" + 
        			"    </div>\r\n" + 
        			"  </div>\r\n" + 
        			"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n" + 
        			"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\"></script>\r\n" + 
        			"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\r\n" + 
        			"  <pingendo onclick=\"window.open('https://pingendo.com/', '_blank')\" style=\"cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white\">Made with Pingendo Free&nbsp;&nbsp;<img src=\"https://pingendo.com/site-assets/Pingendo_logo_big.png\" class=\"d-block\" alt=\"Pingendo logo\" height=\"16\"></pingendo>\r\n" + 
        			"</body>\r\n" + 
        			"\r\n" + 
        			"</html>";
        	
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

        	return true;
        }
        return false;
	}

}
