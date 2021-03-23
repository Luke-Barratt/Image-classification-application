/**
 * 
 */
package cmet.ac.model;

import java.awt.image.BufferedImage;

/**
 * @author Luke_
 *
 */
public class CIFARImage {
	
	int label;
	BufferedImage buf_image;
	
	/**
	 * @param label
	 * @param buf_image
	 */
	public CIFARImage(int label, BufferedImage buf_image) {
		super();
		this.label = label;
		this.buf_image = buf_image;
	}

	/**
	 * @return the label
	 */
	public int getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(int label) {
		this.label = label;
	}

	/**
	 * @return the buf_image
	 */
	public BufferedImage getBuf_image() {
		return buf_image;
	}

	/**
	 * @param buf_image the buf_image to set
	 */
	public void setBuf_image(BufferedImage buf_image) {
		this.buf_image = buf_image;
	}
	
	
	

}
