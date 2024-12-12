# Concurrency Issues

### Problem "Drag racing"
Find a way to always end up with 2_000_000.
The [provided code](./src/main/kotlin/prblemDragRacing/problem.kt) demonstrates a concurrency issue known as a **race condition**.
#### Explanation of the Problem
- **Shared State**: The `counter` variable is shared between two threads (`firstWorker` and `secondWorker`).
- **Increment Operation (`counter++`)**: This operation is not atomic. It consists of multiple steps:
  1. Read the current value of `counter`.
  2. Increment the value.
  3. Write the new value back to memory.

 When two threads execute `counter++` simultaneously, they may read the same initial value of `counter`, leading to incorrect results (e.g., some increments may be "lost").
#### Observed Behavior
The final value of `counter` is **non-deterministic** and typically less than the expected result of `2_000_000`. This happens because of the overlap and interference between the two threads when accessing and modifying `counter`.

#### Key Concept: Race Condition
A **race condition** occurs when the correctness of a program depends on the timing or sequence of threads. In this case, the race condition arises because the threads compete to modify the shared `counter` variable without proper synchronization.
#### Solutions
1. Use [Atomic Variables](./src/main/kotlin/prblemDragRacing/solutionWithAtomic.kt)
2. Use [ReentrantLock(Mutex)](./src/main/kotlin/prblemDragRacing/solutionWithReentrantLock.kt)
3. Use [Semaphore](./src/main/kotlin/prblemDragRacing/solutionWithSemaphore.kt)

### Problem "Pass me some water"
Explain in your own words why the application freezes.
### Solution
