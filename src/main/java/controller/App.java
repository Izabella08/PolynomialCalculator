package controller;

import view.CalculatorView;
import model.PatternMatching;
import model.Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main( String[] args )
    {
        final CalculatorView myFrame = new CalculatorView();
        myFrame.setVisible(true);

        myFrame.addButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                PatternMatching pattern = new PatternMatching();

                String poli1 = myFrame.firstPolynomText.getText();
                String poli2 = myFrame.secondPolynomText.getText();

                p1.monomialsList = pattern.getMonoms(poli1);
                p2.monomialsList = pattern.getMonoms(poli2);

                Polynomial res;
                res = new Polynomial();
                res = res.addition(p1,p2);

                System.out.println("Rezultatul adunarii: " + res.formatPolinom());

                myFrame.resultText.setText(res.formatPolinom());
            }
        });

        myFrame.substractionButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                PatternMatching pattern = new PatternMatching();

                String poli1 = myFrame.firstPolynomText.getText();
                String poli2 = myFrame.secondPolynomText.getText();

                p1.monomialsList = pattern.getMonoms(poli1);
                p2.monomialsList = pattern.getMonoms(poli2);

                Polynomial res;
                res = new Polynomial();
                res = res.substraction(p1,p2);

                System.out.println("Rezultatul scaderii: " + res.formatPolinom());

                myFrame.resultText.setText(res.formatPolinom());
            }
        });

        myFrame.multiplicationButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                PatternMatching pattern = new PatternMatching();

                String poli1 = myFrame.firstPolynomText.getText();
                String poli2 = myFrame.secondPolynomText.getText();

                p1.monomialsList = pattern.getMonoms(poli1);
                p2.monomialsList = pattern.getMonoms(poli2);

                Polynomial res;
                res = new Polynomial();
                res.monomialsList = p1.multiplication(p2);

                System.out.println("Rezultatul inmultirii: " + res.formatPolinom());

                myFrame.resultText.setText(res.formatPolinom());
            }
        });

        myFrame.derivateButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polynomial p1 = new Polynomial();
                PatternMatching pattern = new PatternMatching();

                String poli1 = myFrame.firstPolynomText.getText();

                p1.monomialsList = pattern.getMonoms(poli1);

                Polynomial rez = new Polynomial();
                rez.monomialsList = p1.derivation();

                System.out.println("Rezultatul derivarii: " + rez.formatPolinom());

                myFrame.resultText.setText(rez.formatPolinom());
            }
        });

        myFrame.integrationButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Polynomial p1 = new Polynomial();
                PatternMatching pattern = new PatternMatching();

                String poli1 = myFrame.firstPolynomText.getText();

                p1.monomialsList = pattern.getMonoms(poli1);

                Polynomial rez = new Polynomial();
                rez.monomialsList = p1.integration();

                System.out.println("Rezultatul integrarii: " + rez.formatPolinom2());

                myFrame.resultText.setText(rez.formatPolinom2());
            }
        });
    }
}
