package cc.anjun.javase.java8;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestLambda {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,3999),
            new Employee("李四",38,2999),
            new Employee("王五",48,4999),
            new Employee("赵钱",27,5999)
    );
    @Test
    public void test(){
        employees.stream()
                .filter((e)->e.getSalary()>3000)
                .limit(3)
                .forEach(System.out::println);
    }
    @Test
    public void test2(){
        Runnable r1 =()->System.out.println("hello lambada!");
        r1.run();
    }
    @Test
    public void test3(){
        Consumer<String> con = (x)-> System.out.println(x);
        con.accept("我++");
    }
    @Test
    public  void test4(){
        Comparator<Integer> com = (x, y)->Integer.compare(x,y);
        System.out.println(com.compare(3,4));
    }
    @Test
    public void test5(){
      Integer num =  operation(100,(x)->x*x);
        System.out.println(num);
    }
    public Integer operation(Integer num, MyFun<Integer> mf){
        return mf.getValue(num);
    }
    public void test6(){
        Collections.sort(employees,(e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });
    }
    public void test7(){
        Employee emp = new Employee("x",3,3223);
        Supplier<String> sup = ()->emp.getName();
        System.out.println(sup.get());
    }
    @Test
    public void testFunction(){
        Function<Integer,String[]> fun = (x)->new String[x];
        String[] strs = fun.apply(10);
        Function<Integer,String[]> fun2 =String[]::new;
        String[] str2 = fun2.apply(2);
        System.out.println(str2.length);
    }
}
