package by.epam.module02.task2315;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    //15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
    //последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
    public static void main(String[] args) {
        int n;

        n = 5;

        if (n < 1) {
            System.out.println("Number must be natural!");
            return;
        }

        System.out.println(setOfNumbers(n));
    }

    public static Set<Integer> setOfNumbers(int n) {
        int[] digits;
        Set<Integer> set;

        if (n > 9) {
            return null;
        }

        digits = digitsArrayInitialValue(n);
        set = new TreeSet<>();

        while (digits != null) {
            set.add(digitsArrayToNumber(digits));
            digits = nextDigitsArrayValue(digits);
        }

        return set;
    }

    private static int[] digitsArrayInitialValue(int n) {
        int[] digits;

        digits = new int[n];

        for (int i = 0; i < n; i++) {
            digits[i] = i + 1;
        }

        return digits;
    }

    private static int digitsArrayToNumber(int[] digits) {
        int number = 0;

        for (int i = 1; i <= digits.length; i++) {
            number += digits[digits.length - i] * Math.pow(10, i - 1);
        }

        return number;
    }

    private static int[] nextDigitsArrayValue(int[] prev) {
        if (prev[prev.length - 1] < 9) {
            prev[prev.length - 1]++;
            return prev;
        }

        for (int i = prev.length - 2; i >= 0; i--) {

            if (prev[i] + 1 < prev[i + 1]) {

                prev[i]++;

                for (int j = i + 1; j < prev.length; j++) {
                    prev[j] = prev[j - 1] + 1;
                }

                return prev;

            }

        }

        return null;
    }

}
