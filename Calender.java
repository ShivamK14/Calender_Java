public class Calender {

  // Setup Up Caldender Data
  public static final String[] MONTHS = { "January", "February", "March", "April", "May", "June", "July", "August",
      "Sepetmber", "Octombr", "November", "December" };
  public static final int[] DAYS_OF_MONTHS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  public static final String[] DAYS_OF_WEEK = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat",
      "Sun" };

  // Check for Leap Year
  public static boolean is_leap_year(int year) {
    return year % 4 == 0;
  }

  // print Simgle Month With Proper Formatted Border here
  public static void PrintMonths(String Month, int Days_in_Months, int Year, boolean is_leap_year, int StartDay) {
    PrintBorder(56);
    PrintWeek();
    PrintBorder(56);
    PrintDays(Days_in_Months, StartDay);

  }

  public static void PrintBorder(int length) {
    System.out.print("+");
    for (int i = 1; i < length; i++) {
      if ((i % 8) == 0) {
        System.out.print("+");
      } else {
        System.out.print("-");
      }
    }
    System.out.println("+");
  }

  public static void PrintWeek() {

    for (String day : DAYS_OF_WEEK) {
      System.out.print("|  " + day + "  ");

    }
    System.out.println("|");

  }

  public static void PrintDays(int Days, int StartDay) {
    int i = 0;
    while (i < StartDay) {
      System.out.print("|       ");
      i++;
    }
    for (i = 0; i <= Days; i++) {
      System.out.print("|   " + i + "   ");
      StartDay = (StartDay + 1) % 7;
      if (StartDay == 0) {
        System.out.println("|");
      }
    }
  }

  // Main Function to print N Months starting for Specific year and month
  public static void PrintNMonths(int startYear, int startMonth, int endMonth) {
    int StarDay = CalculateStartDay();
    for (int i = 0; i < endMonth; i++) {
      PrintMonths(MONTHS[startMonth], DAYS_OF_MONTHS[startMonth], startYear, is_leap_year(startYear), StarDay);
      startMonth++;
    }
  }

  public static int CalculateStartDay() {
    return 2;
  }

  // Main Function takes start year and month
  public static void main(String[] args) {
    PrintNMonths(2024, 5, 1);
  }
}