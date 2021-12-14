package by.epam.module02.task2205;

import java.util.Arrays;

public class Main {
    //5. Сортировка вставками. Дана последовательность чисел a1 ,a2 , ... ,an. Требуется переставить числа в порядке
    //возрастания. Делается это следующим образом. Пусть
    //a1, a2, ... , ai - упорядоченная последовательность, т. е. a1 <= a2 <= ... <= an. Берется следующее число ai+1
    //и вставляется в последовательность так, чтобы новая последовательность была тоже возрастающей.
    // Процесс производится до тех пор, пока все элементы от i +1 до n не будут перебраны.
    // Примечание. Место помещения очередного элемента в отсортированную часть производить
    //с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
    public static void main(String[] args) {
        int[] a = {10, 1, 8, 7, 5, 6, 4, 9, 2, 1};
        int currentValue;
        int tempIndex;

        System.out.println(Arrays.toString(a));

        for (int i = 1; i < a.length; i++) {
            tempIndex = searchIndex(a, i - 1, a[i]);
            currentValue = a[i];

            for (int j = i; j > tempIndex; j--) {
                a[j] = a[j - 1];
            }

            a[tempIndex] = currentValue;
        }

        System.out.println("Sorted array: " + Arrays.toString(a));
    }

    public static int searchIndex(int[] a, int lastIndex, int valueForInsert) {
        int firstIndex = 0;
        int middleIndex;

        while (firstIndex <= lastIndex) {

            middleIndex = (firstIndex + lastIndex) / 2;

            if (a[middleIndex] == valueForInsert) {

                return middleIndex;

            } else if (a[middleIndex] < valueForInsert) {

                firstIndex = middleIndex + 1;

            } else if (a[middleIndex] > valueForInsert) {

                lastIndex = middleIndex - 1;

            }

        }

        return firstIndex;
    }
}
