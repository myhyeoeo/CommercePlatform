public class Customer {
    private String name;
    private String email;
    private String grade;

    public Customer(String name, String email, String grade) {
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }
}
