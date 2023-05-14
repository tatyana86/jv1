// класс Дварфы
// видимость полей и методов protected, т.к. у класса есть потомок
class Dwarf {
    protected String name;
    protected int age;
    protected double beardLen;  // длина бороды
    protected int job; // upd: тип String заменен на int 
					   // с кодом деятельности в текущий момент:
					   // 0 - отдыхает, 1 - работает, 2 - сражается
    protected int religion; // upd: тип String заменен на int
										// с кодом уровня поклонения:
										// 0 - неверующий, 1 - колеблющийся, 2 - верующий
    protected boolean marriage; // признак женитьбы
	
	Dwarf(String n, int a, double bl, int j, int r, boolean m) // конструктор
	{
		this.name = n;
		this.age = a;
		this.beardLen = bl;
		this.job = j; 
		this.religion = r;
		this.marriage = m;
	}
	
	// Метод роста бороды:
	protected void beardGrowth(double growth) {
		this.beardLen += growth;
	}
	
	// Метод для женитьбы:
	protected void wedding(boolean marry) {
		this.marriage = marry;
	}
}

// Класс Солдат
// видимость поля private, т.к. дочерних классов не планируется
class Soldier extends Dwarf {
	private int profession; // код профессии: 
							// 0 - отсутствует, 1 - топорщик, 2 - мечник, 3 - арбалетчик
	
	Soldier(String n, int a, double bl, int j, int r, boolean m, int pr) {
		super(n, a, bl, j, r, m); // вызов конструктора Dwarf
		this.profession = pr;
	}
}

// класс Оружие
// видимость полей и методов private, т.к. у класса нет потомков
class Weapon {
    private int arrows; // количество стрел
    private int bolts; // количество болтов
    private boolean bow; //наличие лука
    private boolean crossbow; // наличие арбалета
    private boolean shortSword; // наличие короткого меча
    private boolean dagger; // большой кинжал (есть по умолчанию)
	
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
		Soldier сrossbowman1 = new Soldier("Crossbowman", 10, 5.5, 2, 0, false, 3);
        Pasturable cow1 = new Pasturable("Cow", 1, 100, 300, false, true);
		// Покормим корову:
        cow1.eat(12);
    
    }
}