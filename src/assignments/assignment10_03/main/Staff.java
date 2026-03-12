package assignments.assignment10_03.main;

public abstract class Staff {
    private int id;
    private String name;
    private String department;

    public Staff(int id, String name, String department) {

        if (id <= 0)
            throw new IllegalArgumentException("Staff ID must be positive.");

        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty.");

        if (department == null || department.trim().isEmpty())
            throw new IllegalArgumentException("Department cannot be empty.");

        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public abstract void displayDetails();
}
