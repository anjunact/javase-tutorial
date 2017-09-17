package cc.anjun.javase.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static  void main(String[]args) throws ExecutionException, InterruptedException {
        CallableDemo td= new CallableDemo();
        FutureTask<Integer> result = new FutureTask<Integer>(td);
        new Thread(result).start();
        System.out.println( result.get());
    }
}
class CallableDemo implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for(int i=0;i<100;i++){
            sum+=1;
        }
        return sum;
    }
}