import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haomiaosong
 * @date 2020/11/11 8:15 AM
 */
public class NewThreadUsingThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池
        AtomicInteger value = new AtomicInteger();
        Thread thread = new Thread(() -> {
            value.set(sum());
        });

        // 异步执行 下面方法
        thread.start();
        thread.join();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + value.get());
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