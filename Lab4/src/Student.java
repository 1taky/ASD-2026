class Student {
    public String lastName;
    public String firstName;
    public String group;
    public String region;
    public String city;

    public Student(String lastName, String firstName, String group, String region, String city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.group = group;
        this.region = region;
        this.city = city;
    }

    @Override
    public String toString() {
        return "[" + region + ", м. " + city + "] - " + lastName + " " + firstName + ", Група: " + group;
    }
}