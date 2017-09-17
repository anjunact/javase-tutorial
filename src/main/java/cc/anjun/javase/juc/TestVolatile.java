package cc.anjun.javase.juc;

import lombok.Data;

public class TestVolatile {
    public static void main(String[]args){
        ThreadDemo td =new ThreadDemo();
        new Thread(td).start();
        while (true){
            if(td.isFlag()){
                System.out.println("-----");
                break;
            }
        }
    }
}
@Data
class ThreadDemo implements Runnable{
    private  boolean flag;
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag =true;
        System.out.println("flag="+ isFlag());
    }
}