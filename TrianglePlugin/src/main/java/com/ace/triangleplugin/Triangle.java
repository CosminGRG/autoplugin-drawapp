/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.triangleplugin;

import com.ace.autoplugin.interfaces.*;
import com.ace.menu.ConsoleController;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author ykscr
 */
public class Triangle implements IShape{
    public static String name = "Triangle";
    
    Point[] points = {
        new Point(),
        new Point(),
        new Point()
    };
    
    @Override
    public void draw() {
        for (Point point : points)
        {
            point.toString();
        }
    }
    
    @Override
    public void read() {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 3 points:");
        
        for (int i = 0; i < points.length; i++)
        {
            try
            {
                System.out.println("Point: " + i);
                System.out.println("X: ");
                points[i].x = input.nextInt();
                System.out.println("Y: ");
                points[i].y = input.nextInt();
            }
            catch (InputMismatchException error)
            {
            System.out.println("Input Mismatch.");
            }
        }

        ConsoleController.Clear();
        System.out.println("Shape added - " + name);
        System.out.println("Triangle points coordinates: ");
        for (Point point : points)
        {
            point.toString();
        }
        System.out.println("");
    }
    
    @Override
    public String getInfo() {
        String info = name;
        int i = 0;
        for (Point point : points)
        {
            info += " \n Point " + i + ": X =" + point.x + " Y = " + point.y;
            i++;
        }
        return info;
    }
}
