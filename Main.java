public class Main{
    public static void main(String[] args) {
        
        System.out.println(APCalendar.numberOfLeapYears(2020, 2024));

        System.out.println("\n" + "Testing firstDayOfYear: " + "\n" + APCalendar.day(2024));
        System.out.println(APCalendar.day(2023));
        System.out.println(APCalendar.day(2008));
        
        System.out.println(APCalendar.dayOfWeek(1, 5, 2019));
        System.out.println(APCalendar.dayOfWeek(1, 10, 2019));
    }
}