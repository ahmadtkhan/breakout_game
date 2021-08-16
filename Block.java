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
public class Block extends Rectangle{
    
    static String color;
    

    Block(int x, int y, int block_width, int block_height) {
        super(x, y, block_width, block_height);
        this.color = "green";
        
    }
    /*
    function createBlocks(){
  blocks.destroyEach();
  for (int j=0; j<rowCount; j++){
    for (int i=0; i<columnCount; i++){
      var newBlock = createSprite(); 
      newBlock.x = i*50 + 25;
      newBlock.y = j*25 + 80;
      newBlock.width = 48;
      newBlock.height = 23;
      newBlock.shapeColor = rgb(randomNumber(0,255), randomNumber(0,255), randomNumber(0,255), 1);
      
      // add the new block to the group
      blocks.add(newBlock);
    }  
  }
  blockCount = rowCount * columnCount;  // how many blocks are there
}
    */
    
    public void draw(Graphics g){  
        g.setColor(new Color(225, 0, 0));
       
        
        //    Color.getColor(color);
            g.fillRect(x, y, width, height);
        
    }

   
}
    

