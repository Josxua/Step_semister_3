package main.java.oop_concept2.assigment_problems;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    double calculateBonus() {
        return 0;
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {

        Employee[] employees = {
                new FullTimeEmployee("Asha", 50000),
                new PartTimeEmployee("Ravi", 30000),
                new Intern("Neha", 15000)
        };

        double total = 0;

        for (Employee e : employees) {
            double bonus = e.calculateBonus();

            System.out.printf("%s: %.2f%n", e.name, bonus);

            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}