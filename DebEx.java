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
        assert this.beardLen <= 10; // допустим, что борода не может вырасти более 10 единиц (абсурдная ситуация)
        return this.beardLen;
    }
}

public class DebEx {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(DebEx.class.getName());
        Dwarf pers1 = new Dwarf("Ral", 20);
        Random rand = new Random();

        // Имитируем измение длины бороды (заведомо с ошибкой):
        int r = 100;

        try {
            pers1.beardChange(r);
            System.out.println(pers1.getBeardLen());
            log.info("Изменение успешно");
        }
        catch (AssertionError e) {
            log.log(Level.WARNING, "Абсурдная длина бороды");
        }
    }
}