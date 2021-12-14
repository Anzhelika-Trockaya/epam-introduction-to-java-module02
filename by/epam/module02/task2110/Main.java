package by.epam.module02.task2110;

public class Main {
    //10. Найти положительные элементы главной диагонали квадратной матрицы
    public static void main(String[] args) {
        int[][] a = {{1, 5, 6, 2, 5}, {-1, 5, 8, -9, -1}, {21, 56, -1, 0, 0}, {9, -10, 5, 0, 0}, {0, 2, -3, 5, 1}};

        boolean existsPositive;

        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        System.out.println("Positive elements of the main diagonal: ");

        existsPositive = false;

        for (int i = 0; i < a.length; i++) {

            if (a[i][i] > 0) {
                System.out.print(a[i][i] + " ");
                existsPositive = true;
            }

        }

        if (!existsPositive) {
            System.out.println("There are not positive elements of the main diagonal.");
        }

    }
}
