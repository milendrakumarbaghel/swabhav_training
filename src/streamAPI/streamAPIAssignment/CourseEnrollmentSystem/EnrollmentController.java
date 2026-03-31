package streamAPI.streamAPIAssignment.CourseEnrollmentSystem;

import java.util.*;
import java.util.stream.Collectors;

public class EnrollmentController {
    private List<Participant> participants = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {

        participants.add(new Participant(1, "Amit", "Java", 85, true, "Rahul"));
        participants.add(new Participant(2, "Ravi", "Java", 92, true, "Rahul"));
        participants.add(new Participant(3, "Sita", "Python", 88, false, "Anita"));
        participants.add(new Participant(4, "Geeta", "Python", 95, true, "Anita"));

        int choice;

        do {
            System.out.println("\nCourse Menu ");
            System.out.println("1. Add Participant");
            System.out.println("2. Completed Participants");
            System.out.println("3. Group by Course");
            System.out.println("4. Average Score Course-wise");
            System.out.println("5. Topper of Each Course");
            System.out.println("6. Trainers Set");
            System.out.println("7. Sort by Score Desc");
            System.out.println("8. Course -> Completed Count");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addParticipant();
                case 2 -> completedParticipants();
                case 3 -> groupByCourse();
                case 4 -> averageScore();
                case 5 -> topperByCourse();
                case 6 -> trainersSet();
                case 7 -> sortByScoreDesc();
                case 8 -> completedCountByCourse();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    private void addParticipant() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Score: ");
        double score = sc.nextDouble();

        System.out.print("Completed (true/false): ");
        boolean completed = sc.nextBoolean();
        sc.nextLine();

        System.out.print("Enter Trainer: ");
        String trainer = sc.nextLine();

        participants.add(new Participant(id, name, course, score, completed, trainer));
        System.out.println("Participant added!");
    }

    private void completedParticipants() {
        List<Participant> result = participants.stream()
                .filter(Participant::isCompleted)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private void groupByCourse() {
        Map<String, List<Participant>> result = participants.stream()
                .collect(Collectors.groupingBy(Participant::getCourseName));
        System.out.println(result);
    }

    private void averageScore() {
        Map<String, Double> result = participants.stream()
                .collect(Collectors.groupingBy(
                        Participant::getCourseName,
                        Collectors.averagingDouble(Participant::getScore)
                ));
        System.out.println(result);
    }

    private void topperByCourse() {
        Map<String, Optional<Participant>> result = participants.stream()
                .collect(Collectors.groupingBy(
                        Participant::getCourseName,
                        Collectors.maxBy(Comparator.comparing(Participant::getScore))
                ));
        System.out.println(result);
    }

    private void trainersSet() {
        Set<String> result = participants.stream()
                .map(Participant::getTrainerName)
                .collect(Collectors.toSet());
        System.out.println(result);
    }

    private void sortByScoreDesc() {
        List<Participant> result = participants.stream()
                .sorted(Comparator.comparing(Participant::getScore).reversed())
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private void completedCountByCourse() {
        Map<String, Long> result = participants.stream()
                .collect(Collectors.groupingBy(
                        Participant::getCourseName,
                        Collectors.filtering(Participant::isCompleted, Collectors.counting())
                ));
        System.out.println(result);
    }
}
