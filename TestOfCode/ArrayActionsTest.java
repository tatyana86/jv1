package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class ArrayActionsTest {

    @BeforeAll
    static void start() {
        System.out.println("Testing begins...");
    }

	// Тест 1 - проверка на создание массива случайной размерности
    @Test
    public void testIsCreateWithRandomDimension() {
        Random rand = new Random();
        int n = rand.nextInt(1000) - 500;
        int[] checkArray = MyArray.ArrayActions.listCreate(n);
        assertEquals(n, checkArray.length);
    }
	
	// Тест 2 - проверка на создание пустого массива
    @Test
    public void testIsCreateNullDimension() {
        int n = 0;
        int[] checkArray = MyArray.ArrayActions.listCreate(n);
        assertEquals(n, checkArray.length);
    }

	// Тест 3 - проверка на создание массива большого размера
    @Test
    public void testIsCreateBigDimension() {
        int n = 100000000;
        int[] checkArray = MyArray.ArrayActions.listCreate(n);
        assertEquals(n, checkArray.length);
    }

	// Тест 4 - условный регрессионный тест, проверяющий, правильно ли реализован алгоритм сортировки
    // Как вариант, можно было бы сравнивать отсортированный массив с результатом встроенной сортировки
    @Test
    public void testIsSortArrayIsEqualTrueSort() {
        int[] arr1 = {8, 4, -3, 50, -7, 6, 1, 0, -8};
        int[] arr1_sort = {-8, -7, -3, 0, 1, 4, 6, 8, 50};
        assertArrayEquals(arr1_sort, MyArray.ArrayActions.listSorting(arr1));
    }

    @AfterAll
     static void tear(){
        System.out.println("Testing completed.");
    }
	
}