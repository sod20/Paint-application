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
public class Oval extends BoundedShape {
    
    public Oval(){
        super();
    }
    
    public Oval( int x1, int y1, int x2, int y2, Color color, boolean fill ){
        super(x1, y1, x2, y2, color,fill);
    }
    
    @Override
    public void draw( Graphics g )
    {
        g.setColor( getColor() ); //sets the color
        if (getFill()){
            g.fillOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
        }
        else{
            g.drawOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
        }
    }
    
}
