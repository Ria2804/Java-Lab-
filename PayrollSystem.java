package Lab3pgm_1;



abstract class Employee {                                                                                                                           
    private int employeeId;                                                                                                                         
    private String employeeName;                                                                                                                    
    private String designation;                                                                                                                     
                                                                                                                                                    
    // Constructor                                                                                                                                  
    public Employee(int employeeId, String employeeName, String designation) {                                                                      
        this.employeeId = employeeId;                                                                                                               
        this.employeeName = employeeName;                                                                                                           
        this.designation = designation;                                                                                                             
    }                                                                                                                                               
                                                                                                                                                    
    // Setters and Getters                                                                                                                          
    public int getEmployeeId() {                                                                                                                    
        return employeeId;                                                                                                                          
    }                                                                                                                                               
                                                                                                                                                    
    public String getEmployeeName() {                                                                                                               
        return employeeName;                                                                                                                        
    }                                                                                                                                               
                                                                                                                                                    
    public String getDesignation() {                                                                                                                
        return designation;                                                                                                                         
    }                                                                                                                                               
                                                                                                                                                    
    public void setDesignation(String designation) {                                                                                                
        this.designation = designation;                                                                                                             
    }                                                                                                                                               
                                                                                                                                                    
    // Abstract methods to be implemented by derived classes                                                                                        
    public abstract double calculateWeeklySalary();                                                                                                 
    public abstract double calculateBonus();                                                                                                        
    public abstract double calculateAnnualEarnings();                                                                                               
                                                                                                                                                    
    // Display employee information                                                                                                                 
    public void displayEmployeeInfo() {                                                                                                             
        System.out.println("Employee ID: " + employeeId);                                                                                           
        System.out.println("Name: " + employeeName);                                                                                                
        System.out.println("Designation: " + designation);                                                                                          
        System.out.println("Weekly Salary: " + calculateWeeklySalary());                                                                            
        System.out.println("Annual Earnings: " + calculateAnnualEarnings());                                                                        
        System.out.println("Bonus: " + calculateBonus());                                                                                           
    }                                                                                                                                               
}                                                                                                                                                   
                                                                                                                                                    
// Derived Class: HourlyEmployee                                                                                                                    
class HourlyEmployee extends Employee {                                                                                                             
    private double hourlyRate;                                                                                                                      
    private int hoursWorked;                                                                                                                        
                                                                                                                                                    
    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {                            
        super(employeeId, employeeName, designation);                                                                                               
        setHourlyRate(hourlyRate);                                                                                                                  
        setHoursWorked(hoursWorked);                                                                                                                
    }                                                                                                                                               
                                                                                                                                                    
    public void setHourlyRate(double hourlyRate) {                                                                                                  
        if (hourlyRate > 0) {                                                                                                                       
            this.hourlyRate = hourlyRate;                                                                                                           
        } else {                                                                                                                                    
            throw new IllegalArgumentException("Hourly rate must be positive.");                                                                    
        }                                                                                                                                           
    }                                                                                                                                               
                                                                                                                                                    
    public void setHoursWorked(int hoursWorked) {                                                                                                   
        if (hoursWorked >= 0 && hoursWorked <= 168) { // A week has 168 hours max                                                                   
            this.hoursWorked = hoursWorked;                                                                                                         
        } else {                                                                                                                                    
            throw new IllegalArgumentException("Invalid hours worked.");                                                                            
        }                                                                                                                                           
    }                                                                                                                                               
                                                                                                                                                    
    @Override                                                                                                                                       
    public double calculateWeeklySalary() {                                                                                                         
        return hourlyRate * hoursWorked;                                                                                                            
    }                                                                                                                                               
                                                                                                                                                    
    @Override                                                                                                                                       
    public double calculateBonus() {                                                                                                                
        return calculateWeeklySalary() * 0.10; // 10% bonus                                                                                         
    }                                                                                                                                               
                                                                                                                                                    
    @Override                                                                                                                                       
    public double calculateAnnualEarnings() {                                                                                                       
        return calculateWeeklySalary() * 52; // 52 weeks in a year                                                                                  
    }                                                                                                                                               
}                                                                                                                                                   
                                                                                                                                                    
