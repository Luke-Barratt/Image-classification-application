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
	BufferedImage img;
	
	/**
	 * @param label
	 * @param img
	 */
	public CIFARImage(int label, BufferedImage img) {
		super();
		this.label = label;
		this.img = img;
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
	 * @return the img
	 */
	public BufferedImage getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
	}


	

}
