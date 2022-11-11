/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;

/**
 *
 * @author luciano
 */
public class Chessboard {

    public char[][] board;

    public Chessboard() {
        this.board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void addPiece(char piece, int x, int y) {
        board[x][y] = piece;
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("| %c ", board[i][j]);
            }
            System.out.print("|\n");
        }
    }

    public ChessboardSnapshot createSnapshot() {
        return new ChessboardSnapshot(this, board);
    }
}
