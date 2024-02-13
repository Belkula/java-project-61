package hexlet.code;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit\n"
                + "Your choice: ");
        int game = scanner.nextInt();
        scanner.nextLine();
        switch (game) {
            case 6:
            case 5:
            case 4:
            case 3:
            case 2:
                Game.launcher(scanner, game);
                break;
            case 1:
                Cli.username(scanner);
                break;
            case 0:
            default:
                break;
        }
        scanner.close();
    }
}
