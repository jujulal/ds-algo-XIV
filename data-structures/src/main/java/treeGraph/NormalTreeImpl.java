package treegraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * by prayagupd
 * on 2/21/15.
 *
   4.1
   Implement a function to check if a tree is balanced. For the purposes of this question,
   a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
   from the root by more than one.

 * http://stackoverflow.com/a/4054711/432903
 */

class TreeNode<T> {
  TreeNode<T> parent;
  List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
  T data;

  public TreeNode(TreeNode<T> parent, T data){
    System.out.println(" # Node#Node adding " + data + " to the end of " + parent +" .");
    this.parent = parent;
    this.data = data;
    System.out.println(" # ----------------------------------------------------------------");
  }

  public boolean hasNext(){
    if (this.children !=null) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return data+"";
  }
}

class Tree<T> implements Iterable<T>{
  TreeNode<T> ROOT_NODE;

  public Tree(T data){
    this.ROOT_NODE = new TreeNode<T>(null, data);
  }

  public Tree<T> hasChildren(T data){
    TreeNode<T> current = new TreeNode(this.ROOT_NODE, data);
    ROOT_NODE.children.add(current);
    return this;
  }

  public Tree<T> hasChildren(Tree<T> tree1) {
    tree1.ROOT_NODE.parent = this.ROOT_NODE;
    this.ROOT_NODE.children.add(tree1.ROOT_NODE);
    return this;
  }

  public int size(){
    int size = this.ROOT_NODE.children.size();
    return size;
  }

  /**
   * recursive way to get <height> of a node-x
   * height-x = longest path from x to leaf node on (left and right) ie max(left, right)
   *          = maxDepth
   * depth = no of edges [from ROOT_NODE to node-x]
   * @param node
   */
  public int height(TreeNode<T> node){
    if(node==null || node.children.size()==0) {
      return 0;
    }
    int max[]={0};
    node.children.forEach(elem -> {
      final int height = height(elem);
      if (height > max[0])
        max[0] = height;
    });
    return 1 + max[0]; //node.children.get(0) would be maxof(left / right for Binary Tree)
  }

  public int maxDepth(TreeNode<T> node){
    return height(node);
  }

  public int minDepth(TreeNode<T> node){
    if(node==null || node.children.size()==0) {
      return 0;
    }
    int minHeight[]={0};
    node.children.forEach(elem -> {
      final int height = minDepth(elem);
      if (height < minHeight[0])
        minHeight[0] = height;
    });
    return 1 + minHeight[0]; //node.children.get(0) would be minof(left / right for Binary Tree)
  }

  public String toString(){
    String s = "{" + this.ROOT_NODE.data + " : " + "[";
    int counter = 0;
    for (TreeNode<T> node : ROOT_NODE.children){

      if (counter == ROOT_NODE.children.size()-1) {
        s+=node.data;
      } else {
        s+=node.data+",";
      }
      counter++;
    }
    s+="]" + "}";
    return s;
  }

  @Override public Iterator<T> iterator() {
    return null;
  }
}

public class NormalTreeImpl {

  public static void main(String[] args) {

    //       Amazon
    //        /\
    //       /  \
    //      /    \
    //     /      \
    //    AWS      Route53
    //   /          \
    //  /            \
    // /              \
    //East            West
    Tree<String> tree1 = new Tree<String>("Amazon")
                                         .hasChildren(new Tree<String>("AWS")
                                             .hasChildren(new Tree<String>("East"))
                                             .hasChildren(new Tree<String>("West")))
                                         .hasChildren(new Tree<String>("Route53"));
    System.out.println("tree1 "+ tree1 + " has " + tree1.size() + " nodes ");
    System.out.println("  |");
    System.out.println("  | with height(=max length from ROOT_NODE to leaf node) " + tree1.height(
        tree1.ROOT_NODE));
    System.out.println("  | with minDepth(=min length from ROOT_NODE to leaf node) " + tree1.minDepth(
        tree1.ROOT_NODE));

    //       Facebook
    //        /\
    //       /  \
    //      /    \
    //     /      \
    // Messaging  Feeds
    //              \
    //               \
    //                \
    //                Popular
    Tree<String> tree2 = new Tree<String>("Facebook").hasChildren(new Tree<String>("Messaging"))
                                                     .hasChildren(new Tree<String>("Feeds")
                                                         .hasChildren(new Tree<String>("Popular")));
    System.out.println("tree2 "+ tree2 + " has " + tree2.size() + " nodes ");
    System.out.println("   | with height((=max length from ROOT_NODE to leaf node) " + tree2.height(
        tree2.ROOT_NODE));
    Tree<String> tree = new Tree<String>("CS companies").hasChildren(tree1)
                                                        .hasChildren(tree2);

    System.out.println("tree " + tree + " has " + tree.size() + " nodes with height " + tree.height(
        tree.ROOT_NODE));
  }
}


