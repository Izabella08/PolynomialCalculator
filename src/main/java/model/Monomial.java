package model;

public class Monomial {
    public int degree;
    public float coefficient;
    public int verifyOp;

    public Monomial(int degree, float coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }

    public Monomial(int verifyOp) {
        this.verifyOp = verifyOp;
    }

    public Monomial() {
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getVerifyOp() {
        return verifyOp;
    }

    public void setVerifyOp(int verifyOp) {
        this.verifyOp = verifyOp;
    }

    public String format() {   //formatul standard al monomului
        String format="";

        if (this.coefficient > 0) {   //verificam daca coeficientul este mai mare sau mai mic ca zero pentru a putea concatena semnul
            format = new String("+" +(int) this.coefficient + "x^" +  this.degree);
        }
        else if (this.coefficient < 0){
            format = new String( (int) this.coefficient + "x^" + this.degree);
        }
        return format;
    }

    public String format2() {  //format pentru integrare
        String format = new String(this.coefficient + "x^" + this.degree);
        return format;
    }

    //Am declarat o variabila result (aceasta fiind un monom) si am adunat coeficientul monomului m primit ca parametru cu coeficientul referintei la this
    //puterea ramanand neschimbata ,urmand sa returnam variabila result .
    public Monomial sum(Monomial m) {
        Monomial result = new Monomial(0, 0);
        result.coefficient = m.coefficient + this.coefficient;
        result.degree = this.degree;
        return result;
    }

    //Am declarat o variabila result (aceasta fiind un monom) si am scazut coeficientul monomului m primit ca parametru cu coeficientul referintei la this
    //puterea ramanand neschimbata ,urmand sa returnam variabila result.
    public Monomial substr(Monomial m) {
        Monomial result = new Monomial();
        result.coefficient = m.coefficient - this.coefficient;
        result.degree = this.degree;
        return result;
    }

    //Am declarat o variabila result (aceasta fiind un monom) si am inmultit coeficientul monomului m primit ca parametru cu coeficientul referintei la this
    //puterea monomului m primit ca parametru se aduna cu puterea referintei la this, urmand sa returnam variabila result.
    public Monomial multiply(Monomial m) {
        Monomial result = new Monomial();
        result.coefficient = m.coefficient * this.coefficient;
        result.degree = this.degree + m.degree;
        return result;
    }

    //Am declarat o variabila result (aceasta fiind un monom), am tratat cazurile particulare iar in rest am inmultit coeficientul
    // referintei la this la coeficientul monomului m primit ca parametru cu puterea referintei  this scazand cu 1 , urmand sa
    // returnam variabila result.  Formula matematica:  (x^n)'=n*x^(n-1)
    public Monomial derivate() {
        Monomial result = new Monomial();
        if(this.degree == 0){
            result.coefficient = 0;
            result.degree = 0;
        } else if (this.degree == 1){
            result.coefficient = this.coefficient;
            result.degree = 0;
        } else {
            result.coefficient = this.coefficient * this.degree;
            result.degree = this.degree - 1;
        }
        return result;
    }

    //Am declarat o variabila result (aceasta fiind un monom) si am impartit coeficientul referintei la this la puterea + 1 a monomului m primit ca parametru
    //la  puterea referintei  this se aduna 1,  urmand sa returnam variabila result.
    // Formula matematica: (x^n)= (1/(n+1)) * x^(n+1)
    public Monomial integration() {
        Monomial result = new Monomial();
        result.coefficient = this.coefficient / (this.degree + 1);
        result.degree = this.degree + 1;
        return result;
    }

    //Am declarat o variabila result (aceasta fiind un monom) si am impartit coeficientul referintei la this la coeficientul monomului m primit ca parametru iar
    //puterea monomului m primit ca parametru se scade din puterea referintei la this, urmand sa returnam variabila result.
    public Monomial division(Monomial m) {
        Monomial result = new Monomial();
        result.coefficient = this.coefficient / m.coefficient;
        result.degree = this.degree - m.degree;
        return result;
    }
}
