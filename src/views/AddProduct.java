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

	public boolean process(WebRequest toProcess)
	{


		if(toProcess.path.equalsIgnoreCase("addproduct"))
		{


			//start of html and imports of materialize cs
			String stringToSendToWebBrowser = "<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\" dir=\"ltr\">\r\n" + 
					"  <head>\r\n" + 
					"    <meta charset=\"utf-8\">\r\n" + 
					"    <title>Adding Product</title>\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n" + 
					"    <form action=\"productprocess\" method=\"GET\">\r\n" + 
					"      <p>Tshirt Title</p>\r\n" + 
					"      <input type=\"text\" name=\"ProdTitle\" value=\"\">\r\n" + 
					"      <p>File Path To Image</p>\r\n" + 
					"      <input type=\"text\" name=\"filePathToImage\" value=\"\">\r\n" + 
					"      <p>Price</p>\r\n" + 
					"      <input type=\"text\" name=\"price\" value=\"\">\r\n"
					+ "      <p>Product Description</p>\r\n" + 
					"      <textarea name=\"description\" rows=\"8\" cols=\"50\"></textarea>" + 
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
		else if(toProcess.path.equalsIgnoreCase("productprocess")) {
			Product currProduct = new Product();
			currProduct.uniqueid = "product_"+System.currentTimeMillis();
			currProduct.title = toProcess.params.get("ProdTitle");
			currProduct.price = toProcess.params.get("price");
			currProduct.paypalBtn = toProcess.params.get("paypalBtn");
			currProduct.filePathToImage = toProcess.params.get("filePathToImage");
			currProduct.description = toProcess.params.get("description");

			MVMap<String, Product> products = db.s.openMap("products");
			products.put(currProduct.uniqueid, currProduct);

			db.commit();
			String stringToSendToWebBrowser = "“<html><body><p>Product added</p><a\r\n" + 
					"href=\\”index.html\\”>Home</a></body></html>";

			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );

			return true;
		}

		return false;
	}
}
