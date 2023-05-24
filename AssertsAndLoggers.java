import java.util.Random;
import java.util.logging.*;

class Dwarf {
    String name;
    int beardLen;  // длина бороды

    public Dwarf(String n, int bL)
    {
        this.name = n;
        this.beardLen = bL;
    }

    // Изменение длины бороды:
    public void beardChange(int change) {
        if(this.beardLen + change >= 0)
            this.beardLen += change;
        else
            this.beardLen = 0;
    }

    public int getBeardLen() {
        assert this.beardLen <= 100; // допустим, что борода не может вырасти более 30 единиц (абсурдная ситуация)
        return this.beardLen;
    }
}

public class AssertsAndLoggers {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(AssertsAndLoggers.class.getName());
        Dwarf pers1 = new Dwarf("Ral", 20);
        Random rand = new Random();

        // Имитируем измение длины бороды с помощью случайных чисел:
        try {
            for (int i = 0; i < 5; i++) {
                int r = rand.nextInt(41) - 20;
                log.info("Итерация " + i + ": текущая длина: " + pers1.getBeardLen() + ", изменение на " + r);
                pers1.beardChange(r);
            }
            log.info("Изменения прошли успешно");
        }
        catch (AssertionError e) {
            log.log(Level.WARNING, "Абсурдная длина бороды");
        }
    }
}