package assignments.assignment16_03.libraryBookCirculationSystem;

public class ValidationUtil {
    
    /**
     * Validate Book ID (must be positive)
     */
    public static boolean isValidBookId(int bookId) {
        return bookId > 0;
    }
    
    /**
     * Validate Title (not null, not empty, length between 1-100)
     */
    public static boolean isValidTitle(String title) {
        return title != null && !title.trim().isEmpty() && 
               title.trim().length() >= 1 && title.trim().length() <= 100;
    }
    
    /**
     * Validate Author (not null, not empty, length between 1-100)
     */
    public static boolean isValidAuthor(String author) {
        return author != null && !author.trim().isEmpty() && 
               author.trim().length() >= 1 && author.trim().length() <= 100;
    }
    
    /**
     * Validate Quantity (must be >= 1)
     */
    public static boolean isValidQuantity(int quantity) {
        return quantity >= 1;
    }
    
    /**
     * Validate Subject (not null, not empty, length between 1-50)
     */
    public static boolean isValidSubject(String subject) {
        return subject != null && !subject.trim().isEmpty() && 
               subject.trim().length() >= 1 && subject.trim().length() <= 50;
    }
    
    /**
     * Validate Semester (must be between 1-8)
     */
    public static boolean isValidSemester(int semester) {
        return semester >= 1 && semester <= 8;
    }
    
    /**
     * Validate Issue Month (valid month name or number)
     */
    public static boolean isValidMonth(String month) {
        if (month == null || month.trim().isEmpty()) {
            return false;
        }
        String monthUpper = month.trim().toUpperCase();
        return monthUpper.matches("(JANUARY|FEBRUARY|MARCH|APRIL|MAY|JUNE|JULY|AUGUST|SEPTEMBER|OCTOBER|NOVEMBER|DECEMBER|[1-9]|1[0-2])");
    }
    
    /**
     * Validate Issue Year (must be a valid year, not in future)
     */
    public static boolean isValidYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        return year >= 1900 && year <= currentYear;
    }
    
    /**
     * Validate Requester Name (not null, not empty, length between 1-100)
     */
    public static boolean isValidRequesterName(String name) {
        return name != null && !name.trim().isEmpty() && 
               name.trim().length() >= 1 && name.trim().length() <= 100;
    }
    
    /**
     * Validate Request ID (must be positive)
     */
    public static boolean isValidRequestId(int requestId) {
        return requestId > 0;
    }
}

