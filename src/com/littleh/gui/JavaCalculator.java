package com.littleh.gui;

import com.littleh.math.Operations;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * Created by Dennis on 9/7/2015.
 */
public class JavaCalculator extends JFrame{

    JTextPane displayBox;
    JPanel jPanel;
    String operation;
    double a;
    double b;
    double c;
    Operations operations = new Operations();
    boolean bin;

    public static void main(String[] args){
        JavaCalculator javaCalculator = new JavaCalculator();
    }


    public JavaCalculator(){
        setFrame();
        setButtons();

    }


    public void setFrame(){

        Frame frame = this;
            frame.setLayout(new BorderLayout());
            frame.setTitle("Java Calculator");
            frame.setSize(new Dimension(300, 400));
            frame.setVisible(true);
            super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);


        jPanel = new JPanel();
            jPanel.setSize(new Dimension(300,400));
            jPanel.setLayout(new GridBagLayout());
            frame.add(jPanel, BorderLayout.NORTH);

        displayBox = new JTextPane();
            StyledDocument styledDocument = displayBox.getStyledDocument();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setAlignment(simpleAttributeSet, StyleConstants.ALIGN_RIGHT);
            styledDocument.setParagraphAttributes(0, styledDocument.getLength(),simpleAttributeSet, false);
            jPanel.add(displayBox, quickGridBagConstraints(0, 0, 4, 1));


    }



    public void setButtons() {
        MouseClickedListener buttonClickedListener = new MouseClickedListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton jButton = (JButton) actionEvent.getSource();
                String display = displayBox.getText();
                       display += jButton.getText();
                displayBox.setText(display);
            }
        };




        JButton jButton9 = quickJButton("9", 2, 1, 1, 1, buttonClickedListener);
        JButton jButton8 = quickJButton("8", 1, 1, 1, 1, buttonClickedListener);
        JButton jButton7 = quickJButton("7", 0, 1, 1, 1, buttonClickedListener);
        JButton jButton6 = quickJButton("6", 2, 2, 1, 1, buttonClickedListener);
        JButton jButton5 = quickJButton("5", 1, 2, 1, 1, buttonClickedListener);
        JButton jButton4 = quickJButton("4", 0, 2, 1, 1, buttonClickedListener);
        JButton jButton3 = quickJButton("3", 2, 3, 1, 1, buttonClickedListener);
        JButton jButton2 = quickJButton("2", 1, 3, 1, 1, buttonClickedListener);
        JButton jButton1 = quickJButton("1", 0, 3, 1, 1, buttonClickedListener);
        JButton jButton0 = quickJButton("0", 1, 4, 1, 1, buttonClickedListener);
        JButton jButtonClear = new JButton("Clear");
        JButton jButtonDecimal = new JButton(".");

        JButton jButtonAdd = new JButton("+");
        JButton jButtonMinus = new JButton("-");
        JButton jButtonEquals = new JButton("=");


        jPanel.add(jButtonClear,quickGridBagConstraints(0, 5, 1, 1));
        jPanel.add(jButtonDecimal,quickGridBagConstraints(0,4,1,1));
        jPanel.add(jButtonAdd,quickGridBagConstraints(2,4,1,1));
        jPanel.add(jButtonMinus, quickGridBagConstraints(2,5,1,1));
        jPanel.add(jButtonEquals, quickGridBagConstraints(2,6,1,1));
        matchButtonSizes();





        jButtonClear.addActionListener(new MouseClickedListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayBox.setText("");
            }
        });


        jButtonDecimal.addActionListener(new MouseClickedListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String display = displayBox.getText();
                if(display.indexOf(".") == -1){
                    displayBox.setText(display + ".");
                }
            }
        });

        jButtonAdd.addActionListener(new MouseClickedListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                operation = "add";
                bin = true;
                a = Double.valueOf(displayBox.getText());
                clearDisplay();
            }
        });

        jButtonMinus.addActionListener(new MouseClickedListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                operation = "minus";
                bin = true;
                a = Double.valueOf(displayBox.getText());
                clearDisplay();
            }
        });



        jButtonEquals.addActionListener(new MouseClickedListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!Double.isNaN(a)){
                    if(bin) {
                        b = Double.valueOf(displayBox.getText());
                        c = operations.run(operation,a,b);

                    }else{
                        c = operations.run(operation,a);
                    }
                    displayBox.setText(Double.toString(c));
                    a=Double.NaN;
                    b=Double.NaN;
                    c=Double.NaN;
                }
            }
        });


    }



    private void clearDisplay(){
        displayBox.setText("");
    }



    private JButton quickJButton(String caption, int x, int y, int gridWidth,
                                 int gridHeight, MouseClickedListener mouseClickedListener){

        JButton jButton = new JButton(caption);

        jButton.addActionListener(mouseClickedListener);
        jPanel.add(jButton, quickGridBagConstraints(x,y,gridWidth,gridHeight));
        return jButton;
    }




    private void matchButtonSizes(){
        int i = 0;
        JButton jb = new JButton();
        for(Component component: jPanel.getComponents()){
            if(component.getClass() == JButton.class){
                if(i==0){
                jb = (JButton) component;}
                component.setPreferredSize(jb.getPreferredSize());
                i++;
            }
        }
    }



    private GridBagConstraints quickGridBagConstraints(int gridX, int gridY,
                                                       int gridWidth, int gridHeight){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.gridx = gridX;
        gridBagConstraints.gridy = gridY;
        gridBagConstraints.gridwidth = gridWidth;
        gridBagConstraints.gridheight = gridHeight;

        return gridBagConstraints;
    }





}
