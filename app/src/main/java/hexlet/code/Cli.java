package hexlet.code;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Cli {
    public static  String username(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }
    public static void Even (Scanner scanner){
        Random random = new Random();
        String name = username(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswersCount = 0;
        while (correctAnswersCount < 3) {
            int number = random.nextInt(100) + 1;
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            String correctAnswer = (number % 2 == 0) ? "yes" : "no";
            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            } else {
                System.out.println("Correct!");
                correctAnswersCount++;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

        public static void Calculator (Scanner scanner) {
            Random random = new Random();
            String name = username(scanner);
            char[] operators = {'+', '-'};
            System.out.println("What is the result of the expression?");
            int correctAnswersCount = 0;
            while (correctAnswersCount < 3) {
                int num1 = random.nextInt(100) + 1;
                int num2 = random.nextInt(100) + 1;
                char operator = operators[random.nextInt(2)];
                String question = num1 + " " + operator + " " + num2;
                int correctAnswer;
                switch (operator) {
                    case '+':
                        correctAnswer = num1 + num2;
                        break;
                    case '-':
                        correctAnswer = num1 - num2;
                        break;
                    default:
                        correctAnswer = num1 + num2;
                }
                System.out.println("Question: " + question);
                System.out.print("Your answer: ");
                int userAnswer = scanner.nextInt();

                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!");
                    correctAnswersCount++;
                } else {
                    System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                    System.out.println("Let's try again, " + name + "!");
                    return;
                }
                scanner.nextLine();
            }
            System.out.println("Congratulations, " + name + "!");
        }

    public static void GDD (Scanner scanner) {
        Random random = new Random();
        String name = username(scanner);
        char[] operators = {'+', '-'};
        System.out.println("Find the greatest common divisor of given numbers.");
        int correctAnswersCount = 0;
        while (correctAnswersCount < 3) {
            int num1 = random.nextInt(100) + 1;
            int num2 = random.nextInt(100) + 1;
            String question = num1 + " " + num2;
            int temp = 0;
            while (num2 != 0) {
                temp = num2;
                num2 = num1 % num2;
                num1 = temp;
            }
            int correctAnswer = temp;
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
            scanner.nextLine();
        }
        System.out.println("Congratulations, " + name + "!");
    }

    public static void Progression(Scanner scanner) {
        Random random = new Random();
        String name = username(scanner);
        System.out.println("What number is missing in the progression?");
        int correctAnswersCount = 0;
        while (correctAnswersCount < 3) {
            int progressionLength = random.nextInt(6) + 5;
            int hidden = random.nextInt(progressionLength);
            int firstNumber = random.nextInt(100);
            int step = random.nextInt(10) + 1;
            System.out.print("Question: ");
            for (int i = 0; i < progressionLength; i++) {
                if (i == hidden) {
                    System.out.print(".. ");
                } else {
                    System.out.print(firstNumber + step * i + " ");
                }
            }
            System.out.println();

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            if (userAnswer == firstNumber + step * hidden) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + (firstNumber + step * hidden) + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }
    }
