package by.epam.module02.task2301;

public class Main {
    //1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
    //натуральных чисел: НОК (a, b) = a*b / НОД (a, b)
    public static void main(String[] args) {
        int a;
        int b;

        a = 1250000;
        b = 140;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("gcd = " + greatestCommonDivisor(a, b));

        try {
            System.out.println("lcm = " + leastCommonMultiple(a, b));
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

    private static int multiplyNaturalNumbers(int n1, int n2) {
        if (Integer.MAX_VALUE / n1 >= n2) {
            return n1 * n2;
        } else {
            throw new IllegalArgumentException("Result of multiply: " + n1 + " * " + n2 + " is too big!");
        }
    }

    public static int leastCommonMultiple(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Numbers must be natural!");
        }

        return multiplyNaturalNumbers(a, b) / greatestCommonDivisor(a, b);
    }
}
