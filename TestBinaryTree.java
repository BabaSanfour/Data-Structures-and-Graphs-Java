
public class TestBinaryTree {
    /**
     * @param args
     */
    public static void main(String[] args) {
    BinaryTree bt = new BinaryTree(20);
    bt.add(8);
    bt.add(22);
    bt.add(4);
    bt.add(12);
    bt.add(10);
    bt.add(14);
    
    System.out.println("The size of the binary tree is: " + bt.size_subtree_max(bt.root));

    System.out.println("The biggest element of the binary tree is: " + bt.biggest());

    System.out.println("The height of the element 14 is: " + bt.search(14));

    System.out.println("The sibling of the element 12 is: " + bt.sibling(12));

    System.out.println("The smallest element before the element 14 is: " + bt.smallest_before(14));

    System.out.println("The binary tree is complete: " + bt.complete(bt.root));

    bt.remove(8);
    System.out.println("The size of the binary tree is: " + bt.size_subtree_max(bt.root));

    System.out.println("The biggest element of the binary tree is: " + bt.biggest());

    System.out.println("The height of the element 14 is: " + bt.search(14));

    System.out.println("The sibling of the element 12 is: " + bt.sibling(12));

    System.out.println("The smallest element before the element 14 is: " + bt.smallest_before(14));

    System.out.println("The binary tree is complete: " + bt.complete(bt.root));

    bt.add(30);
    bt.add(18);
    System.out.println("The size of the binary tree is: " + bt.size_subtree_max(bt.root));

    System.out.println("The biggest element of the binary tree is: " + bt.biggest());

    System.out.println("The height of the element 14 is: " + bt.search(14));

    System.out.println("The sibling of the element 12 is: " + bt.sibling(12));

    System.out.println("The smallest element before the element 14 is: " + bt.smallest_before(14));

    System.out.println("The binary tree is complete: " + bt.complete(bt.root));

    BinaryTree bt2 = new BinaryTree(5);
    bt2.add(3);
    bt2.add(7);
    bt2.add(1);
    bt2.add(4);
    bt2.add(6);
    bt2.add(8);
    System.out.println("The binary tree is complete: " + bt2.complete(bt2.root));

    bt2.add(9);
    System.out.println("The binary tree is complete: " + bt2.complete(bt2.root));

    BinaryTree bt3 = new BinaryTree(4);
    bt3.add(2);
    bt3.add(5);
    bt3.add(1);
    bt3.add(3);
    System.out.println("The binary tree is complete: " + bt3.complete(bt3.root));

    bt3.add(6);
    System.out.println("The binary tree is complete: " + bt3.complete(bt3.root));
}}
