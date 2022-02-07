package model;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {

    public ArrayList<Monomial> monomialsList = new ArrayList<Monomial>();

    public Polynomial(ArrayList<Monomial> monomialsList) {
        this.monomialsList = monomialsList;
    }

    public Polynomial() {
    }

    public ArrayList<Monomial> getMonomialsList() {
        return monomialsList;
    }

    public void setMonomialsList(ArrayList<Monomial> monomialsList) {
        this.monomialsList = monomialsList;
    }

    public String formatPolinom() {
        String s = "";
        for (Monomial m : this.monomialsList) {
            s = s + m.format();
        }
        return s;
    }

    public String formatPolinom2() {   //pt integrare
        String s ="";
        for(Monomial m : this.monomialsList) {
            s = s + m.format2();
        }
        return s;
    }

    public static void polynomialSort(Polynomial p) {
        for (int i = 0; i < p.monomialsList.size()-1; i++ ) {
            for (int j = i+1; j < p.monomialsList.size(); j++) {
                if (p.monomialsList.get(i).getDegree() < p.monomialsList.get(j).getDegree()) {
                    Collections.swap(p.monomialsList, i, j);
                }
            }
        }
    }

    //sortez cele doua polinoame, le parcurg si atunci cand intalnesc doua monoame cu grad egal verific daca acestea au fost deja
    //adaugate iar in cazul in care nu au fost (verifyOp == 0) le adaug.
    //la sfarsit verific daca au mai ramas elemente neadaugate pt a le adauga la rezultat (result)
    public Polynomial addition(Polynomial polynomial1, Polynomial polynomial2) {

        Polynomial result = new Polynomial();

        int p1 = 0;
        int p2 = 0;

        polynomialSort(polynomial2);
        polynomialSort(polynomial1);

        for (int i = 0; i < polynomial1.monomialsList.size(); i++) {
            for (int j = 0; j < polynomial2.monomialsList.size(); j++) {
                p1 = polynomial1.monomialsList.get(i).getDegree();
                p2 = polynomial2.monomialsList.get(j).getDegree();
                if (p1 == p2) {
                    if ((polynomial1.monomialsList.get(i).getVerifyOp() == 0) && (polynomial2.monomialsList.get(j).getVerifyOp() == 0))
                    result.monomialsList.add(polynomial1.monomialsList.get(i).sum(polynomial2.monomialsList.get(j)));
                    polynomial1.monomialsList.get(i).setVerifyOp(1);
                    polynomial2.monomialsList.get(j).setVerifyOp(1);
                    //aux.add(polynomial2.monomialsList.get(j));
                }
            }
        }

        for(int i = 0; i < polynomial1.monomialsList.size(); i++)
        {
            if( polynomial1.monomialsList.get(i).getVerifyOp() == 0 )																	// in caz ca nu s-a gasit un monom cu acelasi coeficient
                result.monomialsList.add(polynomial1.monomialsList.get(i));																		// se adauga si acel monom, singur
        }

        for(int j = 0; j < polynomial2.monomialsList.size(); j++)
        {
            if(polynomial2.monomialsList.get(j).getVerifyOp() == 0 )
            {
                result.monomialsList.add(polynomial2.monomialsList.get(j));
            }
        }

        polynomialSort(result);
        return result;
    }

    // inmultesc fiecare coeficient al polinomului 2 cu -1 iar apoi il adun la primul polinom
    public Polynomial substraction(Polynomial polynomial1, Polynomial polynomial2) {

        Polynomial result = new Polynomial();;

        for (int i = 0; i < polynomial2.monomialsList.size(); i++) {
            polynomial2.monomialsList.get(i).coefficient = polynomial2.monomialsList.get(i).coefficient * (-1);
        }

        result = result.addition(polynomial1, polynomial2);

        polynomialSort(result);
        return result;
    }

    //am declarant o variabila result (aceasta fiind tot un polinom) ,  primesc ca si parametrii de intrare doua polinoame,
    // le parcurg si inmultesc fiecare termen din primul polinom cu fiecare termen din al doilea polinom si adaug rezultatul
    // fiecarei inmultiri in result; la final returnez variabila result;
    public ArrayList<Monomial> multiplication(Polynomial polynomial2) {
        Polynomial result = new Polynomial();
        ArrayList<Monomial> aux = new ArrayList<Monomial>();

        for (int i = 0; i < this.monomialsList.size(); i++) {
            for (int j = 0; j < polynomial2.monomialsList.size(); j++) {
                aux.add(this.getMonomialsList().get(i).multiply(polynomial2.getMonomialsList().get(j)));
            }
        }

        //folosim clasa Collections pt a sorta polinomul descrescator in functie de putere
        Collections.sort(aux, new MyComp().reversed());
        result.setMonomialsList(aux);
        result.merge();
        return aux;
    }

    public void merge() {
        int aux = 0;
        while (aux < this.getMonomialsList().size() - 1) {
            if (this.getMonomialsList().get(aux).getDegree() == this.getMonomialsList().get(aux + 1).getDegree()) {
                this.getMonomialsList().get(aux).coefficient = this.getMonomialsList().get(aux).getCoefficient()
                        + this.getMonomialsList().get(aux + 1).getCoefficient();
                this.getMonomialsList().remove(this.getMonomialsList().get(aux + 1));
            } else {
                aux++;
            }
        }
    }

    //am declarant o variabila result (aceasta fiind tot un polinom) si parcurg polinomul referinta this care este de fapt o
    // lista de monoame, iar asupra fiecarui monom aplic operatia de derivarea asupra unui monom (din clasa Monomial),
    // rezultatul il adaug in polinomul result iar la final returnez variabila result;
    public ArrayList<Monomial> derivation() {
        ArrayList<Monomial> result = new ArrayList<Monomial>();

        for (int i = 0; i < this.monomialsList.size(); i++) {
            result.add(this.monomialsList.get(i).derivate());
        }
        return result;
    }

    //am declarant o variabila result (aceasta fiind tot un polinom) si parcurg polinomul referinta this care este de fapt o
    // lista de monoame, iar asupra fiecarui monom aplic operatia de integrare a unui monom (din clasa Monomial), rezultatul
    // il adaug in polinomul result iar la final returnez variabila result;
    public ArrayList<Monomial> integration() {
        ArrayList<Monomial> result = new ArrayList<Monomial>();

        for (int i = 0; i < this.monomialsList.size(); i++) {
            result.add(this.monomialsList.get(i).integration());
        }
        return result;
    }

}
