package linkedLists;

/**
 * by prayagupd
 * on 2/21/15.
 *
 * Implement a DoublyLinkedList algorithm in java with following features
 * addNode()
 * insertNode()
 * size()
 * findNode()
 * removeNode()
 *
 * Arista Networks / http://www.careercup.com/question?id=13116662
 * Given a LinkedList of integers, delete all the nodes from the LinkedList which data value equals to a given value.
 * void delete(Node **linkedListPointer, int target);
 */

class Node<T> {
  Node<T> previous;
  Node<T> next;
  T data;

  public Node(Node<T> p, Node<T> n, T data){
    System.out.println("Node#Node adding " + data + " to the end of " + p +" .");
    this.previous = p;
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

  @Override
  public String toString() {
    return data+"";
  }
}

class DoublyLinkedList<T> {
  Node<T> HEAD_NODE;

  public DoublyLinkedList(){
    this.HEAD_NODE = new Node<T>(null, null, null);
  }

  public void add(T data){
    Node<T> lastNode = HEAD_NODE;
    while(lastNode.next!=null) {
      lastNode = lastNode.next;
      System.out.println("DoublyLinkedList#add Last Node for " + data + " => " + lastNode);
    }
    Node<T> current = new Node(lastNode, null, data);
    lastNode.next= current;
  }

  public void insert(T data, int index){
    Node<T> insertionNode = HEAD_NODE;
    int counter = 0;
    while(insertionNode.next!=null) {
      insertionNode = insertionNode.next;
      if (counter==index-1) {
        System.out.println("index found at " + insertionNode);
        break;
      }
      counter++;
    }
    System.out.println("index found at " + counter);
    Node<T> previous = insertionNode.previous;
    Node<T> newNodeToInsert = new Node(previous, insertionNode, data);
    insertionNode.previous= newNodeToInsert;
    previous.next = newNodeToInsert;
  }

  public int size(){
    Node nextNode = HEAD_NODE;
    int size = 0;
    while(nextNode.next!=null){
      nextNode = nextNode.next;
      System.out.println("Size " + size + " till " + nextNode);
      size++;
    }
    return size;
  }

  public String toString(){
    String s = "[";
    Node next = HEAD_NODE;
    while(next.next!=null) {
      next = next.next;
      s+=next.data;
      if (next.next!=null){
        s+=",";
      }
    }
    s+="]";
    return s;
  }
}

public class DoublyLinkedListImpl {
  public static void main(String[] args) {
    DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
    doublyLinkedList.add("Amazon");
    doublyLinkedList.add("Spotify");
    doublyLinkedList.add("Databricks");
    System.out.println(doublyLinkedList + " has " + doublyLinkedList.size() + " elements.");
    doublyLinkedList.insert("Facebook", 2);
    System.out.println(doublyLinkedList + " has " + doublyLinkedList.size() + " elements.");
  }
}


