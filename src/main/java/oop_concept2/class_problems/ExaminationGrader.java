package main.java.oop_concept2.class_problems;

class Question {
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    double calculateScore() {
        return 0;
    }

    String getType() {
        return "QUESTION";
    }
}

class MCQ extends Question {
    MCQ(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    @Override
    String getType() {
        return "MCQ";
    }
}

class TrueFalse extends Question {
    TrueFalse(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    @Override
    String getType() {
        return "TF";
    }
}

class Essay extends Question {
    Essay(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {

        String[] keywords = correctAnswer.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }

    @Override
    String getType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {
    public static void main(String[] args) {

        Question[] questions = {
                new MCQ("Paris", "Paris", 10),
                new TrueFalse("False", "True", 5),
                new Essay(
                        "Inheritance, Polymorphism, Encapsulation",
                        "Polymorphism is one.",
                        20),
                new Essay(
                        "Abstraction, Composition",
                        "I talked about abstraction.",
                        15)
        };

        double total = 0;

        for (Question q : questions) {
            double score = q.calculateScore();

            System.out.printf("%s: %.2f%n", q.getType(), score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}