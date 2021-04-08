/**
 * 
 */
package cmet.ac.model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author Luke_
 *
 */
public class KnnImage {
	
	int 				k;
	List<CIFARImage> 	data;
	BufferedImage		testImage;
	
	List<TrainImage>	distance_lbl_array;
	List<TrainImage>	klist;
	List<Integer>		lblList;

	String 				result;
	double				confidence;
	
	
	/**
	 * @param k
	 * @param data
	 * @param testImage
	 */
	public KnnImage(int k, List<CIFARImage> data, BufferedImage testImage) {
		super();
		this.k = k;
		this.data = data;
		this.testImage = testImage;
		
		this.distance_lbl_array = new ArrayList<TrainImage>();
		this.klist = new ArrayList<TrainImage>();
		this.lblList = new ArrayList<Integer>();
	}
	
	
	public KnnImage() {
		
	}

	public void imageClassification() throws Exception {
		
		this.data.forEach(item -> {
			
			BufferedImage testImage = this.testImage;
			BufferedImage trainImage = item.getBuf_image();
			int trainImageLbl = item.getLabel();
			
			if((testImage.getWidth() != trainImage.getWidth() || (testImage.getHeight() != trainImage.getHeight()))) {
				throw new Error("The two images have different dimensions");
			}

			double pixel_error_sum = 0;
			
			for(int row = 0; row < testImage.getHeight(); row++) {
				for(int col = 0; col < testImage.getWidth(); col++) {
					
					int testImagePixel = testImage.getRGB(col, row) & 0xFF;
					int trainImagePixel = trainImage.getRGB(col, row) & 0xFF;
					
					pixel_error_sum += ((testImagePixel - trainImagePixel) * (testImagePixel - trainImagePixel));
				}
			}
			
			double distance = Math.sqrt(pixel_error_sum);
			
			distance_lbl_array.add(new TrainImage(distance, trainImageLbl));
			
		});
		
		// print array of distances
		//this.distance_lbl_array.forEach(item -> System.out.println("Label: " + item.getLbl() + " Distance: " + item.getDistance()));
		
		// Sorting array by distance
		Collections.sort(this.distance_lbl_array, new Comparator<TrainImage>() {

			@Override
			public int compare(TrainImage o1, TrainImage o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.getDistance(), o2.getDistance());
			}
			
		});
		
		// print out sorted array of distances
		this.distance_lbl_array.forEach(item -> System.out.println("Label: " + item.getLbl() + " Distance: " + item.getDistance()));
		System.out.println("\n");
		
		// Get the closest k neighbours to the test image
		this.klist = this.distance_lbl_array.subList(0, this.k);
		
		// print out 0 - k nearest neighbours list
		this.klist.forEach(item -> System.out.println("Label: " + item.getLbl() + " Distance: " + item.getDistance()));
		
		// Array List to hold labels
		//this.lblList = new ArrayList<Integer>();

		// Get the label of each k closest neighbours and add to array of labels
		for(int i = 0; i < klist.size(); i++) {
			int lbl = klist.get(i).getLbl();
			lblList.add(lbl);
			System.out.print(lblList.get(i) + "\n");
		}
		
		
		
		// Find the most common label in k closest neighbours 
		int count = 0;
		int element = 0;
		
		for(int i = 0; i <lblList.size(); i++) {
			
			int tempElement = lblList.get(i);
			int tempCount = 0;
			
			for(int p = 0; p <lblList.size(); p++) {
				
				if(lblList.get(p)==tempElement) {
					tempCount++;
				}
				
				if(tempCount>count) {
					element = tempElement;
					count = tempCount;
				}
			}
		}
		
		// store the most common label from k closest neighbours
		this.result = Integer.toString(element);
		System.out.println("Classification: " + result);
		
		// divides the count for the most common label from k closest neighbours by the number of k closest neighbours
		this.confidence = (count/klist.size()) * 100;
		System.out.println("Confidence: " + confidence);
		
		System.out.println("");
	}


	/**
	 * @return the k
	 */
	public int getK() {
		return k;
	}

	/**
	 * @param k the k to set
	 */
	public void setK(int k) {
		this.k = k;
	}

	/**
	 * @return the data
	 */
	public List<CIFARImage> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<CIFARImage> data) {
		this.data = data;
	}

	/**
	 * @return the testImage
	 */
	public BufferedImage getTestImage() {
		return testImage;
	}

	/**
	 * @param testImage the testImage to set
	 */
	public void setTestImage(BufferedImage testImage) {
		this.testImage = testImage;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the confidence
	 */
	public double getConfidence() {
		return confidence;
	}

	/**
	 * @param confidence the confidence to set
	 */
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	
	
}
