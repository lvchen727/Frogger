package frogger;

import java.awt.Color;


/**
 *
 * @author Chen Lu, Liang Wang
 * This class is to model a frog, it can move ,draw  and kill the frog.
 * It also check if the frog collides with the car or the goal.
 *
 *
 */
public class Frog {

	int lives;
	double x;
	double y;
	double halfLength;
	double halfWidth;

	/**
	 * Constructor
	 * @param lives
	 * @param length
	 * @param width
	 */
	public Frog(int lives, double length, double width) {
		this.lives = lives;
		this.x = 1;
		this.y = 1;
		this.halfLength = length;
		this.halfWidth = width;
	}

	/**
	 * move the frog
	 */
	public void move(){
		if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_UP)){
			this.y  += 0.5;
		}else if(ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_LEFT)){
			this.x  -= 0.5;
		}else if(ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_RIGHT)){
			this.x  += 0.5;
		}else if(ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_DOWN)){
			this.y  -= 0.5;
		}
	}

	/**
	 * draw the frog
	 */
	public void draw(){
		StdDraw.picture(this.x,this.y, "./frogger/images/frog.png",  this.halfLength * 2,this.halfWidth * 2);
	}

	/**
	 * sent the frog to the start
	 */
	public void restart(){
		this.x = 1;
		this.y = 1;
	}

	/**
	 * kill the frog and lose one life
	 */
	public void kill(){
		this.lives -= 1;
	}

	/**
	 * check the collision with car
	 * @param car
	 * @return true: collide; false: not collide
	 */
	public boolean collide(Car car){
		if(Math.abs(car.x - this.x) > (car.halfLength + this.halfLength) || Math.abs(car.y - this.y) > (car.halfWidth + this.halfWidth)){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * check the collision with goal
	 * @param goal
	 * @return 1 : collide with goal
	 * 		   0 : collide the green grass
	 *        -1 : not reach the goal and grass yet
	 */
	public int collide(Goal goal){
		if( Math.abs(goal.y - this.y) <= (goal.halfWidth + this.halfWidth)){
			if(!goal.isOccupied && Math.abs(this.x - goal.x) <= goal.halfLength){
				return 1;
			}else{
				return 0;
			}
		}else{
			return -1;
		}

	}

}
