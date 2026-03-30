package ex03_inheritance;

public class Contractor extends Employee {
    private double dailyRate;
    private int daysWorked;


    public Contractor(String name, String employeeId, String department, double dailyRate, int daysWorked) {
        this.dailyRate = dailyRate;
        this.daysWorked = daysWorked;

        super(name, employeeId, department);
    }

    @Override
    public double calculatePay() {
        return dailyRate * daysWorked;
    }
}
