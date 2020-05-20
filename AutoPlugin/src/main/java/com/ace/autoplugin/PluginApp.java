/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.autoplugin;

import com.ace.menu.*;
import com.ace.draw.*;
import java.util.Scanner;
/**
 *
 * @author ykscr
 */
public class PluginApp {
    public static void main(String[] args)
    {
        PluginManager pluginMan = new PluginManager();
        
        Scanner scan = new Scanner(System.in);
        
        int width;
        int height;
        
        System.out.println("Please enter the size of the canvas");
        
        width = scan.nextInt();
        height = scan.nextInt();
        
        Canvas canvas = new Canvas(width, height);
        DrawController drawController = new DrawController(canvas);
        ApplicationMenu appMenu = new ApplicationMenu(pluginMan, drawController);
        
        appMenu.load();
    }
}
