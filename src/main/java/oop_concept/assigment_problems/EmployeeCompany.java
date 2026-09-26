package main.java.oop_concept.assigment_problems;

public class EmployeeCompany {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeCompany(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeCompany e1 = new EmployeeCompany("Ravi", 50000);
        EmployeeCompany e2 = new EmployeeCompany("Divya", 60000);
        EmployeeCompany e3 = new EmployeeCompany("Arjun", 55000);

        EmployeeCompany.printCompanyInfo();
    }
}