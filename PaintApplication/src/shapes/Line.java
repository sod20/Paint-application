/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Naranjo
 */
public class Line extends Shape {
    
    private ArrayList<java.awt.Point> points;
    
    public Line(){
        super();
        this.points = new ArrayList<java.awt.Point>();
    }
    
    public Line( int x1, int y1, int x2, int y2, Color color ){
        super(x1, y1, x2, y2, color);
        this.points = new ArrayList<java.awt.Point>();
    } 
    
    public boolean add(java.awt.Point e){
        return points.add(e);
    }

    @Override
    public void draw(Graphics g) {
        if( this.points.size() == 1 )
        {
            java.awt.Point point = this.points.get( 0 );
            int size = 2; 
            g.fillOval((int)point.x-size/2, (int)point.y-size/2, size, size);
        }
        for( int i = 0 ; i < this.points.size() - 1 ; i++ )
        {
            java.awt.Point p1 = this.points.get( i );
            java.awt.Point p2 = this.points.get( i+1 );
            g.drawLine( (int)p1.x, (int)p1.y, (int)p2.x, (int)p2.y);
        }
    }
    
}
