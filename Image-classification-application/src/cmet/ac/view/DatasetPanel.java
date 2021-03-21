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
		openFileBtn.setToolTipText("Select CIFAR-10 dataset");
		this.readFileBtn = new JButton("Read");
		
		this.filepanel_layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		
		
	}
	
	private void setupPanel() {
		this.setSize(570, 40);
		this.setLayout(filepanel_layout);
		this.add(fileNameLbl);
		this.add(fileNameTxt);
		this.add(openFileBtn);
		this.add(readFileBtn);
	}
	
	private void setupLayout() {
		filepanel_layout.putConstraint(SpringLayout.WEST, fileNameTxt, 18, SpringLayout.EAST, fileNameLbl);
		filepanel_layout.putConstraint(SpringLayout.NORTH, fileNameLbl, 3, SpringLayout.NORTH, fileNameTxt);
		filepanel_layout.putConstraint(SpringLayout.WEST, fileNameLbl, 10, SpringLayout.WEST, this);
		filepanel_layout.putConstraint(SpringLayout.NORTH, readFileBtn, -1, SpringLayout.NORTH, fileNameTxt);
		filepanel_layout.putConstraint(SpringLayout.WEST, readFileBtn, 6, SpringLayout.EAST, openFileBtn);
		filepanel_layout.putConstraint(SpringLayout.NORTH, openFileBtn, -1, SpringLayout.NORTH, fileNameTxt);
		filepanel_layout.putConstraint(SpringLayout.WEST, openFileBtn, 16, SpringLayout.EAST, fileNameTxt);
		filepanel_layout.putConstraint(SpringLayout.NORTH, fileNameTxt, 10, SpringLayout.NORTH, this);
	}

	/**
	 * @return the openFileBtn
	 */
	public JButton getOpenFileBtn() {
		return openFileBtn;
	}

	/**
	 * @param openFileBtn the openFileBtn to set
	 */
	public void setOpenFileBtn(JButton openFileBtn) {
		this.openFileBtn = openFileBtn;
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
	 * @return the fileNameLbl
	 */
	public JLabel getFileNameLbl() {
		return fileNameLbl;
	}

	/**
	 * @param fileNameLbl the fileNameLbl to set
	 */
	public void setFileNameLbl(JLabel fileNameLbl) {
		this.fileNameLbl = fileNameLbl;
	}
	
	
	
}
