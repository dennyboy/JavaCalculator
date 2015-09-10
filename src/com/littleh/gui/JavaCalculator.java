package com.littleh.gui;

import com.littleh.math.Operations;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.font.TextAttribute;
import java.text.AttributedString;


/**
 * Created by Dennis on 9/7/2015.
 */
public class JavaCalculator extends JFrame {

    JTextPane displayBox;
    JPanel jPanel;
    String operation;
    double a;
    double b;
    double c;
    Operations operations = new Operations();
    Boolean bin = null;

    public static void main(String[] args) {
        JavaCalculator javaCalculator = new JavaCalculator();
    }


    public JavaCalculator() {
        setFrame();
        setButtons();

    }


    public void setFrame() {

        Frame frame = this;
        frame.setLayout(new BorderLayout());
        frame.setTitle("Java Calculator");
        frame.setSize(new Dimension(300, 400));
        frame.setVisible(true);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);


        jPanel = new JPanel();
        jPanel.setSize(new Dimension(300, 400));
        jPanel.setLayout(new GridBagLayout());
        frame.add(jPanel, BorderLayout.NORTH);

        displayBox = new JTextPane();
        StyledDocument styledDocument = displayBox.getStyledDocument();
        SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(simpleAttributeSet, StyleConstants.ALIGN_RIGHT);
        styledDocument.setParagraphAttributes(0, styledDocument.getLength(), simpleAttributeSet, false);
        jPanel.add(displayBox, quickGridBagConstraints(0, 0, 4, 1));


    }



    public void setButtons() {


        MouseClickedListener numberListener = getNumberListener();


        JButton jButton9 = quickJButton("9", 2, 1, 1, 1, numberListener);
        JButton jButton8 = quickJButton("8", 1, 1, 1, 1, numberListener);
        JButton jButton7 = quickJButton("7", 0, 1, 1, 1, numberListener);
        JButton jButton6 = quickJButton("6", 2, 2, 1, 1, numberListener);
        JButton jButton5 = quickJButton("5", 1, 2, 1, 1, numberListener);
        JButton jButton4 = quickJButton("4", 0, 2, 1, 1, numberListener);
        JButton jButton3 = quickJButton("3", 2, 3, 1, 1, numberListener);
        JButton jButton2 = quickJButton("2", 1, 3, 1, 1, numberListener);
        JButton jButton1 = quickJButton("1", 0, 3, 1, 1, numberListener);
        JButton jButton0 = quickJButton("0", 1, 4, 1, 1, numberListener);
        JButton jButtonClear = quickJButton("Clear",0,5,1,1, getClearListener());
        JButton jButtonDecimal = quickJButton(".",0,4,1,1, getDecimalListener());
        JButton jButtonEquals = quickJButton("=",2,6,1,1,getEqualsListener());
        JButton jButtonAdd = quickJButton("+", 2, 4, 1, 1, getMathOpListener("add", true));
        JButton jButtonSubtract = quickJButton("-", 2, 5, 1, 1, getMathOpListener("subtract", true));
        JButton jButtonMultiply = quickJButton("*", 1, 5, 1, 1, getMathOpListener("multiply", true));
        JButton jButtonDivide = quickJButton("/", 1, 6, 1, 1, getMathOpListener("divide", true));

        JButton jButtonSquare = quickJButton("<html>x<sup>2</sup></html>", 0, 6, 1, 1, getMathOpListener("square", false));

        JButton jButtonCube = quickJButton("<html>x<sup>3</sup></html>", 0, 7, 1, 1, getMathOpListener("cube", false));
        JButton jButtonMod = quickJButton("mod", 1, 7, 1, 1, getMathOpListener(("mod"), true));

        matchButtonSizes();
        this.revalidate();

    }





    private void clearDisplay() {
        displayBox.setText("");
    }


    /**
     * Shortcut method for the buttons
     * @param caption
     * @param x position on grid
     * @param y position on grid
     * @param gridWidth width of button
     * @param gridHeight width of button
     * @param mouseClickedListener listener
     * @return jButton that has x & y position on grid, <br>
     *     width and height, and an action listener
     */
    private JButton quickJButton(String caption, int x, int y, int gridWidth,
                                 int gridHeight, MouseClickedListener mouseClickedListener) {

        JButton jButton = new JButton(caption);
        jButton.addActionListener(mouseClickedListener);
        jPanel.add(jButton, quickGridBagConstraints(x, y, gridWidth, gridHeight));
        return jButton;
    }


    /**
     * Matches all the buttons' preferred sizes based on
     * the first button that is added
     */
    private void matchButtonSizes() {
        int i = 0;
        JButton jb = new JButton();
        for (Component component: jPanel.getComponents()) {
            if (component.getClass() == JButton.class) {
                if (i == 0) {
                    jb = (JButton) component;
                }
                component.setPreferredSize(jb.getPreferredSize());

                i++;
            }
        }
    }



    private GridBagConstraints quickGridBagConstraints(int gridX, int gridY,
                                                       int gridWidth, int gridHeight) {
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




    /***************************************************************************************
     * Listeners                                                                           *
     ***************************************************************************************/


    private MouseClickedListener getClearListener(){
        MouseClickedListener mouseClickedListener = new MouseClickedListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearDisplay();
            }
        };

        return mouseClickedListener;

    }

    private MouseClickedListener getNumberListener(){
        MouseClickedListener mouseClickedListener = new MouseClickedListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton jButton = (JButton) actionEvent.getSource();
                String display = displayBox.getText();
                display += jButton.getText();
                displayBox.setText(display);
            }
        };
        return mouseClickedListener;
    }

    private MouseClickedListener getDecimalListener(){

        MouseClickedListener mouseClickedListener = new MouseClickedListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String display = displayBox.getText();
                if (display.indexOf(".") == -1) {
                    displayBox.setText(display + ".");
                }
            }
        };

        return mouseClickedListener;

    }

    private MouseClickedListener getEqualsListener(){
        MouseClickedListener mouseClickedListener= new MouseClickedListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!Double.isNaN(a)) {
                    if (bin) {
                        b = Double.valueOf(displayBox.getText());
                        c = operations.run(operation, a, b);

                    } else {
                        c = operations.run(operation, a);
                    }
                    displayBox.setText(Double.toString(c));
                    a = Double.NaN;
                    b = Double.NaN;
                    c = Double.NaN;
                    bin = null;
                }
            }
        };

        return mouseClickedListener;

    }

    private MouseClickedListener getMathOpListener(String op, Boolean isBin) {
        MouseClickedListener mouseClickedListener;
        final String o = op;
        final Boolean aBoolean = isBin;
        mouseClickedListener = new MouseClickedListener() {@Override
                                                           public void actionPerformed(ActionEvent actionEvent) {

            operation = o;
            bin = aBoolean;
            a = Double.valueOf(displayBox.getText());
            clearDisplay();
        }
        };

        return mouseClickedListener;
    }




}