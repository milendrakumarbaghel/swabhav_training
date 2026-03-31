package streamAPI.streamAPIAssignment.employeeManagementAnalyticsSystem;

public class Employee {
    int employeeId;
    String name;
    String department;
    double salary;
    int experience;
    boolean activeStatus;

    public Employee(int employeeId, String name, String department,
                    double salary, int experience, boolean activeStatus) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.experience = experience;
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return employeeId + " | " + name + " | " + department +
                " | ₹" + salary + " | Exp: " + experience +
                " | Active: " + activeStatus;
    }
}
