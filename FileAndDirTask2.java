/*4.2. Напишите функцию с тремя параметрами (путь к каталогу, расширение файла и булев флажок), которая возвращает список из двух списков имён:
список всех файлов с заданным расширением в заданном каталоге (включая файлы из его подкаталогов одного уровня вложенности, если флажок = true),
и список всех подкаталогов в заданном каталоге (включая подкаталоги одного уровня вложенности, если флажок = true).*/

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileAndDirTask2 {

    public static ArrayList<ArrayList<File>> FilesAndDir(String pn, String extension, boolean needSubdir) {
        File root = new File(pn); // связываем переменную root с полученной директорией
        ArrayList<File> filesWithExt = new ArrayList<File>(); // массив для записи файлов с заданным расширением
        ArrayList<File> dir = new ArrayList<File>(); // массив для записи подкаталогов
        ArrayList<ArrayList<File>> result = new ArrayList<>(); // итоговый массив, получаемый из двух вышеописанных массивов
        ArrayList<File> expand = new ArrayList<File>(); // массив путей файлов и каталогов в текущей директории
        expand.addAll(Arrays.asList(root.listFiles())); // все файлы и подкаталоги полученной директории

        int depth = 0; // по умолчанию, вложенность = 0 (анализирутся содержимое только переданной директории)
        // если получено true в качестве 3-го аргумента, то уровень вложенности изменяем на 1
        if(needSubdir) {
            depth = 1;
        }

        // Анализируем содержимое директории в зависимости от уровня вложенности:
        for(int d = 0; d <= depth; d ++) {
            // создаем стандартный массив с известным количеством элементов,
            // добавляя в него элементы ранее созданного массива expand
            // с помощью метода .toArray(), позволяющего преобразовать элементы ArrayList<>
            File[] expandCopy = expand.toArray(new File[expand.size()]);
            expand.clear();  // очищаем массив, чтобы в дальнейшем записать в него пути файлов обнаруженных поддиректорий

            // Проходимся по содержимому директории:
            for (File file : expandCopy) {
                // Это директория?
                if(file.isDirectory()) {
                    // Добавляем файл в массив, чтобы проверить ее содержимое далее при переданном флаге true
                    expand.addAll(Arrays.asList(file.listFiles()));
                    // Добавляем файл в массив, где храним все найденные каталоги
                    dir.add(file);
                }
                String fileName = file.getName(); // запишем название файла в тип данных String
                // В названии есть переданное расширение?
                if(fileName.contains("." + extension)) {
                    // Добавляем файл в массив, где храним все найденные файлы с переданным расширением
                    filesWithExt.add(file);
                }
            }
        }

        // Добавляем массивы в результирующий:
        result.add(filesWithExt);
        result.add(dir);

        // Возвращаем массив массивов (список списков):
        return result;
    }


    public static void main(String[] args) {
        String path = "C:\\Users\\tanya\\Desktop\\test\\TestFiles"; // переданная директория
        String ext = "txt"; // искомое расширение
        boolean flag = true; // будем искать файлы в подкаталоге переданной директории?

        System.out.println(FilesAndDir(path, ext, flag));
    }
}