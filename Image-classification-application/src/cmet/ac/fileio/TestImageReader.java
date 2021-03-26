/**
 * 
 */
package cmet.ac.fileio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cmet.ac.model.TestImage;

/**
 * @author Luke_
 *
 */
public class TestImageReader {
	
	String imagename;
	BufferedImage testImage;
	

	public void readTestImage() throws IOException {
		// TODO Auto-generated method stub
		
		String image_filename = imagename;
		
		//code to read test image
		try {
			testImage = ImageIO.read(new File(image_filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	 * @return the imagename
	 */
	public String getImagename() {
		return imagename;
	}


	/**
	 * @param imagename the imagename to set
	 */
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	
}
