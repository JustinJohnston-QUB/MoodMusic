package views;

import org.h2.mvstore.MVMap;

import model.Product;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class AddProduct extends DynamicWebPage
{
	public AddProduct(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess) {

		if(toProcess.path.equalsIgnoreCase("addprodpage")) {

			String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\" dir=\"ltr\">\r\n" + 
					"  <head>\r\n" + 
					"    <meta charset=\"utf-8\">\r\n" + 
					"    <title>Adding Shirt</title>\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n" + 
					"    <form action=\"Product\" method=\"GET\">\r\n" + 
					"      <p>Product Title</p>\r\n" + 
					"      <input type=\"text\" name=\"ShirtTitle\" value=\"\">\r\n" + 
					"      <p>File Path To Image</p>\r\n" + 
					"      <input type=\"text\" name=\"filePathToImage\" value=\"\">\r\n" + 
					"      <p>Price</p>\r\n" + 
					"      <input type=\"text\" name=\"price\" value=\"\">\r\n" + 
					"      <p>Paypal Button Link</p>\r\n" + 
					"      <input type=\"text\" name=\"paypalBtn\" value=\"\">\r\n" + 
					"      <input type=\"submit\" value=\"Submit\">\r\n" + 
					"    </form>\r\n" + 
					"  </body>\r\n" + 
					"</html>\r\n" + 
					"";

			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

			return true;
		}
		else
			if(toProcess.path.equalsIgnoreCase("productprocess")) {

				Product iTshirt = new Product();
				iTshirt.uniqueid = "shirt_"+System.currentTimeMillis();
				iTshirt.title = toProcess.params.get("ProdTitle");
				iTshirt.price = toProcess.params.get("price");
				iTshirt.paypalBtn = toProcess.params.get("paypalBtn");
				iTshirt.filePathToImage = toProcess.params.get("filePathToImage");

				MVMap<String, Product> products = db.s.openMap("products");
				products.put(iTshirt.uniqueid, iTshirt);

				String stringToSendToWebBrowser = "“<html><body><p>Object added</p><a\r\n" + 
						"href=\\”index.html\\”>Home</a></body></html>";

				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

				return true;
			}

		// TODO Auto-generated method stub
		return false;
	}

}
