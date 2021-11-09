package main.java;

import java.util.Random;

public class Matrix {
    private static Matrix instance = null;
    Print print= new Print();
    //size of the matrix
    private int row = 6;
    private int col = 6;
    //Number of "upswitch" in the matrix
    private int randomUpSwitchCounter = 11;
    //counter for "switch"
    private long counter=0;
    private int differentSolutionCounter=0;
    private int[][] matrix =createRandomSwitch();


    private int[][] createMatrix(int row, int col) {
        return new int[row][col];

    }


    private int[][] createRandomSwitch() {
        int[][] matrix = createMatrix(row, col);
        for (int i = 0; i < randomUpSwitchCounter; i++) {
            matrix[randomNumber(0,6)][randomNumber(0,6)] = 1;
        }
        return matrix;
    }


    private int randomNumber(int low,int high) {
        Random r = new Random();

        return r.nextInt(high - low) + low;
    }

    private void switchMatrix(int[][] matrix, int row, int col) {
        if (row >= 0 && row <= 5 && col >= 0 && col <= 5) {
            changeValue(matrix, row, col);
            //above
            try {
                changeValue(matrix, row - 1, col);
            } catch (ArrayIndexOutOfBoundsException i) {

            }
            //under
            try {
                changeValue(matrix, row + 1, col);
            } catch (ArrayIndexOutOfBoundsException i) {
            }
            // left
            try {
                changeValue(matrix, row, col - 1);
            } catch (ArrayIndexOutOfBoundsException i) {

            }
            //right
            try {
                changeValue(matrix, row, col + 1);
            } catch (ArrayIndexOutOfBoundsException i) {

            }
        }
    }


    private void changeValue(int[][] matrix, int row, int col) {
        if (matrix[row][col] == 0) {
            matrix[row][col] = 1;
        } else if (matrix[row][col] == 1) {
            matrix[row][col] = 0;
        }
    }


    /** Check the matrix elements, return true if all of them "0"  */
    public boolean isFinish() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isEmptyTillLastLine(){
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }


    /**This method starts to making steps till isFinish method is true*/
    public void checkForSolution(int[][] matrix) {
        while(!isFinish()){
            while (!isEmptyTillLastLine()) {
                clearTillLastLine(matrix);
            }
            differentSolutionCounter++;
            if(isEmptyTillLastLine()&&!isFinish()){
                switchMatrix(matrix,0,randomNumber(0,5));
                counter++;

            }
        }
        System.out.println("The solution found ");
        print.printOutSwitchCounter();
        print.printMatrix(Matrix.getInstance().getMatrix());
    }


    private void clearTillLastLine(int[][]matrix){
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    switchMatrix(matrix, i + 1, j);
                    counter++;
                }

            }
        }
    }


    /**Return with one Matrix instance and it can work with the 2 threads*/
    public static Matrix getInstance() {
        if (instance == null) {
            instance = new Matrix();
        }
        return instance;
    }


    public int[][] getMatrix() {
        return matrix;
    }


    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public long getCounter() {
        return counter;
    }


    public int getDifferentSolutionCounter() {
        return differentSolutionCounter;
    }
}

