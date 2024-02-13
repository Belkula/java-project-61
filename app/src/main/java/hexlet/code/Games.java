package hexlet.code;
import java.util.Random;
import java.util.Scanner;
public class Games {
    public static void launcher(Scanner scanner, int game) {
        String name = Cli.username(scanner);
        String correctAnswer;
        int correctAnswersCount = 0;
        Random random = new Random();
        while (correctAnswersCount < 3) {
            switch (game) {
                case 2:
                    correctAnswer = even(random);
                    break;
                case 3:
                    correctAnswer = calculator(random);
                    break;
                case 4:
                    correctAnswer = gcd(random);
                    break;
                case 5:
                    correctAnswer = progression(random);
                    break;
                case 6:
                    correctAnswer = prime(random);
                    break;
                default:
                    correctAnswer = "No";
                    break;
            }
            System.out.print("Your answer: ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was " + correctAnswer);
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
    }

    public static String even(Random random) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int number = random.nextInt(100) + 1;
        System.out.println("Question: " + number);
        return (number % 2 == 0) ? "yes" : "no";
    }

    public static String calculator(Random random) {
        int num1 = random.nextInt(100) + 1;
        int num2 = random.nextInt(100) + 1;
        String result;
        String question;
        boolean operator = random.nextBoolean();
        System.out.println("What is the result of the expression?");
        if (!operator) {
            result = String.valueOf(num1 - num2);
            question = num1 + " - " + num2;
        } else {
            result = String.valueOf(num1 + num2);
            question = num1 + " + " + num2;
        }
        System.out.println("Question: " + question);
        return result;
    }

    public static String gcd(Random random) {
        System.out.println("Find the greatest common divisor of given numbers.");
        int num1 = random.nextInt(100) + 1;
        int num2 = random.nextInt(100) + 1;
        int gcd;
        String question =  num1 + " " + num2;
        while (num2 != 0) {
            gcd = num2;
            num2 = num1 % num2;
            num1 = gcd;
        }
        System.out.println("Question: " + question);
        return String.valueOf(num1);
    }

    public static String progression(Random random) {
        System.out.println("What number is missing in the progression?");
        int firstNumber = random.nextInt(100);
        int step = random.nextInt(10) + 1;
        int numbers = random.nextInt(6) + 5;
        int hiddenIndex = random.nextInt(numbers);
        String result = String.valueOf(firstNumber + hiddenIndex * step);
        String question = "";
        for (int i = 0; i < numbers; i++) {
            if (i == hiddenIndex) {
                question += (".. ");
            } else {
                question += String.valueOf(firstNumber + step * i) + (" ");
            }
        }
        System.out.println("Question: " + question);
        return result;
    }

    public static String prime(Random random) {
        int number = random.nextInt(100) + 1;
        String result = "no";
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        System.out.println("Question: " + number);
        if (number <= 1) {
            result = "yes";
        } else {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    result = "no";
                    break;
                }
            }
        }
        return result;
    }
}
