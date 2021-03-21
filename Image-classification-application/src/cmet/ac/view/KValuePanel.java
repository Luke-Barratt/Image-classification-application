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
		this.selectValueBtn = new JButton("Start");
		selectValueBtn.setToolTipText("Start image classification process");
		
		this.kvaluepanel_layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
	}
	
	private void setupPanel() {
		this.setSize(175, 33);
		this.setLayout(kvaluepanel_layout);
		this.add(kValueLbl);
		this.add(kValueTxt);
		this.add(selectValueBtn);
	}
	
	private void setupLayout() {
		kvaluepanel_layout.putConstraint(SpringLayout.NORTH, selectValueBtn, 5, SpringLayout.NORTH, this);
		kvaluepanel_layout.putConstraint(SpringLayout.NORTH, kValueLbl, 3, SpringLayout.NORTH, kValueTxt);
		kvaluepanel_layout.putConstraint(SpringLayout.EAST, kValueLbl, -6, SpringLayout.WEST, kValueTxt);
		kvaluepanel_layout.putConstraint(SpringLayout.WEST, selectValueBtn, 110, SpringLayout.WEST, this);
		kvaluepanel_layout.putConstraint(SpringLayout.NORTH, kValueTxt, 1, SpringLayout.NORTH, selectValueBtn);
		kvaluepanel_layout.putConstraint(SpringLayout.EAST, kValueTxt, -6, SpringLayout.WEST, selectValueBtn);
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
