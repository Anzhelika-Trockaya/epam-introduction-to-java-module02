package by.epam.module02.task2306;

public class Main {
    //6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
    public static void main(String[] args) {
        int a, b, c;

        a = 75;
        b = 14;
        c = 13;

        try {
            System.out.printf("Numbers: %d %d %d are%s coprime.", a, b, c, areCoprimeNumbers(a, b, c) ? "" : " not");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean areCoprimeNumbers(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException("Numbers must be natural!");
        }

        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean areCoprimeNumbers(int a, int b, int c) {
        return areCoprimeNumbers(a, b) && areCoprimeNumbers(a, c) && areCoprimeNumbers(b, c);
    }
}
