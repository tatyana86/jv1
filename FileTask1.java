import java.io.*;
import java.util.Random;

public class FileTask1 {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        for(int i = 1; i <= 10; i++) {
            File my_fil = new File(i + ".txt"); // связываем переменную с файлом
            BufferedWriter bw = new BufferedWriter(new FileWriter(my_fil)); // поток для записи в файл
            bw.write(Integer.toString(rand.nextInt())); // записываем случайное число в файл
			// записываем еще два числа на новых строках
            for(int k = 0; k < 2; k++) {
               bw.newLine(); 
               bw.write(Integer.toString(rand.nextInt()));
            }
            bw.close(); // закрываем файл
        }
    }
}