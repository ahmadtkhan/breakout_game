/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.Rectangle;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author aktar
 */
public class paddle extends Rectangle{
    int xVelocity;
    int xDirection;
    int speed = 19; 
    paddle(int x, int y, int paddle_width, int paddle_height){
        super(x,y,paddle_width,paddle_height);
    }
    public void setXDirection(int xDirection){
        xVelocity = xDirection;
    }
    public void move(){
        x=x+xVelocity;
    }
    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);

    }

    void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            setXDirection(speed);   
            move();
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            setXDirection(-speed);
            move();
        }    
    }

    void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            setXDirection(0);
	}
	if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            setXDirection(0);
	}
    }
}
