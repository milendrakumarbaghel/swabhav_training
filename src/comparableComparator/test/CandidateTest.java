package comparableComparator.test;

import comparableComparator.main.Candidate;
import comparableComparator.main.CandidateComparator;

import java.util.*;

public class CandidateTest {
    static void main() {
        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(new Candidate("Abhishek", 24));
        candidateList.add(new Candidate("shyam", 20));
        candidateList.add(new Candidate("raju", 29));
        candidateList.add(new Candidate("lakshman", 10));

//        candidateList.add(new Candidate("Abhishek", 24));
//        candidateList.add(new Candidate("Abhishek", 20));
//        candidateList.add(new Candidate("Abhishek", 29));
//        candidateList.add(new Candidate("Abhishek", 10));

//        Collections.sort(candidateList, new CandidateComparator());

//        Collections.sort(candidateList, (c1, c2) -> {
//            int nameCompare = c1.name.compareTo(c2.name);
//            if(nameCompare != 0)
//                return nameCompare;
//            return c1.age - c2.age;
//        });

        candidateList.sort(
                Comparator.comparing((Candidate c) -> c.name)
                        .thenComparing(c -> c.age)
        );


        for(Candidate candidate : candidateList) {
            System.out.println(candidate.name + " " + candidate.age);
        }


//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter number of candidates: ");
//        int n = scanner.nextInt();
//        scanner.nextLine();
//
//        List<Candidate> list = new ArrayList<>();
//
//        for(int i = 0; i < n; i++) {
//            System.out.println("\nEnter Candidate " + (i+1) + " details");
//
//            System.out.print("Name: ");
//            String name = scanner.nextLine();
//
//            System.out.print("Age: ");
//            int age = scanner.nextInt();
//            scanner.nextLine();
//
//            list.add(new Candidate(name, age));
//        }
//
//        Collections.sort(list, new CandidateComparator());
//
//        System.out.println("\nSorted Candidate List:");
//
//        for(Candidate c : list) {
//            System.out.println(c.name + " " + c.age);
//        }
//
//        scanner.close();
    }
}
