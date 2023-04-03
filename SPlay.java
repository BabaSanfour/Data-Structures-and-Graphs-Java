package IFT2015;

public class SPlay<Key extends Comparable<Key>, Value> {
    private Node root;
    
    private class Node {
        Key key;
        Node left;
        Node right;
        Value value;

        Node(Key key, Value value) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.value = null;

        }
    }
    
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }
    
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }
    // The splay() function is used to "splay" a node up to the root of the tree, 
    // which means to bring it up to the root of the tree while maintaining the BST
    // property. The purpose of splaying is to bring frequently accessed nodes closer 
    // to the root of the tree, which can help improve performance.
    // methods used are series of zig-zag, zig-zig, zig rotations.
    private Node splay(Node h, Key key) {
        if (h == null) return null;
        int cmp1 = key.compareTo(h.key);
        if (cmp1 < 0) {
            if (h.left == null) return h;
            int cmp2 = key.compareTo(h.left.key);
            if (cmp2 < 0) {
                h.left.left = splay(h.left.left, key);
                h = rotateRight(h);
            } else if (cmp2 > 0) {
                h.left.right = splay(h.left.right, key);
                if (h.left.right != null)
                    h.left = rotateLeft(h.left);
            }
            if (h.left == null) return h;
            else return rotateRight(h);
        } else if (cmp1 > 0) {
            if (h.right == null) return h;
            int cmp2 = key.compareTo(h.right.key);
            if (cmp2 < 0) {
                h.right.left = splay(h.right.left, key);
                if (h.right.left != null)
                    h.right = rotateLeft(h.right);
            } else if (cmp2 > 0) {
                h.right.right = splay(h.right.right, key);
                h = rotateLeft(h);
            }
            if (h.right == null) return h;
            else return rotateLeft(h);
        } else return h;
    }  
    public void remove(Key key){
        if (root == null) return;
        root = splay(root, key);
        int cmp = key.compareTo(root.key);

        if(cmp==0){
            if (root.left == null){
                root = root.right;
            }
            else {
                Node x = root.right;
                root = root.left;
                splay(root, key);
                root.right = x;
            }
        }
    } 
    public void put(Key key, Value value){
        if (root==null){
            root= new Node(key, value);
            return;
        }
        root = splay(root, key);
        int cmp = key.compareTo(root.key);
        if(cmp<0){
            Node n = new Node(key, value);
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }
        else if(cmp>0){
            Node n = new Node(key, value);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }
        else {
            root.value = value;
        }
    }
    private void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.key + " : " + node.value);
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        SPlay<Integer, String> tree = new SPlay<>();

        // Insert some elements into the tree
        tree.put(5, "five");
        tree.put(3, "three");
        tree.put(8, "eight");
        tree.put(1, "one");
        tree.put(4, "four");
        // Print the tree (in-order traversal)
        System.out.println("Elements in the tree:");
        tree.printTree(tree.root);
    
        // Remove an element from the tree
        tree.remove(3);
    
        // Print the tree again
        System.out.println("Elements in the tree after removing 3:");
        tree.printTree(tree.root);
    
        // Insert and remove some more elements from the tree
        tree.put(7, "seven");
        tree.put(10, "ten");
        tree.put(2, "two");
        tree.put(6, "six");
        tree.remove(8);
    
        // Print the tree again
        System.out.println("Elements in the tree after inserting and removing more elements:");
        tree.printTree(tree.root);
    }
}