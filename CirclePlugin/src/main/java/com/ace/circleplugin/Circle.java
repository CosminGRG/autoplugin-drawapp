/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.circleplugin;

import com.ace.draw.Canvas;
import com.ace.autoplugin.interfaces.IShape;
import java.util.Scanner;
import com.ace.menu.ConsoleController;
import java.awt.Point;
import java.util.InputMismatchException;

/**
 *
 * @author ykscr
 */
public class Circle implements IShape {
    private static String name = "Circle";
    
    private Canvas canvasObserver = null;
    
    Point[] points = {
        new Point()
    };
    double radius;

    @Override
    public void draw() 
    {
        String symbol = "*";

        System.out.println();
        System.out.println("Circle with radius " + radius + ";");

        double thickness = 0.2;
        double rIn = radius - thickness, rOut = radius + thickness;

        for (double y = radius; y >= -radius; --y)
        {
                System.out.println();
            for (double x = -radius; x < rOut; x += 0.5)
            {
                double value = x * x + y * y;
                if (value >= rIn * rIn && value <= rOut * rOut)
                {
                    System.out.print(symbol);
                }
                else
                {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }

    @Override
    public void read() {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        
        System.out.println("Center point coordinates: ");
        Point center = new Point();
        center.x = input.nextInt();
        center.y = input.nextInt();
        
        System.out.println("Radius: ");
        double radius = input.nextDouble();
        
        this.radius = radius;
        this.points[0] = center;

        ConsoleController.Clear();
        System.out.println("Shape added - Circle");
        System.out.println("Center point: " + "(" + points[0].x + ", " + points[0].y + ")");
        System.out.println("Radius: " + radius + ";");
        System.out.println("");
        
        notifyObserver();
    }

    @Override
    public String getInfo() {
        String info = name;
        info += " - Radius: " + this.radius + " - Center point: " + "(" + points[0].x + ", " + points[0].y + ");";
        
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
