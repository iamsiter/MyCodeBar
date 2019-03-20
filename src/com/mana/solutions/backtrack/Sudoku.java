package com.mana.solutions.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '5', '2', '.', '.'}}));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9]; // no need to keep set taking n^2 space....check LC thread
        HashSet<Character>[] cols = new HashSet[9];

        //Check row and cols
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (rows[i] == null) {
                    rows[i] = new HashSet<>();
                }
                if (cols[j] == null) {
                    cols[j] = new HashSet<>();
                }

                if (board[i][j] != '.' && (!rows[i].add(board[i][j]) || !cols[j].add(board[i][j]))) {
                    return false;
                }
            }
        }

        //check cubes...........This is basic one that came to my mind but the mathematical one is more swag
        //https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code?page=2

        for(int i =0;i<board.length-2;i+=3){ //** 7 as upper bound
            for(int j=0;j<board[0].length-2;j+=3){
                HashSet<Character> cube = new HashSet<Character>();
                for(int k = 0;k < 9;k++){
                    if(board[i + k/3][j + k % 3]!='.' && !cube.add(board[i + k/3][j + k % 3]))
                        return false;
                }
            }
        }

        return true;
    }
}

/**
 * int RowIndex = 3*(i/3);
 * int ColIndex = 3*(i%3);
 * if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
 * return false;
 * <p>
 * GFG makes more sense
 * Start points row - row % 3, col - col % 3
 * Then n^2 loop to traverse 9 elements in cube with these starting points
 */


/**
 *              GFG makes more sense
 *              Start points row - row % 3, col - col % 3
 *              Then n^2 loop to traverse 9 elements in cube with these starting points
 */