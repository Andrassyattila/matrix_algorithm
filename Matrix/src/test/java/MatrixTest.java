package test.java;

import main.java.Matrix;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertTrue;


public class MatrixTest {
    Matrix matrix= Matrix.getInstance();

    int[][] solvedMatrix ={
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0}
    };

    int[][] simpleMatrix ={
            {0,0,0,0,0,0},
            {0,1,0,0,0,0},
            {1,1,1,0,0,0},
            {0,1,0,0,1,0},
            {0,1,0,1,1,1},
            {1,1,1,0,1,0}
    };


    @Test
    public void solve_simple_matrix(){
        matrix.setMatrix(simpleMatrix);
        matrix.checkForSolution(matrix.getMatrix());
        int[][] solvedSimpleMatrix = matrix.getMatrix();
        assertTrue(Arrays.deepEquals(solvedMatrix,solvedSimpleMatrix ));

    }


    @Test
    public void check_steps() {
        matrix.setMatrix(simpleMatrix);
        matrix.checkForSolution(matrix.getMatrix());
        int stepsForSolution =Math.toIntExact(matrix.getCounter());
        //for simpleMatrix 3 steps will be the best solution
        int expectedSteps = 3;
        Assert.assertEquals(expectedSteps,stepsForSolution);
    }
}
