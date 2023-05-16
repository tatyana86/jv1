// 4.2
import java.util.Random;

// класс Животные
class Animal {
    protected String kind; // вид
    protected int age; // возраст
	protected int hunger; // upd: добавлено новое поле, голод
    protected int value; // ценность
    protected boolean isTrainer; // способность к дрессировке
    protected boolean isBreeding; // способность к разможению
	
	Animal(String k, int a,int h, int v, boolean isTr, boolean isBr) // конструктор
	{
		this.kind = k;
		this.age = a;
		this.hunger = h;
		this.value = v;
		this.isTrainer = isTr;
		this.isBreeding = isBr;
	}
	
	// Метод foo класса Animal:
	void foo() {
		System.out.println("Animal");
	}
}

// Класс Пастбищные
class Pasturable extends Animal {
	protected int tile; // количество тайл травы - основная еда пастбищных
	
	Pasturable(String k, int a,int h, int v, boolean isTr, boolean isBr) {
		super(k, a, h, v, isTr, isBr); // вызов конструктора Animal
	}

	// Метод foo класса Pasturable:	
	void foo() {
		System.out.println("Pasturable");
	}
}

// Класс Боевые
class TrainableWar extends Animal {
	protected int force; // количество боевой силы животного
	
	TrainableWar(String k, int a,int h, int v, boolean isTr, boolean isBr) {
		super(k, a, h, v, isTr, isBr); // вызов конструктора Animal
		this.isTrainer = true; // боевое животное обладает способностью к тренировкам
	}
	
	// Метод foo класса TrainableWar:	
	void foo() {
		System.out.println("TrainableWar");
	}
}

public class Main {
    public static void main(String[] args) {
		// Создадим объекты классов Animal, Pasturable и TrainableWar:
		Animal cat1 = new Animal("Cat", 2, 50, 20, false, true);
		Pasturable cow1 = new Pasturable("Cow", 1, 100, 300, false, true);
		TrainableWar dragon1 = new TrainableWar("Dragon", 20, 300, 10000, true, true);
		
		// Вызовем метод foo() для созданных объектов:
		cat1.foo(); // Animal
		cow1.foo(); // Pasturable
		dragon1.foo(); // TrainableWar
		
		// Создадим массив и заполним его случаными объектами дочерних классов:
		Random rand = new Random();
		int r; // случанойное число 0 или 1		
		Animal[] arr1 = new Animal[500];
		
		for(int i = 0; i < 500; i++) {
			r = rand.nextInt(2); // если 0 - создаем объект класса Pasturable, 1 - класса TrainableWar
			System.out.print(r + " - ");
			if(r == 0) 
				arr1[i] = new Pasturable("Cow", 1, 100, 300, false, true);
			else
				arr1[i] = new TrainableWar("Dragon", 20, 300, 10000, true, true);
			
			// Если сгенерирован объект класса Pasturable, то будет вызван метод foo(), 
			// определенный в данном классе, и аналогично, если создан объект класса TrainableWar,
			// то будет вызван метод foo(), также определенный в данном классе
			arr1[i].foo();
		}
    }
}