/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.menu;

import com.ace.autoplugin.interfaces.IShape;
import com.ace.draw.DrawController;
import com.ace.autoplugin.*;
import java.util.ArrayList;

/**
 *
 * @author ykscr
 */
public class ApplicationMenu{
    
    private PluginManager pluginMan;
    private DrawController drawController;
    
    private ArrayList<String> existingMenu = new ArrayList<String>();
    
    public ApplicationMenu(PluginManager pluginMan, DrawController drawController)
    {
        this.pluginMan = pluginMan;     
        this.drawController = drawController;
    }
    
    public void load()
    {
        try 
        {
                pluginMan.loadPlugins("/plugins");
        }
        catch (NullPointerException error)
        {
            System.out.println("Null Pointer Exception - Did you forgot the plugins folder?");
            System.exit(0);
        }
        
        int shortCut = 1;
        var plugins = pluginMan.getPlugins();
     
        Menu mainMenu = new Menu("Main Menu");
        Menu addShapeSubMenu = new Menu("Add New Shape");
        mainMenu.AddSubMenu(1, "Add Shape", addShapeSubMenu);
        mainMenu.AddMenuItem(2, "Delete Shape", (parameters) -> {
            ConsoleController.Clear();
            drawController.DeleteShape();
	});
        mainMenu.AddMenuItem(3, "Modify Shape", (parameters) -> {
            ConsoleController.Clear();
            drawController.ModifyShape();
	});
        mainMenu.AddMenuItem(4, "View Canvas ", (parameters) -> {
            drawController.ViewCanvas();
        });
        
        for (int i = 0 ; i < plugins.size(); i++)
        {      
           var currentPlugin = plugins.get(i); 
           MenuItem currentItem = new MenuItem(shortCut++, plugins.get(i).getDisplayText(), (parameters)->{
               IShape shape = currentPlugin.getShape();
               drawController.Read(shape);
           });
           //menuItems.add(currentItem);
           
           addShapeSubMenu.AddMenuItem(currentItem);
        }
        mainMenu.InitMenu();
    }
}
