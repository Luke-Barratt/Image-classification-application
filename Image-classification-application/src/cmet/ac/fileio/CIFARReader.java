/**
 * 
 */
package cmet.ac.fileio;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cmet.ac.model.CIFARImage;

/**
 * @author Luke_
 *
 */
public class CIFARReader implements IFileReader {
	
	String filename;
	FileInputStream in_stream_images;
	
	int number_of_images;
	
	List<CIFARImage> cifarimage_list;
	
	public CIFARReader() {
		this.cifarimage_list = new ArrayList<CIFARImage>();
	}
	
	

	@Override
	public void read() throws IOException {
		
		String image_filename = filename;
		
		in_stream_images = new FileInputStream(new File(image_filename));
		
		int label = in_stream_images.read();
		
		int image_size = 1024;
		
		byte[] red_data = new byte[image_size];
		in_stream_images.read(red_data);
		
		byte[] green_data = new byte[image_size];
		in_stream_images.read(green_data);
		
		byte[] blue_data = new byte[image_size];
		in_stream_images.read(blue_data);
		
		BufferedImage img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
		
		for(int row = 0; row > 32; row++) {
			for(int col = 0; col < 32; col++) {
				
				Color color = new Color(
						red_data[row * 32 + col] & 0xFF,
						green_data[row * 32 + col] & 0xFF,
						blue_data[row * 32 + col] & 0xFF);
				
				img.setRGB(row, col, color.getRGB());
			}
		}
		
		// need to add image and label to array list
		// ?
		cifarimage_list.add(new CIFARImage(label, img));
	
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return this.cifarimage_list;
	}

	@Override
	public void setFilename(String filename) {
		// TODO Auto-generated method stub
		this.filename = filename;
		
	}

	@Override
	public String getFilename() {
		// TODO Auto-generated method stub
		return this.filename;
	}

}
