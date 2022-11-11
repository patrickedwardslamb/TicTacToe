public class Board {

    private Space[][] board;

    public Board() {
        this.board = new Space[3][3];
    }

    public void buildBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                this.board[row][column] = new Space();
            }
        }
    }
    public void printBoard () {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(" " + this.board[row][column] + " ");
            }
            System.out.println();
        }
    }

    public Space getSquare(int userInput){

        if (userInput > 6 && userInput <= 9){
            return this.board[2][userInput-7];
        } else if (userInput > 3 && userInput <= 6){
            return this.board[1][userInput-4];
        } else if (userInput <= 3){
            return this.board[0][userInput-1];
        } else {
            return null;
        }
    }

    // Get and return the correct space according to the user input.

    public boolean drawCondition(){
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (!this.board[row][column].isEmpty()) {
                   count++;
                }
            }
        }
        if (count == 9){
            return true;
        }
        return false;
    }

    public boolean winCondition(){

        // Check horizontally.

        for (int row = 0; row < board.length; row++){
            if (board[row][0].isNought() && board[row][1].isNought() && board[row][2].isNought()
                    || board[row][0].isCross() && board[row][1].isCross() && board[row][2].isCross()){
                return true;
            }
        }

        // Check vertically.

        for (int column = 0; column < board.length; column++){
            if (board[0][column].isNought() && board[1][column].isNought() && board[2][column].isNought()
                    || board[0][column].isCross() && board[1][column].isCross() && board[2][column].isCross()){
                return true;
            }
        }

        // Check diagonally.

        if (board[0][0].isNought() && board[1][1].isNought() && board[2][2].isNought()
                || board[0][0].isCross() && board[1][1].isCross() && board[2][2].isCross()){
            return true;
        }

        if (board[0][2].isNought() && board[1][1].isNought() && board[2][0].isNought()
                || board[0][2].isCross() && board[1][1].isCross() && board[2][0].isCross()){
            return true;
        }

    return false;

    }

}

