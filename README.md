# java-multithreading
learn java multithreading from udemy course 


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




### [`CountDownLatch`]()

1. 线程安全的class,允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行.
2. 在声明时指定Thread数量,有两个方法countDown 与aWait.

[CountDownLatch介绍-英文](https://howtodoinjava.com/java/multi-threading/when-to-use-countdownlatch-java-concurrency-example-tutorial/)
[中文版](http://www.importnew.com/15731.html)


[example CountDownLatch使用](06-CountDownLatch\src\app\App.java)


## Editor

- vscode 


## References

- [github-code](https://github.com/Beerkay/JavaMultiThreading/tree/master/JavaMultiThreadingCodes/src)
- [udemy course](https://www.udemy.com/java-multithreading/learn/v4/t/lecture/107238?start=15)
- [Top 5 Java Multithreading and Concurrency Courses for Experienced Programmers](https://javarevisited.blogspot.com/2018/06/top-5-java-multithreading-and-concurrency-courses-experienced-programmers.html)