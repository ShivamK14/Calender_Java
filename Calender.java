public class Calender {

  // Setup Up Caldender Data
  public static final String[] MONTHS = { "January", "February", "March", "April", "May", "June", "July", "August",
      "Sepetmber", "Octombr", "November", "December" };
  public static final int[] DAYS_OF_MONTHS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  public static final String[] DAYS_OF_WEEK = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
      "Sunday" };
  public static int length = 84;
  public static int Lastday = 0;

  // Check for Leap Year
  public static boolean is_leap_year(int year) {
    return year % 4 == 0;
  }

  // print Simgle Month With Proper Formatted Border here
  public static void PrintMonths(String Month, int Days_in_Months, int Year, boolean is_leap_year, int StartDay) {
    Days_in_Months += is_leap_year ? 1 : 0;
    System.out.println(Month + " " + Year);
    PrintBorder(length);
    PrintWeek();
    PrintBorder(length);
    PrintDays(Days_in_Months, StartDay);

  }

  public static void PrintBorder(int length) {
    System.out.print("+");
    for (int i = 1; i < length; i++) {
      if ((i % 12) == 0) {
        System.out.print("+");
      } else {
        System.out.print("-");
      }
    }
    System.out.println("+");
  }

  public static void PrintWeek() {

    for (String day : DAYS_OF_WEEK) {
      String result = String.format("| %9s ", day);
      System.out.print(result);

    }
    System.out.println("|");

  }

  // PrintDays of Month
  public static void PrintDays(int Days, int StartDay) {
    int i = 0;
    while (i < StartDay) {
      System.out.print("|           ");
      i++;
    }
    for (i = 1; i <= Days; i++) {
      String result = String.format("|     %2d    ", i);
      System.out.print(result);
      StartDay = (StartDay + 1) % 7;
      if (StartDay == 0) {
        System.out.println("|");
        PrintBorder(length);
      }
    }
    Lastday = StartDay;

    // PrintLast Week
    while (StartDay != 0) {
      System.out.print("|           ");
      StartDay = (StartDay + 1) % 7;
    }
    System.out.println("|");
    PrintBorder(length);
  }

  // Main Function to print N Months starting for Specific year and month
  public static void PrintNMonths(int startYear, int startMonth, int endMonth) {

    for (int i = 0; i < endMonth; i++) {
      int StarDay = Lastday;

      PrintMonths(MONTHS[startMonth], DAYS_OF_MONTHS[startMonth], startYear, is_leap_year(startYear), StarDay);
      startMonth++;
    }
  }

  public static int CalculateStartDay() {
    return 2;
  }

  // Main Function takes start year and month
  public static void main(String[] args) {
    PrintNMonths(2024, 1, 3);
  }
}