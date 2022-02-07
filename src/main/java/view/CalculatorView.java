package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    public JButton addButton;
    public JButton substractionButton;
    public JButton multiplicationButton;
    public JButton divisionButton;
    public JButton derivateButton;
    public JButton integrationButton;
    public JLabel firstPolynom;
    public JTextField firstPolynomText;
    public JLabel secondPolynom;
    public JTextField secondPolynomText;
    public JLabel result;
    public JTextField resultText;

    public CalculatorView() {
        this.setSize(800,470);
        this.setTitle("POLYNOMIAL CALCULATOR");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        //setez backgoundul frame-ului
        this.getContentPane().setBackground(new Color(11,11,11));

        JLabel title = new JLabel("POLYNOMIAL CALCULATOR");
        title.setBounds(210,20,400,50);
        title.setForeground(new Color(200,200,200));
        title.setBackground(new Color(255,157,203));
        title.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD,20));
        title.setVisible(true);
        this.add(title);


        //buton pentru suma
        addButton =new JButton("Addition");
        addButton.setBounds(640,100,120,35);
        addButton.setBackground(Color.WHITE);
        addButton.setFocusable(false);
        this.add(addButton);


        //buton pentru scadere
        substractionButton = new JButton("Substraction");
        substractionButton.setBounds(640,150,120,35);
        substractionButton.setBackground(Color.WHITE);
        substractionButton.setFocusable(false);
        this.add(substractionButton);


        //buton pentru inmultire
        multiplicationButton = new JButton("Multiplication");
        multiplicationButton.setBounds(640,200,120,35);
        multiplicationButton.setBackground(Color.WHITE);
        multiplicationButton.setFocusable(false);
        this.add(multiplicationButton);


        //buton pentru impartire
        divisionButton = new JButton("Division");
        divisionButton.setBounds(640,250,120,35);
        divisionButton.setBackground(Color.WHITE);
        divisionButton.setFocusable(false);
        this.add(divisionButton);


        //buton pentru derivare
        derivateButton = new JButton("Derivation");
        derivateButton.setBounds(640,300,120,35);
        derivateButton.setBackground(Color.WHITE);
        derivateButton.setFocusable(false);
        this.add(derivateButton);


        //buton pentru integrare
        integrationButton = new JButton("Integration");
        integrationButton.setBounds(640,350,120,35);
        integrationButton.setBackground(Color.WHITE);
        integrationButton.setFocusable(false);
        this.add(integrationButton);


        //label pt introducerea primului polinom
        firstPolynom = new JLabel("First polynomial:");
        firstPolynom.setFont(new Font("MV Boly",Font.BOLD,20));
        firstPolynom.setBounds(20,20,200,150);
        firstPolynom.setForeground(new Color(255,255,255));
        this.getContentPane().add(firstPolynom);
        firstPolynomText = new JTextField(20);
        firstPolynomText.setBounds(150,120,270,30);
        this.getContentPane().add(firstPolynomText);


        //label pt introducerea celui de al doilea polinom
        secondPolynom = new JLabel("Second polynomial:");
        secondPolynom.setFont(new Font("MV Boly",Font.BOLD,20));
        secondPolynom.setBounds(20,130,240,150);
        secondPolynom.setForeground(new Color(255,255,255));
        this.add(secondPolynom);
        secondPolynomText = new JTextField(20);
        secondPolynomText.setBounds(150,230,270,30);
        this.add(secondPolynomText);


        //label pt afisarea rezultatului
        result = new JLabel("Result:");
        result.setFont(new Font("MV Boly",Font.BOLD,20));
        result.setBounds(20,240,220,150);
        result.setForeground(new Color(255,255,255));
        this.add(result);
        resultText = new JTextField(20);
        resultText.setBounds(150,340,270,30);
        this.add(resultText);

    }

    public void addButton(ActionListener action) {
        addButton.addActionListener(action);
    }

    public void substractionButton(ActionListener action) {
        substractionButton.addActionListener(action);
    }

    public void multiplicationButton(ActionListener action) {
        multiplicationButton.addActionListener(action);
    }

    public void divisionButton(ActionListener action) {
        divisionButton.addActionListener(action);
    }

    public void derivateButton(ActionListener action) {
        derivateButton.addActionListener(action);
    }

    public void integrationButton(ActionListener action) {
        integrationButton.addActionListener(action);
    }

}

