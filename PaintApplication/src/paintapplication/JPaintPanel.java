/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintapplication;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import shapes.Line;
import shapes.Shape;

/**
 *
 * @author Alejandro Naranjo
 */
class JPaintPanel extends JPanel implements MouseListener, MouseMotionListener{
    
    private int currentShapeType;
    private Shape currentShapeObject;
    private Color currentShapeColor;
    
    private ArrayList<Shape> shapes;
    private Line auxLine;
    
    public JPaintPanel(){
        
        currentShapeType=0;
        currentShapeObject=null;
        currentShapeColor=Color.BLACK;
        
        shapes = new ArrayList<Shape>();
        
        super.setBackground( Color.WHITE );
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }    
    
    public void paint( Graphics g )
    {
        super.paintComponent( g );
        
        if( auxLine != null ){
            auxLine.draw(g);
        }
        
        for ( int i = 0; i< shapes.size(); i++ )
           shapes.get(i).draw(g);
    }
    
    public void setCurrentShapeType(int type) {
        currentShapeType=type;
    }
    
    public void setCurrentShapeColor(Color color) {
        currentShapeColor=color;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.auxLine = new Line();
        this.auxLine.add( e.getPoint() );
        this.shapes.add(auxLine);
        repaint();
        /*switch (currentShapeType) {
            
        }*/
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.auxLine.add( e.getPoint() );
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
