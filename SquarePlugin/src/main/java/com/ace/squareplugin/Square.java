/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.squareplugin;

import com.ace.autoplugin.interfaces.*;
import com.ace.menu.*;
import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author ykscr
 */
public class Square implements IShape {
    private static String name = "Square";
    
    int sideLength;
    
    public Square()
    {

    }
    
    @Override
    public void read() {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
      
        System.out.println("Side length:");
        
        int sideLength = input.nextInt();
        
        this.sideLength = sideLength;
        
        ConsoleController.Clear();
        System.out.println("Shape added " + name);
        System.out.println("");
        System.out.println("");
    }
    
    @Override
    public void draw() {
        System.out.println(name + "with side length: " + sideLength);
    }

    public String getInfo() {
        String info = name;
        info += " Side length: " + this.sideLength;
        return info;
    }
}
