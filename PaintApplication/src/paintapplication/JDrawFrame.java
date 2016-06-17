/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alejandro Naranjo
 */
public class JDrawFrame extends JFrame implements ActionListener{
    
    private JFileChooser fileChooser;
    private JPaintPanel panel;
    private JScrollPane scroll;
    
    private int PEN = 22;
    private int CIRCLE = 33;
    private int RECTANGLE = 44;
    private int LINE = 55;
    private int VECTOR = 66;
    
    public JDrawFrame(){
        super( "Aplicación de Dibujo" );
        
        try {
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception e){
            System.out.println("Error en look&feel");
        }
        
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        super.setMaximumSize(DimMax);
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setMinimumSize( new Dimension(800, 600) );
        
        this.fileChooser = new JFileChooser();
        this.fileChooser.addChoosableFileFilter( new FileNameExtensionFilter("Archivos de Imagen", "png", "jpg", "jpeg", "bmp") );
        this.panel = new JPaintPanel();
        this.scroll = new JScrollPane(panel);
        super.setLayout( new BorderLayout() );
        super.add( scroll, BorderLayout.CENTER );
        
        this.createMenu();
        this.createToolbar();
    }
    
    private void createMenu()
    {
        JMenuBar menuBar = new JMenuBar();
        List<MenuObject> menusObject = MenuStructure.getMenus();
        for( MenuObject menuObject : menusObject )
        {
           JMenu menu = this.addMenu(menuObject);
           List<MenuObject> itemsObject = MenuStructure.getMenuItems(menuObject);
           for( MenuObject itemObject : itemsObject )
           {
               this.addMenuItem(menu, itemObject);
           }
           menuBar.add(menu);
        }
        super.setJMenuBar(menuBar);
    }
    
     private JMenu addMenu( MenuObject menuObject )
    {
        JMenu menu = new JMenu( menuObject.getName() );
        menu.setMnemonic( menuObject.getMnemonic() );
        if( menuObject.hasAccelerator() )
        {
            menu.setAccelerator( menuObject.getAccelerator() );
        }
        return menu;
    }
    
    private void addMenuItem( JMenu parent, MenuObject itemObject )
    {
        if( itemObject.isSeparator() )
        {
            parent.addSeparator();
            return;
        }
        JMenuItem item = new JMenuItem(itemObject.getName());
        if( itemObject.hasMnemonic() )
        {
            item.setMnemonic(itemObject.getMnemonic());
        }
        if( itemObject.hasAccelerator() )
        {
            item.setAccelerator( itemObject.getAccelerator() );
        }
        item.setActionCommand(itemObject.getName());
        item.addActionListener(this);
        parent.add(item);
    }
    
