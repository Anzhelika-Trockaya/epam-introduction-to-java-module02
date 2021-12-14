package by.epam.module02.task2208;

//8.Даны дроби p1/q1, p2/q2, ... , pn/qn. (pi, qi - натуральные). Составить программу, которая приводит эти дроби
//к общему знаменателю и упорядочивает их в порядке возрастания.

public class Main {
    public static void main(String[] args) {
        Fraction[] fractions = {new Fraction(1, 2)
                , new Fraction(2, 7)
                , new Fraction(4, 15)
                , new Fraction(1, 9)
                , new Fraction(10000, 14)};

        printFractionArray(fractions);

        fractions = toCommonDenominator(fractions);

        if (fractions != null) {
            System.out.print("With common denominations: ");
            printFractionArray(fractions);

            fractions = byNumeratorsSort(fractions);
            System.out.print("Sorted array: ");
            printFractionArray(fractions);
        }
    }

    public static String stringValue(Fraction fraction) {
        return fraction.p + "/" + fraction.q;
    }

    public static void printFractionArray(Fraction[] fractions) {
        System.out.print("{ ");

        for (Fraction fraction : fractions) {
            System.out.print(stringValue(fraction) + " ");
        }

        System.out.println("}");
    }

    private static int leastCommonDivisor(int a, int b) {
        int lcd = 1;

        if (a >= 1 && b >= 1) {

            for (int i = 2; i <= Math.max(a, b); ) {

                if (a % i == 0 && b % i == 0) {

                    a = a / i;
                    b = b / i;
                    lcd = multiplyNaturalValues(lcd, i);

                } else if (a % i == 0) {

                    a = a / i;
                    lcd = multiplyNaturalValues(lcd, i);

                } else if (b % i == 0) {

                    b = b / i;
                    lcd = multiplyNaturalValues(lcd, i);

                } else {
                    i++;
                }

            }

        } else {
            lcd = 0;
        }

        return lcd;
    }


    private static int multiplyNaturalValues(int value1, int value2) {
        int result = 0;

        if (Integer.MAX_VALUE / value2 >= value1) {
            result = value1 * value2;
        } else {
            System.out.println("Exception! Value of operation: " + value1 + " * " + value2 + " is too big!");
        }

        return result;
    }

    public static int getCommonDenominator(Fraction[] fractions) {
        int commonDenominator = 1;

        for (Fraction fraction : fractions) {
            commonDenominator = leastCommonDivisor(commonDenominator, fraction.q);
        }

        return commonDenominator;
    }

    public static Fraction[] toCommonDenominator(Fraction[] fractions) {
        int commonDenominator;

        commonDenominator = getCommonDenominator(fractions);

        if (commonDenominator > 0) {
            for (Fraction fraction : fractions) {
                fraction.p = multiplyNaturalValues(fraction.p, commonDenominator) / fraction.q;
                fraction.q = commonDenominator;

                if (fraction.p == 0) {
                    return null;
                }
            }
        } else {
            return null;
        }

        return fractions;
    }

    public static Fraction[] byNumeratorsSort(Fraction[] fractions) {
        Fraction temp;

        for (int i = 0; i < fractions.length - 1; i++) {
            for (int j = i + 1; j < fractions.length; j++) {

                if (fractions[j].p < fractions[i].p) {

                    temp = fractions[i];
                    fractions[i] = fractions[j];
                    fractions[j] = temp;

                }

            }
        }

        return fractions;
    }


}
