package com.littleh.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Class so I can ignore the other methods of ActionListener that <br>
 * need to be overridden
 */
abstract public class MouseClickedListener implements ActionListener {


    @Override
    abstract public void actionPerformed(ActionEvent actionEvent);

}

