/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.rectangle;

import com.ace.autoplugin.interfaces.IShape;
import java.util.Scanner;
import com.ace.menu.ConsoleController;
import java.awt.Point;
import java.util.InputMismatchException;
/**
 *
 * @author ykscr
 */
public class Rectangle implements IShape {

    /*
    Point leftUp;
    Point rightDown;

    public Rectangle(double leftX, double leftY, double rightX, double rightY)
    {
        Point leftUp = new Point(leftX, leftY);
        Point leftDown = new Point(rightX, rightY);
    }
    */
    private static String name = "Rectangle";
    
    int width;
    int length;

    @Override
    public void draw() {
        String symbol = "*";

        System.out.println("Rectangle with Length " + length + " and width " + width + "; ");
        for (int i = 0; i < this.length; i++)
        {
            System.out.println("");
            for (int j = 0; j < this.width; j++)
            {
                if (i == 0 || i == this.length - 1)
                {
                        System.out.print(symbol);
                }
                else if (j == 0 || j == this.width - 1)
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

        System.out.println("Length and Width:");

        int length = input.nextInt();
        int width = input.nextInt();
        
        this.length = length;
        this.width = width;

        ConsoleController.Clear();
        System.out.println("Shape added - Rectangle");
        System.out.println("Length: " + length + "; " + "Width: " + width + ";");
        System.out.println("");
    }

    public String getInfo() {
        String info = name;
        info += " - Width: " + this.width + " Length: " + this.length;
        return info;
    }
}
