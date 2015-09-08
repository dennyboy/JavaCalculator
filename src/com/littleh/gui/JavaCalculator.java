package com.littleh.gui;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Dennis on 9/7/2015.
 */
public class JavaCalculator extends JFrame{

    JTextPane displayBox;
    JPanel jPanel;

    public JavaCalculator(){
        setFrame();
        setButtons();

    }


    public void setFrame(){


        setLayout(new BorderLayout());

        setTitle("Java Calculator");
        setSize(new Dimension(300,400));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        GridBagLayout gridLayout = new GridBagLayout();

        jPanel = new JPanel();
        jPanel.setSize(new Dimension(300,400));
        add(jPanel, BorderLayout.NORTH);
        jPanel.setLayout(gridLayout);

         displayBox = new JTextPane();
        StyledDocument styledDocument = displayBox.getStyledDocument();
        SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(simpleAttributeSet,
                                    StyleConstants.ALIGN_RIGHT);
        styledDocument.setParagraphAttributes(0, styledDocument.getLength(),
                                    simpleAttributeSet, false);

        jPanel.add(displayBox, quickGridBagConstraints(0, 0, 4, 1));


    }



    public void setButtons() {
        MouseClickedListener mouseClickedListener = new MouseClickedListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
               //add stuff here
            }
        };

        JButton jButton9 = new JButton("9");
        JButton jButton8 = new JButton("8");
        JButton jButton7 = quickJButton("7",0,1,1,1,mouseClickedListener);
        JButton jButton6 = new JButton("6");
        JButton jButton5 = new JButton("5");
        JButton jButton4 = new JButton("4");
        JButton jButton3 = new JButton("3");
        JButton jButton2 = new JButton("2");
        JButton jButton1 = new JButton("1");
        JButton jButton0 = new JButton("0");

        jPanel.add(jButton7,
                quickGridBagConstraints(0, 1, 1, 1));
        jPanel.add(jButton8,
                quickGridBagConstraints(1, 1, 1, 1));
        jPanel.add(jButton9,
                quickGridBagConstraints(2, 1, 1, 1));
        jPanel.add(jButton4,
                quickGridBagConstraints(0, 2, 1, 1));
        jPanel.add(jButton5,
                quickGridBagConstraints(1, 2, 1, 1));
        jPanel.add(jButton6,
                quickGridBagConstraints(2, 2, 1, 1));
        jPanel.add(jButton1,
                quickGridBagConstraints(0, 3, 1, 1));
        jPanel.add(jButton2,
                quickGridBagConstraints(1, 3, 1, 1));
        jPanel.add(jButton3,
                quickGridBagConstraints(2, 3, 1, 1));
        jPanel.add(jButton0,
                quickGridBagConstraints(1, 4, 1, 1));


        for (Component component : jPanel.getComponents()) {
            if (component.getClass() == JButton.class) {

                JButton jButton = (JButton) component;
                final String x = jButton.getText();

                jButton.addMouseListener(new MouseClickedListener() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {
                        String s = displayBox.getText();
                        displayBox.setText(s += x);
                    }

                });
            }


            JButton jButtonClear = new JButton("Clear");
            jButtonClear.setPreferredSize(jButton0.getPreferredSize());
            jPanel.add(jButtonClear,
                    quickGridBagConstraints(0, 4, 1, 1));
            jButtonClear.addMouseListener(new MouseClickedListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    displayBox.setText("");
                }
            });


        }

    }

    private JButton quickJButton(String caption, int x, int y, int gridWidth,
                                 int gridHeight, MouseClickedListener mouseClickedListener){

        JButton jButton = new JButton(caption);
        jButton.addMouseListener(mouseClickedListener);
        jPanel.add(jButton, quickGridBagConstraints(x,y,gridWidth,gridHeight));


        return jButton;
    }








    private GridBagConstraints quickGridBagConstraints(int gridX, int gridY,
                                                       int gridWidth, int gridHeight){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.gridx = gridX;
        gridBagConstraints.gridy = gridY;
        gridBagConstraints.gridwidth = gridWidth;
        gridBagConstraints.gridheight = gridHeight;

        return gridBagConstraints;
    }


    public static void main(String[] args){
        JavaCalculator javaCalculator = new JavaCalculator();
    }



}
