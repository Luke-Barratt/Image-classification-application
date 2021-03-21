/**
 * 
 */
package cmet.ac.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * @author Luke_
 *
 */
public class KValuePanel extends JPanel {
	
	JButton			selectValueBtn;
	JTextField		kValueTxt;
	JLabel			kValueLbl;
	
	JFrame 			mainWindow;
	
	private SpringLayout	kvaluepanel_layout;
	
	public KValuePanel(JFrame mainWindow) {
		
		this.mainWindow = mainWindow;
		
		this.kValueLbl = new JLabel("K Value: ");
		this.kValueTxt = new JTextField(5);
		kValueTxt.setToolTipText("Enter a value between 1-10");
		this.selectValueBtn = new JButton("Start");
		selectValueBtn.setToolTipText("Start image classification process");
		
		this.kvaluepanel_layout = new SpringLayout();
		kvaluepanel_layout.putConstraint(SpringLayout.NORTH, selectValueBtn, -4, SpringLayout.NORTH, kValueLbl);
		kvaluepanel_layout.putConstraint(SpringLayout.WEST, selectValueBtn, 6, SpringLayout.EAST, kValueTxt);
		kvaluepanel_layout.putConstraint(SpringLayout.NORTH, kValueLbl, 9, SpringLayout.NORTH, this);
		kvaluepanel_layout.putConstraint(SpringLayout.NORTH, kValueTxt, -3, SpringLayout.NORTH, kValueLbl);
		kvaluepanel_layout.putConstraint(SpringLayout.WEST, kValueTxt, 6, SpringLayout.EAST, kValueLbl);
		kvaluepanel_layout.putConstraint(SpringLayout.WEST, kValueLbl, 10, SpringLayout.WEST, this);
		
		setupPanel();
		setupLayout();
	}
	
	private void setupPanel() {
		this.setSize(176, 33);
		this.setLayout(kvaluepanel_layout);
		this.add(kValueLbl);
		this.add(kValueTxt);
		this.add(selectValueBtn);
	}
	
	private void setupLayout() {
	}

	/**
	 * @return the selectValueBtn
	 */
	public JButton getSelectValueBtn() {
		return selectValueBtn;
	}

	/**
	 * @param selectValueBtn the selectValueBtn to set
	 */
	public void setSelectValueBtn(JButton selectValueBtn) {
		this.selectValueBtn = selectValueBtn;
	}

	/**
	 * @return the kValueTxt
	 */
	public JTextField getkValueTxt() {
		return kValueTxt;
	}

	/**
	 * @param kValueTxt the kValueTxt to set
	 */
	public void setkValueTxt(JTextField kValueTxt) {
		this.kValueTxt = kValueTxt;
	}

	/**
	 * @return the kValueLbl
	 */
	public JLabel getkValueLbl() {
		return kValueLbl;
	}

	/**
	 * @param kValueLbl the kValueLbl to set
	 */
	public void setkValueLbl(JLabel kValueLbl) {
		this.kValueLbl = kValueLbl;
	}
	
	

}
