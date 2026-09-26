package main.java.oop_concept2.class_problems;

class Delivery {
    double weight;
    double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    double calculateFee() {
        return 0;
    }

    String getType() {
        return "DELIVERY";
    }
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {

        Delivery[] deliveries = {
                new StandardDelivery(10, 50),
                new ExpressDelivery(5, 20),
                new InternationalDelivery(20, 100, 30)
        };

        double total = 0;

        for (Delivery d : deliveries) {
            double fee = d.calculateFee();

            System.out.printf("%s: %.2f%n", d.getType(), fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}