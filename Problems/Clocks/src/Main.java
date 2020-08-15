import java.util.Scanner;

/* Product - Clock */
interface Clock {
    void tick();
}

/* Concrete Product - Sand Clock */
class SandClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...sand noise...");
    }
}

/* Concrete Product - Digital Clock */
class DigitalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...pim...");
    }
}

/* Concrete Product - Mechanical Clock */
class MechanicalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...clang mechanism...");
    }
}

class ClockFactory {

    /* It produces concrete clocks corresponding their types : Digital, Sand or Mechanical */
    public Clock produce(String type) {
        if ("Sand".equals(type)) {
            return new SandClock();
        }
        if ("Digital".equals(type)) {
            return new DigitalClock();
        }
        if ("Mechanical".equals(type)) {
            return new MechanicalClock();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.next();
        final ClockFactory clockFactory = new ClockFactory();
        final Clock clock = clockFactory.produce(type);
        clock.tick();
        scanner.close();
    }
}
