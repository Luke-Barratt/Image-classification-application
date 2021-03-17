/**
 * 
 */
package cmet.ac.fileio;

import java.io.IOException;

/**
 * @author Luke_
 *
 */
public interface IFileReader {
	public void read() throws IOException;
	public Object getData();	// returns the data read from the file.
	public void setFilename(String filename);
	public String getFilename();
}
