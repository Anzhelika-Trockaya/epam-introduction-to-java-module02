package by.epam.module02.task2108;

import java.util.Scanner;

public class Main {
    //8. В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
    //на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
    //пользователь с клавиатуры.
    public static void main(String[] args) {
        int column1;
        int column2;
        int temp;

        int[][] a = {{1, 5, 6, 2, 4, 5}, {-1, 5, 8, -9, 3, 5}, {21, 56, 1, 0, 5, 9}, {9, -10, 5, 6, 3, 2}};

        for (int[] line : a) {
            for (int element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the column numbers you want to swap. number1 = ");
        column1 = scanner.nextInt();

        System.out.print("number2 = ");
        column2 = scanner.nextInt();

        if (column1 > a[0].length || column2 > a[0].length || column1 <= 0 || column2 <= 0) {
            System.out.println("Incorrect column numbers!");
            return;
        }


        for (int i = 0; i < a.length; i++) {//swapping
            temp = a[i][column1 - 1];
            a[i][column1 - 1] = a[i][column2 - 1];
            a[i][column2 - 1] = temp;
        }

        for (int[] line : a) {
            for (int element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }
}
