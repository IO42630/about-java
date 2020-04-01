## Threads
* Meaning:
    * `java.lang.Thread`
        * Object
    * a thread of execution
        * individual process
        * has its own call stack
        * one theread per call stack, or vice versa
        
    <!-- -->
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

| status | |
---|---
| NEW | 		The thread is created but has not been processed yet.|
| RUNNABLE | 	The thread is occupying the CPU and processing a task. (It may be in WAITING status due to the OS's resource distribution.)|
| BLOCKED | 	The thread is waiting for a different thread to release its lock in order to get the monitor lock. | 
    				WAITING: 	The thread is waiting by using a wait, join or park method.
				TIMED_WAITING:	The thread is waiting by using a sleep, wait, join or park method.
						(The difference from WAITING is that the maximum waiting time is specified by the method parameter,
						and WAITING can be relieved by time as well as external changes.)
thrad types			daemon		stop working when there are no other non-daemon threads.
						Even if you do not create any threads, the Java application will create several threads by default.
						Most of them are daemon threads, mainly for processing tasks such as garbage collection or JMX.
				non-daemon	A thread running the 'static void main(String[] args)’ method is created as a non-daemon thread,
						and when this thread stops working, all other daemon threads will stop as well.
						(The thread running this main method is called the VM thread in HotSpot VM.)

## Thred Dump File
"http-nio-2990-exec-391" #707 daemon prio=5   tid=0x00007fba5cdaf800 nid=0xb77 runnable [0x00007fba8e0e4000] java.lang.Thread.State: RUNNABLE
thread name                           priority
*/