package Memento;

import java.time.LocalDateTime;

public class ChessboardSnapshot implements IMemento {

    private final Chessboard chessboard;
    private final char[][] board;
    private final LocalDateTime createdAt;

    public ChessboardSnapshot(Chessboard chessboard, char[][] board) {
        this.chessboard = chessboard;
        this.board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = board[i][j];
            }
        }
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public void restore() {
        this.chessboard.setBoard(this.board);
    }

    @Override
    public LocalDateTime getCreationDate() {
        return this.createdAt;
    }
}
