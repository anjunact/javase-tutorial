package cc.anjun.javase.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i <= 100; i++) {
                        sum += i;
                    }
                    return sum;
                }
            });
            list.add(future);
        }

        for (Future<Integer> f : list) {
            System.out.println(f.get());
        }

        pool.shutdown();
    }
}
