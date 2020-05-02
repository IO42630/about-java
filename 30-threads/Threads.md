## Threads
* `java.lang.Thread` 
    * Object
* *thread of execution*
    * individual process
    * has its own call stack (one *thread* per call stack, vice versa)
    

* `main()` has a Thread called `main`.
* different JVM implementations may handle threads differently
    * write code so that this doesn't matter
    
#### Methods
* `start()`
    * calling `start()` a second time causes an Exception.
    * new thread of execution starts
    * Thread moves from NEW to RUNNABLE
    * when the thread gets a chance to execute its'target `run()` will run.
    * `t.start()` will cause a new thread of execution (with a new callstack), and execute `run()` therein.
* `yield()`
    * tries to put thread from running to runnable
    * causes thread of same priority to be chosen for running
* `b.join()`
    * guaranteed
    * causes current thread to be appended to `b`
    * effectively injects `b` into current thread
        * after `b` is completed, current thread resumes
* `sleep()`
    * guaranteed to sleep for at least defined time (afterwards schedule decides)
    * static
        * can't be used to put another thread to sleep
    * used to 
        * "slow a thread down"
        * make place for another thread
* `run()`
    * job code goes here
    * starts the the thread of execution (=new call stack) begins by envoking run
    * `new Thread().run()` just calls the run method as part of the enclosing Thread

<br>

* ways to definie & instantiate a thread
    * extend `Thread`
    * implement `Runnable` -> preferrable
 
#### Runnable
* `Thread` : worker
* `Runnable` : job to be done

![](TwoStacksExample.png)

![](JoinExample.png)
   
    
    
* Thread Contention
    * thread a holds lock.
	* thread b waits for the lock to be lifted.


* deadlock
    * special contention
    * n threads are waiting for another thread to complete their tasks in order to complete their own tasks.


* thread dump
    * gives information on the exact status of each thread

#### Synchronization
* Every Java object has a single monitor. The monitor can be owned by one thread.
* To access an object a thread needs to wait in the queue until the first thread releases its monitor.
* see `syncronization`
    * `Win`
        * make variable private
        * put `syncronized` specifier on setter.
    * `TwoJobsFail`
        * this only works if two `Threads` modify the same `Runnable`
        * if two `Runnables` are used `synchronized` does nothing.
* when entering a `synchronized` non-static method
    * the Thread acquires the lock to `this` (the instance of the class containing the method).
    * other threads can't enter any of the `synchronized` methods of `this`.
* possible to synchronize non-`static` blocks of code
    * `synchronized(this){}`
        * possible to replace `this` with the instance of another `Object`. 
* when entering a `syncronized` `static` method
    * the thread acquires the lock to the `java.lang.Class` of the class
        * each `class` has a corresponding instance of `java.lang.Class`
* possible to synchronize `static` blocks of code
    * `synchronize(MyClass.class){}`
* conclusions:
    * `static` and non-`static` methods/block don't block each other.
    * for blocks it matters what object is used as lock
    * two instances have two locks, thus don't block each other
    * use static setters for static fields
    
#### Keep vs Give up Locks
* Give: 
    * `Object.wait()`
* Keep:
    * `Object.notify()`
    * `Thread.join()`
    * `Thread.sleep()`
    * `Thread.yield()` 
    
#### Problems
* Race Condition
    * 2+ threads (race to) modify shared data
    * the outcome is influenced by the scheduler (bad).
* Deadlock
    * Thread A owns "foo" waits for "bar"
    * Thread B owns "bar" waits for "foo"
    * TODO example
* Livelock
    * TODO example
* Starvation
    * Thread A hogs a lock
    * Thread A unable to make progress
    
#### `volatile`
* makes variable atmoic
    * write can't be interrupted 

<br>

#### ThreadSafeClasses
* see `ThreadSafeClass`
* such as `Collections.synchronizedList`
* synchronize only individual methods
    * protect only from i.e. `remove()` is not run, twice simultaneously
    * does not protect from induced race
* TODO why is this so ... IS maybe `size()` not synchronized??
#### Lock vs Monitor
https://howtodoinjava.com/java/multi-threading/multithreading-difference-between-lock-and-monitor/

<br>

#### Dead vs. Alive
* Dead : before `start()` is called, after `run()` is completed.
* checked by `isAlive()`.

<br>

#### States
*  NEW 
    * `Thread` is instanciated. 
    * *Thread of execution* is not yet started. Not alive.
* RUNNABLE 
    * Thread of execution was started with `start()`. 
    * Alive & eligible to be RUNNING.
* RUNNING 
    * Scheduler chose *thread of excution* from the runnable pool.
* BLOCKED 
    * Not eligble to run. 
    * Thread is waiting for a different thread to release its lock in order to get the monitor lock.
* WAITING 
    * Not eligble to run. 
    * The thread is waiting by using a wait, join or park method. 
    * Usually something in it's own `run()` causes the Thread to wait. 
* TIMED_WAITING 
    * Not eligble to run. 
    * The thread is waiting by using a sleep, wait, join or park method. 
    * (The difference from WAITING is that the maximum waiting time is specified by the method parameter, and WAITING can be relieved by time as well as external changes.)
* TERMINATED
    * after `run()` completes.				

<br>
					
#### Types					
* daemon
    * stop working when there are no other non-daemon threads.
    * Even if you do not create any threads, the Java application will create several threads by default.
    * Most of them are daemon threads, mainly for processing tasks such as garbage collection or JMX.
* non-daemon
    * A thread running the 'static void main(String[] args)’ method is created as a non-daemon thread,
    * and when this thread stops working, all other daemon threads will stop as well.
    * (The thread running this main method is called the VM thread in HotSpot VM.)

<br>

#### Thread Scheduler
* decides which threads should run at any given moment
    * threads in the RUNNABLE state are eligible
* takes threads out of the run state.
* can be influenced
* a Thread us guaranteed to complete
* within a thread the order is guarnteed
* with multiple threads
    * not guarantedd order in which they start or finish
        * scheduler controls this  
* uses *priorities*
    * tries to run the thread with highest priority
    * usually not necessary to modify directly
    * main has default priority
    * priority values may differ between JVMs (usually 1,5,10)
        * `Thread.MIN_PRIORITY`
        * `Thread.NORM_PRIORITY`
        * `Thread.MAX_PRIORITY`


#### Thread Interaction
* `wait()` : thread puts itself into the waiting room
* `notify()` : thread (or is it object??) tells one thread to come out the waiting room
* `notifyAll()` : thread tell all waiting threads to come out of the waiting room
* the three above myust be called from `synchronized` code.
* each `Object obj` has a list of threads waiting
    * a thread *t1* gets on the waiting list by executing `obj.wait()`
    * a thread in the waiting list is idle
    * when `obj.notify()` is called by thread *t2* , a thread on the waiting list is picked to receive lock
    
    
