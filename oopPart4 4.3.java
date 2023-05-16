// 4.3
// класс Дварфы
// видимость полей и методов protected, т.к. у класса есть потомок
class Dwarf {
    protected String name;
    protected int beardLen;  // текущая длина бороды

	Dwarf(String n, int bl) // конструктор
	{
		this.name = n;
		this.beardLen = bl;
	}
	
	// Метод роста бороды, получает один аргумент типа int - 
	// - значение, на которое выросла борода:
	public int beardGrowth(int growth) {
		this.beardLen += growth;
		return this.beardLen;
	}
	
	// Метод роста бороды, получает два аргумента:
	// 1 - типа int - значение, на которое выросла борода;
	// 2 - типа int - значение, на которое борода была обрезана в бою.
	public int beardGrowth(int growth, int trim) {
		this.beardLen = this.beardLen + growth - trim;
		if(this.beardLen < 0)
		    this.beardLen = 0;
		return this.beardLen;
	}
	
}

public class Main {
    public static void main(String[] args) {
		// Создадим объект класса Dwarf:
        Dwarf Dastot = new Dwarf("Dastot", 5);
		
		// Вызовем метод beardGrowth() с одним аргументом,
		// будет вызван соответствующий метод с одним параметром:
		System.out.println(Dastot.beardGrowth(4)); // 5 + 4 = 9
		
		// Вызовем метод beardGrowth() с двумя аргументом,
		// будет вызван соответствующий метод с двумя параметрами:
		System.out.println(Dastot.beardGrowth(0, 10)); // 9 + 0 - 10 = -1, -1 < 0 - обнуляем длину бороды
    }
}