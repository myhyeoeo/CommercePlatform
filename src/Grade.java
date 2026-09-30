public enum Grade {
    BRONZE("Bronze",0.0),
    SILVER("Silver",0.05),
    GOLD("Gold",0.1),
    PLATINUM("Platinum",0.15);

    private final String grade;
    private final double discount;

    Grade(String grade, double discount) {
        this.grade = grade;
        this.discount = discount;
    }
}
