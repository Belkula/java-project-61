package hexlet.code;
import java.util.Random;
import java.util.Scanner;
public class Games {
    private static final int range = 100;
    private static final  int evem = 2;
    private static final int calc = 3;
    private static final int gcd = 4;
    private static final int progression = 5;
    private static final  int prime = 6;
    public static void launcher(Scanner scanner, int game) {
        String name = Cli.username(scanner);
        String correctAnswer;
        int steps = 3;
        int correctAnswersCount = 0;
        Random random = new Random();
        while (correctAnswersCount < steps) {
            correctAnswer = selector(game, random);
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
        System.out.println("Congratulations, " + name + "!");
    }

    private static String selector(int game, Random random) {
        switch (game) {
            case evem:
                return even(random);
            case calc:
                return calculator(random);
            case gcd:
                return gcd(random);
            case progression:
                return progression(random);
            case prime:
                return prime(random);
            default:
                return "no";
        }
    }

    public static String even(Random random) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int number = random.nextInt(range) + 1;
        System.out.println("Question: " + number);
        return (number % 2 == 0) ? "yes" : "no";
    }

    public static String calculator(Random random) {
        int num1 = random.nextInt(range) + 1;
        int num2 = random.nextInt(range) + 1;
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
        int num1 = random.nextInt(range) + 1;
        int num2 = random.nextInt(range) + 1;
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
        int minrnd = 6;
        int maxrnd = 5;
        System.out.println("What number is missing in the progression?");
        int firstNumber = random.nextInt(range);
        int step = random.nextInt(range) + 1;
        int numbers = random.nextInt(minrnd) + maxrnd;
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
        int number = random.nextInt(range) + 1;
        String result = "no";
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        System.out.println("Question: " + number);
        if (primecheck(number)) {
            result = "yes";
        }
        return result;
    }

    public static boolean primecheck(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
