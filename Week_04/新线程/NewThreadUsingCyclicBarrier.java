import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haomiaosong
 * @date 2020/11/11 8:21 AM
 */
public class NewThreadUsingCyclicBarrier {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池
        // 异步执行 下面方法
        AtomicInteger result = new AtomicInteger();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> new Thread(() -> result.set(sum())).start());
        cyclicBarrier.await();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

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
