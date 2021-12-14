package by.epam.module02.task2302;

public class Main {
    //2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
    public static void main(String[] args) {
        int a;
        int b;
        int c;
        int d;

        a = 21000000;
        b = 420;
        c = 84;
        d = 42;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        try {
            System.out.println("gcd = " + greatestCommonDivisor(a, b, c, d));
        } catch (IllegalArgumentException exception) {
            System.out.println("EXCEPTION!");
            System.out.println(exception.getMessage());
        }

    }

    public static int greatestCommonDivisor(int a, int b) {
        int gcd = 1;

        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Numbers must be natural!");
        }

        for (int i = 2; i <= Math.min(a, b); i++) {

            while (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
                gcd *= i;
            }

        }

        return gcd;
    }

    public static int greatestCommonDivisor(int a, int b, int c, int d) {
        if (a <= 0 || b <= 0 || c <= 0 || d <= 0) {
            throw new IllegalArgumentException("Numbers must be natural!");
        }

        return greatestCommonDivisor(greatestCommonDivisor(a, b), greatestCommonDivisor(c, d));
    }
}
