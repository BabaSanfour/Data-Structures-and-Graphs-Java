public class SinglyLinkedList<E> {
    //---------------- nested Node class---------------
    private static class Node<E> {
        private E element; // reference to the element stored at this node 
        private Node<E> next; // reference to the subsequent node in the list 
        public Node(E e, Node<E> n) {
            element = e; 
            next = n;
        }
        public E getElement() { return element; } 
        public Node<E> getNext() { return next; } 
        public void setNext(Node<E> n) { next = n; }
    }
    private Node <E> head = null; //head node of the list(or null if empty)
    private Node <E> tail = null; //last node of the list(or null if empty)
    private int size=0;           //number of nodes in the list 
    public SinglyLinkedList(){}   //constructs an initially empty list
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.element);
            result.append(", ");
            current = current.next;
        }
        return result.toString();
    }
    
    public void addFirst(E e){
        head = new Node <> (e , head); //create and link a new node 
        if(size==0)
            tail=head; //special case : new node becomes tail also 
        size++;
    }
    public void addLast(E e){ //adds element e to the end of the list
        Node <E> newest =new Node<> (e,null); //node will eventually be the tail 
        if(isEmpty())
            head=newest; //special case: previously empty list
        else
            tail.setNext(newest); //new node after existing tail
        tail=newest; //new node becomes the tail
        size++;
        }
    public E removeFirst(){ //removes and returns the first element 
        if(isEmpty())
            return null; //nothing to remove 
        E answer=head.getElement();
        head=head.getNext();  //will become null if list had only one node
        size--;
        if(size==0)
            tail=null;  //special case as list is now empty
        return answer;
    }
    public void removeLast(Node<E> node) {
        if (node.next == null) {
            node = null;
        } else {
            removeLast(node.next);
            node.next = null;
        }
    }
    
    public static SinglyLinkedList reverse(SinglyLinkedList listToReverse) {
        SinglyLinkedList reversedList = new SinglyLinkedList();
        while(listToReverse.head != null) {
            reversedList.addFirst(listToReverse.head.getElement());
            listToReverse.head = listToReverse.head.next;
        }
        return reversedList;
    }
    public void removeDuplicates() {
        // current node points to the head element
        Node current = head, 
        index = null, 
        temp = null;
        if(head == null) { 
            return;
        } else {
            while(current != null) {
                // temp node points to the previous node 
                temp = current;
                // index node points to node next to current 
                index = current.next;
                while (index != null) {
                // checking if node of current data is 
                // equal to index node data
                    if (current.element == index.element) {
                        // duplicate node is skipped
                        temp.next = index.next; }
                    else {
                    // temp node points to the previous 
                    // node of index node
                        temp = index;
                        }
                        index = index.next;
                }
                current = current.next; }
            } 
    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        
        System.out.println("Is linked list empty? " + linkedList.isEmpty());
        
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        
        System.out.println("Linked list after adding elements: ");
        System.out.println(linkedList.toString());
        
        linkedList.removeFirst();
        
        System.out.println("Linked list after removing first and last elements: ");
        System.out.println(linkedList.toString());
        
        linkedList.removeDuplicates();
        
        System.out.println("Linked list after removing duplicates: ");
        System.out.println(linkedList.toString());
        
        SinglyLinkedList<Integer> reversedList = SinglyLinkedList.reverse(linkedList);
        
        System.out.println("Reversed linked list: ");
        System.out.println(reversedList.toString());
        }
}
      
    
