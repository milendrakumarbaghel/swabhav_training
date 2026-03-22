package assignments.assignment16_03.collegeStudentPerformanceTracker;

import java.util.*;

public class StudentService {
    public Set<Student> students = new HashSet<>();
    private TreeSet<Student> sortedStudents = new TreeSet<>();
    private Map<String, List<Student>> deptMap = new HashMap<>();

    public void addStudent(Student s) throws DuplicateStudentException {

        if(!students.add(s)) throw new DuplicateStudentException("Duplicate Student ID");

        sortedStudents.add(s);

        deptMap.computeIfAbsent(s.getDepartment(), k -> new ArrayList<>())
                .add(s);
    }

    public void displayStudents() {
        sortedStudents.forEach(System.out::println);
    }

    public void sortByName() {
        List<Student> list = new ArrayList<>(students);
        list.sort(Comparator.comparing(st -> st.name));
        list.forEach(System.out::println);
    }

    public void removeLowPerformers(double minAvg) {

        Iterator<Student> itr = students.iterator();

        while(itr.hasNext()) {
            Student s = itr.next();

            if(s.getAverage() < minAvg) {
                itr.remove();
                sortedStudents.remove(s);
                System.out.println("Removed: " + s);
            }
        }
    }

    public void displayByDepartment() {
        deptMap.forEach((dept, list) -> {
            System.out.println("\nDept: " + dept);
            list.forEach(System.out::println);
        });
    }

    public Student findStudentById(int id) {
        for(Student student : students) {
            if(student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    public void displayStudentDetails(int id) throws Exception {
        Student student = findStudentById(id);

        if(student == null) {
            throw new Exception("Student Not Found");
        }

        System.out.println("\nStudent Details");
        System.out.println("ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Department: " + student.getDepartment());
        System.out.println("Average: " + student.getAverage());

        if(student.getMarks().isEmpty()) {
            System.out.println("Subject Marks: No marks recorded");
            return;
        }

        System.out.println("Subject Marks:");
        student.getMarks().forEach((subject, mark) ->
                System.out.println(subject + " -> " + mark));
    }
}
