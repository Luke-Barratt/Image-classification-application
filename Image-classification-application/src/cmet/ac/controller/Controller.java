/**
 * 
 */
package cmet.ac.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cmet.ac.model.CIFARImage;
import cmet.ac.model.KnnImage;
import cmet.ac.model.Model;
import cmet.ac.model.TestImage;
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
		
		this.mainview.getKvaluepanel().getSelectValueBtn().addActionListener((e) -> selectKValue());
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	private void readImageAction() {
		try {
			this.model.getCifarreader().read();
		} catch (IOException e){
			this.mainview.showMessage("Error in Reading the CIFAR-10 data", "File Read Error", JOptionPane.ERROR_MESSAGE);
		}
		this.model.setCifarimage_list((List<CIFARImage>) this.model.getCifarreader().getData());
		
		//convert to training data image to gray scale
		for(int i = 0; i < this.model.getCifarimage_list().size(); i++) {
			BufferedImage	grayScaleImage;
			grayScaleImage = this.model.getCifarimage_list().get(i).getBuf_image();
			this.model.convertToGrayscale(grayScaleImage);
		}

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
		//read in test image
		try {
			this.model.getTestImageReader().readTestImage();
		} catch (IOException e) {
			this.mainview.showMessage("Error in Reading Test Image", "File Read Error", JOptionPane.ERROR_MESSAGE);
		}
		this.model.setTestImage((BufferedImage) this.model.getTestImageReader().getTestImage());
		
		BufferedImage buffImage = null;
		buffImage = this.model.getTestImage();

		
		// Converts test image to gray scale
		BufferedImage greyScaleImage = null; 
		greyScaleImage = this.model.convertToGrayscale(buffImage);
		
		// Output test image to display panel
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
	
	private void imageClassificationAction() throws Exception {
		
		int kvalue = this.model.getKnnImage().getK();
		this.model.getKnnImage().setData(this.model.getCifarimage_list());
		
		this.model.getKnnImage().setTestImage(this.model.getTestImage());
		
//		KnnImage knnImage = new KnnImage(kvalue, this.model.getCifarimage_list(), this.model.getTestImage());
//		knnImage.calculateDistance();
//		knnImage.classify();
		
		this.model.getKnnImage().calculateDistance();
		this.model.getKnnImage().classify();
		
		
		// set classification label
		String result_string = this.model.getKnnImage().getResult();
		this.mainview.getDisplaypanel().setClassificationLbl(new JLabel(result_string));
		
		// set confidence label
		double confidence_double = this.model.getKnnImage().getConfidence();
		String confidence = Double.toString(confidence_double);
		
		this.mainview.getDisplaypanel().setConfidenceLbl(new JLabel(confidence));
	}
	
	private void selectKValue() {
		
		// Convert the input for the JTextField to an integer value
		JTextField input = this.mainview.getKvaluepanel().getkValueTxt();
		String text = input.getText();
		int kvalue = Integer.parseInt(text);
		
		// set the k value in the KnnImage class
		this.model.getKnnImage().setK(kvalue);
	}
	
}