// Derived Class: SalariedEmployee                                                                                                                  
class SalariedEmployee extends Employee {                                                                                                           
    private double monthlySalary;                                                                                                                   
                                                                                                                                                    
    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {                                        
        super(employeeId, employeeName, designation);                                                                                               
        setMonthlySalary(monthlySalary);                                                                                                            
    }                                                                                                                                               
                                                                                                                                                    
    public void setMonthlySalary(double monthlySalary) {                                                                                            
        if (monthlySalary > 0) {                                                                                                                    
            this.monthlySalary = monthlySalary;                                                                                                     
        } else {                                                                                                                                    
            throw new IllegalArgumentException("Monthly salary must be positive.");                                                                 
        }                                                                                                                                           
    }                                                                                                                                               
                                                                                                                                                    
    @Override                                                                                                                                       
    public double calculateWeeklySalary() {                                                                                                         
        return monthlySalary / 4; // Assuming a 4-week month                                                                                        
    }                                                                                                                                               
                                                                                                                                                    
    @Override                                                                                                                                       
    public double calculateBonus() {                                                                                                                
        return calculateWeeklySalary() * 0.15; // 15% bonus                                                                                         
    }                                                                                                                                               
                                                                                                                                                    
    @Override                                                                                                                                       
    public double calculateAnnualEarnings() {                                                                                                       
        return monthlySalary * 12;                                                                                                                  
    }                                                                                                                                               
}                                                                                                                                                   
                                                                                                                                                    
// Derived Class: ExecutiveEmployee                                                                                                                 
class ExecutiveEmployee extends SalariedEmployee {                                                                                                  
    private double bonusPercentage;                                                                                                                 
                                                                                                                                                    
    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {               
        super(employeeId, employeeName, designation, monthlySalary);                                                                                
        setBonusPercentage(bonusPercentage);                                                                                                        
    }                                                                                                                                               
                                                                                                                                                    
    public void setBonusPercentage(double bonusPercentage) {                                                                                        
        if (bonusPercentage >= 0 && bonusPercentage <= 100) {                                                                                       
            this.bonusPercentage = bonusPercentage;                                                                                                 
        } else {                                                                                                                                    
            throw new IllegalArgumentException("Bonus percentage must be between 0 and 100.");                                                      
        }                                                                                                                                           
    }                                                                                                                                               
                                                                                                                                                    
    @Override                                                                                                                                       
    public double calculateBonus() {                                                                                                                
        double baseBonus = super.calculateBonus();                                                                                                  
        return baseBonus + (getMonthlySalary() * 12) * (bonusPercentage / 100);                                                                     
    }                                                                                                                                               
                                                                                                                                                    
    private double getMonthlySalary() {                                                                                                             
        return calculateWeeklySalary() * 4; // Monthly salary from weekly calculation                                                               
    }                                                                                                                                               
                                                                                                                                                    
    @Override                                                                                                                                       
    public double calculateAnnualEarnings() {                                                                                                       
        return getMonthlySalary() * 12 + calculateBonus();                                                                                          
    }                                                                                                                                               
}                                                                                                                                                   
                                                                                                                                                    
// Main Class to demonstrate functionality                                                                                                          
public class PayrollSystem {                                                                                                                        
    public static void main(String[] args) {                                                                                                        
        // Create instances of each employee type                                                                                                   
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "Alice Johnson", "Technician", 20.0, 40);                                             
        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Bob Smith", "Professor", 4000.0);                                              
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "Carol White", "Dean", 7000.0, 20.0);                                        
                                                                                                                                                    
        // Display information and calculate payroll for each employee                                                                              
        hourlyEmployee.displayEmployeeInfo();                                                                                                       
        System.out.println();                                                                                                                       
                                                                                                                                                    
        salariedEmployee.displayEmployeeInfo();                                                                                                     
        System.out.println();                                                                                                                       
                                                                                                                                                    
        executiveEmployee.displayEmployeeInfo();                                                                                                    
        System.out.println();                                                                                                                       
    }                                                                                                                                               
}                                                                                                                                                   
                                                                                                                                                    
                                                                                                                                                    