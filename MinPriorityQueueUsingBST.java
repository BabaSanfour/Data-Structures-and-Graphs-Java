public class MinPriorityQueueUsingBST {

    Node root;

    static class Node {
        int key;
        Node left;
        Node right;
        private Node p;
        private int size;
        private Node min; // to store the min node

        public Node(int key, int size) {
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
            this.min = null;
        }
    }

    public MinPriorityQueueUsingBST() {
        root = null;
    }

    public Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    private void updateMinNode(Node z) {
        if (z != null) {
            Node left = z.left;
            Node right = z.right;
    
            updateMinNode(left);
            updateMinNode(right);
            Node minNode = z;

            if (left != null && left.min.key < minNode.key) {
                minNode = left.min;
            }
            if (right != null && right.min.key < minNode.key) {
                minNode = right.min;
            }
            z.min = minNode;
        }
    }
  
    private void transplant(Node u, Node v) {
        if (u.p == null){
            root = v;
        } else if (u == u.p.right){ //right child
            u.p.right = v;
        } else { // left child
            u.p.left = v;
        }
        if (v!=null)
            v.p = u.p;
    }

    public Node extractMinEfficient(Node z) {
	    if (z == null) {
            return null; 
        } 
        Node minNode = z.min;
        transplant(minNode, minNode.right);
        minNode.right = null; 
        z.size--;
        updateMinNode(z);
        return minNode;
    }
}
