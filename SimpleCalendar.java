import java.util.Calendar;
import java.util.GregorianCalendar;

public class SimpleCalendar {

    public static void main(String[] args) {
        int year = 2024; // Specify the year
        int month = 8; // September (0-based index, so 9 means September)

        printCalendar(year, month);
    }

    public static void printCalendar(int year, int month) {
        // Create a calendar instance
        Calendar calendar = new GregorianCalendar(year, month, 1);

        // Print the month and year
        System.out.printf("Calendar for %s %d\n", getMonthName(month), year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        // Get the first day of the week and the total number of days in the month
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Print leading spaces for the first week
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("   "); // Print empty spaces
        }

        // Print the days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);
            // Move to the next line after Saturday
            if ((day + firstDayOfWeek - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // Print an extra line at the end
    }

    public static String getMonthName(int month) {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return months[month];
    }
}
