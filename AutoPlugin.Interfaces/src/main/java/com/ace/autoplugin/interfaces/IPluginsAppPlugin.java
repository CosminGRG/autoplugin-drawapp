/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.autoplugin.interfaces;

import java.util.ArrayList;

/**
 *
 * @author catalin
 */
public interface IPluginsAppPlugin {
     String getUniqueNameText();
     String getDisplayText();
     IShape getShape();
}
