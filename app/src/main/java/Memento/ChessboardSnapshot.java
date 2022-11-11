/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;

/**
 *
 * @author luciano
 */
public class ChessboardSnapshot {

    private final Chessboard chessboard;
    private final char[][] board;

    public ChessboardSnapshot(Chessboard chessboard, char[][] board) {
        this.chessboard = chessboard;

        this.board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public void restore() {
        this.chessboard.setBoard(this.board);
    }
}
