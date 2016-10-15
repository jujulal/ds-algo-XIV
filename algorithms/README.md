algorithms
----------

```
What is the time complexity of the following code?

i = 1;
while (i < N) {i *= 2;} O(N)
```

```
Problem Statement

You are given a list of tasks as an integer array, task_costs. Every i-th element of task_costs represents a task
and requires task_costs[i] seconds to complete. All tasks listed in the array are independent of other tasks.

It is required to finish all the tasks independently and as soon as possible. You are given a single worker robot 
to start taking the tasks and finish them one at a time. However if you like, you can divide the worker robot in two. 
Each resulting robot can then be further divided into two and so on. There is a cost, in seconds, of dividing a 
robot in two, represented by robot_divide_cost.

You can assign an independent task to any available robot, however you can't interrupt or divide a robot while 
it is working on the assigned task. At the same time you can't assign a task to any robot while its in the process 
of getting divided. 

To keep things simple you can't allow multiple robots to work on the same task. At any given time only one robot 
can work on a task and finish it. Once any particular robot finishes a task it can't be assigned any further tasks.

Given a list of tasks and cost of dividing a robot, find the least amount of time to finish all tasks.
```

sorting
-------

parallelism
-----------
