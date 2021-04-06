/**
 * 
 */
package cmet.ac.model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTextField;


/**
 * @author Luke_
 *
 */
public class KnnImage {
	
	int 				k;
	List<CIFARImage> 	data;
	BufferedImage		testImage;
	
	List<TrainImage>	distance_lbl_array;

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
	}
	
	public void calculateDistance() throws Exception {
		
		for(int i = 0;  i < data.size(); i++) {
			
			BufferedImage testImage = this.testImage;
			
			BufferedImage trainImage = this.data.get(i).getBuf_image();
			int trainImageLbl = this.data.get(i).getLabel();
			
			if((testImage.getWidth() != trainImage.getWidth()) || (testImage.getHeight() != trainImage.getHeight())) {
				throw new Exception("The two images have different dimensions");
			}
			
			double pixel_error_sum = 0;
			
			for(int row = 0; row < testImage.getHeight(); row++) {
				for(int col = 0; col < testImage.getWidth(); col++) {
					
					int testImagePixel = testImage.getRGB(col, row);
					int trainImagePixel = trainImage.getRGB(col, row);
					
					pixel_error_sum += ((testImagePixel - trainImagePixel) * (testImagePixel - trainImagePixel));

				}
			}
			double distance = Math.sqrt(pixel_error_sum);
			
			TrainImage distance_lbl_image = new TrainImage(distance, trainImageLbl);
			
			distance_lbl_array.add(distance_lbl_image);
		}
	}

	public void classify() {
		
		// Sorting array by distance
		Collections.sort(this.distance_lbl_array, new Comparator<TrainImage>() {

			@Override
			public int compare(TrainImage o1, TrainImage o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.getDistance(), o2.getDistance());
			}
			
		});
		
		// print out sorted array of distances
		this.distance_lbl_array.forEach(item -> System.out.println(item + " distance; " + item.getDistance()));
		
		// Get the closest k neighbours to the test image
		List<TrainImage> klist = this.distance_lbl_array.subList(0, this.k);
		
		// Array List to hold labels
		ArrayList<Integer> lblList = new ArrayList<Integer>();
		
		// Get the label of each k closest neighbours and add to array of labels
		for(int i = 0; i < klist.size(); i++) {
			int lbl = klist.get(i).getLbl();
			lblList.add(lbl);
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
		result = Integer.toString(element);
		
		// divides the count for the most common label from k closest neighbours by the number of k closest neighbours
		confidence = (count/klist.size()) * 100;
		
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
