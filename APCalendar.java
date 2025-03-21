public class APCalendar{

    /** Returns true if year is a leap year and false otherwise. */
    private static boolean isLeapYear(int year){
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    /** Returns the number of leap years between year1 and year2, inclusive.
    * Precondition: 0 <= year1 <= year2
    */
    public static int numberOfLeapYears(int year1, int year2){
        int count = 0;
        for(int i = year1; i <= year2; i++){
            if(isLeapYear(i)){
                count++;
            }
        }
        return count;
    }

    /** Returns the value representing the day of the week for the first day of year,
    * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
    */
    private static int firstDayOfYear(int year){
        //only works for the 2000s
        int lastTwo = year - 2000 ;
        lastTwo += lastTwo/4 ;
        lastTwo += 6 + 1 ;
        if(isLeapYear(year)){
            lastTwo -= 1 ;
        }
        int ans = lastTwo % 7 ;
        return ans ;
    }

    //To access the private methods
    public static int day(int year){
        return firstDayOfYear(year);
    }
    public static int day(int month, int day, int year){
        return dayOfYear(month, day, year) ;
    }

    /** 
    * JFM: 033, AMJ: 614, JAS: 625, OND: 035. 
    */
    private static int monthCode(int month){
        if(month == 1 || month == 10 ){
            return 0;
        } else if (month == 2 || month == 3 || month == 11){
            return 3;
        } else if (month == 4 || month == 7){
            return 6;
        } else if(month == 5){
            return 1;
        } else if(month == 6){
            return 4; 
        } else if(month == 8){
            return 2;
        } else if(month == 9 || month == 12){
            return 5;
        }
        return -1;
    }

    /** Returns n, where month, day, and year specify the nth day of the year.
    * Returns 1 for January 1 (month = 1, day = 1) of any year.
    * Precondition: The date represented by month, day, year is a valid date.
    */
    private static int dayOfYear(int month, int day, int year){
        int lastTwo = year - 2000 ;
        lastTwo += lastTwo/4 ;
        lastTwo += 6 + day ;
        lastTwo += monthCode(month);
        if(isLeapYear(year) && (month == 1 || month == 2)){
            lastTwo -= 1 ;
        }
        int ans = lastTwo % 7 ;
        return ans ;
    }
    
    /** Returns the value representing the day of the week for the given date
    * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
    * and 6 denotes Saturday.
    * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year){
        int additional = dayOfYear(month, day, year) - 1;
        return (firstDayOfYear(year) + additional) % 7;
    }
    // There may be instance variables, constructors, and other methods not shown.
}