/**
 * 
 */
package cmet.ac.model;

/**
 * @author Luke_
 *
 */
public class TrainImage {
	
	double distance;
	int lbl;
	
	/**
	 * @param distance
	 * @param lbl
	 */
	public TrainImage(double distance, int lbl) {
		super();
		this.distance = distance;
		this.lbl = lbl;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return the lbl
	 */
	public int getLbl() {
		return lbl;
	}

	/**
	 * @param lbl the lbl to set
	 */
	public void setLbl(int lbl) {
		this.lbl = lbl;
	}
	
	
}
