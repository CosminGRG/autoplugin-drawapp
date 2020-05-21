/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.rectangle;

import com.ace.autoplugin.interfaces.IShape;
import com.ace.draw.Canvas;
import java.util.Scanner;
import com.ace.menu.ConsoleController;
import java.awt.Point;
import java.util.InputMismatchException;
/**
 *
 * @author ykscr
 */
public class Rectangle implements IShape {
    private static String name = "Rectangle";
    
    Canvas canvasObserver = null;
    
    Point[] points = {
        new Point(),
        new Point()
    };
    
    int width;
    int length;

    @Override
    public void draw() {
        String symbol = "*";

        System.out.println("Rectangle with Length " + length + " and Width " + width + "; ");
        for (int i = 0; i < this.width; i++)
        {
            System.out.println("");
            for (int j = 0; j < this.length; j++)
            {
                if (i == 0 || i == this.width - 1)
                {
                        System.out.print(symbol);
                }
                else if (j == 0 || j == this.length - 1)
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
        
        for (int i = 0; i < points.length; i++)
        {
            System.out.println("Point: " + i);
            System.out.println("X: ");
            points[i].x = input.nextInt();
            System.out.println("Y: ");
            points[i].y = input.nextInt();     
        }
        
        int length = Math.abs(points[0].x - points[1].x);
        int width = Math.abs(points[0].y - points[1].y);
        
        this.length = length;
        this.width = width;
        

        ConsoleController.Clear();
        System.out.println("Shape added - Rectangle");
        int i = 0;
        for (Point point : points)
        {
            System.out.println("Point " + i++ + ": (" + point.x + ", " + point.y + "); ");
        }
        System.out.println("Length: " + length + "; " + "Width: " + width + ";");
        System.out.println("");
        
        notifyObserver();
    }

    public String getInfo() {
        String info = name;
        int i = 0;
        info += " - Width: " + this.width + " Length: " + this.length;
        for (Point point : points)
        {
            info += " \n Point " + i + ": X = " + point.x + " Y = " + point.y;
            i++;
        }    
        return info;
    }
    
    @Override
    public void setObserver(Canvas observer)
    {
        canvasObserver = observer;
    }
    
    private void notifyObserver()
    {
        canvasObserver.UpdateCanvas(this, points);
    }
}
