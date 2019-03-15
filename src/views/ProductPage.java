package views;

import java.util.ArrayList;
import java.util.List;

import org.h2.mvstore.MVMap;

import model.Product;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class ProductPage extends DynamicWebPage
{
	public ProductPage(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		
		MVMap<String, Product> products = db.s.openMap("products");
		List<String> productKeys = products.keyList();
		
		
		if (productKeys.size() == 0) {	
			Product emptProd = new Product();
			emptProd.title = "There were no products!";
		}
		if(toProcess.path.equalsIgnoreCase("productpage")) {
			String productID = toProcess.params.get("prodID").toLowerCase();
			Product product = products.get(productID);

			String stringToSendToWebBrowser = PageElements.header();
			stringToSendToWebBrowser += PageElements.Navbar();
			
			stringToSendToWebBrowser +=
					"  <!--Main body of content-->\r\n" + 
					"  <div class=\"container\">\r\n" + 
					"\r\n" + 
					"  <div class=\"grid-container\">\r\n" + 
					"    <div class=\"item1\">\r\n" + 
					"      <h3>"+product.title+"</h3>\r\n"+
					"        <h6>Average Review: "+product.avgReview()+"/5 ("+product.reviews.size()+" customers)</h6>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item2\">\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item3\"></div>\r\n" + 
					"    <div class=\"item4\">\r\n" + 
					"      <image class=\"left\" src=\""+product.filePathToImage+"\" alt=\"Picture of tshirt\" width=200px></image>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item5\">\r\n";
			
			
			stringToSendToWebBrowser +=
					"      <p class = \"productDesc\">"+product.description+"</p>\r\n" + 
					"    </div>\r\n"
					+ "        <div class=\"container\">\r\n" + 
					"" + 
					"<div class=\"item6\">\r\n" + 
							"      <h5>Review Section</h5>\r\n" + 
							"      <p>How would you rate this T-Shirt out of 5?</p>\r\n" +
							"<form action=\"submitprocess\">\r\n" + 
							"          <p class=\"range-field\">\r\n" + 
							"            <input type=\"range\" name=\"tshirtReview\" min=\"0\" max=\"5\" />\r\n" + 
							"          </p>\r\n" +
							"          <input class = \"hiddendiv\" type=\"text\" name=\"prodID\" value=\""+productID+"\">\r\n" +
							"          <button class=\"btn waves-effect waves-light\" type=\"submit\">Submit\r\n" + 
							"            <i class=\"material-icons right\">send</i>\r\n" + 
							"          </button>\r\n" + 
							"        </form>\r\n" + 
							"    </div>\r\n" + 
							"    </div>\r\n" + 
					"    <div class=\"item7\">\r\n"
					+ "<div class=\"paypalBtn\">\r\n" + 
					"            <form target=\"paypal\" action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\">\r\n" + 
					"              <input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\">\r\n" + 
					"              <input type=\"hidden\" name=\"hosted_button_id\" value=\""+product.paypalBtn+"\">\r\n" + 
					"              <input type=\"image\" src=\"https://www.paypalobjects.com/webstatic/en_US/i/buttons/checkout-logo-medium.png\" border=\"0\" name=\"submit\" alt=\"PayPal – The safer, easier way to pay online!\">\r\n" + 
					"              <img alt=\"\" border=\"0\" src=\"https://www.paypalobjects.com/en_GB/i/scr/pixel.gif\" width=\"1\" height=\"1\">\r\n" + 
					"            </form>\r\n" + 
					"          </div>" + 
					"    </div>\r\n" + 
					"    <div class=\"item8\">\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item9\"></div>\r\n" + 
					"  </div>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"  <!--Footer-->\r\n";
			
			//Footer
			stringToSendToWebBrowser += PageElements.footer();
					
			stringToSendToWebBrowser += PageElements.scripts();
			stringToSendToWebBrowser +=
					
					"</body>\r\n" + 
					"\r\n" + 
					"</html>\r\n" + 
					"";

			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;

		}
		else if(toProcess.path.equalsIgnoreCase("submitprocess")) {
			
			String productID = toProcess.params.get("prodID").toLowerCase();
			Product product = products.get(productID);
			
			int revScore = Integer.parseInt(toProcess.params.get("tshirtReview"));
			ArrayList<Integer> revArr = product.reviews;
			product.reviews.add(revScore);
			products.put(productID, product);

			db.commit();
			String stringToSendToWebBrowser = PageElements.header();
			stringToSendToWebBrowser += PageElements.Navbar();
			stringToSendToWebBrowser +=
					
					"\r\n" + 
					"  <!--Main body of content-->\r\n" + 
					"  <div class=\"container\">\r\n" + 
					"\r\n" + 
					"    <div class=\"grid-container\">\r\n" + 
					"      <div class=\"item1\">\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"item2\">\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"item3\">\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"item4\">\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"item5\">\r\n" + 
					"        <h1 class=\"center\">Thank You!</h1>\r\n" + 
					"        <h5 class=\"center\">Your feedback is valued</h5>\r\n" + 
					"\r\n" + 
					"      </div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"      <div class=\"item6\">\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"item7\">\r\n" + 
					"      </div>\r\n";
					stringToSendToWebBrowser +=
					"            <a class=\"waves-effect waves-light btn\" href=\"productpage?prodID="+productID+"\">Back</a>\r\n"; 
					stringToSendToWebBrowser +=
					"      <div class=\"item8\">\r\n" + 
					"      </div>\r\n" + 
					"      <div class=\"item9\">\r\n" + 
					"      </div>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n";
					stringToSendToWebBrowser += PageElements.footer();
					stringToSendToWebBrowser += PageElements.scripts();
					stringToSendToWebBrowser +=
					"</body>\r\n" + 
					"\r\n" + 
					"</html>\r\n" + 
					"";

			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

			return true;
		}
		return false;
	}


}
