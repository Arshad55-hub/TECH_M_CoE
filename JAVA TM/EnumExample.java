enum Weekdays {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumExample {
    public static void main(String[] args) {
        Weekdays currentDay = Weekdays.SATURDAY;

        if (currentDay == Weekdays.SATURDAY || currentDay == Weekdays.SUNDAY) {
            System.out.println("Holiday");
        } else {
            System.out.println("Not Holiday");
        }
    }
}
