/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;

/**
 *
 * @author aktar
 */
public class Score extends Rectangle{
    
    static int displayscore;
    static int lives;
    static int highscore;

    Score(int displayscore, int lives) {
        super(displayscore, lives);
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("Score = "+ String.valueOf(displayscore), 0, 500);
        g.drawString("Lives = "+ String.valueOf(lives), 0, 520);
        g.drawString("highscore = "+ String.valueOf(highscore), 0, 540);
        
    }
}
