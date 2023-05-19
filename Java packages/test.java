import java.util.Scanner;
import TwoDimFigures.Triangle;
import ThreeDimFigures.Tetrahedron;

public class test {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Вычислим площадь треугольника.");
        System.out.print("Введите величину основания треугольника a: ");
        double base1 = keyboard.nextDouble();
        System.out.print("Введите величину высоты треугольника h, проведенного к основанию a: ");
        double height1 = keyboard.nextDouble();
        System.out.println("Площадь треугольника с основанием " + base1 + " и высотой " + height1 + " равна: " + Triangle.square(base1, height1));
		System.out.println();

        System.out.println("Вычислим объем тетраэдра.");
        System.out.print("Введите величину основания треугольника a - одной из граней тетраэдра: ");
        double base2 = keyboard.nextDouble();
        System.out.print("Введите величину высоты треугольника h, проведенного к основанию a: ");
        double height2 = keyboard.nextDouble();
        System.out.print("Введите величину высоты тетраэдра H, опущенной к выбранной грани: ");
        double heightTetr2 = keyboard.nextDouble();
        System.out.println("Объем тетраэдра с параметрами a = " + base2 + ", h = " + height2 + " и H = " + heightTetr2 + " равен: " + Tetrahedron.volume(base2, height2, heightTetr2));
    }
}