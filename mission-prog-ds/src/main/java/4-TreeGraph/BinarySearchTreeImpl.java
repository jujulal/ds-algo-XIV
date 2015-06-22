/**
 * by prayagupd
 * on 2/23/15.
 *
 * 4.5
   Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a given node in
   a binary search tree where each node has a link to its parent.
 */

class BinarySearchTree<K, V> {
  K key;
  V value;
  BinarySearchTree<K, V> parent;
  BinarySearchTree<K, V> left;
  BinarySearchTree<K, V> right;

  public BinarySearchTree(K key, V value, BinarySearchTree<K, V> left, BinarySearchTree<K, V> right){
    this.key = key;
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public BinarySearchTree(K key, V value){
    this.key = key;
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public void left(BinarySearchTree<K, V> left) {
    this.left = left;
    return;
  }

  public void right(BinarySearchTree<K, V> right) {
    this.right = right;
    return;
  }

  public String toString(){
    BinarySearchTree<K, V> leftNode = this.left;
    BinarySearchTree<K, V> rightNode = this.right;
    String result = "{";
    result = result + this.key + " : [";

    //traverse left side only
    while(leftNode!=null || rightNode!=null) {
      final String l = leftNode!=null? leftNode.key+"":"N/A";
      final String r = (rightNode!=null?rightNode.key+"":"N/A");
      //System.out.println("left:right => " + l + ":" + r);
      result = result + l + " | " + r +",";
      leftNode = leftNode!=null?leftNode.left:null;
      rightNode = leftNode!=null?leftNode.right:null;
    }
    result +=" ] }";
    return result;
  }

}

public class BinarySearchTreeImpl {
  public static void main(String[] args){
    BinarySearchTree<String, String> binaryTree = new BinarySearchTree<String, String>("Programming Language", "100");
    BinarySearchTree<String, String> tree1 = new BinarySearchTree<String, String>("Java", "101");
    BinarySearchTree<String, String> tree11 = new BinarySearchTree<String, String>("Spring", "1011");
    BinarySearchTree<String, String> tree12 = new BinarySearchTree<String, String>("Grails", "1012");
    tree1.left(tree11);
    tree1.right(tree12);

    binaryTree.left(tree1);
    binaryTree.right(new BinarySearchTree<String, String>("Scala", "102"));

    System.out.println("" + binaryTree);
  }
}
