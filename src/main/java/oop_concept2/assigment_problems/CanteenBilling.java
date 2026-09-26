package main.java.oop_concept2.assigment_problems;

class Customer {
    double bill;

    Customer(double bill) {
        this.bill = bill;
    }

    double finalAmount() {
        return bill;
    }

    String getType() {
        return "CUSTOMER";
    }
}

class StudentCustomer extends Customer {
    StudentCustomer(double bill) {
        super(bill);
    }

    @Override
    double finalAmount() {
        return bill * 0.90;
    }

    @Override
    String getType() {
        return "STUDENT";
    }
}

class StaffCustomer extends Customer {
    StaffCustomer(double bill) {
        super(bill);
    }

    @Override
    double finalAmount() {
        return bill * 0.95;
    }

    @Override
    String getType() {
        return "STAFF";
    }
}

class GuestCustomer extends Customer {
    GuestCustomer(double bill) {
        super(bill);
    }

    @Override
    double finalAmount() {
        return bill + 10;
    }

    @Override
    String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {

        Customer[] customers = {
                new StudentCustomer(200),
                new StaffCustomer(300),
                new GuestCustomer(150)
        };

        double total = 0;

        for (Customer c : customers) {
            double amount = c.finalAmount();

            System.out.printf("%s: %.2f%n", c.getType(), amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}