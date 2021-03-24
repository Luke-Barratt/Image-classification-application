/**
 * 
 */
package cmet.ac.fileio;

import java.io.IOException;

/**
 * @author Luke_
 *
 */
public interface IImageReader {
	public void readTestImage() throws IOException;
	public Object getData();	// returns the data read from the image.
	public void setImagename(String imagename);
	public String getImage();
}
