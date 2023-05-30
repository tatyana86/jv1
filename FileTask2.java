import java.io.*;
import java.util.Random;

public class FileTask2 {
	
	/* Получает на вход два случайных числа от 1 до 10 и путь к файлам, 
	открывает соответствующие файлы и возвращает сумму шести чисел*/
    public static int Sum(int a, int b, String p) throws Exception {
        int sum = 0;

        File my1 = new File(p + "\\" + a + ".txt"); // связываем переменную с файлом
        File my2 = new File(p + "\\" + b + ".txt"); // связываем переменную с файлом

		// инициализируем перед блоком try, чтобы иметь возможность обратиться в блоке finally
        BufferedReader br1 = null; 
        BufferedReader br2 = null;
        try {
            br1 = new BufferedReader(new FileReader(my1)); // поток для чтения файла
            br2 = new BufferedReader(new FileReader(my2)); // поток для чтения файла
			// пройдемся по строчкам сразу двух файлов
            for (int i = 1; i <= 3; i++) {
                String s1 = br1.readLine();
                String s2 = br2.readLine();
                sum = sum + Integer.valueOf(s1) + Integer.valueOf(s2); // суммируем числа построчно
            }
        } catch (FileNotFoundException e) { // обработка исключения, если хотя бы один файл не найден
            throw new FileNotFoundException("Один или оба файла не найдены.");
        } catch (NumberFormatException e) { // обработка исключения, если в файле некорректные данные
            throw new NumberFormatException("Неподходящее содержимое файлов. " +
                    "Проверьте, что в файлах имеется нужное количество чисел, " +
                    "а также отсутствуют лишние символы (в том числе пустые строки).");
        } catch (Exception e) { // другие возможные исключения
            throw new Exception(e);
        } finally { // закрываем файлы, если они были открыты
            if(br1 != null)
                br1.close();
            if(br2 != null)
                br2.close();
        }
        return sum;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        String Path = "C:\\Users\\tanya\\Desktop\\test\\FileTask1";

        int f1 = rand.nextInt(10) + 1;
        int f2 = rand.nextInt(10) + 1;

        try {
            int summa = Sum(f1, f2, Path);
            System.out.println("Сумма чисел в файлах " + f1 + ".txt и " + f2 + ".txt равна " + summa + ".");
        } catch (Exception e) {
            System.out.println("Не удалось вычислить сумму чисел в файлах " + f1 + ".txt и " + f2 + ".txt.");
            System.out.println(e);
        }
    }
}