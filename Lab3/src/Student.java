public class Student {
    private String lastName;
    private int course;
    private long studentId;
    private double averageGrade;
    private String citizenship;

    public Student(String lastName, int course, long studentId, double averageGrade, String citizenship) {
        this.lastName = lastName;
        this.course = course;
        this.studentId = studentId;
        this.averageGrade = averageGrade;
        this.citizenship = citizenship;
    }

    public String getLastName() { return lastName; }
    public int getCourse() { return course; }
    public long getStudentId() { return studentId; }
    public double getAverageGrade() { return averageGrade; }
    public String getCitizenship() { return citizenship; }

    @Override
    public String toString() {
        return String.format("%-10d | %-15s | %-5d | %-6.2f | %-10s",
                studentId, lastName, course, averageGrade, citizenship);
    }
}