package by.epam.module02.task2208;

//8.Даны дроби p1/q1, p2/q2, ... , pn/qn. (pi, qi - натуральные). Составить программу, которая приводит эти дроби
//к общему знаменателю и упорядочивает их в порядке возрастания.
public class Fraction {
    public int p;
    public int q;

    public Fraction(int p, int q) {
        if (p > 0 && q > 0) {
            this.p = p;
            this.q = q;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
