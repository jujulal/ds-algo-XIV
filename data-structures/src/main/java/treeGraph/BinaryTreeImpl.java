/**
 * by prayagupd
 * on 2/23/15.
 *
 * 4.5
   Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a given node in
   a binary search tree where each node has a link to its parent.
 */

class BinaryTree<K, V> {
  K key;
  V value;
  BinaryTree<K, V> left;
  BinaryTree<K, V> right;

  public BinaryTree(K key, V value, BinaryTree<K, V> left, BinaryTree<K, V> right){
    this.key = key;
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public BinaryTree(K key, V value){
    this.key = key;
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public void left(BinaryTree<K, V> left) {
    this.left = left;
    return;
  }

  public void right(BinaryTree<K, V> right) {
    this.right = right;
    return;
  }

  public void inOrder(){

  }

  public String toString(){
    BinaryTree<K, V> leftNode = this.left;
    BinaryTree<K, V> rightNode = this.right;
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

public class BinaryTreeImpl {
  public static void main(String[] args){
    BinaryTree<String, String> binaryTree = new BinaryTree<String, String>("Programming Language", "100");
    BinaryTree<String, String> tree1 = new BinaryTree<String, String>("Java", "101");
    BinaryTree<String, String> tree11 = new BinaryTree<String, String>("Spring", "1011");
    BinaryTree<String, String> tree12 = new BinaryTree<String, String>("Grails", "1012");
    tree1.left(tree11);
    tree1.right(tree12);

    binaryTree.left(tree1);
    binaryTree.right(new BinaryTree<String, String>("Scala", "102"));

    System.out.println("" + binaryTree);
  }
}
