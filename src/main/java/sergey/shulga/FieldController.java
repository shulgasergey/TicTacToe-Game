package sergey.shulga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TicTacToe Console Game
 * @author sergejsulga
 */

public class FieldController {

    protected static String[][] field = new String[3][3];
    protected static List<String> usedCoordinates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        fillTheField();
    }

    protected static void fillTheField() throws IOException {
        System.out.println(" ");
        System.out.println("Welcome to the TICTACTOE game!");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = "□";
            }
        }
        printField();
        UserMovesController.moveItem();
    }

    protected static void printField() {
        for (String[] strings : field) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}