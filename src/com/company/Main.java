package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * This class provides
 * the user with a calculator
 * for decimal, binary, big number
 * and hexadecimal numbers.
 * @author Ian McLean
 * @version 1.0
 */
class Main {

    /**
     * Main method, the starting
     * point for this program sets
     * up which user interface to use
     * and creates the main frame.
     *
     * @param args - command line arguments ignored
     *               in this program.
     */
    public static void main(String[] args) {
        // set up the frame
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        JFrame frame = new JFrame();
        frame.setSize(screenWidth, screenHeight);

        frame.setTitle("Java Calculator");
        var layOut = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(layOut);
        var instructions = instructionText();
        var helpPan = helpPanels();
        frame.add(instructions);
        frame.add(helpPan);
        // make the menubar
        var menuBar = new JMenuBar();
        var calculator = new JMenu("Start");
        var decimal = new JMenuItem("Decimal Calculation");
        var binary = new JMenuItem("Binary Calculation");
        var hexaDec = new JMenuItem("Hexadecimal Calculation");
        var bigNum = new JMenuItem("BigNumber Calculation");
        var binaryConvert = new JMenuItem("Binary to Decimal");
        var hexConvert = new JMenuItem("Hexadecimal to Decimal");
        var decToBinary = new JMenuItem("Decimal to Binary");
        var decToHex = new JMenuItem("Decimal to Hexadecimal");
        var exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        calculator.add(decimal);
        calculator.add(binary);
        calculator.add(hexaDec);
        calculator.add(bigNum);
        calculator.add(binaryConvert);
        calculator.add(hexConvert);
        calculator.add(decToBinary);
        calculator.add(decToHex);
        calculator.add(exit);
        menuBar.add(calculator);
        frame.setVisible(true);

        decimal.addActionListener(e -> {
            var calc = new CalculatorScreen(1);
            calc.setBackground(Color.WHITE);
            calc.setTitle("Decimal Calculator");
            calc.setSize(700, 500);
            calc.setVisible(true);
        });

        binary.addActionListener(e -> {
            var calc = new CalculatorScreen(2);
            calc.setBackground(Color.WHITE);
            calc.setVisible(true);
            calc.setTitle("Binary Calculator");
            calc.setSize(700, 500);
        });

        hexaDec.addActionListener(e -> {
            var calc = new CalculatorScreen(3);
            calc.setBackground(Color.WHITE);
            calc.setVisible(true);
            calc.setTitle("HexaDecimal Calculator");
            calc.setSize(700, 500);
        });

        bigNum.addActionListener(e -> {
            var calc = new CalculatorScreen(4);
            calc.setBackground(Color.WHITE);
            calc.setVisible(true);
            calc.setTitle("BigNumber Calculator");
            calc.setSize(700, 500);
        });

        binaryConvert.addActionListener(e -> {
            var calc = new ConverterScreen(1);
            calc.setBackground(Color.WHITE);
            calc.setVisible(true);
            calc.setTitle("Binary to Decimal");
            calc.setSize(700, 500);
        });

        hexConvert.addActionListener(e -> {
            var calc = new ConverterScreen(2);
            calc.setBackground(Color.WHITE);
            calc.setVisible(true);
            calc.setTitle("Hexadecimal to Decimal");
            calc.setSize(700, 500);
        });
        frame.setJMenuBar(menuBar);

        decToBinary.addActionListener(e -> {
            var calc = new ConverterScreen(3);
            calc.setBackground(Color.WHITE);
            calc.setVisible(true);
            calc.setTitle("Decimal to Binary");
            calc.setSize(700, 500);
        });

        decToHex.addActionListener(e -> {
            var calc = new ConverterScreen(4);
            calc.setBackground(Color.WHITE);
            calc.setVisible(true);
            calc.setTitle("Decimal to Hexadecimal");
            calc.setSize(700, 500);
        });

        frame.setJMenuBar(menuBar);
        frame.validate();
    }

