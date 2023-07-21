public class Manager implements Employee {
    public static final double BONUS = 0.05;
    private static final int FIX_SALARY = 100000;
    private final int earningsForCompany;

    public Manager() {
        this.earningsForCompany = (int) (Math.random() * 25000) + 115000;
    }

    public int getMonthSalary() {
        return FIX_SALARY + (int) (earningsForCompany * BONUS);
    }
}