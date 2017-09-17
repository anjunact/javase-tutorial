package cc.anjun.javase.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TestForkJoinPool {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 100L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {
    private static final long serialVersionUID = -23232323214151L;
    private long start;
    private long end;
    private  final static long THURSHOlD = 10L;

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THURSHOlD) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        } else {
            long midlle = (start + end) / 2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, midlle);
            left.fork();
            ForkJoinSumCalculate right = new ForkJoinSumCalculate(midlle + 1, end);
            right.fork();

            return left.join() + right.join();
        }

    }
}
