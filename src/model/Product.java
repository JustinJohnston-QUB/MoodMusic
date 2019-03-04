package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String uniqueid;
	public String filePathToImage;
	public String price;
	public String title;
	public String paypalBtn;
	public String description;
	public ArrayList<Integer> reviews = new ArrayList<Integer>();
	
	public double avgReview() {
		if(this.reviews.size() == 0) {
			return 0;
		}
		double total = 0;
		for (Integer integer : this.reviews) {
			total += integer;
		}
		
		Double avg = truncAvg(total/this.reviews.size());
		return avg;
		
	}
	//Used because high precision is not needed when in the context of reviews
	public static double truncAvg(double value) {
	    double scale = Math.pow(10, 1);
	    return Math.round(value * scale) / scale;
	}

}
