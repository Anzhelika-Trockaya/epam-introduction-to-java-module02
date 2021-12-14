package by.epam.module02.task2311;

public class Main {
    //11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
    public static void main(String[] args) {
        int number1;
        int number2;

        number1 = -1;
        number2 = 1;
        System.out.println("Numbers: " + number1 + " , " + number2);

        switch (compareDigitsNumber(number1, number2)) {
            case 1 -> System.out.println("The first number has more digits than the second.");
            case -1 -> System.out.println("The second number has more digits than the first.");
            case 0 -> System.out.println("Numbers have equal number of digits.");
        }

    }

    public static int compareDigitsNumber(int number1, int number2) {
        String digits1;
        String digits2;

        digits1 = Integer.toString(number1).replace("-", "");
        digits2 = Integer.toString(number2).replace("-", "");


        return Integer.compare(digits1.length(), digits2.length());
    }//method return 1 if the first number has more digits, -1 if second number, 0 if in numbers equal number of digits

    public static int compareDigitsNumber2(int number1, int number2) {
        int digitsNumber1;
        int digitsNumber2;

        digitsNumber1 = countDigitsNumber(number1);
        digitsNumber2 = countDigitsNumber(number2);

        return Integer.compare(digitsNumber1, digitsNumber2);
    }

    public static int countDigitsNumber(int number) {
        int digitsNumber;

        if (number == 0) {
            return 1;
        } else if (number < 0) {
            number *= -1;
        }

        digitsNumber = 0;

        while (number > 0) {
            digitsNumber++;
            number = number / 10;
        }

        return digitsNumber;
    }

}
