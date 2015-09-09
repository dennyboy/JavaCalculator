package com.littleh.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;


/**
 * Created by Dennis on 9/7/2015.
 */
abstract public class MouseClickedListener implements ActionListener {


    @Override
    abstract public void actionPerformed(ActionEvent actionEvent);

}

