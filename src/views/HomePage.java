package views;

import java.util.ArrayList;
import java.util.Random;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class HomePage extends DynamicWebPage
{
	public HomePage(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
        if(toProcess.path.equalsIgnoreCase("homepage"))
        {
          	ArrayList<String> pageimages = new ArrayList<String>();
        	pageimages.add("images/homepage/1.gif");
        	pageimages.add("images/homepage/2.gif");
        	pageimages.add("images/homepage/3.gif");
        	pageimages.add("images/homepage/4.gif");
        	pageimages.add("images/homepage/5.gif");
        	pageimages.add("images/homepage/6.gif");//( max - min )) + min 
        	Random rn = new Random();
        	int randomimage = rn.nextInt(pageimages.size());
        	String stringToSendToWebBrowser = PageElements.header()+PageElements.Navbar()+PageElements.Search()+
        			"    <div class=\"row\">\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6\"> <!Right Hand Side Panel-->\r\n" + 
        			"<img class=\"materialboxed\" width=\"100%\" src=\""+pageimages.get(randomimage)+"\">"+
        			"   </div>\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6 orange\"> <!-- Left Hand Panel -->\r\n" + 
        			"  <div>\r\n" + 
        			"    <h1 class=\"center-align orange white-text\">Welcome</h1>\r\n" + 
        			"  </div>\r\n" + 
        			"   <div>\r\n" + 
        			"    <p class=\"orange white-text\">Created and designed by Google, Material Design is a design language that combines the classic principles of successful design along with innovation and technology. Google's goal is to develop a system of design that allows for a unified user experience across all their products on any platform.</p>\r\n" + 
        			"  </div>\r\n" + 
        			" "+
        			"  <div class=\"carousel carousel-slider center \">\r\n" + 
        			"    <div class=\"carousel-item orange white-text\" href=\"#one!\">\r\n" + 
        			"      <h2>First Panel</h2>\r\n" + 
        			"      <p class=\"white-text\">This is your first panel</p>\r\n" + 
        			"    </div>\r\n" + 
        			"    <div class=\"carousel-item orange white-text\" href=\"#two!\">\r\n" + 
        			"      <h2>Second Panel</h2>\r\n" + 
        			"      <p class=\"white-text\">This is your second panel</p>\r\n" + 
        			"    </div>\r\n" + 
        			"    <div class=\"carousel-item orange white-text\" href=\"#three!\">\r\n" + 
        			"      <h2>Third Panel</h2>\r\n" + 
        			"      <p class=\"white-text\">This is your third panel</p>\r\n" + 
        			"    </div>\r\n" + 
        			"    <div class=\"carousel-item orange white-text\" href=\"#four!\">\r\n" + 
        			"      <h2>Fourth Panel</h2>\r\n" + 
        			"      <p class=\"white-text\">This is your fourth panel</p>\r\n" + 
        			"    </div>\r\n" + 
        			"  </div>\r\n" + 
        			"        "+
        			"      </div>\r\n" + 
        			"\r\n" + 
        			"    </div>"+
        			"        <!-- Footer -->\r\n" + PageElements.scripts()+ PageElements.footer2()+
        	
        			"  <!-- Footer -->\r\n" + 
        			"\r\n" + 
        			"        \r\n" + 
        			"    </head>\r\n" + 
        			"</html>";
        	
        	
        	toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

        	return true;
        }
        return false;
	}

}
