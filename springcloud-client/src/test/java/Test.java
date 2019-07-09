import java.util.concurrent.SynchronousQueue;

/**
 * @author vanki
 * @date 2019-07-09 10:01
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        /*ThreadPoolExecutor tp = new ThreadPoolExecutor(2, 2, 0, TimeUnit.DAYS, new SynchronousQueue<>());

        for (int i = 0; i < 5; i++) {
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("haha");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("hehe");
                }
            });
        }*/

        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
//        System.out.println(queue.add(1));
//        System.out.println(queue.add(2));

        System.out.println(queue.offer(4));
        System.out.println(queue.offer(5));

//        queue.put(6);
//        queue.put(7);
    }
}
