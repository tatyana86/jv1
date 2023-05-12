// класс Дварфы
class Dwarf {
    String name;
    int age;
    double beardLen;  // длина бороды
    String job = "no job"; // деятельность в текущий момент
    String religion = "dubious"; // уровень поклонения
    boolean marriage = false; // признак женитьбы
	
	Dwarf(String n, int a) // конструктор
	{
		this.name = n;
		this.age = a;
		this.beardLen = 0;
	}
	
	// Метод роста бороды:
	void beardGrowth(double growth) {
		this.beardLen += growth;
	}
	
	// Метод для женитьбы:
	void wedding(boolean marry) {
		this.marriage = marry;
	}
}

// класс Оружие
class Weapon {
    int arrows = 0; // количество стрел
    int bolts = 0; // количество болтов
    boolean bow = false; //наличие лука
    boolean crossbow = false; // наличие арбалета
    boolean shortSword = false; // наличие короткого меча
    boolean dagger = true; // большой кинжал (есть по умолчанию)
	
	// Метод для собирания стрел:
	void findArrows(int ar) {
		this.arrows += ar;
	}
	
	// Метод для запуска стрелы при наличии лука:
	void throwBolts() {
		if(this.bow) {
			this.arrows -= 1;
		}
	}
}

// класс Животные
class Animal {
    String kind; // вид
    int age; // возраст
    int value; // ценность
    boolean isTrainer; // способность к дрессировке
    boolean isBreeding; // способность к разможению
	
	Animal(String k, int a, int v, boolean isTr, boolean isBr) // конструктор
	{
		this.kind = k;
		this.age = a;
		this.value = v;
		this.isTrainer = isTr;
		this.isBreeding = isBr;
	}
	
	// Метод болезнь (если животное болеет, то его ценность падает в 2 раза, и оно не может разможаться):
	void beSick() {
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