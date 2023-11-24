package sergey.shulga;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserMovesController extends FieldController {

    // Constants
    private final static String MOVEX = "X";
    private final static String MOVEO = "O";
    private static int xCoordinate;
    private static int yCoordinate;
    protected static int moveCounter = 0;


    protected static void moveItem() throws IOException {
        boolean continueGame;
        do {
            isADraw();

            findWhosNext();

            getInputCoordinates();

            checkInput(xCoordinate, yCoordinate);

            if (moveCounter % 2 == 0) {
                field[xCoordinate][yCoordinate] = MOVEO;
            } else {
                field[xCoordinate][yCoordinate] = MOVEX;
            }

            moveCounter++;

            printField();

            continueGame = WinnerChecker.continueGame();

        } while (continueGame);

        WinnerChecker.getWinner(moveCounter);
    }

    private static void isADraw() throws IOException {
        if (moveCounter == 9) {
            System.out.println("Wow! It's a draw!");
            WinnerChecker.reloadGame();
        }
    }

    public static boolean checkInput(int xCoordinate, int yCoordinate) throws IOException {
        String currentCoord = Integer.toString(xCoordinate) + yCoordinate;
        boolean isInputCorrect = true;

        if (usedCoordinates.contains(currentCoord)) {
            System.out.println("Choose free coordinates!");
            printField();
            System.out.println(" ");
            moveItem();
            isInputCorrect = false;
        } else if (xCoordinate <= -1 || xCoordinate >= 3 ||
                yCoordinate <= -1 || yCoordinate >= 3) {
            System.out.println("Choose correct coordinates!");
            printField();
            System.out.println(" ");
            moveItem();
            isInputCorrect = false;
        }

        usedCoordinates.add(currentCoord);
        return isInputCorrect;
    }

    public static void findWhosNext() {
        if (moveCounter % 2 == 0) {
            System.out.println("Now it's O's turn");
        } else {
            System.out.println("Now it's X's turn");
        }
    }

    private static void getInputCoordinates() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Type index of your columns: ");
        xCoordinate = Integer.parseInt(reader.readLine());
        System.out.print("Type index of your lines: ");
        yCoordinate = Integer.parseInt(reader.readLine());
    }
}