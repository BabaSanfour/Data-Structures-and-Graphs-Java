public class Bubble_Sort {
    public static class Node {
        int value;
        Node next;
        
        public Node(int value) {
            this.value = value;
        }
    }
    public static Node bubble_sort(Node list){
        Node head = list;
        boolean flipped = false;
    
        while (!flipped){
            flipped = true;
            Node current = head;
            Node prev = null;
    
            while (current != null && current.next != null){
                if (current.value > current.next.value){
                    flipped = false;
                    if (prev == null){
                        head = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    Node next = current.next;
                    current.next = next.next;
                    next.next = current;
                    prev = next;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        }
        return head;
    }
        public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(7);
        Node n3 = new Node(1);
        Node n4 = new Node(8);
        Node n5 = new Node(4);
        Node n6 = new Node(2);
        Node n7 = new Node(6);
        Node n8 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        System.out.println("Original list:");
        printList(n1);

        Node sortedList = Bubble_Sort.bubble_sort(n1);
        System.out.println("Sorted list:");
        printList(sortedList);
        }

}
