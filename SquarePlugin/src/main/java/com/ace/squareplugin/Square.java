/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.squareplugin;

import com.ace.autoplugin.interfaces.*;
import com.ace.draw.Canvas;
import com.ace.menu.*;
import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author ykscr
 */
public class Square implements IShape {
    private static String name = "Square";
    
    Canvas canvasObserver = null;
    
    Point[] points = {
        new Point(),
        new Point()
    };
    
    int sideLength;
    
    public Square()
    {
        String symbol = "*";
        
        for (int i = 0; i < this.sideLength; i++)
        {
            System.out.println("");
            for (int j = 0; j < this.sideLength; j++)
            {
                if (i == 0 || i == this.sideLength - 1)
                {
                        System.out.print(symbol);
                }
                else if (j == 0 || j == this.sideLength - 1)
                {
                        System.out.print(symbol);
                }
                else
                {
                        System.out.print(" ");
                }
            }
        }
        System.out.println("");
    }
    
    @Override
    public void read() {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
      
        System.out.println("Point: ");
        System.out.println("X: ");
        points[0].x = input.nextInt();
        System.out.println("Y: ");
        points[0].y = input.nextInt();
        
        points[1].x = points[0].y;
        points[1].y = points[0].x;
        
        this.sideLength = Math.abs(points[0].x - points[1].x);
        
        ConsoleController.Clear();
        System.out.println("Shape added " + name);
        int i = 0;
        for (Point point : points)
        {
            System.out.println("Point " + i++ + ": (" + point.x + ", " + point.y + "); ");
        }
        System.out.println("Side length: " + this.sideLength);
        System.out.println("");
        
        notifyObserver();
    }
    
    @Override
    public void draw() {
        System.out.println(name + " with coordinates: ");
        int i = 0;
        for (Point point : points)
        {
            System.out.println("Point" + i++ + " (" + point.x + ", " + point.y + "); ");
        }
        System.out.println(name + " with side length: " + sideLength);
    }

    public String getInfo() {
        String info = name;
        info += " - Side length: " + this.sideLength;
        int i = 0;
        for (Point point : points)
        {
            info += " \n Point " + i + ": X = " + point.x + " Y = " + point.y;
            i++;
        }    
        return info;
    }
    
    @Override
    public Point[] getCoords()
    {
        return points;
    }
    
    @Override
    public void setObserver(Canvas observer)
    {
        canvasObserver = observer;
    }
    
    @Override
    public void notifyObserver()
    {
        canvasObserver.UpdateCanvas(this);
    }
}
