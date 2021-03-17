/**
 * 
 */
package cmet.ac.view;

import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

/**
 * @author Luke_
 *
 */
public class MainView {
	
	JLabel			filePathLbl;
	JTextField 		fileNameTxt;
	JButton 		selectFileBtn;
	JButton 		readFileBtn;
	
	JLabel			imagePathLbl;
	JTextField		imageNameTxt;
	JButton			selectImageBtn;
	JButton			readImageBtn;
	
	JFrame			MainView;
	
	private static MainView instance;
	
	public static MainView getInstance() {
		if(instance == null)
			instance = new MainView();
		
		return instance;
	}
	
	public MainView() {
		
		JFrame jframe = new JFrame("Image Classification");
		jframe.setSize(593, 495);
		jframe.getContentPane().setLayout(new BorderLayout(0, 0));
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		
		JPanel panel = new JPanel();
		jframe.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		//setup view to select CIFAR-10 data file
		this.filePathLbl = new JLabel("File path: ");
		sl_panel.putConstraint(SpringLayout.NORTH, filePathLbl, 22, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, filePathLbl, 10, SpringLayout.WEST, panel);
		panel.add(filePathLbl);
		
		this.fileNameTxt = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, fileNameTxt, -3, SpringLayout.NORTH, filePathLbl);
		sl_panel.putConstraint(SpringLayout.WEST, fileNameTxt, 20, SpringLayout.EAST, filePathLbl);
		sl_panel.putConstraint(SpringLayout.EAST, fileNameTxt, -186, SpringLayout.EAST, panel);
		panel.add(fileNameTxt);
		fileNameTxt.setColumns(35);
		
		this.selectFileBtn = new JButton("Select file");
		sl_panel.putConstraint(SpringLayout.NORTH, selectFileBtn, -4, SpringLayout.NORTH, filePathLbl);
		sl_panel.putConstraint(SpringLayout.WEST, selectFileBtn, 15, SpringLayout.EAST, fileNameTxt);
		panel.add(selectFileBtn);
		
		this.readFileBtn = new JButton("Read");
		sl_panel.putConstraint(SpringLayout.NORTH, readFileBtn, -4, SpringLayout.NORTH, filePathLbl);
		sl_panel.putConstraint(SpringLayout.EAST, readFileBtn, -16, SpringLayout.EAST, panel);
		panel.add(readFileBtn);
		
		// setup view to select test image
		this.imagePathLbl = new JLabel("Image path: ");
		panel.add(imagePathLbl);
		
		this.imageNameTxt = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, imageNameTxt, 78, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, imagePathLbl, 3, SpringLayout.NORTH, imageNameTxt);
		sl_panel.putConstraint(SpringLayout.EAST, imagePathLbl, -6, SpringLayout.WEST, imageNameTxt);
		panel.add(imageNameTxt);
		imageNameTxt.setColumns(10);
		
		this.selectImageBtn = new JButton("Select image");
		sl_panel.putConstraint(SpringLayout.NORTH, imageNameTxt, 1, SpringLayout.NORTH, selectImageBtn);
		sl_panel.putConstraint(SpringLayout.EAST, imageNameTxt, -15, SpringLayout.WEST, selectImageBtn);
		sl_panel.putConstraint(SpringLayout.NORTH, selectImageBtn, 20, SpringLayout.SOUTH, selectFileBtn);
		sl_panel.putConstraint(SpringLayout.WEST, selectImageBtn, 0, SpringLayout.WEST, selectFileBtn);
		panel.add(selectImageBtn);
		
		this.readImageBtn = new JButton("Read");
		sl_panel.putConstraint(SpringLayout.NORTH, readImageBtn, 0, SpringLayout.NORTH, selectImageBtn);
		sl_panel.putConstraint(SpringLayout.EAST, readImageBtn, 0, SpringLayout.EAST, readFileBtn);
		panel.add(readImageBtn);
		
		
	}
	

	/**
	 * @return the fileNameTxt
	 */
	public JTextField getFileNameTxt() {
		return fileNameTxt;
	}


	/**
	 * @param fileNameTxt the fileNameTxt to set
	 */
	public void setFileNameTxt(JTextField fileNameTxt) {
		this.fileNameTxt = fileNameTxt;
	}


	/**
	 * @return the selectFileBtn
	 */
	public JButton getSelectFileBtn() {
		return selectFileBtn;
	}


	/**
	 * @param selectFileBtn the selectFileBtn to set
	 */
	public void setSelectFileBtn(JButton selectFileBtn) {
		this.selectFileBtn = selectFileBtn;
	}


	/**
	 * @return the readFileBtn
	 */
	public JButton getReadFileBtn() {
		return readFileBtn;
	}


	/**
	 * @param readFileBtn the readFileBtn to set
	 */
	public void setReadFileBtn(JButton readFileBtn) {
		this.readFileBtn = readFileBtn;
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
	 * @return the selectImageBtn
	 */
	public JButton getSelectImageBtn() {
		return selectImageBtn;
	}

	/**
	 * @param selectImageBtn the selectImageBtn to set
	 */
	public void setSelectImageBtn(JButton selectImageBtn) {
		this.selectImageBtn = selectImageBtn;
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
	
	
}
