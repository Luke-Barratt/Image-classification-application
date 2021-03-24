/**
 * 
 */
package cmet.ac.fileio;

import java.io.IOException;

/**
 * @author Luke_
 *
 */
public class TestImageReader implements IImageReader {
	
	String imagename;

	@Override
	public void readTestImage() throws IOException {
		// TODO Auto-generated method stub
		
		String image_filename = imagename;
		
		//code to read test image
		
		
		
		
		
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setImagename(String imagename) {
		// TODO Auto-generated method stub
		this.imagename = imagename;
		
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return this.imagename;
	}

	
	
	
	
}
