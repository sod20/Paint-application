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
public class Rectangle extends BoundedShape{ 
    /**
     * No parameter constructor which calls the no parameter constructor in MyBoundedShape
     */
    public Rectangle(){
        super();
    }
    
    /** 
     * Overloaded constructor that takes coordinates, color and fill. 
     * It passes them into MyBoundedShape's constructor
     */
    public Rectangle( int x1, int y1, int x2, int y2, Color color, boolean fill ){
        super(x1, y1, x2, y2, color,fill);
    } 
    
    /**
     * Overrides the draw method in MyBoundedShape. It sets the gets the color from MyBoundedShape
     * to set the color and the values it needs to draw from MyBoundedShape as well.
     */
    @Override
    public void draw( Graphics g ){
        g.setColor( getColor() ); //sets the color
        if (getFill()){
            g.fillRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
        }
        else{
            g.drawRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
        }
        
    } 
}
