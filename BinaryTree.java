
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Node {
    protected int value;
    protected Node left;
    protected Node right;
    
    Node(int value){
        this.value = value;
        right = null;
        left = null;
    }
    public void add_element(int value){
        if (value == this.value)
            return;
        else if (value < this.value){
            if (left == null){
                left = new Node(value);
            }
            else {
                left.add_element(value);
            } 
        }
        else {
            if (right == null){
                right = new Node(value);
            }
            else {
                right.add_element(value);
            }
        }

    }
}
public class BinaryTree {
    Node root;

    BinaryTree(int value){
        root = new Node(value);
    }
    public void add(int value){
        root.add_element(value);
    }
    public int biggest(){ // find biggest element in a binary tree
        Node biggest = root;
        
        while (biggest.right != null)
            biggest = biggest.right;
        return biggest.value;
    }
    public int search(int value){
        Node current = root;
        int height = 0;
        while (current != null){
            if (current.value == value)
                return height;
            else if (current.value < value)
                current = current.right;
            else
                current = current.left;
            height++;
                
            
        }
        return -1; // if we don't find the elemnt
    }
    public boolean checker(BinaryTree tree){
        return checker(tree.root);
    }
    public int max(int v1, int v2){
        return v1>v2 ? v1 : v2;
    }
    public int min(int v1, int v2){
        return v1>v2 ? v2 : v1;
    }
    public int get_max(Node current){
        if (current==null)
            return -1;
        int max_right = get_max(current.right);
        int max_left = get_max(current.left);
        return max(max(current.value, max_right), max_left);
    }
    public int get_min(Node current){
        if (current==null)
            return -1;
        int min_right = get_min(current.right);
        int min_left = get_min(current.left);
        return min(min(current.value, min_right), min_left);
    }
    public boolean checker(Node tree){
        if (tree == null)
            return true;
        if (get_max(tree.left)>tree.value)
            return false;
        if (tree.value> get_min(tree.right))
            return false;
        return checker(tree.left) && checker(tree.right);
    }

    public int sibling(int value){
        Node current = root;
        if (current.value == value)
            return -1;
        while (current!= null){
            if (current.right != null){
                if (current.right.value == value){
                    if (current.left == null)
                        return -1;
                    return current.left.value;
                }
            }
            if (current.left != null){
                if (current.left.value == value){
                    if (current.right == null)
                        return -1;
                    return current.right.value;
                }
            }
            if (current.value<value)
                current = current.right;
            else    
                current = current.left;
        }
        return -1;
    }
    BinaryTree(Node tree){
        root = tree;
    }
    public int smallest_before(int value){
        Node current = root;
        Node father = null;
        
        while (current != null){
            if (current.value == value)
                break;
            if (current.value < value){
                father = current;
                current = current.right;
            }
            else
                current = current.left;
        }
        if (current == null)
            return -1;
        if (current.left != null){
            BinaryTree smaller = new BinaryTree(current.left);
            return smaller.biggest();
        }
        if (father == null)
            return -1;
        return father.value;   
    }
    public void remove(int value){
        Node to_rm = root;
        Node father = null;

        while(to_rm!= null){
            if (to_rm.value == value)
                break;
            father = to_rm;
            if (to_rm.value < value){
                to_rm = to_rm.right;
            }
            else
                to_rm = to_rm.left;
        }
        if (to_rm == null)
            return;
        Node current = to_rm.left;
        while (current.right != null)
            current = current.right;
        current.right = to_rm.right;
        if (father==null)
            root = to_rm.left;
        else{
            if (father.right.value == value)
                father.right = to_rm.left;
            else
                father.left =to_rm.left;
        }


    }
    public int size_subtree_max(Node tree){
        if (tree==null)
            return 0;
        return max(size_subtree_max(tree.left), size_subtree_max(tree.right)) + 1;
    }
    public int size_subtree_min(Node tree){
        if (tree.left == null)
            return 0;
        if (tree.right == null)
            return 0;
        return min(size_subtree_min(tree.left), size_subtree_min(tree.right)) +1;
    }
    public boolean complete(Node root){
        return (size_subtree_max(root) -size_subtree_max(root)) <=1;
    }
    public void balance_helper(Node current, Node parent){
        if (current == null)
            return;
        balance_helper(current.right, current);
        balance_helper(current.left, current);

        if (complete(current))
            return;
        if (size_subtree_max((current.left))<size_subtree_max(current.right)){
            if (parent != null){
                if (parent.right.value == current.value)
                    parent.right = current.right;
                else
                    parent.left = current.right;
            }
            Node tmp = current.right.left;
            current.right.left = current;
            current.right = tmp;
        }
        if (size_subtree_max((current.left))>size_subtree_max(current.right)){
            if (parent != null){
                if (parent.right.value == current.value)
                    parent.right = current.left;
                else
                    parent.left = current.left;
            }
            Node tmp = current.left.right;
            current.left.right = current;
            current.left = tmp;
        }
        balance_helper(current, parent);
    }
    public int smallestCommonAncestor(int i, int j){
        Node current = root;

        if (((search(i)==-1)) || ((search(j)==-1)))
            return -1;
        while (current != null){
            int val = current.value;
            if (i<val && j<val)
                current = current.left;
            else if (i>val && j>val)
                current = current.right;
            else
                break;
        }
        if (current == null)
            return -1;
        return current.value;
    }
    public static void extractKeys(Node current, Set<Integer> set){
        if (current == null){
            return;
        }
        extractKeys((current.left), set);
        set.add(current.value);
        extractKeys(current.right, set);
    }
    public int[] findSum(int N){
        int[] ret ={-1, -1};
        Node current = root;

        while (N<current.value){
            current = current.left;
            if (current == null)
                return ret;
        }
        Set<Integer> set = new TreeSet<>();
        extractKeys(current.right, set);
        Iterator<Integer> it = set.iterator();

        while(!set.isEmpty()){
            int value = it.next();
            int target = N-value;
            if (search(target) != -1) {
                ret[0] = value;
                ret[1] = target;
                break;
            }
        }
        return ret;
    }
    public static void convertToBST(Node current, Iterator<Integer> it){
        if (current == null){
            return;
        }
        convertToBST(current.left, it);
        current.value = it.next();
        convertToBST(current.right, it);
    }
    public static void convertToBST(Node root){
        Set<Integer> set = new TreeSet<>();
        extractKeys(root, set);

        Iterator<Integer> it = set.iterator();
        convertToBST(root, it);
    }

}