    public static JPanel helpPanels() {

        var pan = new JPanel();
        pan.setSize(200, 200);
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        var helpText1 = new JTextArea(5, 10);
        helpText1.setText("""
                How to use calculators:

                Put the left side of the equation in the left box,
                select the operation and then put right side of
                the equation in the right box. The answer will
                appear in the bottom box. Make sure to type in
                numbers that exist in the number system you are using
                (i.e binary must contain only 1 and 0)""");
        helpText1.setFont(font1);
        var helpText2 = new JTextArea(5, 10);
        helpText2.setFont(font1);
        helpText2.setText("""
                How to use converters:
                
                Enter the number you want to convert into the top
                box and click enter. The answer will be displayed in
                the bottom box. Make sure to type in numbers that exist
                in the number system you are using
                (i.e hexadecimal must contain base 16 numbers)""");
        helpText1.setBackground(Color.DARK_GRAY);
        helpText2.setBackground(Color.DARK_GRAY);
        helpText1.setForeground(Color.WHITE);
        helpText2.setForeground(Color.WHITE);
        pan.add(helpText1);
        pan.add(Box.createHorizontalStrut(10));
        pan.add(helpText2);
        pan.setBackground(Color.DARK_GRAY);
        pan.setVisible(true);
        return pan;
    }

    public static JPanel instructionText() {
        var pan = new JPanel();
        pan.setBackground(Color.DARK_GRAY);
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        var text = new JTextArea("Please click the start button" +
                " to use the calculator operations");
        text.setBackground(Color.DARK_GRAY);
        text.setForeground(Color.white);
        text.setFont(font1);
        pan.add(text);
        return pan;
    }
}

/**
 * This class has a simple calculator
 * screen that works with all
 * CalculatorNumber object children
 * by extending the JFrame class.
 * @author Ian McLean
 * @version 1.0
 */
class CalculatorScreen extends JFrame {

    /**
     * The constructor for this class.
     * opens up a calculator GUI based
     * upon the type of numbers the
     * user wants to calculator with
     */
    CalculatorScreen(int n) {
        CalculatorNumber obj;
        switch (n) {
            case 1 -> obj = new Decimal();
            case 2 -> obj = new Binary();
            case 3 -> obj = new Hexadecimal();
            default -> obj = new BigNumber();
        }
        // establish boxes to type numbers in
        JTextField operand1 = new JTextField(20);
        //JTextField operand2 = new JTextField(20);
        var textPanel = new JPanel();
        textPanel.add(operand1);
        //textPanel.add(operand2);
        textPanel.setBackground(Color.DARK_GRAY);
        this.add(textPanel);

        // make button group
        var group = new ButtonGroup();
        //make radio buttons for operators
        var add = new JRadioButton("+");
        var subtract = new JRadioButton("-");
        var multiply = new JRadioButton("*");
        var divide = new JRadioButton("/");

// add all the buttons to the group
        group.add(add);
        group.add(subtract);
        group.add(multiply);
        group.add(divide);
        textPanel.add(add);
        textPanel.add(subtract);
        textPanel.add(multiply);
        textPanel.add(divide);
        JTextField operand2 = new JTextField(20);
        textPanel.add(operand2);

        var enter = new JButton("Enter");
        textPanel.add(enter);

        JTextField outputText = new JTextField(50);
        textPanel.add(outputText);
        enter.addActionListener(
                e -> {
                    String output = "";
                    String first = operand1.getText();
                    String second = operand2.getText();
                    if (add.isSelected()) {
                        output = obj.arithmetic(first, "+", second);
                    } else if (subtract.isSelected()) {
                        output = obj.arithmetic(first, "-", second);
                    } else if (multiply.isSelected()) {
                        output = obj.arithmetic(first, "*", second);
                    } else if (divide.isSelected()) {
                        output = obj.arithmetic(first, "/", second);
                    }
                    outputText.setText(output);
                }
        );
    }
}

class ConverterScreen extends JFrame {
    ConverterScreen(int n) {
        Converter obj;
        switch (n) {
            case 1 -> obj = new BinaryConverter();
            case 2 -> obj = new HexConverter();
            case 3 -> obj = new DectoBin();
            default -> obj = new DecToHex();
        }

        // establish boxes to type numbers in
        JTextField operand1 = new JTextField(40);
        var textPanel = new JPanel();
        textPanel.add(operand1);
        textPanel.setBackground(Color.DARK_GRAY);
        this.add(textPanel);

        var enter = new JButton("Enter");
        textPanel.add(enter);

        JTextField outputText = new JTextField(40);
        textPanel.add(outputText);

        enter.addActionListener(e -> {
            outputText.setText(obj.convert(operand1.getText()));
        });
    }
}
