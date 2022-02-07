package model;

import model.Monomial;

import java.util.ArrayList;

public class PatternMatching {

    public PatternMatching() {
    }

    private int getExp(String m) {
        // -4x^2 --> 2
        String[] aux = m.split("\\^"); //ia tot ce e dupa ^
        int exp;
        exp = Integer.parseInt(aux[1]);
        return exp;
    }

    private int getCoeff(String m) {
        // -4x^2 --> 2
        String[] aux = m.split("x");  //ia tot ce e inainte de x
        int coeff;
        coeff = Integer.parseInt(aux[0]);
        return coeff;
    }

    public ArrayList<Monomial> getMonoms(String polynom) {

        ArrayList<Monomial> poly = new ArrayList<Monomial>();
        String b = polynom.replaceAll("-", "+-");

        String[] arr = b.split("\\+");
        for (String a : arr) {
            if (a != null) {
                int coeff = getCoeff(a);
                int exp = getExp(a);
                poly.add(new Monomial(exp, coeff));
            }
        }

        return poly;
    }
}
