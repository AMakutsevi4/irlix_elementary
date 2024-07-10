package ru.irlix_elementary.spring.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameTest {

    @Test
    void testCheckWin() {
        BoardGame game = new BoardGame(new char[3][3]);
        /*Проверка выигрыша по строке*/
        game.board[0][0] = 'X';
        game.board[0][1] = 'X';
        game.board[0][2] = 'X';
        assertTrue(game.checkWin('X'));

        /*Проверка выигрыша по столбцу*/
        game = new BoardGame(new char[3][3]); // Новый экземпляр для нового теста
        game.board[0][0] = '0';
        game.board[1][0] = '0';
        game.board[2][0] = '0';
        assertTrue(game.checkWin('0'));

        /* Проверка выигрыша по диагонали слева направо*/
        game = new BoardGame(new char[3][3]);
        game.board[0][0] = 'X';
        game.board[1][1] = 'X';
        game.board[2][2] = 'X';
        assertTrue(game.checkWin('X'));

        /* Проверка выигрыша по диагонали справа налево*/
        game = new BoardGame(new char[3][3]);
        game.board[0][2] = '0';
        game.board[1][1] = '0';
        game.board[2][0] = '0';
        assertTrue(game.checkWin('0'));
    }
}