package frogger;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Chen Lu, Liang Wang
 * This class manipulates the frogger game;
 *
 */
public class Frogger implements FroggerGame{

	Frog frog;
	LinkedList<Car> cars;
	int score;
	ArrayList<Goal> goals;

	/**
	 * Constructor
	 */
	public Frogger() {
		//create a frog
		frog = new Frog(3, 0.5, 0.5);

		//create four lines of cars, add to list/array
		cars = new LinkedList<Car>();

		for(int i = 0; i < 4; i++){
			Car car = new Car(3 + i * 4, 3 , 0.5, 0.5, 0.1, true,1);
			cars.add(car);
		}
		for(int i = 0; i < 4; i++){
			Car car = new Car(5 + i * 4, 6 , 0.5, 0.5, 0.1, false,2);
			cars.add(car);
		}
		for(int i = 0; i < 4; i++){
			Car car = new Car(7 + i * 4, 9 , 1, 0.5, 0.1, true,3);
			cars.add(car);
		}
		for(int i = 0; i < 4; i++){
			Car car = new Car(5 + i * 4, 12 , 0.5, 0.5, 0.1, false,1);
			cars.add(car);
		}


		//create five goals, add to list/array
		goals = new ArrayList<Goal>();
		for(int i = 0; i < 5; i++){
			Goal goal = new Goal(false, 20/5 * i + 2, 15.8, 0.8, 0.8);
			goals.add(goal);
		}

		//set initial score
		score = 0;

	}

	@Override
	public void playGame() {

		//title screen
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0, 20);
		StdDraw.setYscale(0, 20);
		StdDraw.clear();
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(10,10,10,10);
		StdDraw.picture(10,10, "./frogger/images/start.png", 8,5);
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.text(10, 18, "Frogger");
		StdDraw.show(1500);

		//start the game
		while (frog.lives > 0 ) {

			frog.move();

			//Check for collision with car
			for( int i = 0; i < cars.size(); i++){
				if(frog.collide(cars.get(i))){
					frog.kill();//kill my frog
					frog.restart();//send to start
				}
			}

			//Check for collision with goals
			for(int i = 0; i < goals.size(); i++){
				if(frog.collide(goals.get(i)) == 1){ // frog collide with goal successfully : update status of goal
					//update car speed
					for(int j = 0; j < cars.size(); j++){
						cars.get(j).update();
					}
					score += 10;//update score
					goals.get(i).update();
					frog.restart();//send frog to start
				}else if(frog.collide(goals.get(i)) == 0 && i == goals.size()-1){// frog collide with goal unsuccessfully
					frog.kill();
					frog.restart();//send frog to start
				}
			}



			//Move the cars
			for( int i = 0; i < cars.size(); i++){
				cars.get(i).move();
			}

			StdDraw.clear();

			//draw background
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.filledRectangle(10,10,10,10);
			StdDraw.setPenColor(Color.GREEN);
			StdDraw.filledRectangle(10,16,10,1);
			StdDraw.text(10, 18, "Frogger");

			//draw frog
			frog.draw();

			//draw goals
			for(int i = 0; i < goals.size(); i++){
				goals.get(i).draw();
			}

			//draw cars
			for( int i = 0; i < cars.size(); i++){
				cars.get(i).draw();
			}

			//draw score and lives
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(18, 18, "Lives:"+frog.lives);
			StdDraw.text(2, 18, "Scores:"+score);

			StdDraw.show(150);

		}
		//game over screen
		StdDraw.clear();
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(10,10,10,10);
		StdDraw.picture(10,10, "./frogger/images/gameover.png", 8,5);
		StdDraw.show(1500);
	}

	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return "Frogger";
	}

	@Override
	public String[] getTeamMembers() {
		// TODO Auto-generated method stub
		return null;
	}
}
