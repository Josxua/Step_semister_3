package main.java.oop_concept.class_problems;

import java.util.Arrays;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double getCompositeScore() {
            return (cgpa * 10) + (codingScore * 0.5);
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore());
        }
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] temp = new Candidate[candidates.length];
        int count = 0;

        for (int i = 0; i < candidates.length; i++) {
            if (isEligible(candidates[i].cgpa) ||
                    isEligible(candidates[i].cgpa, candidates[i].codingScore)) {

                temp[count] = candidates[i];
                count++;
            }
        }

        Candidate[] shortlisted = new Candidate[count];

        for (int i = 0; i < count; i++) {
            shortlisted[i] = temp[i];
        }

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result = result + " | ";
            }

            result = result + (i + 1) + ". "
                    + shortlisted[i].name
                    + " (" + shortlisted[i].getCompositeScore() + ")";
        }

        return result;
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}