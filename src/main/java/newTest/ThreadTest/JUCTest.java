package newTest.ThreadTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @program: mybatisPlusdemo
 * @description: juc工具包测试
 * @author: hzl
 * @create: 2022-05-19 20:40
 **/

public class JUCTest {
    //CountDownLatch的使用例子 --  6个文件并行读取完成后，再继续其他操作
    //相当于比赛结束，需要宣布成绩；只有每个人都跑完的才可以颁奖
    public class CountDownLatchExample1 {
        // 处理文件的数量
        private static final int threadCount = 6;

        @Test
        public void main(String[] args) throws InterruptedException {
            // 创建一个具有固定线程数量的线程池对象（推荐使用构造方法创建）
            ExecutorService threadPool = Executors.newFixedThreadPool(10);
            final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
            for (int i = 0; i < threadCount; i++) {
                final int threadnum = i;
                threadPool.execute(() -> {
                    try {
                        //处理文件的业务操作
                        //......
                    } finally {
                        //表示一个文件已经被完成
                        countDownLatch.countDown();
                    }

                });
            }
            countDownLatch.await();
            threadPool.shutdown();
            System.out.println("finish");
        }
    }

    //JAVA8 对countDownLatch的优化  ->CompletableFuture
    public class CompletableFutureExample{
        //使用它可以很方便地为我们编写多线程程序，什么异步、串行、并行或者等待所有线程执行完任务什么的都非常方便

        CompletableFuture<Void> task1 = CompletableFuture.supplyAsync(()->{
                    //自定义业务操作

                    return null;
                });

        CompletableFuture<Void> task2 = CompletableFuture.supplyAsync(()->{
                    //自定义业务操作
                    return null;
                });

        CompletableFuture<Void> task3 = CompletableFuture.supplyAsync(()->{
                    //自定义业务操作
                    return null;
                });

        CompletableFuture<Void> task4 = CompletableFuture.supplyAsync(()->{
                    //自定义业务操作
                    return null;
                });

        @Test
        public void test(){
            CompletableFuture<Void> headerFuture=CompletableFuture.allOf(task1,task2, task3,task4);

            try {
                headerFuture.join();
            } catch (Exception ex) {
                //......
            }
            System.out.println("all done. ");


//            //文件夹位置
//            List<String> filePaths = Arrays.asList();
//            // 异步处理所有文件
//            List<CompletableFuture<String>> fileFutures = filePaths.stream()
//                    .map(filePath -> doSomeThing(filePath))
//                    .collect(Collectors.toList());
//            // 将他们合并起来
//            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
//                    fileFutures.toArray(new CompletableFuture[fileFutures.size()])
//            );

        }

        public void doSomeThing(String s){
//            return true;
        }
    }
}
