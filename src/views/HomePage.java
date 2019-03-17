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
			if(moodkeys.size() > 0) {
				int random = rn.nextInt(moodkeys.size());
				String randommoodid = moodkeys.get(random);
				imood = moods.get(randommoodid);
			}else {
				Mood imood0 = new Mood();
				imood0.moodname = "Ecstatic";	
				imood0.shortmooddescription = "Get Happy!";
				imood0.mooddescription ="If you're blissful, you're happy and at peace.<br> You can never have too many blissful moments. <br>If you're feeling blissful, then you're lucky.<br> This is a word for total contentment and major happiness, along with a kind of Zen-like peace.";	
				imood0.moodimage = "images/moodimages/happy.jpg";
				moods.put(imood0.moodname, imood0);
				Mood imood1 = new Mood();
				imood1.moodname = "Rage";	
				imood1.shortmooddescription = "Get Even,Get Angry";
				imood1.mooddescription ="If you're mad about something and you're not going to take it anymore, you're feeling anger, a strong emotion you experience when you think someone has done you wrong.<br> If you want to scream and kick, you're feeling anger.";	
				imood1.moodimage = "images/moodimages/angry.jpg";
				moods.put(imood1.moodname, imood1);
				Mood imood2 = new Mood();
				imood2.moodname = "Melancholy";	
				imood2.shortmooddescription = "Cry it Out";
				imood2.mooddescription ="When you're sad, you feel unhappy. ... You might use the adjective sad informally to describe something that's pathetic or that you feel scornful or disdainful about.<br>For example, you might comment on your friend's elaborate homemade hat by saying, \"That hat is just sad,\" though it wouldn't be very nice of you to say it.";	
				imood2.moodimage = "images/moodimages/Melancholy.jpg";
				moods.put(imood2.moodname, imood2);
		 		Mood imood4= new Mood();
				imood4.moodname = "Romance";	
				imood4.shortmooddescription = "Love is in the Air";
				imood4.mooddescription ="Love encompasses a range of strong and positive emotional and mental states, from the most sublime virtue or good habit, the deepest interpersonal affection and to the simplest pleasure.<br>Love is unconditional. The word unconditional means that there are no expectations or limitations set. To love unconditionally is a difficult thing, and most humans aren't good at that.<br>But true love really does love without trying to change the other person";	
				imood4.moodimage = "images/moodimages/Romantic.jpg";
				moods.put(imood4.moodname, imood4);
				db.commit();
			}
			//Random Artist
			if(artistkeys.size() > 0) {
				int random = rn.nextInt(artistkeys.size());
				String randomartistid = artistkeys.get(random);
				iartist =artists.get(randomartistid);
			}else {
				iartist.artistName = "No Artists";
				iartist.uniqueID = "";
				iartist.artistImage = "/images/homepage/addartist.gif";
			}
			
			//Random Song
			if(songkeys.size() > 0) {
			int random = rn.nextInt(songkeys.size());
			String randomsongid = songkeys.get(random);
			isong =songs.get(randomsongid);
			}else {
				isong.songImage = "/images/homepage/addsong.gif";
				isong.songtitle = "songs missing";
				isong.uniqueID = "";
			}

			//Top product
			if(productkeys.size() > 0) {
				double topRev = -1.0;
				ArrayList<Product> prodArr = new ArrayList<Product>(); //array to hold products
				for (int i = 0; i < productkeys.size(); i++) { //loop to add to array
					String productUniqueID = productkeys.get(i);
					prodArr.add(products.get(productUniqueID));
				}
				for (Product currProd : prodArr) { //for each product, checks largest avg review
					if(currProd.avgReview() > topRev) {
						iproduct = currProd;
						topRev = currProd.avgReview();
					}
				}
			}
			else {
				iproduct.title = "There are no products";
				iproduct.filePathToImage = "images/bag.JPG";
				
			}
			
        	ArrayList<String> pageimages = new ArrayList<String>();
        	pageimages.add("images/homepage/1.gif");
        	pageimages.add("images/homepage/2.gif");
        	pageimages.add("images/homepage/3.gif");
        	pageimages.add("images/homepage/4.gif");
        	pageimages.add("images/homepage/5.gif");
        	pageimages.add("images/homepage/6.gif");//( max - min )) + min 
        	int randomimage = rn.nextInt(pageimages.size());
        	String stringToSendToWebBrowser = PageElements.header()+"<body>\n"+PageElements.Navbar()+PageElements.Search()+
        			"    <div class=\"row \">\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6 \"> <!Right Hand Side Panel-->\r\n" + 
        			"<img class=\"materialboxed\" width=\"100%\" src=\""+pageimages.get(randomimage)+"\">"+
        			"   </div>\r\n" + 
        			"\r\n" + 
        			"      <div class=\"col s12 m6 l6  \"> <!-- Left Hand Panel -->\r\n" + 
        			"  <div>\r\n" + 
        			"    <h1 class=\"orange white-text center-align \">Our Picks</h1>\r\n" + 
        			"  </div>\r\n" + 
        			"   <div>\r\n" + 
        			"    <h3 class=\"flow-text \">We picked out some songs and moods you might like, click on the tabs below to try them out.<br> Support the site by buying some of the fresh apparel from the store.</h3>\r\n" + 
        			"  </div>\r\n" + 
        			" <ul id=\"tabs\" class=\"tabs\">\r\n" + 
        			"    <li class=\"tab col s3\"><a  class=\"active\" href=\"#test-swipe-1\">Mood</a></li>\r\n" + 
        			"    <li class=\"tab col s3\"><a href=\"#test-swipe-2\">Artist</a></li>\r\n" + 
        			"    <li class=\"tab col s3\"><a href=\"#test-swipe-3\">Song</a></li>\r\n" + 
        			"    <li class=\"tab col s3\"><a href=\"#test-swipe-4\">Merch</a></li>\r\n" + 
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
        			"    <p class=\"flow-text\"><br>Voted fans favourite product!</p>\r\n" + 
        			"  </div>\r\n" + 
        			" </div>\r\n" +
        			//end card 4
        			"      </div>\r\n" + 
        			"\r\n" + 
        			"    </div>"+
        			"        <!-- Footer -->\r\n" + PageElements.scripts()+ PageElements.footer()+
        	
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
