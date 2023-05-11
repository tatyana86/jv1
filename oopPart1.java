1.1.
a) в приложении для чтения книг может быть реализован класс book с такими полями: автор (String), название (String), год издания (int), количество страниц (int), рейтинг (double).
б) в приложении для покупки товаров может быть реализован класс product с такими полями: тип товара (String), цвет (String), стоимость (double), наличие (boolean).
в) в игре для персонажа может быть реализован класс woman с полями: имя (String), возраст (int), цвет волос (String), цвет глаз (String).
1.2.
// класс Дварфы
class Dwarf {
    String name = "Dwarf";
    int age = 0;
    double beardLen = 0;  // длина бороды
    String job = "no job"; // деятельность в текущий момент
    String religion = "dubious"; // уровень поклонения
    boolean marriage = false; // признак женитьбы
}

// класс Оружие
class Weapon {
    int arrows = 0; // количество стрел
    int bolts = 0; // количество болтов
    boolean bow = false; //наличие лука
    boolean crossbow = false; // наличие арбалета
    boolean shortSword = false; // наличие короткого меча
    boolean dagger = true; // большой кинжал (есть по умолчанию)
}

// класс Животные
class Animals {
    String kind; // вид
    int age = 0; // возраст
    int value = 0; // ценность
    boolean isTrainer = false; // способность к дрессировке
    boolean isBreeding = false; // способность к разможению

}

public class YourClassNameHere {
    public static void main(String[] args) {
        // Создадим объект Dastot класса Dwarf и заполним некоторые поля:
        Dwarf Dastot;
        Dastot = new Dwarf();
        Dastot.name = "Dastot";
        Dastot.age = 5;
        Dastot.beardLen = 10.5;

        // Создадим объект Ral класса Dwarf и заполним некоторые поля:
        Dwarf Ral;
        Ral = new Dwarf();
        Ral.name = "Ral";
        Ral.age = 7;
        Ral.beardLen = 15.0;
        Ral.job = "on break";
        Ral.religion = "ardent";

        // Создадим объект DastotWeapon класса Weapon и заполним некоторые поля:
        Weapon DastotWeapon;
        DastotWeapon = new Weapon();
        DastotWeapon.bolts = 10;
        DastotWeapon.crossbow = true;

        // Создадим объект RalWeapon класса Weapon и заполним некоторые поля:
        Weapon RalWeapon;
        RalWeapon = new Weapon();
        RalWeapon.bow = true;
        RalWeapon.crossbow = true;
        RalWeapon.shortSword = true;

        // Создадим объект Dog класса Animals и заполним некоторые поля:
        Animals Dog;
        Dog = new Animals();
        Dog.kind = "Dog";
        Dog.age = 10;
        Dog.value = 30;
        Dog.isTrainer = true;
        Dog.isBreeding = true;

        // Создадим объект Mule класса Animals и заполним некоторые поля:
        Animals Mule;
        Mule = new Animals();
        Mule.kind = "Mule";
        Mule.age = 5;
        Mule.value = 200;

        // Информация о дварфе Dastot
        System.out.println("Возраст " + Dastot.name + ": " + Dastot.age);
        System.out.println("Длина бороды " + Dastot.name + ": " + Dastot.beardLen);
        System.out.println("Статус работы в настоящий момент " + Dastot.name + ": " + Dastot.job);
        System.out.println("Уровень поклонения " + Dastot.name + ": " + Dastot.religion);

        // Информация о дварфе Ral
        System.out.println("Возраст " + Ral.name + ": " + Ral.age);
        System.out.println("Длина бороды " + Ral.name + ": " + Ral.beardLen);
        System.out.println("Статус работы в настоящий момент " + Ral.name + ": " + Ral.job);
        System.out.println("Уровень поклонения " + Ral.name + ": " + Ral.religion);

        // Информация о некотором оружии дварфа Dastot
        System.out.println("У " + Dastot.name + " имеется: " + DastotWeapon.bolts + " болтов и " + DastotWeapon.arrows + " стрел." );

        // Информация о некотором оружии дварфа Ral
        System.out.println("У " + Ral.name + " имеется: " + RalWeapon.bolts + " болтов и " + RalWeapon.arrows + " стрел." );

        // Информация о ценности собаке:
        System.out.println("Ценность вида " + Dog.kind + ": " + Dog.value);

        // Информация о ценности мула:
        System.out.println("Ценность вида " + Mule.kind + ": " + Mule.value);
    }
}
1.3.
// класс Дварфы
class Dwarf {
    int age = 0;
}

public class Main {
    public static void main(String[] args) {
        // Создадим объекты Dastot1 и Dastot2 класса Dwarf и заполним поле Dastot1:
        Dwarf Dastot1 = new Dwarf();
        Dwarf Dastot2 = new Dwarf();
        Dastot1.age = 5;
    
        // Присваиваем переменной Dastot2 объект Dastot1:
        Dastot2 = Dastot1;
        // Изменяем поле age объекта Dastot1:
        Dastot1.age = 7; // изменили значение с 5 на 7
        // Посмотрим, какое значение принимает поле age объекта Dastot1:
        System.out.println(Dastot2.age); // 7
        
        // Значение в поле переменной Dastot2 также изменилось на 7, 
        // так как в этой переменной хранится не само значение, а ссылка в памяти на него.
    }
}