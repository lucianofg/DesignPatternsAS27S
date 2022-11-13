package Memento;

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

        System.out.println("Chessboard created");
        b.addPiece('t', 0, 0);
        b.addPiece('h', 0, 1);

        ChessboardSnapshot snapshot = b.createSnapshot();
        b.printBoard();
        System.out.println("\nSnapshot created");

        System.out.println("\nChanging chessboard:");

        b.addPiece('h', 0, 6);
        b.addPiece('t', 0, 7);

        b.printBoard();

        snapshot.restore();
        System.out.println("\nRestoring chessboard:");
        b.printBoard();

    }
}
