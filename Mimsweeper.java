import java.util.Random;

public class Mimsweeper {
    private final int rows;
    private final int cols;
    private final int numMims;
    private final char[][] board;
    private final boolean[][] mims;

    public Mimsweeper(int rows, int cols, int numMims) {
        this.rows = rows;
        this.cols = cols;
        this.numMims = numMims;
        this.board = new char[rows][cols];
        this.mims = new boolean[rows][cols];
        initializeBoard();
        placeMims();
        assignNumbers();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '.';
            }
        }
    }

    private void placeMims() {
        Random random = new Random();
        int mimsPlaced = 0;
        while (mimsPlaced < numMims) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            if (!mims[row][col]) {
                mims[row][col] = true;
                mimsPlaced++;
            }
        }
    }

    private void assignNumbers() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!mims[i][j]) {
                    int count = countAdjacentMims(i, j);
                    board[i][j] = (char) (count + '0');
                }
            }
        }
    }

    private int countAdjacentMims(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && mims[newRow][newCol]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void uncoverCell(int row, int col) {
        if (mims[row][col]) {
            System.out.println("Game over! You uncovered a Mim!");
            // Handle game over logic here
        } else {
            // Recursive logic to uncover cells if necessary
            // For simplicity, not implemented here
        }
    }

    public void flagCell(int row, int col) {
        // Flagging logic
        // For simplicity, not implemented here
    }

    public boolean isGameWon() {
        // Check if all non-Mim cells are uncovered
        // For simplicity, not implemented here
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;
        int numMims = 5;
        Mimsweeper game = new Mimsweeper(rows, cols, numMims);
        game.printBoard();
    }
}
