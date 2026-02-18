package enums;

public class EnumDemo {
    public static void main(String[] args) {
        enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        Day today = Day.FRIDAY;
        System.out.println("Today is: " + today);

        enum Status {
            SUCCESS, FAILURE, PENDING
        }

        Status stats = Status.SUCCESS;

        switch(stats) {
            case SUCCESS -> System.out.println("Task Successful");
            case FAILURE -> System.out.println("Task Failed");
            case PENDING -> System.out.println("Task Pending");

        }
    }
}
