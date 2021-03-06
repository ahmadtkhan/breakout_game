/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.Rectangle;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;


public class Ball extends Rectangle{

    static void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 4;
	
	Ball(int x, int y, int width, int height){
            super(x,y,width,height);
            random = new Random();
            int randomXDirection = random.nextInt(2);
            if(randomXDirection == 0)
            randomXDirection--;
            setXDirection(initialSpeed*randomXDirection);
                
            int randomYDirection = random.nextInt(2);
            if(randomYDirection == 0)
            randomYDirection--;
            setYDirection(randomYDirection*initialSpeed);                
		
	}
	
	public final void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}
	public void move() {
		x = x + xVelocity;
		y = y + yVelocity;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
        
}
