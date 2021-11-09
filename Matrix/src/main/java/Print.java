package main.java;
import java.util.Date;

public class Print{

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /** print the current number of steps(every switch in matrix is a step)*/
    public void printOutSwitchCounter(){
        long counter=Matrix.getInstance().getCounter();
        System.out.println("It took "+counter+" steps");
    }

    /**Print a horizontal line to separate two different prints*/
    public void printHorizontalLine(){
        System.out.println("-------------");
    }


    public void printCurrentDate(){
        Date date=java.util.Calendar.getInstance().getTime();
        System.out.println(date);
    }

    /**different solution means every series of steps what are not lead to result  */
    public void printNumberOfDifferentSolution(int time){
        int solutionCounter = Matrix.getInstance().getDifferentSolutionCounter();
        System.out.println(time*10+" sec:Tried "+solutionCounter+" different solution" );
    }

}
