/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;

/**
 *
 * @author luciano
 */
public class App {

    public static void main(String[] args) {
        System.out.printf("Name of the pieces:\n"
                + "\tp = pawn\n"
                + "\tt = tower\n"
                + "\tb = bishop\n"
                + "\th = horse\n"
                + "\tq = queen\n"
                + "\tk = king\n\n");
        
        Chessboard b = new Chessboard();
        b.addPiece('h', 0, 1);
        b.addPiece('h', 0, 6);
        
        b.printBoard();
    }
}
