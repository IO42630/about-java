package advanced;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Robot_About {

	Color read() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			return robot.getPixelColor(10, 20);

		} catch (AWTException e) {
			e.printStackTrace();
		}
		return null;

	}



	public static void main(String args[]) {
        /* The original idea of this example was to solve the 2048 game (by creating a bot)

         */

		Color color = new Robot_About().read();

        System.out.print(color);
    }


}