package sergey.shulga;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class WinnerChecker extends FieldController {

    protected static boolean continueGame() {
        boolean checker = true;
        for (int j = 0; j < field.length; j++) {
            if (Objects.equals(field[j][0], "O") && Objects.equals(field[j][1], "O") && Objects.equals(field[j][2], "O") ||
                    Objects.equals(field[j][0], "X") && Objects.equals(field[j][1], "X") && Objects.equals(field[j][2], "X") ||
                    Objects.equals(field[0][j], "O") && Objects.equals(field[1][j], "O") && Objects.equals(field[2][j], "O") ||
                    Objects.equals(field[0][j], "X") && Objects.equals(field[1][j], "X") && Objects.equals(field[2][j], "X") ||
                    Objects.equals(field[0][0], "O") && Objects.equals(field[1][1], "O") && Objects.equals(field[2][2], "O") ||
                    Objects.equals(field[0][2], "O") && Objects.equals(field[1][1], "O") && Objects.equals(field[2][0], "O") ||
                    Objects.equals(field[0][0], "X") && Objects.equals(field[1][1], "X") && Objects.equals(field[2][2], "X") ||
                    Objects.equals(field[0][2], "X") && Objects.equals(field[1][1], "X") && Objects.equals(field[2][0], "X")) {
                checker = false;
                break;
            }
        }
        return checker;
    }

    public static void getWinner(int moveCounter) throws IOException {
        System.out.println("END OF GAME");
        if (moveCounter % 2 == 0) {
            System.out.println("X WIN!");
        } else {
            System.out.println("O WIN!");
        }
        reloadGame();
    }

    protected static void reloadGame() throws IOException {
        System.out.println(" ");
        System.out.println("Do you want to reload game? \nType Y/N.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        if (answer.equals("Y")) {
            System.out.println("-----------");
            usedCoordinates.clear();
            UserMovesController.moveCounter = 0;
            FieldController.fillTheField();
        } else {
            System.out.println("Goodbye!");
        }
    }
}