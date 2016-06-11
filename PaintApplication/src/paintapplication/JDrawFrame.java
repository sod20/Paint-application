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
    
    private JFileChooser fc;
    private JPaintPanel panel;
    private JScrollPane scroll;
    
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
        
        this.fc = new JFileChooser();
        this.fc.addChoosableFileFilter( new FileNameExtensionFilter("Archivos de Imagen", "png", "jpg", "jpeg", "bmp") );
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
        ImageIcon iconPen = new ImageIcon( "images/tool_pencil.png" );
        ImageIcon iconRedo = new ImageIcon( "images/do_redo.png" );
        ImageIcon iconUndo = new ImageIcon( "images/do_undo.png" );
        ImageIcon iconBrush = new ImageIcon( "images/tool_brush.png" );
        
        ButtonGroup group = new ButtonGroup();
        group.add( this.createToolButton( toolbar, iconPen, true, CommandNames.COMMAND_PEN_BUTTON) );
        group.add( this.createToolButton( toolbar, iconBrush, true, CommandNames.COMMAND_BRUSH_BUTTON) );
        group.add( this.createToolButton( toolbar, iconUndo, true, CommandNames.COMMAND_UNDO_BUTTON) );
        group.add( this.createToolButton( toolbar, iconRedo, true, CommandNames.COMMAND_REDO_BUTTON) );
        
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
             case CommandNames.COMMAND_PEN_BUTTON:
                 System.out.println("Presionado Lapiz");
                break;
            case CommandNames.COMMAND_BRUSH_BUTTON:
                System.out.println("Presionado Brocha");
                break;
            case CommandNames.COMMAND_REDO_BUTTON:
                System.out.println("Presionado Rehacer");
                break;
            case CommandNames.COMMAND_UNDO_BUTTON:
                System.out.println("Presionado Deshacer");
                break;
        }
    }
}
