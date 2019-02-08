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
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
        			"<html>\n" + 
        			"\n" + 
        			"<head>\n" + 
        			"  <meta charset=\"utf-8\">\n" + 
        			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
        			"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n" + 
        			"  <link rel=\"stylesheet\" href=\"https://static.pingendo.com/bootstrap/bootstrap-4.2.1.css\">\n" + 
        			"</head>\n" + 
        			"\n" + 
        			"<body>\n" + 
        			"  <nav class=\"navbar navbar-expand-md navbar-light\">\n" + 
        			"    <div class=\"container\"> <a class=\"navbar-brand text-primary\" href=\"#\">\n" + 
        			"        <i class=\"fa d-inline fa-lg fa-stop-circle\"></i>\n" + 
        			"        <b class=\"\"> BRAND</b>\n" + 
        			"      </a> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar4\">\n" + 
        			"        <span class=\"navbar-toggler-icon\"></span>\n" + 
        			"      </button>\n" + 
        			"      <div class=\"collapse navbar-collapse\" id=\"navbar4\">\n" + 
        			"        <ul class=\"navbar-nav ml-auto\">\n" + 
        			"          <li class=\"nav-item\" > <a class=\"nav-link\" href=\"index.html\">Features</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Pricing</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">About</a> </li>\n" + 
        			"          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">FAQ</a> </li>\n" + 
        			"        </ul> <a class=\"btn navbar-btn ml-md-2 btn-light\">Contact us</a>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </nav>\n" + 
        			"  <div class=\"py-5\">\n" + 
        			"    <div class=\"container\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"col-md-12\">\n" + 
        			"          <h1 class=\"display-1\">Store Page<br></h1>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <div class=\"py-5\">\n" + 
        			"    <div class=\"container\">\n" + 
        			"      <div class=\"row\">\n" + 
        			"        <div class=\"col-md-6\" style=\"\">\n" + 
        			"          <div class=\"carousel slide\" data-ride=\"carousel\" id=\"carousel\">\n" + 
        			"            <div class=\"carousel-inner\">\n" + 
        			"              <div class=\"carousel-item active\"> <img class=\"d-block img-fluid w-100\" src=\"tshirt4.jpeg\">\n" + 
        			"                <div class=\"carousel-caption\">\n" + 
        			"                  <h5 class=\"m-0\"></h5>\n" + 
        			"                  <p></p>\n" + 
        			"                </div>\n" + 
        			"              </div>\n" + 
        			"              <div class=\"carousel-item\"> <img class=\"d-block img-fluid w-100\" src=\"tshirt2.jpg\">\n" + 
        			"                <div class=\"carousel-caption\">\n" + 
        			"                  <h5 class=\"m-0\"></h5>\n" + 
        			"                  <p></p>\n" + 
        			"                </div>\n" + 
        			"              </div>\n" + 
        			"              <div class=\"carousel-item\"> <img class=\"d-block img-fluid w-100\" src=\"tshirt3.jpg\">\n" + 
        			"                <div class=\"carousel-caption\">\n" + 
        			"                  <h5 class=\"m-0\"></h5>\n" + 
        			"                  <p></p>\n" + 
        			"                </div>\n" + 
        			"              </div>\n" + 
        			"            </div> <a class=\"carousel-control-prev\" href=\"#carousel\" role=\"button\" data-slide=\"prev\"> <span class=\"carousel-control-prev-icon bg-success\"></span> <span class=\"sr-only\">Previous</span> </a> <a class=\"carousel-control-next\" href=\"#carousel\" role=\"button\" data-slide=\"next\"> <span class=\"carousel-control-next-icon bg-success\"></span> <span class=\"sr-only\">Next</span> </a>\n" + 
        			"          </div>\n" + 
        			"        </div>\n" + 
        			"        <div class=\"col-md-6\">\n" + 
        			"          <h1 class=\"\">CornDogMusic now has merch!</h1>\n" + 
        			"          <div class=\"row\">\n" + 
        			"            <div class=\"col-md-12\">\n" + 
        			"              <h3 class=\"\">That's right. Your favourite emotion base music website now allows you to flaunt your musical prowess with pride.&nbsp;<br></h3>\n" + 
        			"            </div>\n" + 
        			"          </div>\n" + 
        			"          <div class=\"row\">\n" + 
        			"            <div class=\"col-md-12\">\n" + 
        			"              <h3 class=\"\">So why not support as and look damn good while doing it!</h3>\n" + 
        			"            </div>\n" + 
        			"          </div>\n" + 
        			"        </div>\n" + 
        			"      </div>\n" + 
        			"    </div>\n" + 
        			"  </div>\n" + 
        			"  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" + 
        			"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\" integrity=\"sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut\" crossorigin=\"anonymous\" style=\"\"></script>\n" + 
        			"  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\" integrity=\"sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k\" crossorigin=\"anonymous\" style=\"\"></script>\n" + 
        			"  <pingendo onclick=\"window.open('https://pingendo.com/', '_blank')\" style=\"cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white\">Made with Pingendo Free&nbsp;&nbsp;<img src=\"https://pingendo.com/site-assets/Pingendo_logo_big.png\" class=\"d-block\" alt=\"Pingendo logo\" height=\"16\"></pingendo>\n" + 
        			"</body>\n" + 
        			"\n" + 
        			"</html>";
        	
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

        	return true;
        }
        return false;
	}

}
