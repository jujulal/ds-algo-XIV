package linkedLists;

import java.util.*;

/**
 *
 * 2.2
   Implement an algorithm to find the nth to last element of a singly LinkedList.
 */

class SingleNode<T> {
  SingleNode<T> next;
  T data;

  public SingleNode(){
    this.next = null;
    this.data = null;
  }

  public SingleNode(SingleNode<T> n, T data){
    System.out.println("SingleNode#SingleNode adding " + data +" .");
    this.next = n;
    this.data = data;
    System.out.println("----------------------------------------------------------------");
  }

  public boolean hasNext(){
    if (this.next!=null) {
      return true;
    }
    return false;
  }

  public void add(T data){
    SingleNode<T> lastNode = next;
    if (lastNode!=null) {
      while (lastNode.hasNext()) {
        lastNode = lastNode.next;
      }
    } else {
      next = new SingleNode<T>();
      lastNode = next;
    }
    lastNode.next = new SingleNode<T>(null, data);
  }

  public int size() {
    int size = 0;
    SingleNode<T> lastNode = next;
    if (lastNode==null) return size;
    while(lastNode.hasNext()) {
      lastNode = lastNode.next;
      size++;
    }
    return size;
  }

  @Override
  public String toString() {
    return data+"";
  }
}

class SinglyLinkedList<T> {
  public SingleNode<T> HEAD;

  public SinglyLinkedList(){
    HEAD = new SingleNode<T>(null, null);
  }

  public void add(T data){
    SingleNode<T> lastNode = HEAD;
    while (lastNode.hasNext()) {
      lastNode = lastNode.next;
    }

    lastNode.next = new SingleNode<T>(null, data);
  }

  public SingleNode<T> next(){
    return HEAD.next;
  }

}

public class SinglyLinkedListNthNodeToLast {

  public static SingleNode nthNode(SingleNode linkedList, int n){
    SingleNode linkedList1 = linkedList ;
    SingleNode linkedList2 = linkedList;

    //advance linkedList2 by n-1 nodes;
    for  (int  i  =  0;  i  <  n  - 1;  ++i)  {
      if  (linkedList2  ==  null)  {
      /*this is an error condition to check to see if
         the linked list is less than n nodes long, in which
         case we just return null indicating an error
      */
        return null;
      }

      else //go to the next node
        linkedList2 = linkedList2.next;

    }

    /*Now, keep going until you hit a null node,
      and then you've reached the end, and
      pntr1 will be pointing to the nth from
     last node
    */

    while(linkedList2.next != null){
      linkedList1 = linkedList1.next;
      linkedList2 = linkedList2.next;
    }

    return linkedList1;
  }

  public static void main (String[] args) {
    SingleNode<String> linkedList = new SingleNode<String>();
    linkedList.add("Hadoop");
    linkedList.add("Spark");
    linkedList.add("Storm");
    linkedList.add("Elasticsearch");
    linkedList.add("Kafka");
    linkedList.add("Zookeeper");
    linkedList.add("Cassandra");
    int searchFromEnd = 4;
    SingleNode<String> node = nthNode(linkedList, searchFromEnd);
    System.out.println("required node " +searchFromEnd+" in linkedlist of size " + linkedList.size() + " => " + node);
  }
}

