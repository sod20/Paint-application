/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Alejandro Naranjo
 */
public class Point extends Shape{
    
    public Point(){
        super();
    }
    
    public Point( int x1, int y1, Color color ){
        super(x1, y1, 0, 0, color);
    } 
    
    public void draw(Graphics g)
    {
        g.fillOval(getX1()-2, getY1()-2, 2, 2);
    }
    
}
