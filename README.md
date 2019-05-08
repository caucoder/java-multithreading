# java-multithreading
learn java multithreading from udemy course 


1. 创建线程去执行代码
2. 编写线程安全的代码（类）


### [`1-Starting Threads`](./01-Starting-Threading)

> basic methods of creating a thread in java

1. extends the Thread class.
2. implement Runnable interface.
3. pass it to the constructor of the the thread class.
    ```java
        new Thread(()->{
            //code here
        }).start();
    ```


### [`2-Volatile-Basic Thread Communication`](./02-Basic-Thread-Communication)

> **volatile** : it's used to prevent threads caching variable.

[example stop a thread](./02-Basic-Thread-Communication/src/app/VolatileKeyWord.java)




### [`03-Synchronized`]()


**synchronized**: guarantees all threads can see the current state of the variable.don't need **volatile**

synchronized method,thread acquire object's intrinsic lock. 确保atomic原子操作（read-write(modify)）

[example add count](03-Synchronized\src\app\AppSynchronized.java)


### [`04-Lock-Objects`]()


multiple lock,synchronized代码块;
声明Object对象，使用不同的内部锁，提高时间性能

[exmaple 使用multiple lock 提高时间效率](04-Lock-Objects\src\app\Worker.java)



### [`05-Thread-pools`]()

1. recycling the threads avoid overhead.
2. as soon as one thread is finished and it's idle that same thread will now process a new task.

```java
ExecutorService executor = Executors.newFixedThreadPool(2);
// 提交5个任务
for (int i = 0; i < 5; i++) {
    executor.submit(new Processor(i));
}
// 禁止提交任务
executor.shutdown();
```

[example 线程池Executors处理5个任务](05-Thread-Pool\src\app\App.java)




### [`06-CountDownLatch`]()

1. 线程安全的class,允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行.
2. 在声明时指定Thread数量,有两个方法countDown 与aWait.

[CountDownLatch介绍-英文](https://howtodoinjava.com/java/multi-threading/when-to-use-countdownlatch-java-concurrency-example-tutorial/)
[中文版](http://www.importnew.com/15731.html)


[example CountDownLatch使用](06-CountDownLatch\src\app\App.java)






### [`07-BlockingQueue & 生产者-消费者`]()

1. 线程安全的queue,BlockingQueue,ArrayBlockingQueue
2. 使用put以及take方法，是具有阻塞效果
    ```java
    // Retrieves and removes the head of this queue,
    // waiting if necessary until an element becomes available.
    Integer tmp = queue.take();
    ```

[example 生产-消费者](07-BlockingQueue\src\app\App.java)



### [`08-wait and notify`]()

1. synchronized获取对象内部锁,wait阻塞，notify唤醒获取该内部锁的线程。
2. notify执行后并不是wait就马上执行，而是要释放内部锁后。

[example wait notify](08-wait-and-notify\src\app\Processor.java)



### [`09-Low-Level Producer-Consumer`]()


1. 自己使用LinkedList，wait,notify实现生产-消费

[**example 生产-消费者**](09-Low-Level Producer-Consumer\src\app\Processor.java)



### [`10-ReentrantLock`]()

1. 重入锁的使用方式ReentrantLock与Condition

[example 通过使用ReentrantLock实现加法](10-ReentrantLock\src\app\Runner.java)




### [`11-DeadLock`]()

> Account 转账例子，这里用到了两个锁,


避免四所的两个方法

1. 声明锁的顺序一样[example Runner.java](11-DeadLock\src\app\Runner.java)
2. 通过while循环不断检测锁是否可用[example RunnerImprove.java](11-DeadLock\src\app\RunnerImprove.java)




### [`12-Semaphore`]()

1. semaphore构造函数声明permits许可得数量
2. aquire获取许可，release释放许可

[example 线程池执行200个任务Connection（单例模式）,但是连接只用10个用semaphores来处理](12-Semaphore\src\app\Connection.java)


![](imgs\semaphores-1.PNG)
![](imgs\semaphores-2.PNG)
![](imgs\semaphores-3.PNG)
![](imgs\semaphores-4.PNG)








### [`13-Callable and Future`]()

> get return value from threads

1. Callable<> call method用于返回值
2. Future<> 用于接收值


[Example 返回线程睡眠得时间，如果睡眠时间超过2000异常]()




## Editor

- vscode 


## References

- [github-code](https://github.com/Beerkay/JavaMultiThreading/tree/master/JavaMultiThreadingCodes/src)
- [udemy course](https://www.udemy.com/java-multithreading/learn/v4/t/lecture/107238?start=15)
- [Top 5 Java Multithreading and Concurrency Courses for Experienced Programmers](https://javarevisited.blogspot.com/2018/06/top-5-java-multithreading-and-concurrency-courses-experienced-programmers.html)

- [Youtube-Java-concurrency](https://www.youtube.com/playlist?list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6)