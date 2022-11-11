import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    public Scanner scanner;
    public boolean playerOneTurn;
    public boolean gameComplete;

    public UserInterface(){
        this.scanner = new Scanner(System.in);
        this.playerOneTurn = true;
        this.gameComplete = false;
    }

    public void start(){
        Board board = new Board();
        board.buildBoard();

        while (!gameComplete){

            board.printBoard();
            printPlayerTurn();

            int userInput = getIntegerInput();

            if (board.getSquare(userInput).isEmpty()){
                if (playerOneTurn){
                    board.getSquare(userInput).setNought();
                    playerOneTurn = false;
                } else {
                    board.getSquare(userInput).setCross();
                    playerOneTurn = true;
                }
            } else {
                printError();
            }

            if (board.winCondition()){
                printWinnerMessage();
                gameComplete = true;
            }

            if (board.drawCondition()){
                printDrawMessage();
                gameComplete = true;
            }

        }
    }

    public int getIntegerInput(){
        int userInput;
        do {
            System.out.println("Please choose a square (1-9)");
            userInput = scanner.nextInt();
        } while (userInput < 0 || userInput > 9);
        return userInput;
    }

    // Check the user entered a valid integer between 1-9.

    public void printWinnerMessage(){
        if (playerOneTurn){
            System.out.println("Noughts wins!");
        } else {
            System.out.println("Crosses wins!");
        }
    }

    public void printDrawMessage(){
        System.out.println("Draw!");
    }

    public void printPlayerTurn(){
        if (playerOneTurn){
            System.out.println("Player 1's turn (Noughts)");
        } else {
            System.out.println("Player 2's turn (Crosses)");
        }
    }

    public void printError(){
        System.out.println("Error. Invalid input. Please try again.");
    }

}
