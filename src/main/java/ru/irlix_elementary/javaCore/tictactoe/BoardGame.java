package ru.irlix_elementary.javaCore.tictactoe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardGame {

    private static final Scanner scanner = new Scanner(System.in);
    public char[][] board;
    private static final int MAP_SIZE = 3;
    private static final char EMPTY_FILED = '*';
    private int step = 1;

    public BoardGame(char[][] board) {
        this.board = board;
    }

    public void initMap() {
        board = new char[MAP_SIZE][MAP_SIZE];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = EMPTY_FILED;
            }
        }
    }

    public void printMap() {
        /*Выводим на экран верхние указатели*/
        for (int i = 0; i <= MAP_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            /*Выводим на экран боковые указатели*/
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                /*Выводим на экран всё игровое поле (на данный момент заполненное символом '*' */
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*Данным методом проверяем проверку победителя*/
    public boolean checkWin(char symbol) {
        for (int i = 0; i < MAP_SIZE; i++) {
            /*Проверка строк*/
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            /*Проверка столбцов*/
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
            /*Проверка диогонали слева направо*/
            if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
                return true;
            }
            /*Проверка диогонали справа налево*/
            if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
                return true;
            }
        }
        return false;
    }

    /*Проверяем наличие пустых клеток для хода*/
    public boolean validMap() {
        return step < (MAP_SIZE * MAP_SIZE);
    }

    /*метод проверяет валидность хода*/
    private boolean validStep(int x, int y) {
        if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE) {
            return false;
        }
        if (board[x][y] != EMPTY_FILED) {
            return false;
        }
        return true;
    }

    /*сканером считываем ход игрока, и если он валиден то делаем ход.*/
    public void humanStep(char SYMBOL_STEP) {
        int x, y;
        do {
            System.out.println("Ход игрока. Введите координаты вашего хода (например 1 1)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!validStep(x, y));
        board[x][y] = SYMBOL_STEP;
        step++;
    }

    /*ход компьютера, и если он валиден то делаем ход.*/
    public void computerStep(char SYMBOL_STEP) {
        int x, y;
        do {
            System.out.println("Ход компьютера.");
            x = (int) (Math.random() * MAP_SIZE);
            y = (int) (Math.random() * MAP_SIZE);
        } while (!validStep(x, y));
        board[x][y] = SYMBOL_STEP;
        step++;
    }
}
