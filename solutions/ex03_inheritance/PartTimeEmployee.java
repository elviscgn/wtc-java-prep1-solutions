package ex03_inheritance;

public class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;


    public PartTimeEmployee(String name, String employeeId, String department, double hoursWorked, double hourlyRate) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;

        super(name, employeeId, department);
    }

    @Override
    public double calculatePay() {
        return hoursWorked * hourlyRate;
    }

}
