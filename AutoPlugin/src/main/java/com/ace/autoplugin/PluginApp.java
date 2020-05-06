/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.autoplugin;

import com.ace.menu.*;
import com.ace.draw.*;
/**
 *
 * @author ykscr
 */
public class PluginApp {
    public static void main(String[] args)
    {
        PluginManager pluginMan = new PluginManager();
        
        Canvas canvas = new Canvas();
        DrawController drawController = new DrawController(canvas);
        ApplicationMenu appMenu = new ApplicationMenu(pluginMan, drawController);
        
        appMenu.load();
    }
}
