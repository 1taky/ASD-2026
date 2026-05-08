class Student {
    String lastName;
    String firstName;
    double averageGrade;
    int course;
    String phone;

    public Student(String lastName, String firstName, double averageGrade, int course, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.averageGrade = averageGrade;
        this.course = course;
        this.phone = phone;
    }

    public String getOperator() {
        if (phone.startsWith("067") || phone.startsWith("068"))
            return "Kyivstar";
        if (phone.startsWith("050") || phone.startsWith("066"))
            return "Vodafone";
        return "Lifecell";
    }

    @Override
    public String toString() {
        return lastName + " " + firstName +
                ", Avg: " + averageGrade +
                ", Course: " + course +
                ", Phone: " + phone;
    }
}