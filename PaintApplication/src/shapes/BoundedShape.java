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
abstract class BoundedShape extends Shape {
    
    private boolean fill;
    
    public BoundedShape() {
        super();
        fill=false;
    }
    
    public BoundedShape(int x1, int y1, int x2, int y2, Color color, boolean fill){
        super(x1, y1, x2, y2, color);
        this.fill=fill;
    }
    
    public void setFill(boolean fill)
    {
        this.fill=fill;
    }

    public int getUpperLeftX() {
        return Math.min(getX1(),getX2());
    }
    
    public int getUpperLeftY() {
        return Math.min(getY1(),getY2());
    }
    
    public int getWidth() {
        return Math.abs(getX1()-getX2());
    }

    public int getHeight() {
        return Math.abs(getY1()-getY2());
    }
    
    public boolean getFill() {
        return fill;
    }
    
    abstract public void draw( Graphics g );
}
