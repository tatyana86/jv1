import java.util.Random;
import MyArray.ArrayActions;

import static MyArray.ArrayActions.listCreate;

public class Main {

    public static void main(String[] args) {
        // Вводим размерность массива:
        int n = 5;
        int[] arr = listCreate(n);

        System.out.println("Before:");
        ArrayActions.listPrint(arr);

        ArrayActions.listSorting(arr);

        System.out.println("After:");
        ArrayActions.listPrint(arr);

        isCreateWithRandomDimension();
        isCreateNullDimension();
        isCreateMaxIntDimension();
        isSortArrayIsEqualTrueSort();
    }

    // Тест 1 - проверка на создание массива случайной размерности
    public static void isCreateWithRandomDimension()
    {
        try {
            Random rand = new Random();
            for(int i = 0; i < 1000; i++) {
                int n = rand.nextInt(50) - 25;
                ArrayActions.listCreate(n);
            }
            System.out.println("TEST 1 PASSED");
        }
        catch(Exception e) {
            System.out.println("TEST 1 FAILED: " + e);
        }
    }

    // Тест 2 - проверка на создание пустого массива
    public static void isCreateNullDimension()
    {
        try {
            int n = 0;
            ArrayActions.listCreate(n);
            System.out.println("TEST 2 PASSED");
        }
        catch(Exception e) {
            System.out.println("TEST 2 FAILED: " + e);
        }
    }

    // Тест 3 - проверка размерности массива на максимальное значение типа int приводит к ограничениям JM
    // предполагаю, что необходимо выяснить максимальную размерность массива,
    // не приводяющую к данной проблеме, и проверять на меньшее число (и ограничить пользователя в размерности)
    public static void isCreateMaxIntDimension()
    {
        try {
            int n = 2147483647;
            ArrayActions.listCreate(n);
            System.out.println("TEST 3 PASSED");
        }
        catch(OutOfMemoryError e) {
            System.out.println("TEST 3 FAILED: " + e);
        }
        catch(Exception e) {
            System.out.println("TEST 3 FAILED: " + e);
        }
    }

    // Тест 4 - условный регрессионный тест, проверяющий, правильно ли реализован алгоритм сортировки
    // Как вариант, можно было бы сравнивать отсортированный массив с результатом встроенной сортировки
    public static void isSortArrayIsEqualTrueSort()
    {
        int[] arr1 = {8, 4, -3, 50, -7, 6, 1, 0, -8};
        int[] arr1_sort = {-8, -7, -3, 0, 1, 4, 6, 8, 50};
        boolean isEqual = true;
        ArrayActions.listSorting(arr1);
        for(int i = 0; i < arr1.length; i ++)
            if(arr1[i] != arr1_sort[i]) {
                isEqual = false;
                break;
            }
        if(isEqual)
            System.out.println("TEST 4 PASSED");
        else
            System.out.println("TEST 4 FAILED");
    }
}