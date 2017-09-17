package cc.anjun.javase.java8;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Callable<Date> task = new Callable<Date>() {
//            @Override
//            public Date call() throws Exception {
//                return DateFormatThreadLocal.convert("20170913");
//            }
//        };
//        ExecutorService pool = Executors.newFixedThreadPool(10);
//        List<Future<Date>> results = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            results.add(pool.submit(task));
//        }
//        for (Future<Date> f : results) {
//            System.out.println(f.get());
//        }
//        pool.shutdown();

        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyMMdd");
        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                 return    LocalDate.parse("20170809",dtf);
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        for (Future<LocalDate> f : results) {
            System.out.println(f.get());
        }
        pool.shutdown();
    }
}
