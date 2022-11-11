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
        this.board = board;
    }

    public void restore() {
        this.chessboard.setBoard(this.board);
    }
}
