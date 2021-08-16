/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author aktar
 */
public class Gamepanel extends JPanel implements Runnable{
    
    int gamewidth =1000;
    int gameheight = 600;
    Dimension screen_size = new Dimension(gamewidth,gameheight);
    int ball_diameter = 15;
    int paddle_width = 200;
    int paddle_height = 15;
    int block_width = 50;
    int block_height = 15;
    int no_blocks = 20;
    Image image;
    Thread gamethread;
    Graphics graphics;
    paddle paddle;
    Ball ball;
    Block block;
    Score score;
    Random random;
    int i;
    

  //  public int map[][];
    ArrayList<Block>blocks = new ArrayList<Block>();
    
    
    Gamepanel(){
      
       paddle();
       newball();
        this.setFocusable(true);
       this.addKeyListener(new AL());
        this.setPreferredSize(screen_size);
        gamethread = new Thread(this);
       gamethread.start();
       score = new Score (gamewidth, gameheight); 
       for (i = 0; i<no_blocks;i++){
           blocks.add(new Block((i*50), 0, 48, block_height));
           
       }
       for (i = 0; i<no_blocks;i++){
           blocks.add(new Block((i*50), block_height+2, 48, block_height));
       }
       for (i = 0; i<no_blocks;i++){
           blocks.add(new Block((i*50), 34, 48, block_height));
       } 
       for (i = 0; i<no_blocks;i++){
           blocks.add(new Block((i*50), 51, 48, block_height));
       }
       for (i = 0; i<no_blocks;i++){
           blocks.add(new Block((i*50), 68, 48, block_height));
       } 
       for (i = 0; i<no_blocks;i++){
           blocks.add(new Block((i*50), 85, 48, block_height));
       } 
       for (i = 0; i<no_blocks;i++){
           blocks.add(new Block((i*50), 102, 48, block_height));
       } 
       
    }
    /*
    public void blocks(){
       
        block = new Block( 0, 0, block_width, block_height);
        
 
    }
    */
    public void newball(){
        random = new Random();
        ball = new Ball((gamewidth/2)-(ball_diameter/2), gameheight/2,ball_diameter,ball_diameter);
        //(gamewidth/2-paddle_width/2), 
    }
    
    public void paddle(){
        paddle = new paddle(gamewidth/2- paddle_width/2,gameheight-paddle_height,paddle_width,paddle_height);
        //gamewidth/2- paddle_width/2gameheight-paddle_height
    }
    
    
    
    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
	graphics = image.getGraphics();
	draw(graphics);
	g.drawImage(image,0,0,this);
    }
    
    public void draw(Graphics g){
        paddle.draw(g);
        ball.draw(g);
        score.draw(g);
        blocks.forEach(block ->{
            block.draw(g);
        });
        
      Toolkit.getDefaultToolkit().sync();
        
    }   
    
    public void move(){
       paddle.move();
       ball.move();
       
    }
    
    public void check_collision(){
     if(ball.x<=0){
            ball.setXDirection(-ball.xVelocity);
        }
        if(ball.x >= gamewidth-ball_diameter) {
            ball.setXDirection(-ball.xVelocity);
        }
        if(ball.y<=0){
             ball.setYDirection(-ball.yVelocity);
        }
        if(ball.intersects(paddle)) {
            score.displayscore = score.displayscore+100;
           // System.out.println("score = "+ score.displayscore);
            ball.yVelocity = Math.abs(ball.yVelocity);
            ball.yVelocity++; //optional for more difficulty
            if(ball.xVelocity>0)
                ball.xVelocity++; //optional for more difficulty
            else
                ball.xVelocity--;
        if (score.displayscore>score.highscore){
                score.highscore = score.displayscore;
            }
            else 
                score.highscore = score.highscore;
	ball.setXDirection(ball.xVelocity);
	ball.setYDirection(-ball.yVelocity); 
	} 
        if(paddle.x<=0)
            paddle.x=0;
        if(paddle.x >= (gamewidth-paddle_width))
            paddle.x = gamewidth-paddle_width;
        if(ball.y>gameheight){
            newball();
            score.lives++;
            score.displayscore = 0;
            
            //System.out.println("Gameover. Lives wasted = "+ score.lives);
        }
        blocks.forEach(blocks ->{
            if(ball.intersects(blocks)){ 
                blocks.setSize(0, 0); 
                score.displayscore = score.displayscore+50;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(-ball.yVelocity);
        }
        });
            
    } 

    @Override
    public void run() {
        long lastTime = System.nanoTime();
	double amountOfTicks =60.0;
	double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				check_collision();
				repaint();
				delta--;
            }
        }
    }
    public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle.keyPressed(e);
                        
			
		}
		public void keyReleased(KeyEvent e) {
			paddle.keyReleased(e);
                        
			
		}
	}

}
    
    

    