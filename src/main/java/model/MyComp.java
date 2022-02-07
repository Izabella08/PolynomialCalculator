package model;

import model.Monomial;

import java.util.Comparator;

public class MyComp implements Comparator<Monomial> {

    public int compare(Monomial m1, Monomial m2) {
        return m1.degree - m2.degree;
    }

}