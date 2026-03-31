package ex03_inheritance;

public class Contractor extends Employee {
    private double dailyRate;
    private int daysWorked;
    private String company;

    public Contractor(String name, String employeeId, String department, double dailyRate, int daysWorked, String company) {
        this.dailyRate = dailyRate;
        this.daysWorked = daysWorked;
        this.company = company;

        super(name, employeeId, department);
    }

    @Override
    public double calculatePay() {
        return dailyRate * daysWorked;
    }
}
