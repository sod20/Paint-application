/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapplication;

import javax.swing.KeyStroke;

/**
 *
 * @author pablo
 */
public class MenuObject
{
    private String name;
    private int mnemonic;
    private KeyStroke accelerator;
    private boolean separator;

    public MenuObject()
    {
    }
    
    public MenuObject(String name)
    {
        this.name = name;
        this.mnemonic = -1;
        this.accelerator = null;
        this.separator = false;
    }
    
    public MenuObject(String name, int mnemonic)
    {
        this.name = name;
        this.mnemonic = mnemonic;
        this.accelerator = null;
        this.separator = false;
    }
    
    public MenuObject(String name, KeyStroke accelerator)
    {
        this.name = name;
        this.accelerator = accelerator;
    }
    
    public MenuObject(String name, int mnemonic, KeyStroke accelerator)
    {
        this(name, mnemonic);
        this.accelerator = accelerator;
    }
    
    public boolean hasMnemonic()
    {
        return (this.mnemonic != -1);
    }

    public void setSeparator(boolean separator)
    {
        this.separator = separator;
    }

    public boolean isSeparator()
    {
        return separator;
    }
    
    public KeyStroke getAccelerator()
    {
        return accelerator;
    }

    public void setAccelerator(KeyStroke accelerator)
    {
        this.accelerator = accelerator;
    }

    public int getMnemonic()
    {
        return mnemonic;
    }

    public void setMnemonic(int mnemonic)
    {
        this.mnemonic = mnemonic;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public boolean hasAccelerator()
    {
        return (this.accelerator != null);
    }
}
