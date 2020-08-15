import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public static Time noon() {
        return Time.of(12, 0, 0);
    }

    public static Time midnight() {
        return Time.of(0, 0, 0);
    }

    public static Time ofSeconds(long seconds) {
        int hour = Math.toIntExact((seconds / 3600L) % 24L);
        int minute = Math.toIntExact((long) Math.floor((seconds % 3600L) / 60L));
        int second = Math.toIntExact(seconds % 60L);
        return Time.of(hour, minute, second);
    }

    public static Time of(int hour, int minute, int second) {
        boolean hourFits = hour >= 0 && hour < 24;
        boolean minuteFits = minute >= 0 && minute < 60;
        boolean secondFits = second >= 0 && second < 60;
        if(hour >= 0 && hour < 24) {
            if(minute >= 0 && minute < 60) {
                if(second >= 0 && second < 60) {
                    return new Time(hour, minute, second);
                }
            }
        }
        return null;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}