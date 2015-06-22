

import java.util.Enumeration;
import java.util.Stack;

/**
 * by prayagupd
 * on 2/21/15.
 *
 * 3.2
   How would you design a Stack which, in addition to push and pop, also has a function
   min() and max() which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 *
 * @ref Stack with find-min/find-max more efficient than O(n)?
 * http://stackoverflow.com/a/16485020/432903
 *
 * Yahoo,
 * Implement the stack in such a way that push,pop and minimum find in the stack operations are o(1).
 * http://www.careercup.com/question?id=3079
 */

class StackWithMinimum extends Stack<Integer> {
  Stack<Integer> minStack;

  public StackWithMinimum(){
    minStack = new Stack<Integer>();
  }

  /**
   * push element only if value you want to add is lesser/equal than top() of stack
   * @param value
   */
  public void push(int value){
    if (value <= min()) {
      minStack.push(value);
    } else {
      System.out.println(value + " can not be added to minStack.");
    }
    super.push(value);
  }

  @Override
  public Integer pop() {
    int value = super.pop(); //fixme java.util.EmptyStackException
    if (value == min()) {
      minStack.pop();
    }
    return value;
  }

  public int min() {
    if (minStack.isEmpty()) {
      return Integer.MAX_VALUE;
    } else {
      //peek object at the top of this minStack without removing it
      return minStack.peek();
    }
  }

  public String toString(){
    String result = "[";
    Enumeration<Integer> elements = this.minStack.elements();
    int counter =0;
    while(elements.hasMoreElements()){
      int element = elements.nextElement();
      if(counter == size()-1) {
        result += element + "";
      } else {
        result += element + ", ";
      }
      //System.out.println("elem => " + element);
      counter++;
    }
    return result+"]";
  }
}

public class StackWithMinimumImpl {
  public static void main(String[] args){
    StackWithMinimum stackWithMinimum = new StackWithMinimum();
    stackWithMinimum.push(28);
    stackWithMinimum.push(10);
    stackWithMinimum.push(19); //wont be added
    stackWithMinimum.push(89); //wont be added

    String s = stackWithMinimum.toString();
    System.out.println("min element => " + stackWithMinimum.min() + " for min stack "+ s);

    int top1 = stackWithMinimum.pop();
    String s2 =  stackWithMinimum.toString();
    System.out.println("top element => " + top1  + " for min stack "+ s);
  }
}