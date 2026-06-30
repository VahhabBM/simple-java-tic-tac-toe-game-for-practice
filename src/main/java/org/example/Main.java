package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void printBoard( char[][] board ) {
        for (int i=0 ; i < board.length ; i++) {
            System.out.print("\n \n");
            for (int j=0 ; j < board[i].length; j++) {
                System.out.print(board[i][j] + "    ");
            }
        }
    }
    public static boolean isFinished(char[][] b) {

        return
                // row 0
                (b[0][0] != '_' && b[0][0] == b[0][1] && b[0][1] == b[0][2]) ||
                        // row 1
                        (b[1][0] != '_' && b[1][0] == b[1][1] && b[1][1] == b[1][2]) ||
                        // row 2
                        (b[2][0] != '_' && b[2][0] == b[2][1] && b[2][1] == b[2][2]) ||

                        // col 0
                        (b[0][0] != '_' && b[0][0] == b[1][0] && b[1][0] == b[2][0]) ||
                        // col 1
                        (b[0][1] != '_' && b[0][1] == b[1][1] && b[1][1] == b[2][1]) ||
                        // col 2
                        (b[0][2] != '_' && b[0][2] == b[1][2] && b[1][2] == b[2][2]) ||

                        // diag 1
                        (b[0][0] != '_' && b[0][0] == b[1][1] && b[1][1] == b[2][2]) ||
                        // diag 2
                        (b[0][2] != '_' && b[0][2] == b[1][1] && b[1][1] == b[2][0]);
    }


    public static boolean xWinner(char[][] b) {
        return
                // rows
                (b[0][0] == 'x' && b[0][1] == 'x' && b[0][2] == 'x') ||
                        (b[1][0] == 'x' && b[1][1] == 'x' && b[1][2] == 'x') ||
                        (b[2][0] == 'x' && b[2][1] == 'x' && b[2][2] == 'x') ||

                        // columns
                        (b[0][0] == 'x' && b[1][0] == 'x' && b[2][0] == 'x') ||
                        (b[0][1] == 'x' && b[1][1] == 'x' && b[2][1] == 'x') ||
                        (b[0][2] == 'x' && b[1][2] == 'x' && b[2][2] == 'x') ||

                        // diagonals
                        (b[0][0] == 'x' && b[1][1] == 'x' && b[2][2] == 'x') ||
                        (b[0][2] == 'x' && b[1][1] == 'x' && b[2][0] == 'x');
    }

    public static boolean oWinner(char[][] b) {
        return
                // rows
                (b[0][0] == 'o' && b[0][1] == 'o' && b[0][2] == 'o') ||
                        (b[1][0] == 'o' && b[1][1] == 'o' && b[1][2] == 'o') ||
                        (b[2][0] == 'o' && b[2][1] == 'o' && b[2][2] == 'o') ||

                        // columns
                        (b[0][0] == 'o' && b[1][0] == 'o' && b[2][0] == 'o') ||
                        (b[0][1] == 'o' && b[1][1] == 'o' && b[2][1] == 'o') ||
                        (b[0][2] == 'o' && b[1][2] == 'o' && b[2][2] == 'o') ||

                        // diagonals
                        (b[0][0] == 'o' && b[1][1] == 'o' && b[2][2] == 'o') ||
                        (b[0][2] == 'o' && b[1][1] == 'o' && b[2][0] == 'o');
    }



    public static boolean isValid(int inpt) {
        return inpt == 0 || inpt == 1 || inpt == 2;
    }

    public static boolean isEmpty(char[][] board , int x , int y) {
        return board[x][y] == '_';
    }

    public static boolean isFull(char[][] board) {
        boolean checker = true;
        for (int i=0; i<board.length ; i++) {
            for (int j=0 ; j< board[i].length ; j++) {
                if (board[i][j] == '_') {
                    checker = false;
                    break;
                }
            }
        }
        return checker;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] gameBoard = { { '_' , '_' , '_' } , { '_' , '_' , '_' } , { '_' , '_' , '_'} };
        while (!isFinished(gameBoard)) {
            printBoard(gameBoard);
            if (isFull(gameBoard)) {
                break;
            }
            System.out.println("\n \n");

            System.out.println("player X turn:");
            System.out.println(" player x! enter the <row> place!");
            int xRow = scanner.nextInt();
            System.out.println(" player x! enter the <column> place!");
            int xCol = scanner.nextInt();

            while (!isValid(xRow) || !isValid(xCol) || !isEmpty(gameBoard, xRow, xCol)) {
                System.out.println("invalid input! try other one!");
                xRow = scanner.nextInt();
                xCol = scanner.nextInt();
            }
            gameBoard[xRow][xCol] = 'x';
            if (isFinished(gameBoard)) {
                break;
            }
            printBoard(gameBoard);
            System.out.println("\n \n");
            if (isFull(gameBoard)) {
                break;
            }

            System.out.println("player O turn:");
            System.out.println(" player o! enter the <row> place!");
            int yRow = scanner.nextInt();
            System.out.println(" player o! enter the <column> place!");
            int yCol = scanner.nextInt();

            while (!isValid(yRow) || !isValid(yCol) || !isEmpty(gameBoard, yRow, yCol)) {
                System.out.println("invalid input! try other one!");
                yRow = scanner.nextInt();
                yCol = scanner.nextInt();
            }
            gameBoard[yRow][yCol] = 'o';
            printBoard(gameBoard);
            System.out.println("\n \n");
            if (isFull(gameBoard)) {
                break;
            }
        }

        System.out.println("game is over!");
        printBoard(gameBoard);
        if (xWinner(gameBoard)) {
            System.out.println(" player x is winner!");
        } else if (oWinner(gameBoard)) {
            System.out.println(" player o is winner!");
        } else {
            System.out.println(" draw !!!!!!!!");
        }
    }
}