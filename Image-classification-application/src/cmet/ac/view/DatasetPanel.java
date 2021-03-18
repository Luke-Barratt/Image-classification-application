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
public class DatasetPanel extends JPanel {
	
	JButton 		openFileBtn;
	JButton 		readFileBtn;
	JTextField 		fileNameTxt;
	JLabel 			fileNameLbl;
	
	JFrame			mainWindow;
	
	private JFileChooser	fileChooser;
	private SpringLayout	filepanel_layout;

	public DatasetPanel(JFrame mainWindow) {
		
		this.mainWindow = mainWindow;
		
		this.fileNameLbl = new JLabel("File path: ");
		this.fileNameTxt = new JTextField(40);
		this.fileNameTxt.setEnabled(false);
		this.openFileBtn = new JButton("Select file");
		this.readFileBtn = new JButton("Read");
		
		this.filepanel_layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		
		
	}
	
	private void setupPanel() {
		this.setSize(600, 70);
		this.setLayout(filepanel_layout);
		this.add(fileNameLbl);
		this.add(fileNameTxt);
		this.add(openFileBtn);
		this.add(readFileBtn);
	}
	
	private void setupLayout() {
		filepanel_layout.putConstraint(SpringLayout.NORTH, openFileBtn, -4, SpringLayout.NORTH, fileNameLbl);
		filepanel_layout.putConstraint(SpringLayout.WEST, openFileBtn, 18, SpringLayout.EAST, fileNameTxt);
		filepanel_layout.putConstraint(SpringLayout.NORTH, readFileBtn, -4, SpringLayout.NORTH, fileNameLbl);
		filepanel_layout.putConstraint(SpringLayout.EAST, readFileBtn, -25, SpringLayout.EAST, this);
		filepanel_layout.putConstraint(SpringLayout.NORTH, fileNameLbl, 3, SpringLayout.NORTH, fileNameTxt);
		filepanel_layout.putConstraint(SpringLayout.WEST, fileNameLbl, 10, SpringLayout.WEST, this);
		filepanel_layout.putConstraint(SpringLayout.NORTH, fileNameTxt, 22, SpringLayout.NORTH, this);
		filepanel_layout.putConstraint(SpringLayout.WEST, fileNameTxt, 76, SpringLayout.WEST, this);
	}
	

}
