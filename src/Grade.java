public enum Grade {
    BRONZE("Bronze",0.0),
    SILVER("Silver",0.05),
    GOLD("Gold",0.1),
    PLATINUM("Platinum",0.15);

    private final String gradeName;
    private final double discountRate;

    Grade(String gradeName, double discountRate) {
        this.gradeName = gradeName;
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public String getGradeName() {
        return gradeName;
    }
}
