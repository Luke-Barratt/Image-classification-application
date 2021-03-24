/**
 * 
 */
package cmet.ac.model;

import java.util.List;

import cmet.ac.fileio.CIFARReader;
import cmet.ac.fileio.IFileReader;
import cmet.ac.fileio.IImageReader;
import cmet.ac.fileio.TestImageReader;

/**
 * @author Luke_
 *
 */
public class Model {
	
	List<CIFARImage> cifarimage_list;
	IFileReader imagereader;
	
	IImageReader testimagereader;
	
	//Need to update class to add test image reader?
	
	public Model() {
		imagereader = new CIFARReader();
		testimagereader = new TestImageReader();
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
	 * @return the testimagereader
	 */
	public IImageReader getTestimagereader() {
		return testimagereader;
	}


	/**
	 * @param testimagereader the testimagereader to set
	 */
	public void setTestimagereader(IImageReader testimagereader) {
		this.testimagereader = testimagereader;
	}

	
	
}
