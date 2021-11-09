package main.java;

public class Logic {
    MatrixAlgorithmThread matrixAlgorithmThread = new MatrixAlgorithmThread();
    TimerThread timerThread = new TimerThread();
    Print print=new Print();

    /**2 It's print out the local time and the initial state of the matrix(matrix is always random),and start the 2 threads */
    public void runThreads(){
        print.printCurrentDate();
        print.printMatrix(Matrix.getInstance().getMatrix());
        timerThread.start();
        matrixAlgorithmThread.start();


    }
}
