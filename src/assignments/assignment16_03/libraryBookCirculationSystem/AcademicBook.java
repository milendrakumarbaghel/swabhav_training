package assignments.assignment16_03.libraryBookCirculationSystem;

public class AcademicBook extends Book{
    private String subject;
    private int semester;

    public AcademicBook(int bookId, String title, String author,
                        String subject, int semester) {

        super(bookId, title, author);
        this.subject = subject;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Subject:" + subject +
                " Semester:" + semester;
    }
}
