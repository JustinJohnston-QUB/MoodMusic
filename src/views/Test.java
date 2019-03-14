package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.h2.mvstore.MVMap;

import model.Artist;
import model.Mood;
import model.Product;
import model.Song;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class Test extends DynamicWebPage
{
	public Test(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
        if(toProcess.path.equalsIgnoreCase("aboutus.html"))
        {
        	String stringToSendToWebBrowser = "<!DOCTYPE html>\n" + 
					PageElements.header()+ "<body>\n"  + PageElements.Navbar()+ PageElements.Search()+
					"    <div class=\"row\">\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6\"> <!Right Hand Side Panel-->\r\n" + 
        			"<img class=\"materialboxed\" width=\"100%\" src=\"images/homepage/addartist.gif\">"+
        			"   </div>\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6\"> <!-- Left Hand Panel -->\r\n" + 
        			"			<h2>Add Artist</h2>\n" + 
					"			<form action=\"../addartist.html\" role=\"form\" method = \"POST\" id = \"addartist\" enctype=\"multipart/form-data\">\n " + 
					" 			 Artist Name " + 
					" 			 <input type=\"text\" name=\"artistname\" placeholder=\"Name\" required>\n" + 
					" 			 <br>\n" + 
					"  			Description<input type=\"text\" name=\"artistdescription\" placeholder=\"description\"required>\n" + 
					" 			 <br><br>Upload Artist Image\n" + 
					"			<div class=\"form-group\">\n"+
					"                    <div class=\"col s12\">\n"+
					"                      <label for=\"artistimage\" class=\"control-label\">Upload an image of the artist</label>\n"+
					"                    </div>\n"+
					"                    <div class=\"col s10\">\n"+
					"                      <input type=\"file\" class=\"form-control\" id=\"artistimage\" name=\"artistimage\"required\n"+
					"                      </div>\n"+
					"      </div>\n"+
					"    </div>\n"+
					"  	<br><br><br><br>"+

					"  			<input class=\"btn waves-effect waves-light deep-orange \" type=\"submit\" value=\"Submit\">\n" + 
					"			</form> \n" + 
        			"    </div>"+
        			"    </div>"+
        			"        <!-- Footer -->\r\n" + PageElements.scripts()+ PageElements.footer2()+

        			"\r\n" + 
					"\n" + 
							"</body>\n" + 
							"</html> ";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;

        }
        return false;
	}

}
