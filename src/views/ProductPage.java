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

			String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0\" />\r\n" + 
					"  <title>Product</title>\r\n" + 
					"\r\n" + 
					"  <!-- CSS  -->\r\n" + 
					"  <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n" + 
					"  <link href=\"../css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\" />\r\n" + 
					"  <link href=\"../css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\" />\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body>\r\n";
			stringToSendToWebBrowser += PageElements.Navbar();
			
			stringToSendToWebBrowser +=
					"  <!--Main body of content-->\r\n" + 
					"  <div class=\"container\">\r\n" + 
					"\r\n" + 
					"  <div class=\"grid-container\">\r\n" + 
					"    <div class=\"item1\">\r\n" + 
					"      <h3>"+product.title+"</h3>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item2\">\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item3\">3</div>\r\n" + 
					"    <div class=\"item4\">\r\n" + 
					"      <image class=\"left\" src=\""+product.filePathToImage+"\" alt=\"Picture of tshirt\" width=200px></image>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item5\">\r\n";
			
			
			stringToSendToWebBrowser +=
					"      <p class = \"productDesc\">"+product.description+"</p>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item6\">\r\n" + 
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
					"    <div class=\"item7\">\r\n" + 
					"        <h6>Average Review: "+product.avgReview()+"/5</h6>\r\n" + 
					"<p>Left by: "+product.reviews.size()+" customers</p>\r\n" +
					"    </div>\r\n" + 
					"    <div class=\"item8\">\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"item9\">9</div>\r\n" + 
					"  </div>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"  <!--Footer-->\r\n";
			
			//Footer
			stringToSendToWebBrowser += PageElements.footer();
					
			stringToSendToWebBrowser +=
					"  <!--  Scripts-->\r\n" + 
					"  <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
					"  <script src=\"../js/materialize.js\"></script>\r\n" + 
					"  <script src=\"../js/init.js\"></script>\r\n" + 
					"  <script>\r\n" + 
					"    $(document).ready(function() {\r\n" + 
					"      $('.dropdown-trigger').dropdown();\r\n" + 
					"\r\n" + 
					"      $('#textarea1').val('New Text');\r\n" + 
					"  M.textareaAutoResize($('#textarea1'));\r\n" + 
					"    });\r\n" + 
					"  </script>\r\n" + 
					"\r\n" + 
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
			String stringToSendToWebBrowser = "<html><body><p>Review Submitted</p><a\r\n" + 
					"href=\"productpage?prodID="+productID+">Home</a></body></html>";

			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

			return true;
		}
		return false;
	}


}
