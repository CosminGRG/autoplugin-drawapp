/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.draw;

import com.ace.menu.ConsoleController;
import com.ace.autoplugin.interfaces.IShape;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ykscr
 */
public class DrawController {
    private Canvas canvas;

    public DrawController(Canvas canvas)
    {
        this.canvas = canvas;
    }

    public void Read(IShape shape)
    {
        canvas.AddShape(shape);
    }

    public void DeleteShape()
    {
        if (canvas.ViewCanvasAsList())
        {
            int option = 0;
            try
            {
                System.out.println("Insert index to delete shape:");

                option = ReadOption();

                if (canvas.getShapeList().get(option) != null)
                {
                        canvas.getShapeList().remove(option);
                        ConsoleController.Clear();
                        System.out.println("Shape deleted.");
                }
            }
            catch (InputMismatchException error)
            {
                    System.out.println("Input Mismatch.");
            }
            catch (IndexOutOfBoundsException error)
            {
                    System.out.println("Index out of bounds.");
            }
            System.out.println("");
        }
    }

    public void ModifyShape()
    {
        if (canvas.ViewCanvasAsList())
        {
            int option = 0;
            try
            {
                System.out.println("Insert index to modify shape:");

                option = ReadOption();

                if (canvas.getShapeList().get(option) != null)
                {
                        canvas.getShapeList().get(option).read();
                        ConsoleController.Clear();
                        System.out.println("Shape modified.");
                }
            }
            catch (InputMismatchException error)
            {
                    System.out.println("Input Mismatch.");
            }
            catch (IndexOutOfBoundsException error)
            {
                    System.out.println("Index out of bounds.");
            }
            System.out.println("");
        }
    }

    public void ViewCanvas()
    {
        System.out.println("1. View as list.");
        System.out.println("2. View shapes.");

        int option = 0;
        try
        {
            System.out.println("Insert your option:");

            option = ReadOption();

            if (option == 1 || option == 2)
            {
                if (option == 1)
                {
                    canvas.ViewCanvasAsList();
                }
                else if (option == 2)
                {
                    canvas.ViewCanvas();
                }
            }
        }
        catch (InputMismatchException error)
        {
                System.out.println("Input Mismatch.");
        }
        System.out.println("");
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    private int ReadOption()
    {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);

        int option = input.nextInt();

        return option;
    }
}
