import java.util.HashMap;
import java.util.Random;

public class WorkWithMapTask1 {

    public static void main(String[] args) {

        HashMap<Integer, String> map100 = new HashMap<Integer, String>(); // объявляем HashMap
        Random rand = new Random();
        int n = 100;
        int[] keys = new int[n];
        int i = 0;
        // Заполняем массив случайными уникальными числами:
        while(i < n) {
            int r = rand.nextInt(1000) + 1;
            boolean isRepeat = false; // проверка, встречалось ли уже такое число
            for(int j = 0; j < i; j ++)
                if(keys[j] == r) {
                    isRepeat = true;
                    break;
                }
            if(isRepeat) { // если такое число встречалось, генерируем новое случаное число
                continue;
            }
            keys[i] = r; // нашли оригинальное число
            i ++;
        }

        // Добавляем 100 случайных пар в словарь:
        for(int k = 0; k < 100; k ++) {
            map100.put(keys[k], String.valueOf(keys[k]));
        }

        // Выведем значения по ключам:
        for(Integer k : map100.keySet()) {
            System.out.println(map100.get(k));
        }

        // Удаляем все пары:
        map100.clear();

    }
}