package frogger;

import java.awt.Color;


/**
 *
 * @author Chen Lu, Liang Wang
 * This class is to model a car.
 *
 */
public class Car {

	double x;
	double y;
	double halfLength;
	double halfWidth;
	double speed;
	boolean direction; // 1 for left, 0 for right
	int imageIndex;

	/**
	 *
	 * @param x : x coordinate of the car center
	 * @param y : y coordinate of the car center
	 * @param length
	 * @param width
	 * @param speed
	 * @param direction
	 * @param imageIndex
	 *
	 */
	public Car(double x,double y, double length, double width, double speed,
			boolean direction, int imageIndex) {
		this.x = x;
		this.y = y;
		this.halfLength = length;
		this.halfWidth = width;
		this.speed = speed;
		this.direction = direction;
		this.imageIndex = imageIndex;

	}

	/**
	 * move the car
	 */
	public void move(){
		if (this.direction == true) {
			this.x = (this.x > (this.halfLength + this.speed)) ?(this.x - this.speed):(this.x + 18);
		} else {
			this.x = (this.x <= (20 - this.halfLength - this.speed)) ?(this.x + speed):(this.x - 18);


		}
	}

	/**
	 * draw the car
	 */
	public void draw() {
		if( this.imageIndex == 1 )
			StdDraw.picture(this.x,this.y, "./frogger/images/car1.png",  this.halfLength * 2,this.halfWidth * 2);
		else if( this.imageIndex == 2)
			StdDraw.picture(this.x,this.y, "./frogger/images/car2.png",  this.halfLength * 2,this.halfWidth * 2);
		else if( this.imageIndex == 3)
			StdDraw.picture(this.x,this.y, "./frogger/images/car3.png",  this.halfLength * 2,this.halfWidth * 2);
	}

	/**
	 * increase the car speed
	 */
	public void update(){
		this.speed += 0.05;
	}



}
