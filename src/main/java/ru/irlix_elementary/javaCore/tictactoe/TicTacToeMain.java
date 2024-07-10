package ru.irlix_elementary.javaCore.tictactoe;

public class TicTacToeMain {

    public static void main(String[] args) {
        BoardGame boardGame = new BoardGame();
        boardGame.initMap();
        boardGame.printMap();

        while (true) {
            boardGame.humanStep('X');
            boardGame.printMap();
            if (boardGame.checkWin('X')) {
                System.out.println("Игра завершена, победил игрок.");
                break;
            }
            if (!boardGame.validMap()) {
                System.out.println("Игра завершена, ничья");
                break;
            }

            boardGame.computerStep('0');
            boardGame.printMap();
            if (boardGame.checkWin('0')) {
                System.out.println("Игра завершена, победил компьютер.");
                break;
            }
            if (!boardGame.validMap()) {
                System.out.println("Игра завершена, ничья");
                break;
            }
        }
    }
}
