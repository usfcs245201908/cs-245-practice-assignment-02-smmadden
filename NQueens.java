public class NQueens {
    private int n;
    private int[][] board;

    NQueens(int boardSize){
        n = boardSize;
        board = new int[n][n];

    }

    boolean placeNQueens() throws Exception {
        if(n<=0){
            throw new Exception();
        }

        if(placeQueen(0)){
            printToConsole();
            return true;
        } else {
            System.out.println("Unable to place " + n + " queens on the board.");
            return false;
        }

    }

    private boolean placeQueen(int row){
        if(row == n){
            return true;
        }

        for(int col = 0; col < n; col++){
            if(canPlaceAQueen(row, col)){
                board[row][col] = 1;
                if(placeQueen(row + 1)){
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private boolean canPlaceAQueen(int row, int col){
        for(int i = 0; i < n; i++){
            if(board[row][i] == 1 || board[i][col] == 1){
                return false;
            }
            if(row + i < n && col + i < n && board[row + i][col + i] == 1){
                return false;
            }
            if(row - i >= 0 && col - i >= 0 && board[row - i][col - i] == 1){
                return false;
            }
            if(row + i < n && col - i >= 0 && board[row + i][col - i] == 1){
                return false;
            }
            if(row - i >= 0 && col + i < n && board[row - i][col + i] == 1){
                return false;
            }
        }
        return true;
    }

    void printToConsole(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 0){
                    System.out.print("-");
                } else {
                    System.out.print("Q");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
