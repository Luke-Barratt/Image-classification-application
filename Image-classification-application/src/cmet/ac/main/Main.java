/**
 * 
 */
package cmet.ac.main;

import javax.swing.UIManager;

import cmet.ac.view.MainView;

/**
 * @author Luke_
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			System.out.println("Error occured while setting "
					+ "up the look and feel" + e.toString());
		}
		
		javax.swing.SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						MainView.getInstance();
					}
				}
			);
	}
}
