/**
 * 
 */
package cmet.ac.view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;

/**
 * @author Luke_
 *
 */
public class DisplayPanel extends JPanel {
	
	JLabel						imageLbl;
	
	private JFrame				mainWindow;
	private SpringLayout		displaypanel_layout;
	
	public DisplayPanel(JFrame mainWindow) {
		
		this.mainWindow = mainWindow;
		this.displaypanel_layout = new SpringLayout();
		this.imageLbl = new JLabel();

		setupPanel();
		setupLayout();
	}
	
	private void setupPanel() {
		setPreferredSize(new Dimension(200, 40));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		add(imageLbl);
		
	}

	private void setupLayout() {

	}

	/**
	 * @return the imageLbl
	 */
	public JLabel getImageLbl() {
		return imageLbl;
	}

	/**
	 * @param imageLbl the imageLbl to set
	 */
	public void setImageLbl(JLabel imageLbl) {
		this.imageLbl = imageLbl;
	}


}
