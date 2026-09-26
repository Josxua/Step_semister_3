package main.java.oop_concept2.class_problems;

class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    double calculateFare() {
        return 0;
    }

    String getType() {
        return "TRANSPORT";
    }
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    @Override
    String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    String getType() {
        return "METRO";
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {

        Transport[] transports = {
                new Bus(15),
                new Train(50),
                new Metro(10, 1.5)
        };

        double total = 0;

        for (Transport t : transports) {
            double fare = t.calculateFare();

            System.out.printf("%s: %.2f%n", t.getType(), fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}