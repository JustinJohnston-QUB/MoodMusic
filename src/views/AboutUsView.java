package views;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.h2.mvstore.MVMap;

import model.Artist;
import model.Mood;
import model.Subscriber;
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
			String stringToSendToWebBrowser = PageElements.header()+
					"\r\n" + 
					"<body >\r\n" + PageElements.Navbar()+PageElements.Search()+
					"\r\n" + 
					"  <div id=\"index-banner\" class=\"parallax-container\">\r\n" + 
					"    <div class=\"section no-pad-bot\">\r\n" + 
					"      <div class=\"container\">\r\n" + 
					"        <br><br>\r\n" + 
					"        <h1 class=\"header center white-text\"><b>About Us</b></h1>\r\n" + 
					"        <div class=\"row center\">\r\n" + 
					"          <h5 class=\"header col s12 white-text\"><b>A music site with a diffence, find the music that meets your mood in the middle!</b></h5>\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"row center\">\r\n" + 
					"        </div>\r\n" + 
					"        <br><br>\r\n" + 
					"\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"parallax\"><img src=\"images/Background4.JPG\" alt=\"Unsplashed background img 1\"></div>\r\n" + 
					"  </div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"  <div class=\"container\">\r\n" + 
					"    <div class=\"section\">\r\n" + 
					"\r\n" + 
					"      <!--   Icon Section   -->\r\n" + 
					"      <div class=\"row\">\r\n" + 
					"        <h1 class=\"header center \"><b>Meet the Team</b></h1>\r\n" + 
					"        <div class=\"col s12 m4\">\r\n" + 
					"          <div class=\"icon-block center\">\r\n" + 
					"            <img src=\"images/face.jpg\" alt=\"\" class=\"circle responsive-img \">\r\n" + 
					"            <h5 class=\"center\">Johnny Hume</h5>\r\n" + 
					"\r\n" + 
					"            <p class=\"light left-align\">We did most of the heavy lifting for you to provide a default stylings that incorporate our custom components. Additionally, we refined animations and transitions to provide a smoother experience for developers.</p>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"\r\n" + 
					"        <div class=\"col s12 m4\">\r\n" + 
					"          <div class=\"icon-block center\">\r\n" + 
					"            <img src=\"images/face.jpg\" alt=\"\" class=\"circle responsive-img \">\r\n" + 
					"            <h5 class=\"center\">Justin Johnston</h5>\r\n" + 
					"\r\n" + 
					"            <p class=\"light left-align\">By utilizing elements and principles of Material Design, we were able to create a framework that incorporates components and animations that provide more feedback to users. Additionally, a single underlying responsive system across all platforms allow for a more unified user experience.</p>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"\r\n" + 
					"        <div class=\"col s12 m4\">\r\n" + 
					"          <div class=\"icon-block center\">\r\n" + 
					"            <img src=\"images/face.jpg\" alt=\"\" class=\"circle responsive-img\">\r\n" + 
					"            <h5 class=\"center\">Karolis katauskas</h5>\r\n" + 
					"\r\n" + 
					"            <p class=\"light left-align\">We have provided detailed documentation as well as specific code examples to help new users get started. We are also always open to feedback and can answer any questions a user may have about Materialize.</p>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"  <div class=\"parallax-container valign-wrapper\">\r\n" + 
					"    <div class=\"section no-pad-bot\">\r\n" + 
					"      <div class=\"container\">\r\n" + 
					"        <div class=\"row center\">\r\n" + 
					"          <h1 class=\"header col s12 white-text light\">#MOOD</h1>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"parallax\"><img src=\"images/Background2.JPG\" alt=\"Unsplashed background img 2\"></div>\r\n" + 
					"  </div>\r\n" + 
					"\r\n" + 
					"  <div class=\"container\">\r\n" + 
					"    <div class=\"section\">\r\n" + 
					"\r\n" + 
					// Form
					"      <div class=\"row\">\r\n" + 
					"        <div class=\"col s12 center\">\r\n" + 
					"          <h3><i class=\"mdi-content-send brown-text\"></i></h3>\r\n" + 
					"          <h4>Subcribe to our Newsletter</h4>\r\n" + 
					"          <p class=\"left-align light\"> We are glad you like the site, we have more coming and we would love for your to be the first to know about these exciting projects,fill out the form below.e.;</p>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"\r\n"+
					"		<form action=\"../subscribe\" role=\"form\" method = \"GET\" id = \"subscribe\">\n" + 
					"  		Email Address " + 
					"  		<input type=\"email\" name=\"email\" placeholder=\"email\" required>\n" + 
					"  		Name " + 
					"  		<input type=\"text\" name=\"name\" placeholder=\"Enter your Name\" required>\n" + 
					"  		<br>Choose your mood\n" + 
					"		</select>" + 
					"			<div class=\"input-field\"> "+
					"			Mood<select name=\"mood\" class = \"browser-default\" form=\"subscribe\">\n"+
					"			option value=\"\" disabled selected>Choose your option</option>" ;
				
					MVMap<String, Mood> moods= db.s.openMap("Mood");
					List<String> moodkeys = moods.keyList() ;
					Mood imood = new Mood();
							
					for(int i = 0; i < moodkeys.size();i++) {
						String moodUniqueID = moodkeys.get(i);
						imood= moods.get(moodUniqueID);
						stringToSendToWebBrowser += "  <option value=\""+imood.moodname +"\">"+imood.moodname+"</option>\n";
					}

					stringToSendToWebBrowser += "</select>" + 
							"  </div>"+
							"  <br><br>\n" + 
							"  <button class=\"btn waves-effect waves-light Deep-Orange\" type=\"submit\" name=\"action\">subscribe\r\n" + 
							"    <i class=\"material-icons right\">send</i>\r\n" + 
							"  </button>" +
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"\r\n" + 
					//
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"  <div class=\"parallax-container valign-wrapper\">\r\n" + 
					"    <div class=\"section no-pad-bot\">\r\n" + 
					"      <div class=\"container\">\r\n" + 
					"        <div class=\"row center\">\r\n" + 
					"          <h5 class=\"header col s12 light\"></h5>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"parallax\"><img src=\"images/Background3.JPG\" alt=\"Unsplashed background img 3\"></div>\r\n" + 
					"  </div>\r\n" + 
					"\r\n" + 
					
					"\r\n" + 
					"\r\n" + 
					PageElements.scripts()+
					"  </body>"+
					PageElements.footer2()+
					"</body>\r\n" + 
					"\r\n" + 
					"</html>";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK,
			WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}else if(toProcess.path.equalsIgnoreCase("subscribe")) {
			Subscriber isubscriber = new Subscriber();
			isubscriber.uniqueid= "sub_"+System.currentTimeMillis();
			isubscriber.emailaddress = toProcess.params.get("email");	
			isubscriber.name = toProcess.params.get("name");	
			isubscriber.mood = toProcess.params.get("mood");
			MVMap<String, Subscriber> subscribers= db.s.openMap("Subscribers");
			subscribers.put(isubscriber.uniqueid, isubscriber);
			db.commit();
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"<body>\n" + 
					"	<h2>thank you "+isubscriber.name+" you are now a subscriber to our newsletter</h2>\n";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser +=
					"</body>\n" + 
							"</html>\n" + 
							"";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}else if(toProcess.path.equalsIgnoreCase("exportsubs")) {
			String filelocation = "httpdocs/subscribers.csv";
			File csvfile = new File(filelocation);
			Subscriber isubscriber = new Subscriber();
			MVMap<String, Subscriber> subscribers= db.s.openMap("Subscribers");
			List<String> subkeys = subscribers.keyList() ;
			try {
				FileWriter fw = new FileWriter(csvfile,false);
				PrintWriter pw = new PrintWriter(fw);
				pw.println("name,email-address,mood");
				for(int i = 0;i < subkeys.size();i++ ) {
					String sub = subkeys.get(i);
					isubscriber = subscribers.get(sub);
					pw.println(isubscriber.name+","+isubscriber.emailaddress+","+isubscriber.mood);
				}
				pw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}

		
			String stringToSendToWebBrowser = PageElements.header() + PageElements.Navbar()+ PageElements.Search()+
					"<body>\n" + 
					"	<h2>a csv file has been exported to the httpdocs folder</h2>\n";
			stringToSendToWebBrowser += PageElements.scripts()+ PageElements.footer2();
			stringToSendToWebBrowser +=
					"</body>\n" + 
							"</html>\n" + 
							"";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
	return false;
	}
}
	
			
	
	
	
	
	

