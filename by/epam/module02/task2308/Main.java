package by.epam.module02.task2308;

public class Main {
    //8. Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
    //Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
    //массива с номерами от k до m.
    public static void main(String[] args) {
        double[] d = {1.0, 2.5, 6, 8, 10.2, 3, 30, 12};

        int startIndex;
        double sumOfElements;

        try {
            startIndex = 0;
            sumOfElements = sumOf3Elements(d, startIndex);
            System.out.println("Sum of elements from " + startIndex + " to " + (startIndex + 2) + " = " + sumOfElements);

            startIndex = 1;
            sumOfElements = sumOf3Elements(d, startIndex);
            System.out.println("Sum of elements from " + startIndex + " to " + (startIndex + 2) + " = " + sumOfElements);

            startIndex = 5;
            sumOfElements = sumOf3Elements(d, startIndex);
            System.out.println("Sum of elements from " + startIndex + " to " + (startIndex + 2) + " = " + sumOfElements);

            startIndex = 6;
            sumOfElements = sumOf3Elements(d, startIndex);
            System.out.println("Sum of elements from " + startIndex + " to " + (startIndex + 2) + " = " + sumOfElements);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double sumOf3Elements(double[] d, int k) {
        if (k + 2 > d.length - 1) {
            throw new IllegalArgumentException("There are no two elements after the element with the index " + k + "!");
        } else if (k < 0) {
            throw new IllegalArgumentException("Index must be positive!");
        }

        return d[k] + d[k + 1] + d[k + 2];
    }

}
