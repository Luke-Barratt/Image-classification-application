/**
 * 
 */
package cmet.ac.view;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * @author Luke_
 *
 */
public class TestImagePanel extends JPanel {
	
	JButton			openImageBtn;
	JButton			readImageBtn;
	JTextField		imageNameTxt;
	JLabel			imageNameLbl;
	
	JFrame 			mainWindow;
	
	private JFileChooser 	imageChooser;
	private SpringLayout	imagepanel_layout;
	
	
	public TestImagePanel(JFrame mainWindow) {
		
		this.mainWindow = mainWindow;
		
		this.imageNameLbl = new JLabel("Image path: ");
		this.imageNameTxt = new JTextField(40);
		this.imageNameTxt.setEnabled(false);
		this.openImageBtn = new JButton("Select image");
		this.readImageBtn = new JButton("Read");
		
		this.imagepanel_layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		
	}
	
	private void setupPanel() {
		this.setSize(600, 70);
		this.setLayout(imagepanel_layout);
		this.add(imageNameLbl);
		this.add(imageNameTxt);
		this.add(openImageBtn);
		this.add(readImageBtn);
	}
	
	private void setupLayout() {
		imagepanel_layout.putConstraint(SpringLayout.NORTH, readImageBtn, -4, SpringLayout.NORTH, imageNameLbl);
		imagepanel_layout.putConstraint(SpringLayout.WEST, readImageBtn, 12, SpringLayout.EAST, openImageBtn);
		imagepanel_layout.putConstraint(SpringLayout.NORTH, openImageBtn, -4, SpringLayout.NORTH, imageNameLbl);
		imagepanel_layout.putConstraint(SpringLayout.WEST, openImageBtn, 11, SpringLayout.EAST, imageNameTxt);
		imagepanel_layout.putConstraint(SpringLayout.NORTH, imageNameTxt, -3, SpringLayout.NORTH, imageNameLbl);
		imagepanel_layout.putConstraint(SpringLayout.WEST, imageNameTxt, 6, SpringLayout.EAST, imageNameLbl);
		imagepanel_layout.putConstraint(SpringLayout.SOUTH, imageNameLbl, -30, SpringLayout.SOUTH, this);
		imagepanel_layout.putConstraint(SpringLayout.WEST, imageNameLbl, 10, SpringLayout.WEST, this);
	}

	/**
	 * @return the openImageBtn
	 */
	public JButton getOpenImageBtn() {
		return openImageBtn;
	}

	/**
	 * @param openImageBtn the openImageBtn to set
	 */
	public void setOpenImageBtn(JButton openImageBtn) {
		this.openImageBtn = openImageBtn;
	}

	/**
	 * @return the readImageBtn
	 */
	public JButton getReadImageBtn() {
		return readImageBtn;
	}

	/**
	 * @param readImageBtn the readImageBtn to set
	 */
	public void setReadImageBtn(JButton readImageBtn) {
		this.readImageBtn = readImageBtn;
	}

	/**
	 * @return the imageNameTxt
	 */
	public JTextField getImageNameTxt() {
		return imageNameTxt;
	}

	/**
	 * @param imageNameTxt the imageNameTxt to set
	 */
	public void setImageNameTxt(JTextField imageNameTxt) {
		this.imageNameTxt = imageNameTxt;
	}

	/**
	 * @return the imageNameLbl
	 */
	public JLabel getImageNameLbl() {
		return imageNameLbl;
	}

	/**
	 * @param imageNameLbl the imageNameLbl to set
	 */
	public void setImageNameLbl(JLabel imageNameLbl) {
		this.imageNameLbl = imageNameLbl;
	}
	
	

}
