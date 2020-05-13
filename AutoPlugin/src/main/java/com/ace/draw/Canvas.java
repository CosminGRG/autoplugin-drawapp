/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.draw;

import com.ace.autoplugin.interfaces.IShape;
import com.ace.menu.ConsoleController;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author ykscr
 */
public class Canvas {
    private IShape shape;
    private ArrayList<IShape> shapeList = new ArrayList<IShape>();
	
    public void AddShape()
    {
        
        try
        {
            shape.read();
            shapeList.add(shape);

        }
        catch(InputMismatchException error)
        {
            System.out.println("Input Mismatch.");
        }

    }
	
    public void DrawShape()
    {
        shape.draw();
    }
	
    public void setShape(IShape shape)
    {
        this.shape = shape;
    }
	
    public ArrayList<IShape> getShapeList()
    {
        return shapeList;
    }
	
    public boolean ViewCanvasAsList()
    {
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
}

