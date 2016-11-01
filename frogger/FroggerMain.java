package frogger;

/**
 *
 * @author Chen Lu, Liang Wang
 * Lab 10 : Frogger game
 * Include a title screen and game over screen, with animations that you've created. (EC: 10 points)
 * Every time a level/goal is reached, make the game more difficult by making the cars move faster. (EC: 10 points)
 *
 */
public class FroggerMain {
	public static void main(String[] args) {
		while(true) {//always restart the game
			Frogger g = new Frogger();
			g.playGame();
		}
	}
}
