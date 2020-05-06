/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.menu;

/**
 *
 * @author ykscr
 */
public class MenuItem implements IMenuItem {
	
    private int shortcutNumber;
    private String textMessage;
    @SuppressWarnings("unused")
    private Menu subMenu;
    private IExecutableAction action;

    public MenuItem(int shortcutNumber, String textMessage, Menu subMenu, IExecutableAction action)
    {
        this.shortcutNumber = shortcutNumber;
        this.textMessage = textMessage;
        this.subMenu = subMenu;
        this.action = action;
    }

    public MenuItem(int shortcutNumber, String textMessage, IExecutableAction action)
    {
        this.shortcutNumber = shortcutNumber;
        this.textMessage = textMessage;
        this.action = action;
    }

    public void render()
    {
        System.out.println(shortcutNumber + " "  + textMessage);
    }

    public void execute()
    {
        if (action != null)
        {
            action.execute(new Object[] {this});
        }
    }

    public void setSubMenu(Menu subMenu)
    {
        this.subMenu = subMenu;
    }
}