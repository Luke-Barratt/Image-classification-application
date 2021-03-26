/**
 * 
 */
package cmet.ac.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


import cmet.ac.model.CIFARImage;
import cmet.ac.model.Model;
import cmet.ac.view.MainView;

/**
 * @author Luke_
 *
 */
public class Controller {
	
	Model model;
	MainView mainview;
	
	/**
	 * @param model
	 * @param mainview
	 */
	public Controller(Model model, MainView mainview) {
		super();
		this.model = model;
		this.mainview = mainview;
		
		initController();
	}
	
	private void initController() {
		
		this.mainview.getDatasetpanel().getOpenFileBtn().addActionListener((e) -> fileopenAction());
		this.mainview.getDatasetpanel().getReadFileBtn().addActionListener((e) -> readImageAction());
		
		this.mainview.getTestimagepanel().getOpenImageBtn().addActionListener((e) -> imageOpenAction());
		this.mainview.getTestimagepanel().getReadImageBtn().addActionListener((e) -> readTestImageAction());
		
		
	}
	
	@SuppressWarnings("unchecked")
	private void readImageAction() {
		try {
			this.model.getCifarreader().read();
		} catch (IOException e){
			this.mainview.showMessage("Error in Reading the CIFAR-10 data", "File Read Error", JOptionPane.ERROR_MESSAGE);
		}
		this.model.setCifarimage_list((List<CIFARImage>) this.model.getCifarreader().getData());

	}
	
	
	private void fileopenAction() {
		File selected_file = this.mainview.getDatasetpanel().showDirectoryChooserDialog();
		String file_path = selected_file.getPath();
		
		//update model
		this.model.getCifarreader().setFilename(file_path);
		
		//update the view
		this.mainview.getDatasetpanel().getFileNameTxt().setText(file_path);
	}
	
	
	private void readTestImageAction() {
		try {
			this.model.getTestImageReader().readTestImage();
		} catch (IOException e) {
			this.mainview.showMessage("Error in Reading Test Image", "File Read Error", JOptionPane.ERROR_MESSAGE);
		}
		this.model.setTestImage((BufferedImage) this.model.getTestImageReader().getTestImage());
		
		BufferedImage buffImage = null;
		buffImage = this.model.getTestImage();
		this.mainview.getDisplaypanel().getImageLbl().setIcon(new ImageIcon(buffImage));
	
	}
	
	private void imageOpenAction() {
		File selected_image = this.mainview.getTestimagepanel().showDirectoryChooserDialogTestImage();
		String image_path = selected_image.getPath();
		
		//update model
		this.model.getTestImageReader().setImagename(image_path);
		
		//update view
		this.mainview.getTestimagepanel().getImageNameTxt().setText(image_path);
		
		

	}
	
}
