package by.epam.module02.task2115;

public class Main {
    //15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него
    public static void main(String[] args) {
        int[][] a = {{1, 5, 6, 2, 4, 5}, {-1, 5, 8, -9, 3, 5}, {21, 56, 1, 0, 5, 9}, {9, -10, 5, 6, 3, 2}};
        int max;

        printMatrix(a);

        max = a[0][0];

        for (int[] ints : a) {//searching maximum element
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {//replacing
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] % 2 != 0) {
                    a[i][j] = max;
                }
            }
        }

        System.out.println("Maximum element: " + max);

        System.out.println("Result:");
        printMatrix(a);
    }

    public static void printMatrix(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
