// 4.1
// класс Дварфы
// видимость полей и методов protected, т.к. у класса есть потомок
class Dwarf {
    protected String name;
    protected int age;
    protected double beardLen;  // длина бороды
    protected int job; // upd: тип String заменен на int 
					   // с кодом деятельности в текущий момент:
					   // 0 - отдыхает, 1 - работает, 2 - сражается
	
	protected Weapon dwarfWeapon; // комбинация оружия дварфа в данный момент
	
	protected Animal dwarfAnimal; // животное дварфа
	
	public Dwarf(String n, int a, double bl, int j, Weapon dwW, Animal dwAn) // конструктор
	{
		this.name = n;
		this.age = a;
		this.beardLen = bl;
		this.job = j; 
		this.dwarfWeapon = dwW;
		this.dwarfAnimal = dwAn;
	}
	
	// Метод роста бороды:
	protected void beardGrowth(double growth) {
		this.beardLen += growth;
	}
	
}

// Класс Солдат
// видимость поля private, т.к. дочерних классов не планируется
class Soldier extends Dwarf {
	private int profession; // код профессии: 
							// 0 - отсутствует, 1 - топорщик, 2 - мечник, 3 - арбалетчик
	
	Soldier(String n, int a, double bl, int j, int pr, Weapon dwW, Animal dwAn) {
		super(n, a, bl, j, dwW, dwAn); // вызов конструктора Dwarf
		this.profession = pr;
	}
	
	// Геттер для получения информации об объекте Soldier:
	public void getInfo() {
		System.out.println("Информация о персонаже:");
		System.out.println("Имя: " + this.name);
		System.out.println("Возраст: " + this.age);
		System.out.println("Текущая длина бороды: " + this.beardLen);
		System.out.print("Текущая деятельность: ");
		if(this.job == 0)
			System.out.println("отдыхает"); else
		if(this.job == 1)
			System.out.println("работает"); else
		if(this.job == 2)
			System.out.println("сражается"); 
		else
			System.out.println("в разработке");
			
		System.out.println("Количество стрел: " + this.dwarfWeapon.arrows);
		System.out.println("Количество болтов: " + this.dwarfWeapon.bolts);
		System.out.print("Наличие лука: ");
		if(this.dwarfWeapon.bow)
			System.out.println("есть");
		else
			System.out.println("нет");
		System.out.print("Наличие арбалета: ");
		if(this.dwarfWeapon.crossbow)
			System.out.println("есть");
		else
			System.out.println("нет");
		System.out.print("Наличие короткого меча: ");
		if(this.dwarfWeapon.shortSword)
			System.out.println("есть");
		else
			System.out.println("нет");
		System.out.print("Наличие большого кинжала: ");
		if(this.dwarfWeapon.dagger)
			System.out.println("есть");
		else
			System.out.println("нет");
			
		System.out.print("Владение животным: " + this.dwarfAnimal.kind);
	}
		
}

// класс Оружие
// видимость полей и методов private, т.к. у класса нет потомков
class Weapon {
    protected int arrows; // количество стрел
    protected int bolts; // количество болтов
    protected boolean bow; //наличие лука
    protected boolean crossbow; // наличие арбалета
    protected boolean shortSword; // наличие короткого меча
    protected boolean dagger; // большой кинжал (есть по умолчанию)
	
	Weapon(int a, int blt, boolean b, boolean cb, boolean shSw, boolean d) // конструктор
	{
		this.arrows = a;
		this.bolts = blt;
		this.bow = b;
		this.crossbow = cb;
		this.shortSword = shSw;
		this.dagger = d;
	}
	
	// Метод для собирания стрел:
	private void findArrows(int ar) {
		this.arrows += ar;
	}
	
	// Метод для запуска стрелы при наличии лука:
	private void throwBolts() {
		if(this.bow) {
			this.arrows -= 1;
		}
	}
}

// класс Животные
// видимость полей и методов protected, т.к. у класса есть потомок
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
	
	// Метод болезнь (если животное болеет, то его ценность падает в 2 раза, и оно не может разможаться):
	protected void beSick() {
		this.value /= 2;
		this.isBreeding = false;
	}
	
	// Метод взросления (при достижении 10 единиц времени, животное теряет способность размножаться):
	void growUp() {
		this.age += 1;
		if(this.age >= 10) {
			this.isBreeding = false;
		}
	}
}

// Класс Пастбищные
// видимость полей и методов protected, 
// т.к. у класса могут быть потомки - представители пастбищных
class Pasturable extends Animal {
	protected int tile; // количество тайл травы - основная еда пастбищных
	
	Pasturable(String k, int a,int h, int v, boolean isTr, boolean isBr) {
		super(k, a, h, v, isTr, isBr); // вызов конструктора Animal
	}
	
	protected void eat(int t) {
		this.tile = t;
		int grazer = 10 * tile; // сколько голода утоляется поглощением тайла травы
		if(hunger >= grazer) 
			this.hunger -= grazer;
		else 
			this.hunger = 0;
	}
}

public class Main {
    public static void main(String[] args) {
		// Создадим объект cow1 класса Animal:
		Pasturable cow1 = new Pasturable("Cow", 1, 100, 300, false, true);
		// Создадим объект класса Weapon - некоторую комбинацю оружия:
		Weapon comb1 = new Weapon(5, 5, true, true, false, true);
		
		// Создадим композицию - объект класса Soldier (дочерний класс Dwarf) 
		// с созданными объектами cow1 и comb1 - объектами классов Pasturable и Weapon:
		Soldier сrossbowman1 = new Soldier("Crossbowman", 10, 5.5, 2, 0, comb1, cow1);

		// Выведем информацию об объекте сrossbowman1:
		сrossbowman1.getInfo();

    
    }
}