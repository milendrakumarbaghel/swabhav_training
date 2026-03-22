package assignments.assignment16_03.hospitalPatientTokenAndRecordSystem;

public abstract class Patient implements Comparable<Patient> {
    protected int patientId;
    protected String name;
    protected int age;
    protected String department;
    protected String doctorName;
    protected boolean discharged;

    public Patient(int patientId, String name, int age, String department, String doctorName) {
        if(patientId <= 0) {
            throw new IllegalArgumentException("Patient ID must be greater than 0.");
        }
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        if(age <= 0 || age > 120) {
            throw new IllegalArgumentException("Patient age must be between 1 and 120.");
        }
        if(department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty.");
        }
        if(doctorName == null || doctorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be empty.");
        }

        this.patientId = patientId;
        this.name = name.trim();
        this.age = age;
        this.department = department.trim();
        this.doctorName = doctorName.trim();
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void markDischarged() {
        this.discharged = true;
    }

    public abstract String getCategory();

    protected abstract String getCategoryInfo();

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.patientId, other.patientId);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Patient)) {
            return false;
        }
        return patientId == ((Patient)o).patientId;
    }

    @Override
    public int hashCode() {
        return patientId;
    }

    @Override
    public String toString() {
        return patientId + " | " + name + " | Age: " + age +
                " | Dept: " + department + " | Doctor: " + doctorName +
                " | Type: " + getCategory() + " | " + getCategoryInfo() +
                " | Discharged: " + discharged;
    }
}

