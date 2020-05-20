/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.draw;

import com.ace.autoplugin.interfaces.IShape;
import com.ace.menu.ConsoleController;
import java.awt.Point;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author ykscr
 */
public class Canvas {
    int width;
    int height;
    
    private ArrayList<IShape> shapeList = new ArrayList<IShape>();

    public Canvas(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    
    public void AddShape(IShape shape)
    {
        try
        {
            shape.setObserver(this);
            shape.read();
            shapeList.add(shape);
        }
        catch(InputMismatchException error)
        {
            System.out.println("Input Mismatch.");
        }
    }
	
    public ArrayList<IShape> getShapeList()
    {
        return shapeList;
    }
	
    public boolean ViewCanvasAsList()
    {
        ConsoleController.Clear();
        System.out.println("Canvas size: " + width + " x " + height);
        if (shapeList.size() == 0)
        {
                System.out.println("");
                System.out.println("Canvas is empty.");
                System.out.println("");
                return false;
        }
        int index = 0;
        System.out.println("Index : Shape Type");
        for (IShape item : shapeList)
        {
            System.out.println(index + " : " + item.getInfo());
            index++;
        }
        System.out.println("");
        return true;
    }
	
    public void ViewCanvas()
    {
        ConsoleController.Clear();
        if (shapeList.size() == 0)
        {
            System.out.println("");
            System.out.println("Canvas is empty.");
            System.out.println("");
        }
        for (IShape item : shapeList)
        {
            item.draw();
        }
        System.out.println("");
    }
    
    public void UpdateCanvas(IShape shape)
    {
        int padding = 5;
        Point[] shapeCoords = shape.getCoords();
        for (Point point : shapeCoords)
        {
            if (point.x > this.width)
            {
                this.width += point.x + padding;
                System.out.println("Canvas size updated - Width: " + width);
            }
            if (point.y > this.height)
            {
                this.height += point.y + padding;
                System.out.println("Canvas size updated - Height: " + height);
            }
        }
    }
    
    public String getSize()
    {
        String size = new String();
        size += width + " x " + height;
        
        return size;
    }
}

