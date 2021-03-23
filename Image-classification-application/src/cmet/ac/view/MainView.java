/**
 * 
 */
package cmet.ac.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cmet.ac.controller.Controller;
import cmet.ac.model.Model;

import java.awt.Component;

/**
 * @author Luke_
 *
 */
public class MainView {
	
	JFrame 				mainwindow;
	
	DatasetPanel 		datasetpanel;
	TestImagePanel 		testimagepanel;
	KValuePanel			kvaluepanel;
	DisplayPanel 		displaypanel;
	
	Model				model;
	Controller			controller;
	
	
	private static MainView instance;
	
	public static MainView getInstance() {
		if(instance == null)
			instance = new MainView();
		
		return instance;
	}
	
	private MainView() {
		
		this.mainwindow = new JFrame("CIFAR-10 Image Classification");
		this.mainwindow.setSize(735, 200);
		this.mainwindow.setResizable(false);
		this.mainwindow.getContentPane().setLayout(new BoxLayout(this.mainwindow.getContentPane(), BoxLayout.Y_AXIS));
		
		//initialise panels
		this.datasetpanel = new DatasetPanel(mainwindow);
		this.testimagepanel = new TestImagePanel(mainwindow);
		this.kvaluepanel = new KValuePanel(mainwindow);
		this.displaypanel = new DisplayPanel(mainwindow);
		
		
		// add panels
		this.mainwindow.getContentPane().add(this.datasetpanel);
		this.mainwindow.getContentPane().add(this.testimagepanel);
		this.mainwindow.getContentPane().add(this.kvaluepanel);
		this.mainwindow.getContentPane().add(this.displaypanel);
		
		
		
		this.mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainwindow.setVisible(true);
		
		//initialise the model and controller
		this.model = new Model();
		this.controller = new Controller(model, this);
		
	}

	/**
	 * @return the datasetpanel
	 */
	public DatasetPanel getDatasetpanel() {
		return datasetpanel;
	}

	/**
	 * @param datasetpanel the datasetpanel to set
	 */
	public void setDatasetpanel(DatasetPanel datasetpanel) {
		this.datasetpanel = datasetpanel;
	}

	/**
	 * @return the testimagepanel
	 */
	public TestImagePanel getTestimagepanel() {
		return testimagepanel;
	}

	/**
	 * @param testimagepanel the testimagepanel to set
	 */
	public void setTestimagepanel(TestImagePanel testimagepanel) {
		this.testimagepanel = testimagepanel;
	}

	/**
	 * @return the displaypanel
	 */
	public DisplayPanel getDisplaypanel() {
		return displaypanel;
	}

	/**
	 * @param displaypanel the displaypanel to set
	 */
	public void setDisplaypanel(DisplayPanel displaypanel) {
		this.displaypanel = displaypanel;
	}
	
	public void showMessage(String message, String title, int flag) {
		JOptionPane.showMessageDialog(this.mainwindow, message, "File Read Error", flag);
	}
	
	
}
