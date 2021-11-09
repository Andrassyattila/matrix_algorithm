package main.java;

public class TimerThread extends Thread{
    Matrix m = Matrix.getInstance();
    Print print=new Print();
    int timer=0;


    @Override
    public void run(){
        print.printHorizontalLine();
        while(!m.isFinish()){
            try {
                Thread.sleep(10000);
                timer++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!m.isFinish()){
                print.printNumberOfDifferentSolution(timer);
                print.printHorizontalLine();
            }
        }
    }
}
