/**
 * 
 */
package cmet.ac.main;

import cmet.ac.view.MainView;

/**
 * @author Luke_
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						MainView.getInstance();
					}
				}
			);
	}
}
