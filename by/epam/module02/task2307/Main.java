package by.epam.module02.task2307;

public class Main {
    //7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
    public static void main(String[] args) {
        System.out.println("Sum of factorials of odd numbers from 1 to 9 is " + sumOfFactorialsOfOddNumbersFrom1To9());
    }

    public static int factorial(int a) {
        int factorial;

        if (a < 0) {
            throw new IllegalArgumentException("Numbers must be not negative!");
        }

        if (a == 0) {
            return 1;
        }

        factorial = 1;

        for (int i = a; i > 1; i--) {

            if (Integer.MAX_VALUE / i > factorial) {
                factorial *= i;
            } else {
                throw new IllegalArgumentException("Result of multiplication " + factorial + " * " + i + " is too big!");
            }

        }

        return factorial;
    }

    public static int sumOfFactorialsOfOddNumbersFrom1To9() {
        int sum = 0;

        for (int i = 1; i <= 9; i += 2) {
            sum += factorial(i);
        }

        return sum;
    }
}
