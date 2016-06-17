/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Naranjo
 */
public class Vector extends Shape{
    
    private Color color;
    private int size;
    
    public Vector(){
        super();
    }
    
    public Vector( int x1, int y1, int x2, int y2, Color color ){
        super(x1, y1, x2, y2, color);
        this.size = 1;
    }
    
    public void setTickness( int size ){
        this.size = size;
    }
    
    public void setColor( Color newColor ){
        this.color = newColor;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(size));
        g2.draw(new Line2D.Float(this.getX1(), this.getY1(), this.getX2(), this.getY2()));
    }
    
}
