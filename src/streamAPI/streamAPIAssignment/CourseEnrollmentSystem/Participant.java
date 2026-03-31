package streamAPI.streamAPIAssignment.CourseEnrollmentSystem;

import java.util.Objects;

public class Participant {
    private int participantId;
    private String name;
    private String courseName;
    private double score;
    private boolean completed;
    private String trainerName;

    public Participant(int participantId, String name, String courseName,
                       double score, boolean completed, String trainerName) {
        this.participantId = participantId;
        this.name = name;
        this.courseName = courseName;
        this.score = score;
        this.completed = completed;
        this.trainerName = trainerName;
    }

    public int getParticipantId() { return participantId; }
    public String getName() { return name; }
    public String getCourseName() { return courseName; }
    public double getScore() { return score; }
    public boolean isCompleted() { return completed; }
    public String getTrainerName() { return trainerName; }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + participantId +
                ", name='" + name + '\'' +
                ", course='" + courseName + '\'' +
                ", score=" + score +
                ", completed=" + completed +
                ", trainer='" + trainerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant that = (Participant) o;
        return participantId == that.participantId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantId);
    }
}
