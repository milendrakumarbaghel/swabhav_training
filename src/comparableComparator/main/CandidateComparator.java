package comparableComparator.main;

import java.util.Comparator;

public class CandidateComparator implements Comparator<Candidate> {
    public int compare(Candidate c1, Candidate c2) {
//        int name = c1.name.compareTo(c2.name);
//
//        if(name !=0) {
//            return name;
//        }

        return c2.age - c1.age;
    }
}
