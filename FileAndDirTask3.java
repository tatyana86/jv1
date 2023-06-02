/* 4.3. Напишите функцию, которая удаляет заданный каталог (возможно, непустой) и все файлы внутри него. Если внутри каталога есть подкаталоги, ничего удалять не надо. Функция возвращает флажок успешно/неудача. */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileAndDirTask3 {

    public static boolean DelDir(String pn) {

        try {
            File root = new File(pn); // связываем переменную root с полученной директорией
            ArrayList<File> expand = new ArrayList<File>(); // массив путей файлов и каталогов в текущей директории
            expand.addAll(Arrays.asList(root.listFiles())); // все файлы и подкаталоги полученной директории

            // создаем стандартный массив с известным количеством элементов,
            // добавляя в него элементы ранее созданного массива expand
            // с помощью метода .toArray(), позволяющего преобразовать элементы ArrayList<>
            File[] expandCopy = expand.toArray(new File[expand.size()]);

            // Проходимся по содержимому директории:
            for (File file : expandCopy) {
                // Это директория?
                if (file.isDirectory()) {
                    return false; // возвращаем false и выходим из функции
                }
            }

            // Если дошли досюда, то подкаталогов не найдено
            // Проходимся по содержимому директории и удаляем все файлы:
            for (File file : expandCopy) {
                file.delete();
            }

            root.delete(); // теперь можем удалить пустую папку

            // если во время выполнения программы какой-либо файл открыт, то удалить его не удастся,
            // поэтому проверяем, успешно ли удаление исходной директории
            if(root.exists())
                return false; // скорее всего какие-то файлы используются другими програмамми и не могут быть удалены
            return true; // удаление пришло успешно

        } catch (NullPointerException e) { // ловим исключение, если переданной директории не существует
            System.out.println("Выбранного каталога не существует.");
            return false;
        }
    }


    public static void main(String[] args) {
        String path = "C:\\Users\\tanya\\Desktop\\test\\TestFiles2"; // переданная директория

        if(DelDir(path))
            System.out.println("Удаление прошло успешно.");
        else
            System.out.println("Удаление не выполнено.");
    }
}