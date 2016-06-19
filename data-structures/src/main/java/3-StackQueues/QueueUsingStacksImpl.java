

import java.util.Stack;

/**
 * by prayagupd
 * on 2/21/15.
 *
 * 3.5	Implement a "QueueUsingStacks" class which implements a queue using two stacks.
 * Microsoft, http://www.careercup.com/question?id=15443694
 *
 * Amazon, Design a stack using queue(s)
 * http://www.careercup.com/question?id=5701535442927616
 */

interface Queue<T> {
  public void add(T value);
  public T remove();
  public int size();
}

/**
 * Keep 2 stacks, let's call them inbox and outbox.
 * Queue:
 - Push the new element onto inbox

 Dequeue:
 - If outbox is empty, refill it by popping each element from inbox and pushing it onto outbox
 - Pop and return the top element from outbox

 Using this method, each element will be in each stack exactly once -
 meaning each element will be pushed twice and popped twice, giving amortized constant time operations.
 */

class QueueUsingStacks<T> implements Queue<T> {
    Stack<T> initialStack;
    Stack<T> finalStack;

    public QueueUsingStacks() {
      initialStack = new Stack<T>();
      finalStack = new Stack<T>();
    }

    @Override
    public int size() {
      return initialStack.size() + finalStack.size();
    }

    @Override
    public void add(T value) {
      initialStack.push(value);
    }

    public T peek() {
      if (!finalStack.empty()) {
        return finalStack.peek();
      }
      moveInitialStack();
      return finalStack.peek();
    }

    @Override
    public T remove() {
      if (!finalStack.empty()) {
        return finalStack.pop();
      }
      moveInitialStack();
      return finalStack.pop();
    }


    private void moveInitialStack() {
      while (!initialStack.empty()) {
        finalStack.push(initialStack.pop());
      }
    }
}

public class QueueUsingStacksImpl {

   public static void main (String[] args) {
      QueueUsingStacks<String> queueUsingStacks = new QueueUsingStacks<String>();
      queueUsingStacks.add("Amazon");
      queueUsingStacks.add("Databricks");
      queueUsingStacks.add("Foursquare");
      System.out.println("initial size => " + queueUsingStacks.size());

      String removed = queueUsingStacks.remove();
      System.out.println("Removed => " + removed);
      System.out.println("final size => " + queueUsingStacks.size());
   }
}
