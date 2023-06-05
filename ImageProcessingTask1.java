import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ImageProcessingTask1 {

    public static boolean ConvImageExt(String extOld, String extNew)  {
        File root = new File(".\\"); // связываем переменную root с текущей директорией
        ArrayList<File> expand = new ArrayList<File>(); // массив для файлов и каталогов в текущей директории
        expand.addAll(Arrays.asList(root.listFiles())); // добавляем все файлы и подкаталоги полученной директории

        try {
            // Проходимся по содержимому директории:
            for (File file : expand) {
                String fileName = file.getName(); // запишем название файла
                // В названии есть переданное расширение?
                if(fileName.contains("." + extOld)) {
                    // Создаем переменную с изображением нужного расширения:
                    BufferedImage image = ImageIO.read(file);
                    // Сохраняем изображение с новым расширением:
                    ImageIO.write(image, extNew, new File(".\\" + fileName.substring(0, fileName.indexOf(".")) + "." + extNew));
                    // Удаляем файл со старым расширением:
                    file.delete();
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Возникла проблема: " + e);
            return false;
        }
    }


    public static void main(String[] args) throws IOException {

        String ext1 = "jpg"; // искомое расширение
        String ext2 = "png"; // новое расширение

        if(ConvImageExt(ext1, ext2))
            System.out.println("Все найденные изображения ." + ext1 + " переконвертированы в ." + ext2 + ".");
        else
            System.out.println("Не удалось выполнить конвертацию.");
    }
}