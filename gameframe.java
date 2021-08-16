/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author aktar
 */
public class gameframe extends JFrame{
    
    Gamepanel panel;
    gameframe(){
        panel = new Gamepanel();
        this.add(panel);
	this.setTitle("Pong Game");
	this.setResizable(false);
	this.setBackground(Color.black);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
	this.setVisible(true);
	this.setLocationRelativeTo(null);
               
 
        
    }
    
}
