/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapplication;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.KeyStroke;

/**
 *
 * @author pablo
 */
public class MenuStructure
{
    private static HashMap<MenuObject, List<MenuObject>> structure;
    private static List<MenuObject> menus;
    
    static
    {
        MenuObject separator = new MenuObject();
        separator.setSeparator(true);
        
        MenuStructure.structure = new HashMap<>();
        
        MenuObject archivo = new MenuObject(CommandNames.CAPTION_MENU_ARCHIVO, KeyEvent.VK_A);
        List<MenuObject> itemsArchivo = new ArrayList<>();
        itemsArchivo.add( new MenuObject(CommandNames.CAPTION_ITEM_NUEVO, KeyEvent.VK_N, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)) );
        itemsArchivo.add( new MenuObject(CommandNames.CAPTION_ITEM_ABRIR, KeyEvent.VK_B,  KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK)) );
        itemsArchivo.add( new MenuObject(CommandNames.CAPTION_ITEM_GUARDAR, KeyEvent.VK_G,  KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK)) );
        itemsArchivo.add( new MenuObject(CommandNames.CAPTION_ITEM_GUARDAR_COMO, KeyEvent.VK_U,  KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK|ActionEvent.ALT_MASK)) );
        itemsArchivo.add( separator );
        itemsArchivo.add( new MenuObject(CommandNames.CAPTION_ITEM_SALIR, KeyEvent.VK_S,  KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK)) );
        MenuStructure.structure.put(archivo, itemsArchivo);
        
        
        MenuObject edicion = new MenuObject(CommandNames.CAPTION_MENU_EDICION, KeyEvent.VK_E );
        List<MenuObject> itemsEdicion = new ArrayList<>();
        itemsEdicion.add( new MenuObject(CommandNames.CAPTION_ITEM_CORTAR, KeyEvent.VK_O, KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK) ) );
        itemsEdicion.add( new MenuObject(CommandNames.CAPTION_ITEM_COPIAR, KeyEvent.VK_C, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK) ) );
        itemsEdicion.add( new MenuObject(CommandNames.CAPTION_ITEM_PEGAR, KeyEvent.VK_P, KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK) ) );
        itemsEdicion.add( new MenuObject(CommandNames.CAPTION_ITEM_BORRAR, KeyEvent.VK_B, KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK)) );
        MenuStructure.structure.put(edicion, itemsEdicion);
        
        MenuObject ayuda = new MenuObject(CommandNames.CAPTION_MENU_AYUDA, KeyEvent.VK_Y );
        List<MenuObject> itemsAyuda = new ArrayList<>();
        itemsAyuda.add( new MenuObject(CommandNames.CAPTION_ITEM_AYUDA, KeyEvent.VK_U ) );
        itemsAyuda.add( new MenuObject(CommandNames.CAPTION_ITEM_ACERCA_DE, KeyEvent.VK_C ) );
        MenuStructure.structure.put(ayuda, itemsAyuda);
        
        MenuStructure.menus = new ArrayList<>();
        MenuStructure.menus.add(archivo);
        MenuStructure.menus.add(edicion);
        MenuStructure.menus.add(ayuda);
        
    }
    
    static public List<MenuObject> getMenus()
    {
        return MenuStructure.menus;
    }
    
    static public List<MenuObject> getMenuItems( MenuObject menu )
    {
        return MenuStructure.structure.get(menu);
    }
}
