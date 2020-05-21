/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.autoplugin.interfaces;
import com.ace.draw.Canvas;
import java.awt.Point;

/**
 *
 * @author ykscr
 */
public interface IShape {
    void read();
    void draw();
    String getInfo();
    void setObserver(Canvas observer);
}
