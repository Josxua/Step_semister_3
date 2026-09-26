package main.java.oop_concept2.class_problems;

class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    double calculateAmount() {
        return amount;
    }

    String getType() {
        return "PAYMENT";
    }
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount + (amount * 0.02);
    }

    @Override
    String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount + (amount * 0.01);
    }

    @Override
    String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {

        Payment[] payments = {
                new CardPayment(1000),
                new WalletPayment(500),
                new BankTransferPayment(2000)
        };

        double total = 0;

        for (Payment p : payments) {
            double amount = p.calculateAmount();

            System.out.printf("%s: %.2f%n", p.getType(), amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}