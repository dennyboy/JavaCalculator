package com.littleh.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Dennis on 9/7/2015.
 */
abstract public class MouseClickedListener implements MouseListener {


    @Override
    abstract public void mouseClicked(MouseEvent mouseEvent);

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
