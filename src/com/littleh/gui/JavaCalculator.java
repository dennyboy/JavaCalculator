package com.littleh.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dennis on 9/7/2015.
 */
public class JavaCalculator extends JFrame{



    public JavaCalculator(){
        setFrame();

    }


    public void setFrame(){
        setTitle("Java Calculator");
        setSize(new Dimension(300,400));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        JPanel jPanel = new JPanel();
        jPanel.setSize(new Dimension(300,400));
        add(jPanel);

        JTextField displayBox = new JTextField();
        displayBox.setPreferredSize(new Dimension(290,25));
        displayBox.setSize(new Dimension(290,25));
        displayBox.setEditable(false);
        jPanel.add(displayBox);

    }


    public static void main(String[] args){
        JavaCalculator javaCalculator = new JavaCalculator();
    }



}
