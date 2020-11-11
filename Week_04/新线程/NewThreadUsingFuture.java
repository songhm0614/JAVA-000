import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.*;

/**
 * @author haomiaosong
 * @date 2020/11/11 8:21 AM
 */
public class NewThreadUsingFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池
        ExecutorService executorService = newSingleThreadExecutor();

        // 异步执行 下面方法
        Future<Integer> result = executorService.submit(NewThreadUsingFuture::sum);

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result.get());
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
        executorService.shutdown();
    }

    private static int sum() {
        return fibo(45);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
    
}
