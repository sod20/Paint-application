/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintapplication;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import shapes.Line;
import shapes.Oval;
import shapes.Rectangle;
import shapes.Shape;

/**
 *
 * @author Alejandro Naranjo
 */
class JPaintPanel extends JPanel implements MouseListener, MouseMotionListener{
    
    private int currentShapeType;
    private Shape currentShapeObject;
    private Color currentColor;
    private int currentSize;
    
    private int PEN = 22;
    private int CIRCLE = 33;
    private int RECTANGLE = 44;
    private int LINE = 55;
    
    private ArrayList<Shape> shapes;
    private Line auxLine;
    private Oval auxOval;
    private Rectangle auxRectangle;
    private boolean tickness;
    
    public JPaintPanel(){
        
        currentShapeType = 22;
        currentShapeObject = null;
        currentColor = Color.BLACK;
        currentSize = 1;
        tickness = false;
        
        shapes = new ArrayList<Shape>();
        
        super.setBackground(Color.WHITE);
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }    
    
    public void paint( Graphics g )
    {
        super.paintComponent( g );
        
        if( auxLine != null ){
            auxLine.draw(g);
        }
        if( auxOval != null ){
            auxOval.draw(g);
        }
        if( auxRectangle != null ){
            auxRectangle.draw(g);
        }
        
        for ( int i = 0; i< shapes.size(); i++ )
           shapes.get(i).draw(g);
    }
    
    public void setCurrentShapeType(int type) {
        currentShapeType=type;
    }
    
    public void setTickness( boolean tick ){
        this.tickness = tick;
    }
    
    public void setCurrentColor(Color color) {
        currentColor=color;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if( currentShapeType == PEN ){
            this.auxLine = new Line();
            this.auxLine.setColor(currentColor);
            if( tickness ){
                this.auxLine.setTickness(5);
            }
            this.auxLine.add( e.getPoint() );
            this.shapes.add(auxLine);
        }
        if( currentShapeType == CIRCLE ){
            this.auxOval = new Oval(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, false);
        }
        if( currentShapeType == RECTANGLE ){
            this.auxRectangle = new Rectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, false);
        }
        if( currentShapeType == LINE ){
        
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if( auxOval != null ){
            shapes.add( auxOval );
            auxOval = null;
        }
        if( auxRectangle != null ){
            shapes.add( auxRectangle );
            auxRectangle = null;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if( currentShapeType == PEN ){
            this.auxLine.add( e.getPoint() );
        }
        if( currentShapeType == CIRCLE ){
            this.auxOval.setX2(e.getX());
            this.auxOval.setY2(e.getY());
        }
        if( currentShapeType == RECTANGLE ){
            this.auxRectangle.setX2(e.getX());
            this.auxRectangle.setY2(e.getY());
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
