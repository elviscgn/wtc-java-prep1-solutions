package ex03_inheritance;

public class Employee {
    private String name;
    private String employeeId;
    private String department;

    public Employee(String name, String employeeId, String department) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
    }

    public double calculatePay() {
        return 0;
    }

    public void printPaySlip() {
        System.out.println("Payslip");
        System.out.println("Payment: " + calculatePay());
    }

}

