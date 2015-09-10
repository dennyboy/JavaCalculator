package com.littleh.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;


/**
 * Class so I can ignore the other methods of ActionListener that <br>
 * need to be overridden
 */
abstract public class MouseClickedListener implements ActionListener {


    @Override
    abstract public void actionPerformed(ActionEvent actionEvent);

}

