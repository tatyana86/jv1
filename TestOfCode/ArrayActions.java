package MyArray;

import java.util.Random;

public class ArrayActions {
    // Заполнение массива случайными числами
    public static int[] listCreate(int n) {
        if(n < 0) // исправляем некорректный размер массива
            n = 0;
        int[] list = new int[n];
        Random rand = new Random();
        for(int i = 0; i < n; i ++)
            list[i] = rand.nextInt(10) + 1;
        return list;
    }

    // Вывод массива на экран:
    public static void listPrint(int[] list) {
        for(int i = 0; i < list.length; i ++)
            System.out.print(list[i] + " ");
        System.out.println();
    }

    // Сортировка массива, возвращение результата сортировки
    public static int[] listSorting(int[] list) {
        int x, y;
        // В первом цикле сравниваем i-ое число с последующим, минимальное сдвигаем влево:
        for(int i = 0; i < (list.length - 1); i ++) {
            if(list[i + 1] < list[i]) {
                x = list[i];
                list[i] = list[i + 1];
                list[i + 1] = x;
                // Во втором цикле проверяем, нужно ли еще сдвинуть элемент влево
                for(int j = i; j > 0; j --) {
                    if(list[j] < list[j - 1]) {
                        y = list[j];
                        list[j] = list[j - 1];
                        list[j - 1]= y;
                    }
                }
            }
        }
        return list;
    }
}
