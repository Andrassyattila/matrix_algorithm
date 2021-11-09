package main.java;

public class MatrixAlgorithmThread extends Thread{
    Matrix m= Matrix.getInstance();

    @Override
    public void run(){
        m.checkForSolution(m.getMatrix());
    }
}
