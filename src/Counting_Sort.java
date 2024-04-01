import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Counting_Sort {
    //сорування підрахунком від найменшого до найбільшого елемента
    public static int[] countSort(int[] arr) {
        int min = getSmallestElement(arr);
        int max = getBiggestElement(arr);

        // Зміщення для врахування від'ємних елементів
        int offset = Math.abs(min);

        // Розмір масиву підрахунку
        int[] count = new int[max - min + 1];

        fulfilArray(arr, count, offset);

        // Виконуємо сортування підрахунком
        System.out.println("масив підрахунку "+Arrays.toString(count));
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i - offset;
                count[i]--;
            }
        }

        return arr;
    }
    //сортування підрахунком від найбільшого до найменшого елемента
    public static int[] countSortRev(int[] arr) {
        int min = getSmallestElement(arr);
        int max = getBiggestElement(arr);

        // Зміщення для врахування від'ємних елементів
        int offset = Math.abs(min);

        // Розмір масиву підрахунку
        int[] count = new int[max - min + 1];

        fulfilArray(arr, count, offset);

        // Виконуємо сортування підрахунком
        System.out.println("масив підрахунку \n"+Arrays.toString(count));
        int index = arr.length-1;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index--] = i - offset;
                count[i]--;
            }
        }

        return arr;
    }

    public static int getBiggestElement(int[] arr) {
        int max = 0;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int getSmallestElement(int[] arr) {
        int min = 0;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static void fulfilArray(int[] arr, int[] count, int offset) {
        Arrays.fill(count, 0);
        for (int num : arr) {
            count[num + offset]++;
        }
    }
}
