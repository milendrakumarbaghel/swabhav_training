package assignments.assignment16_03.libraryBookCirculationSystem;

public class AcademicBook extends Book {
    private String subject;
    private int semester;

    public AcademicBook(int bookId, String title, String author,
                        String subject, int semester, int quantity) {
        super(bookId, title, author, quantity);
        
        if (!ValidationUtil.isValidSubject(subject)) {
            throw new IllegalArgumentException("Invalid subject");
        }
        if (!ValidationUtil.isValidSemester(semester)) {
            throw new IllegalArgumentException("Semester must be between 1 and 8");
        }
        
        this.subject = subject;
        this.semester = semester;
    }

    public String getSubject() {
        return subject;
    }
    
    public int getSemester() {
        return semester;
    }

    @Override
    public String displayBook() {
        return super.displayBook() + " Subject: " + subject + " Semester: " + semester;
    }
}
