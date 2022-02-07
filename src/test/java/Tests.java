import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Monomial;
import model.Polynomial;
import model.PatternMatching;

public class Tests {

    @Test   //suma a doua monoame
    public void testMonom() {
        Monomial a   = new Monomial(2, 7);
        Monomial b = new Monomial(2, 22);

        Monomial r = a.sum(b);
        Monomial rez = new Monomial(2, 29);

        System.out.println("Rezultat 1 (coeficient si exponent): " + r.coefficient + " " + r.degree + "\n" +
                "Rezultat 2 (coeficient si exponent): " + rez.coefficient + " "+ rez.degree);

        assertEquals(r.format(),rez.format());
    }


    @Test  //suma a doua polinoame
    public void test1() {
        PatternMatching pattern;
        pattern = new PatternMatching();

        Polynomial p1;
        p1 = new Polynomial();
        p1.setMonomialsList(pattern.getMonoms("4x^6-5x^3"));
        for (Monomial m : p1.getMonomialsList()) {
            System.out.println(m.format());
        }

        Polynomial p2;
        p2 = new Polynomial();
        p2.setMonomialsList(pattern.getMonoms("3x^6+6x^3"));
        for (Monomial m : p2.getMonomialsList()) {
            System.out.println(m.format());
        }

        Polynomial pRes;
        pRes = new Polynomial();
        pRes = pRes.addition(p1,p2);
        System.out.println("Rezultatul adunarii este: " + pRes.formatPolinom());
    }


    @Test  //scaderea a doua polinoame
    public void test2() {
        PatternMatching pattern;
        pattern = new PatternMatching();

        Polynomial p1 = new Polynomial();
        p1.setMonomialsList(pattern.getMonoms("12x^3+7x^6-2x^0"));
        for (Monomial m : p1.getMonomialsList()) {
            System.out.println(m.format());
        }

        Polynomial p2 = new Polynomial();
        p2.setMonomialsList(pattern.getMonoms("2x^3-6x^6-2x^0"));
        for (Monomial m : p2.getMonomialsList()) {
            System.out.println(m.format());
        }

        Polynomial pRes;
        pRes = new Polynomial();
        pRes = pRes.substraction(p1,p2);
        System.out.println("Rezultatul scaderii este: " + pRes.formatPolinom());
    }


    @Test  //inmultirea a doua polinoame
    public void test3() {
        PatternMatching pattern;
        pattern = new PatternMatching();

        Polynomial p1 = new Polynomial();
        p1.setMonomialsList(pattern.getMonoms("2x^3-5x^6"));
        for (Monomial m : p1.getMonomialsList()) {
            System.out.println(m.format());
        }

        Polynomial p2 = new Polynomial();
        p2.setMonomialsList(pattern.getMonoms("11x^3+4x^6"));
        for (Monomial m : p2.getMonomialsList()) {
            System.out.println(m.format());
        }

        Polynomial pRes = new Polynomial();
        pRes.setMonomialsList(p1.multiplication(p2));
        System.out.println("Rezultatul inmultirii este: " + pRes.formatPolinom());
    }


    @Test  //integrarea unui polinom
    public void test4() {
        PatternMatching pattern;
        pattern = new PatternMatching();

        Polynomial p = new Polynomial();
        p.setMonomialsList(pattern.getMonoms("5x^4+8x^7"));

        Polynomial pRes = new Polynomial();
        pRes.setMonomialsList(p.integration());
        for (Monomial m : pRes.getMonomialsList()) {
            System.out.println("Rezultatul integrarii este: " + m.format2());
        }
        System.out.println("Rezultatul este: " + pRes.formatPolinom());
    }


    @Test  //derivarea unui polinom
    public void test5() {
        PatternMatching pattern;
        pattern = new PatternMatching();

        Polynomial p = new Polynomial();
        p.setMonomialsList(pattern.getMonoms("5x^4+8x^7-11x^2"));

        Polynomial pRes = new Polynomial();
        pRes.setMonomialsList(p.derivation());
        for (Monomial m : pRes.getMonomialsList()) {
            System.out.println("Rezultatul derivarii este: " + m.format2());
        }
    }

}
