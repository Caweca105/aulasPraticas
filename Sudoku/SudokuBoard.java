import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class SudokuBoard {
    private int[][] board;
    private int[][] initialBoard;
    private int[] moveHistoryRow;
    private int[] moveHistoryCol;
    private int[] moveHistoryValue;
    private int moveCount;

    public SudokuBoard(int[][] initialBoard) {
        this.initialBoard = new int[9][9];
        this.board = new int[9][9];
        this.moveHistoryRow = new int[81];
        this.moveHistoryCol = new int[81];
        this.moveHistoryValue = new int[81];
        this.moveCount = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.initialBoard[i][j] = initialBoard[i][j];
                this.board[i][j] = initialBoard[i][j];
            }
        }

        if (!isValidSudoku(this.initialBoard)) {
            throw new IllegalArgumentException("Tabuleiro de Sudoku inv\u00E1lido!");
        }
    }

    private boolean isValidSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] boxCheck = new boolean[9];
    
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != 0) {
                    if (rowCheck[board[i][j] - 1]) {
                        return false; // Duplicate in row
                    }
                    rowCheck[board[i][j] - 1] = true;
                }
    
                // Check column
                if (board[j][i] != 0) {
                    if (colCheck[board[j][i] - 1]) {
                        return false; // Duplicate in column
                    }
                    colCheck[board[j][i] - 1] = true;
                }
    
                // Check 3x3 box
                int boxRow = 3 * (i / 3);
                int boxCol = 3 * (i % 3);
                int boxNumber = board[boxRow + j / 3][boxCol + j % 3];
                if (boxNumber != 0) {
                    if (boxCheck[boxNumber - 1]) {
                        return false; // Duplicate in 3x3 segment
                    }
                    boxCheck[boxNumber - 1] = true;
                }
            }
        }
        return true;
    }    

    public int getNumber(int row, int col) {
        return this.board[row][col];
    }

    public void makeMove(int row, int col, int value) {
        if (this.initialBoard[row][col] == 0 && this.board[row][col] != value) {
            this.board[row][col] = value;
            moveHistoryRow[moveCount] = row;
            moveHistoryCol[moveCount] = col;
            moveHistoryValue[moveCount] = value;
            moveCount++;
        }
    }

    public void makeRandomMove() {
        Random random = new Random();
        int row, col;
    
        // Create an array of possible numbers and shuffle it
        int[] possibleNumbers = new int[9];
        for (int i = 0; i < 9; i++) {
            possibleNumbers[i] = i + 1;
        }
        
        // Fisher-Yates shuffle algorithm
        for (int i = possibleNumbers.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Simple swap
            int a = possibleNumbers[index];
            possibleNumbers[index] = possibleNumbers[i];
            possibleNumbers[i] = a;
        }
    
        // Attempt to make a valid random move
        for (int attempt = 0; attempt < possibleNumbers.length; attempt++) {
            row = random.nextInt(9);
            col = random.nextInt(9);
    
            if (this.board[row][col] == 0) { // Check if the cell is empty
                int number = possibleNumbers[attempt];
                if (isValidMove(row, col, number)) {
                    makeMove(row, col, number);
                    break; // Exit the loop after making a valid move
                }
            }
        }
    }
    
    public boolean isValidMove(int row, int col, int number) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (this.board[row][i] == number || this.board[i][col] == number) {
                return false;
            }
        }
    
        // Check 3x3 box
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[boxRowStart + i][boxColStart + j] == number) {
                    return false;
                }
            }
        }
        return true; // Move is valid
    }
    
    public void resetBoard() {
        for (int i = 0; i < 9; i++) {
            System.arraycopy(this.initialBoard[i], 0, this.board[i], 0, 9);
        }
        moveHistory.clear();
    }

    public boolean[] validateSegments() {
        boolean[] segmentValidity = new boolean[9];
    
        for (int segment = 0; segment < 9; segment++) {
            boolean[] seen = new boolean[9];
            boolean isValid = true;
    
            int rowStart = (segment / 3) * 3;
            int colStart = (segment % 3) * 3;
    
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int number = this.board[rowStart + i][colStart + j];
                    if (number != 0) {
                        if (seen[number - 1]) {
                            isValid = false; // Number is repeated in this 3x3 segment
                            break;
                        }
                        seen[number - 1] = true;
                    }
                }
                if (!isValid) {
                    break;
                }
            }
            segmentValidity[segment] = isValid;
        }
        return segmentValidity;
    } 

    public boolean[] validateRows() {
        boolean[] rowValidity = new boolean[9];
    
        for (int row = 0; row < 9; row++) {
            boolean[] seen = new boolean[9];
            boolean isValidRow = true;
    
            for (int col = 0; col < 9; col++) {
                int number = this.board[row][col];
                if (number != 0) {
                    if (seen[number - 1]) {
                        isValidRow = false;
                        break;
                    }
                    seen[number - 1] = true;
                }
            }
            rowValidity[row] = isValidRow;
        }
        return rowValidity;
    }
    
    
    public boolean[] validateColumns() {
        boolean[] columnValidity = new boolean[9];
    
        for (int col = 0; col < 9; col++) {
            boolean[] seen = new boolean[9];
            boolean isValidColumn = true;
    
            for (int row = 0; row < 9; row++) {
                int number = this.board[row][col];
                if (number != 0) {
                    if (seen[number - 1]) {
                        isValidColumn = false;
                        break;
                    }
                    seen[number - 1] = true;
                }
            }
    
            columnValidity[col] = isValidColumn;
        }
    
        return columnValidity;
    }
    

    public boolean isCompleted() {
        // Check each row and column for completeness
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
    
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] == 0 || rowCheck[board[i][j] - 1]) {
                    return false;
                }
                rowCheck[board[i][j] - 1] = true;
    
                // Check column
                if (board[j][i] == 0 || colCheck[board[j][i] - 1]) {
                    return false;
                }
                colCheck[board[j][i] - 1] = true;
            }
        }
    
        // Check each 3x3 box for completeness
        for (int boxStartRow = 0; boxStartRow < 9; boxStartRow += 3) {
            for (int boxStartCol = 0; boxStartCol < 9; boxStartCol += 3) {
                boolean[] boxCheck = new boolean[9];
    
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        int num = board[boxStartRow + row][boxStartCol + col];
                        if (num == 0 || boxCheck[num - 1]) {
                            return false;
                        }
                        boxCheck[num - 1] = true;
                    }
                }
            }
        }
        return true; // The board is fully solved
    }
    
    public void undoMove() {
        if (moveCount > 0) {
            moveCount--;
            int row = moveHistoryRow[moveCount];
            int col = moveHistoryCol[moveCount];
            this.board[row][col] = 0; // Reset the cell to empty
        }
    } 
}
