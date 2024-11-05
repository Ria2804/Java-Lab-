package LAb3pgm2;
abstract class Employee {
    protected int employeeId;
    protected String employeeName;
    protected String designation;

    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public abstract double calculateWeeklySalary();
    public abstract double calculateAnnualEarnings();
    public abstract double calculateTotalPayroll();

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }
}

// HourlyEmployee class
class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateAnnualEarnings() {
        return calculateWeeklySalary() * 52; // Assuming 52 weeks per year
    }

    @Override
    public double calculateTotalPayroll() {
        return calculateAnnualEarnings();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
        System.out.println("Annual Earnings: $" + calculateAnnualEarnings());
        System.out.println("Total Payroll: $" + calculateTotalPayroll());
    }
}

// SalariedEmployee class
class SalariedEmployee extends Employee {
    protected double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateWeeklySalary() {
        return (monthlySalary * 12) / 52; // Convert monthly to weekly
    }

    @Override
    public double calculateAnnualEarnings() {
        return monthlySalary * 12;
    }

    @Override
    public double calculateTotalPayroll() {
        return calculateAnnualEarnings();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Monthly Salary: $" + monthlySalary);
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
        System.out.println("Annual Earnings: $" + calculateAnnualEarnings());
        System.out.println("Total Payroll: $" + calculateTotalPayroll());
    }
}

// ExecutiveEmployee class
class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    public double calculateBonus() {
        return calculateAnnualEarnings() * (bonusPercentage / 100);
    }

    @Override
    public double calculateTotalPayroll() {
        return calculateAnnualEarnings() + calculateBonus();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus Percentage: " + bonusPercentage + "%");
        System.out.println("Annual Bonus: $" + calculateBonus());
        System.out.println("Total Payroll: $" + calculateTotalPayroll());
    }
}

// Test Program
public class EmployeeTest {
    public static void main(String[] args) {
        // Create an HourlyEmployee
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "Alice Johnson", "Clerk", 20.5, 40);
        System.out.println("Hourly Employee Information:");
        hourlyEmployee.displayInfo();
        System.out.println();

        // Create a SalariedEmployee
        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Bob Smith", "Manager", 5000);
        System.out.println("Salaried Employee Information:");
        salariedEmployee.displayInfo();
        System.out.println();

        // Create an ExecutiveEmployee
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "Carol Williams", "CEO", 10000, 15);
        System.out.println("Executive Employee Information:");
        executiveEmployee.displayInfo();
        System.out.println();
    }
}
