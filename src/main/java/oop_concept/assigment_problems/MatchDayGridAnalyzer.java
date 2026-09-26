package main.java.oop_concept.assigment_problems;

public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        int sum = 0;

        for (int i = 0; i < row.length; i++) {
            sum = sum + row[i];
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(
            int[][] runsPerOver,
            int threshold) {
        String result = "";

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);

            if (i > 0) {
                result = result + " | ";
            }

            if (average >= threshold) {
                result = result + "Match " + i + ": Power Surge";
            } else {
                result = result + "Match " + i + ": Normal";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
                { 4, 6, 8 },
                { 10, 12, 14 },
                { 2, 3, 1 }
        };

        int threshold = 8;

        System.out.println(
                classifyMatches(runsPerOver, threshold));
    }
}