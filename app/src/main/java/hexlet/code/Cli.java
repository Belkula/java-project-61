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
}
