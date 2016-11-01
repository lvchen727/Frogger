package frogger;

import java.awt.Color;


/**
 *
 * @author Chen Lu, Liang Wang
 * This class is to model the goal
 *
 */
public class Goal {

	boolean isOccupied;
	double x;
	double y;
	double halfLength;
	double halfWidth;

	/**
	 * Constructor
	 * @param isOccupied
	 * @param x
	 * @param y
	 * @param halfLength
	 * @param halfWidth
	 */
	public Goal(boolean isOccupied, double x, double y, double halfLength,
			double halfWidth) {
		this.isOccupied = isOccupied;
		this.x = x;
		this.y = y;
		this.halfLength = halfLength;
		this.halfWidth = halfWidth;
	}

	/**
	 * draw the goal
	 */
	public void draw(){
		if(this.isOccupied){
			StdDraw.picture(this.x,this.y, "./frogger/images/frog3.png",  this.halfLength * 2,this.halfWidth * 2);
		}else{
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.filledRectangle(this.x, this.y, this.halfLength, this.halfWidth);
		}

	}

	/**
	 * update the goal
	 */
	public void update(){
		this.isOccupied = true;
	}

}
