package newTest.ThreadTest;

/**
 * @program: mybatisPlusdemo
 * @description: ThreadLocal使用范例
 * @author: hzl
 * @create: 2022-05-19 19:54
 **/

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable{

    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    //上面的代码等于下侧这段代码，Java8新特性
//    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
//        @Override
//        protected SimpleDateFormat initialValue(){
//            return new SimpleDateFormat("yyyyMMdd HHmm");
//        }
//    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        // 这里的formatter 是上面的static的类formatter，
        // 但是真实使用的时候其实是通过ThreadLocal的Thread.getCurrentThread()获取当前的线程对象
        // 再根据getMap(Thread t)可以访问到该线程的ThreadLocalMap对象【本线程Thread专属的ThreadLocalMap】
        // 最后再根据对应的ThreadLocal获取相应的value
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 此时本线程的ThreadLocal的内容已经被修改了，但是其他线程中还是保持原来的副本的样子。
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }

}

