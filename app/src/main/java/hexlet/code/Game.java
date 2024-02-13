package hexlet.code;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void launcher(Scanner scanner, int game) {
        String name = Cli.username(scanner);

        switch (game) {
            case 2:
                even(scanner, name);
                break;
            case 3:
                calculator(scanner, name);
                break;
            case 4:
                gcd(scanner, name);
                break;
            case 5:
                progression(scanner, name);
                break;
            case 6:
                prime(scanner, name);
                break;
            default:
                break;
        }
    }
    public static void even(Scanner scanner, String name) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        playGame(scanner, name, (number, answer) -> {
            String correctAnswer = (number % 2 == 0) ? "yes" : "no";
            return correctAnswer.equalsIgnoreCase(answer);
        });
    }

    public static void calculator(Scanner scanner, String name) {
        System.out.println("What is the result of the expression?");
        playGame(scanner, name, (question, answer) -> {
            String[] parts = String.valueOf(question).split("\\s+");
            int num1 = Integer.parseInt(parts[0]);
            char operator = parts[1].charAt(0);
            int num2 = Integer.parseInt(parts[2]);
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
            return Integer.parseInt(answer) == correctAnswer;
        });
    }

    public static void gcd(Scanner scanner, String name) {
        System.out.println("Find the greatest common divisor of given numbers.");
        playGame(scanner, name, (question, answer) -> {
            String[] parts = String.valueOf(question).split("\\s+");
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[1]);
            int temp;
            while (num2 != 0) {
                temp = num2;
                num2 = num1 % num2;
                num1 = temp;
            }
            return Integer.parseInt(answer) == num1;
        });
    }

    public static void progression(Scanner scanner, String name) {
        System.out.println("What number is missing in the progression?");
        playGame(scanner, name, (question, answer) -> {
            String[] parts = String.valueOf(question).split("\\s+");
            int firstNumber = Integer.parseInt(parts[0]);
            int step = Integer.parseInt(parts[2]) - firstNumber;
            int hiddenIndex = -1;
            for (int i = 0; i < parts.length; i++) {
                if (parts[i].equals("..")) {
                    hiddenIndex = i;
                    break;
                }
            }
            int hiddenNumber = firstNumber + hiddenIndex * step;
            return Integer.parseInt(answer) == hiddenNumber;
        });
    }

    public static void prime(Scanner scanner, String name) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        playGame(scanner, name, (number, answer) -> {
            boolean isPrime = true;
            if (number <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            return (isPrime && answer.equalsIgnoreCase("yes")) || (!isPrime && answer.equalsIgnoreCase("no"));
        });
    }

    public static void playGame(Scanner scanner, String name, GameLogic logic) {
        Random random = new Random();
        int correctAnswersCount = 0;
        while (correctAnswersCount < 3) {
            int number = random.nextInt(100) + 1;
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = scanner.next();
            if (logic.isCorrect(number, answer)) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '...");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

    interface GameLogic {
        boolean isCorrect(int question, String answer);
    }
}
