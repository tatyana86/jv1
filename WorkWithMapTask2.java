import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class WorkWithMapTask2 {

    static ArrayList<Integer> repeatNum(int [] list, int N) {

        ArrayList<Integer> res = new ArrayList<>(); // результирующий список
        HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>(); // словарь для подсчета чисел в переданном списке

        // Посчитаем повторения чисел в переданном списке:
        for(int i = 0; i < list.length; i ++) {
            // Метод .getOrDefault() возвращает значение по ключу, если таковой существует;
            // в противном случае создает пару с переданным ключом и присваивает значение второго аргумента,
            // в данном случае - 0.
            numCount.put(list[i], numCount.getOrDefault(list[i], 0) + 1);
        }

        // Пройдемся по парам словаря и добавим в результирующий список числа, повторяющиеся не менее N раз:
        for(Integer k : numCount.keySet()) {
            if(numCount.get(k) >= N) {
                res.add(k);
            }
        }

        return res;

    }

    public static void main(String[] args) {

        int Num = 10; // введем число повторений
        Random rand = new Random();
        int n = 100;
        int[] randNums = new int[n];

        // Заполняем массив случайными числами:
        for(int i = 0; i < 100; i ++) {
            randNums[i] = rand.nextInt(10) + 1;
        }

        ArrayList<Integer> repeatN = repeatNum(randNums, Num);

    }
}