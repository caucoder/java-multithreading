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




### [03-Synchronized]()


**synchronized**: guarantees all threads can see the current state of the variable.don't need **volatile**

synchronized method,thread acquire object's intrinsic lock. 确保atomic原子操作（read-write(modify)）



## Editor

- vscode 


## References

- [github-code](https://github.com/Beerkay/JavaMultiThreading/tree/master/JavaMultiThreadingCodes/src)
- [udemy course](https://www.udemy.com/java-multithreading/learn/v4/t/lecture/107238?start=15)
- [Top 5 Java Multithreading and Concurrency Courses for Experienced Programmers](https://javarevisited.blogspot.com/2018/06/top-5-java-multithreading-and-concurrency-courses-experienced-programmers.html)