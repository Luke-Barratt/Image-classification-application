/**
 * 
 */
package cmet.ac.model;

import java.awt.image.BufferedImage;
import java.util.List;

import cmet.ac.fileio.CIFARReader;
import cmet.ac.fileio.IFileReader;
import cmet.ac.fileio.TestImageReader;

/**
 * @author Luke_
 *
 */
public class Model {
	
	List<CIFARImage> 	cifarimage_list;
	IFileReader 		imagereader;
	KnnImage			knnImage;
	
	TestImageReader		testImageReader;
	
	BufferedImage		testImage;
	BufferedImage 		grayScaleImg;
	
	public Model() {
		imagereader = new CIFARReader();
		testImageReader = new TestImageReader();
	}
	
	public BufferedImage convertToGrayscale(BufferedImage img) {
		
		this.grayScaleImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		int[] source = img.getRGB(0, 0, width, height, null, 0, width);
		int[] destination = new int[source.length];
		
		for(int y = 0; y < img.getHeight(); y++) {
			for(int x = 0; x < img.getWidth(); x++) {
				
				int rgbvalue = source[(y) * width + (x)];
				
				int alpha = (rgbvalue >> 24) & 0xff;
				int red = (rgbvalue >> 16) & 0xff;
				int green = (rgbvalue >> 8) & 0xff;
				int blue = (rgbvalue) & 0xff;
				
				int grayscale = (int) ((0.3 * red) + (0.59 * green) + (0.11 * blue));
				
				int new_pixel_value = 0xFF000000 | ( grayscale << 16 ) |
						(grayscale << 8 ) |
						(grayscale);
				
				destination[(y)* width + (x)] = new_pixel_value;
			}
		}
		this.grayScaleImg.setRGB(0, 0, width, height, destination, 0, width);
		
		return this.grayScaleImg;
	}
	

	/**
	 * @return the cifarimage_list
	 */
	public List<CIFARImage> getCifarimage_list() {
		return cifarimage_list;
	}

	/**
	 * @param cifarimage_list the cifarimage_list to set
	 */
	public void setCifarimage_list(List<CIFARImage> cifarimage_list) {
		this.cifarimage_list = cifarimage_list;
	}

	/**
	 * @return the imagereader
	 */
	public IFileReader getCifarreader() {
		return imagereader;
	}

	/**
	 * @param imagereader the imagereader to set
	 */
	public void setImagereader(IFileReader imagereader) {
		this.imagereader = imagereader;
	}


	/**
	 * @return the testImageReader
	 */
	public TestImageReader getTestImageReader() {
		return testImageReader;
	}


	/**
	 * @param testImageReader the testImageReader to set
	 */
	public void setTestImageReader(TestImageReader testImageReader) {
		this.testImageReader = testImageReader;
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
	 * @return the knnImage
	 */
	public KnnImage getKnnImage() {
		return knnImage;
	}

	/**
	 * @param knnImage the knnImage to set
	 */
	public void setKnnImage(KnnImage knnImage) {
		this.knnImage = knnImage;
	}
	
	
	
}
