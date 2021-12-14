package by.epam.module02.task2206;

import java.util.Arrays;

public class Main {
    //6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
    //Делается это следующим образом: сравниваются два соседних элемента ai и ai+1. Если
    //ai <= ai+1, то продвигаются на один элемент вперед. Если ai > ai+1, то производится перестановка
    // и сдвигаются на один элемент назад. Составить алгоритм этой сортировки.
    public static void main(String[] args) {
        double[] a = {1.5, 2, 6.25, 0, -5, 9, 100, 2, -1, 0.05, 8};
        double temp;

        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length - 1; ) {

            if (a[i] > a[i + 1]) {

                temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;

                if (i != 0) {
                    i--;
                }

            } else {
                i++;
            }

        }

        System.out.println("Sorted array: " + Arrays.toString(a));
    }
}
