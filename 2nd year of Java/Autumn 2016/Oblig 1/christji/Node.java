public class Node {
   String data;
   Node left = null;
   Node right = null;
   Node parent = null;
   int depth;

  public Node(String word) {
    this.data = word;
  }

  public void addNode(Node node) {
    // Checks if input word is smaller than root-node.
    if(node.data.compareTo(this.data) < 0) {
      // Puts left if smaller than root-node.
      if(this.left == null) {
        this.left = node;
        node.parent = this;
        return;
        // Recursive call to find the right place to put in the new node.
      } else {
        this.left.addNode(node);
        return;
      }
    }
    if(node.data.compareTo(this.data) > 0) {
      // Puts left if smaller than root-node.
      if(this.right == null) {
        this.right = node;
        node.parent = this;
        return;
        // Recursive call to find the right place to put in the new node.
      } else {
        this.right.addNode(node);
        return;
      }
    }
    if(node.data.compareTo(this.data) == 0) {
      return;
    }

  } // addNode-end.

} // Slutt Node
