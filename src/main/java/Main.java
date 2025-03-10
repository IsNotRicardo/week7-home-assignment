import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SportsTimeTracker sportsTimeTracker = new SportsTimeTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSports Time Tracker\n");
            System.out.println("1. Add activity");
            System.out.println("2. View activities");
            System.out.println("3. View total time");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("\nEnter a date in the format yyyy-mm-dd: ");
                        String date = scanner.nextLine();
                        System.out.print("Enter a start time in the format hh:mm: ");
                        String startTime = scanner.nextLine();
                        System.out.print("Enter an end time in the format hh:mm: ");
                        String endTime = scanner.nextLine();
                        System.out.print("Enter the name of the activity: ");
                        String name = scanner.nextLine();

                        try {
                            sportsTimeTracker.addActivity(LocalDateTime.parse(date + "T" + startTime),
                                    LocalDateTime.parse(date + "T" + endTime), name);
                            System.out.println("\nActivity added successfully.");
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("\nInvalid date/time format. Returning to main menu.");
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage());
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nActivities:");
                    for (SportActivity activity : sportsTimeTracker.getActivities()) {
                        System.out.println(activity.name() + " - " + activity.startTime() + " to " + activity.endTime());
                    }
                    break;
                case 3:
                    System.out.println("\nTotal time: " + sportsTimeTracker.getTotalTime() + " hours");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