    private void createToolbar()
    {
        JToolBar toolbar = new JToolBar();
        ButtonGroup group = new ButtonGroup();
        ButtonGroup groupColor = new ButtonGroup();
        
        ImageIcon iconNew = new ImageIcon( "images/doc_new.png" );
        ImageIcon iconSave = new ImageIcon( "images/doc_save.png" );
        ImageIcon iconExport = new ImageIcon( "images/doc_export.png" );
        ImageIcon iconPrint = new ImageIcon( "images/doc_print.png" );

        group.add( this.createToolButton( toolbar, iconNew, true, CommandNames.COMMAND_NEW_BUTTON) );
        group.add( this.createToolButton( toolbar, iconSave, true, CommandNames.COMMAND_SAVE_BUTTON) );
        group.add( this.createToolButton( toolbar, iconExport, true, CommandNames.COMMAND_EXPORT_BUTTON) );
        group.add( this.createToolButton( toolbar, iconPrint, true, CommandNames.COMMAND_PRINT_BUTTON) );
        
        toolbar.addSeparator();
        ImageIcon iconUndo = new ImageIcon( "images/do_undo.png" );
        ImageIcon iconRedo = new ImageIcon( "images/do_redo.png" );
        group.add( this.createToolButton( toolbar, iconUndo, true, CommandNames.COMMAND_UNDO_BUTTON) );
        group.add( this.createToolButton( toolbar, iconRedo, true, CommandNames.COMMAND_REDO_BUTTON) );
        
        toolbar.addSeparator();
        ImageIcon iconPen = new ImageIcon( "images/tool_pencil.png" );
        ImageIcon iconBrush = new ImageIcon( "images/tool_brush.png" );
        group.add( this.createToolButton( toolbar, iconPen, true, CommandNames.COMMAND_PEN_BUTTON) );
        group.add( this.createToolButton( toolbar, iconBrush, true, CommandNames.COMMAND_BRUSH_BUTTON) );
        
        
        toolbar.addSeparator();
        ImageIcon iconLine = new ImageIcon( "images/tool_line.png" );
        ImageIcon iconRectangle = new ImageIcon( "images/shape_rectangle.png" );
        ImageIcon iconCircle = new ImageIcon( "images/shape_circle.png" );
        ImageIcon iconPolygon = new ImageIcon( "images/shape_polygon.png" );
        ImageIcon iconPolyline = new ImageIcon( "images/shape_polyline.png" );
        group.add( this.createToolButton( toolbar, iconLine, true, CommandNames.COMMAND_LINE_BUTTON) );
        group.add( this.createToolButton( toolbar, iconRectangle, true, CommandNames.COMMAND_RECTANGLE_BUTTON) );
        group.add( this.createToolButton( toolbar, iconCircle, true, CommandNames.COMMAND_CIRCLE_BUTTON) );
        group.add( this.createToolButton( toolbar, iconPolygon, true, CommandNames.COMMAND_POLYGON_BUTTON) );
        group.add( this.createToolButton( toolbar, iconPolyline, true, CommandNames.COMMAND_POLYLINE_BUTTON) );
        
        toolbar.addSeparator();
        ImageIcon iconBlack = new ImageIcon( "images/color_black.png" );
        ImageIcon iconRed = new ImageIcon( "images/color_red.png" );
        ImageIcon iconBlue = new ImageIcon( "images/color_blue.png" );
        ImageIcon iconYellow = new ImageIcon( "images/color_yellow.png" );
        groupColor.add( this.createToolButton( toolbar, iconBlack, true, CommandNames.COMMAND_COLOR_BLACK) );
        groupColor.add( this.createToolButton( toolbar, iconBlue, true, CommandNames.COMMAND_COLOR_BLUE) );
        groupColor.add( this.createToolButton( toolbar, iconYellow, true, CommandNames.COMMAND_COLOR_YELLOW) );
        groupColor.add( this.createToolButton( toolbar, iconRed, true, CommandNames.COMMAND_COLOR_RED) );
        
        this.add( toolbar, BorderLayout.PAGE_START );
    }
    
    private JToggleButton createToolButton( JToolBar toolbar, Icon icon, boolean state, String actionCommand )
    {
        JToggleButton button = new JToggleButton( icon );
        button.setSelected(state);
        button.setActionCommand(actionCommand);
        toolbar.add(button);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch( e.getActionCommand() ){
            case CommandNames.COMMAND_SAVE_BUTTON:
                int result = this.fileChooser.showSaveDialog(panel);
                if( result == JFileChooser.APPROVE_OPTION ){
                    this.panel.saveTo( this.fileChooser.getSelectedFile() );
                }
                break;
             case CommandNames.COMMAND_PEN_BUTTON:
                panel.setCurrentShapeType(PEN);
                panel.setTickness(false);
                break;
            case CommandNames.COMMAND_BRUSH_BUTTON:
                panel.setTickness(true);
                break;
            case CommandNames.COMMAND_REDO_BUTTON:
                System.out.println("Presionado Rehacer");
                break;
            case CommandNames.COMMAND_UNDO_BUTTON:
                System.out.println("Presionado Deshacer");
                break;
            //FORMAS
            case CommandNames.COMMAND_LINE_BUTTON:
                panel.setCurrentShapeType(VECTOR);
                break;
            case CommandNames.COMMAND_CIRCLE_BUTTON:
                panel.setCurrentShapeType(CIRCLE);
                break;
            case CommandNames.COMMAND_RECTANGLE_BUTTON:
                panel.setCurrentShapeType(RECTANGLE);
                break;
            //COLORES
            case CommandNames.COMMAND_COLOR_BLACK:
                panel.setCurrentColor(Color.BLACK);
                break;
            case CommandNames.COMMAND_COLOR_RED:
                panel.setCurrentColor(Color.RED);
                break;
            case CommandNames.COMMAND_COLOR_YELLOW:
                panel.setCurrentColor(Color.YELLOW);
                break;
            case CommandNames.COMMAND_COLOR_BLUE:
                panel.setCurrentColor(Color.BLUE);
                break;
        }
    }
}
