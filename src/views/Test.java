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
        if(toProcess.path.equalsIgnoreCase("test"))
        {
           	MVMap<String, Product> products= db.s.openMap("products");
        	List<String> productkeys = products.keyList() ;
        	Product iproduct = new Product();
        	MVMap<String, Mood> moods= db.s.openMap("Mood");
			List<String> moodkeys = moods.keyList() ;
			Mood imood = new Mood();
			MVMap<String, Artist> artists= db.s.openMap("Artist");
			List<String> artistkeys = artists.keyList() ;
			Artist iartist = new Artist();
			MVMap<String, Song> songs= db.s.openMap("Song");
			List<String> songkeys = songs.keyList() ;
			Song isong = new Song();
			Random rn = new Random();
			//Random Mood
			int random = rn.nextInt(moodkeys.size());
			String randommoodid = moodkeys.get(random);
			imood = moods.get(randommoodid);
			//Random Artist
			random = rn.nextInt(artistkeys.size());
			String randomartistid = artistkeys.get(random);
			iartist =artists.get(randomartistid);
			//Random Song
			random = rn.nextInt(songkeys.size());
			String randomsongid = songkeys.get(random);
			isong =songs.get(randomsongid);
			//Random Product
			random = rn.nextInt(productkeys.size());
			String randomproductid = productkeys.get(random);
			iproduct =products.get(randomproductid);
			
        	ArrayList<String> pageimages = new ArrayList<String>();
        	pageimages.add("images/homepage/1.gif");
        	pageimages.add("images/homepage/2.gif");
        	pageimages.add("images/homepage/3.gif");
        	pageimages.add("images/homepage/4.gif");
        	pageimages.add("images/homepage/5.gif");
        	pageimages.add("images/homepage/6.gif");//( max - min )) + min 
        	int randomimage = rn.nextInt(pageimages.size());
        	String stringToSendToWebBrowser = PageElements.header()+PageElements.Navbar()+PageElements.Search()+
        			"    <div class=\"row\">\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6\"> <!Right Hand Side Panel-->\r\n" + 
        		    "<h3 class=\"flow-text \"> <br> </h3>\r\n" +
        			"<img class=\"materialboxed\" width=\"100%\" src=\""+pageimages.get(randomimage)+"\">"+
        			"   </div>\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6 \"> <!-- Left Hand Panel -->\r\n" + 
        			"  <div>\r\n" + 
        			"    <h1 class=\"center-align\">Our Picks</h1>\r\n" + 
        			"  </div>\r\n" + 
        			"   <div>\r\n" + 
        			"    <h3 class=\"flow-text \">We picked out some songs and moods you might like, click on the tabs below to try them out.<br> Support the site by buying some of the fresh apparel from the store.</h3>\r\n" + 
        			"  </div>\r\n" + 
        			" <ul id=\"tabs-swipe-demo swipeable\" class=\"tabs\">\r\n" + 
        			"    <li class=\"tab col s3\"><a href=\"#test-swipe-1\">Mood</a></li>\r\n" + 
        			"    <li class=\"tab col s3\"><a class=\"active\" href=\"#test-swipe-2\">Artist</a></li>\r\n" + 
        			"    <li class=\"tab col s3\"><a href=\"#test-swipe-3\">Song</a></li>\r\n" + 
        			"    <li class=\"tab col s3\"><a href=\"#test-swipe-4\">Product</a></li>\r\n" + 
        			"  </ul>\r\n" + 
        			//card 1
        			"  <div id=\"test-swipe-1\" class=\"col s12  black-text center-align\">"+
        			"   <div>\r\n" + 
        			"    <h4 class=\"black-text center-align\">"+imood.moodname+"</h4>\r\n" + 
        			"  </div>\r\n" + 
        			"	<a href = \"moodpage.html?mood="+imood.moodname+"\"><img class=\"circle\" width=\"30%\" src=\""+imood.moodimage+"\"></a>"+
        			"   <div>\r\n" + 
        			"    <p class=\"flow-text\">"+imood.shortmooddescription+"<br>Click the image above to visit this mood!</p>\r\n" + 
        			"  </div>\r\n" + 
        			" </div>\r\n" +
        			//end card 1
        			//card 2
        			"  <div id=\"test-swipe-2\" class=\"col s12 black-text center-align\">"+
        			"   <div>\r\n" + 
        			"    <h4 class=\"black-text center-align\">"+iartist.artistName+"</h4>\r\n" + 
        			"  </div>\r\n" + 
        			"	<a href = \"artistpage.html?artist="+iartist.uniqueID+"\"><img class=\"circle\" width=\"30%\" src=\""+iartist.artistImage+"\"></a>"+
        			"   <div>\r\n" + 
        			"    <p class=\"flow-text\"><br>Click the image above to visit this Artist!</p>\r\n" + 
        			"  </div>\r\n" + 
        			" </div>\r\n" +
        			//end card 2
        			//card 3
        			"  <div id=\"test-swipe-3\" class=\"col s12 black-text center-align\">"+
        			"   <div>\r\n" + 
        			"    <h4 class=\"black-text center-alignt\">"+isong.songtitle+"</h4>\r\n" + 
        			"  </div>\r\n" + 
        			"	<a href = \"songpage?song="+isong.uniqueID+"\"><img class=\"circle\" width=\"30%\" src=\""+isong.songImage+"\"></a>"+
        			"   <div>\r\n" + 
        			"    <p class=\"flow-text\"><br>Click the image above to visit this track!</p>\r\n" + 
        			"  </div>\r\n" + 
        			" </div>\r\n" +
        			//end card 3
        			//card 4
        			"  <div id=\"test-swipe-4\" class=\"col s12 black-text center-align\">"+
        			"   <div>\r\n" + 
        			"    <h4 class=\"black-text center-align\">"+iproduct.title+"</h4>\r\n" + 
        			"  </div>\r\n" + 
        			"	<a href = \"productpage?prodID="+iproduct.uniqueid+"\"><img class=\"circle\" width=\"30%\" src=\""+iproduct.filePathToImage+"\"></a>"+
        			"   <div>\r\n" + 
        			"    <p class=\"flow-text\"><br>why not buy some of  our merch!</p>\r\n" + 
        			"  </div>\r\n" + 
        			" </div>\r\n" +
        			//end card 4
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
