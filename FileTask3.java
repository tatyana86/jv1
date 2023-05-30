import java.io.*;
import java.util.ArrayList;

class Cat {
    String name;
    double mass;
    int fq;

    Cat(String n, double m, int f) { // конструктор
        this.name = n; // кличка
        this.mass = m; // масса
        this.fq = f; // частота мурлыканья
    }

    public void getInfo() {
        System.out.println("Информация о коте по кличке " + this.name + ":");
        System.out.println("Масса котика: " + this.mass);
        System.out.println("Частота мурлыканья котика: " + this.fq);
    }

}

public class FileTask3 {
    public static void main(String[] args) throws Exception {
        ArrayList<Cat> catsList = new ArrayList<Cat>(); // массив из объектов класса Cat
		// связываем переменную с файлом:
        File fil = new File("C:\\Users\\tanya\\Desktop\\test\\FileTask3\\Data.txt"); 
		// инициализируем перед блоком try, чтобы иметь возможность обратиться в блоке finally
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fil)); // поток для чтения файла
            String line = br.readLine(); // читаем содержимое первой строки

            while (line != null) { // выполняем команды, пока файл не пуст
				// записываем слова в строке в массив слов (разделитель - пробел):
                String[] words = line.split(" "); 
				// используем записанные элементы для создания объекта класса Cat и добавления его в массив:
                catsList.add(new Cat(words[0], Double.valueOf(words[1]), Integer.valueOf(words[2])));
                line = br.readLine(); // читаем следующую строку
            }
        } catch (FileNotFoundException e) { // обработка исключения, если файл не найден
            System.out.println("Файла не существует.");
        } catch (NumberFormatException e) { // обработка исключения, если второе значение в строке не преобразуется к double, а третье - к int
            System.out.println("Неподходящее содержимое файлов. " +
                    "Проверьте, что частота мурлыканья задана целым числом.");
        } catch (ArrayIndexOutOfBoundsException e) { // обработка исключения, если задано менее трех "слов" в строке (менее двух пробелов)
            System.out.println("Неподходящее содержимое файлов. " +
                    "Проверьте, что в каждой строке есть кличка, масса и частота, заданные через пробел.");
        } catch (Exception e) { // другие возможные исключения
            System.out.println(e);
        } finally { // закрываем файл, если он был открыт
            if(br != null)
                br.close();
        }

		// Выведем в консоль информацию об обработанных котах-объектах:
        for(int k = 0; k < catsList.size(); k ++) {
            catsList.get(k).getInfo();
        }
    }
}