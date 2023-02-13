public class DoublyLinkedList<E> {
    //---------------- nested Node class---------------
    private static class Node<E> { 
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e; 
            prev=p; 
            next = n;
        }
        public E getElement() { return element; } 
        public Node<E> getPrev() {return prev;} 
        public Node<E> getNext() { return next; } 
        public void setPrev(Node<E>p) {prev=p;} 
        public void setNext(Node<E> n) { next = n; } 
    }
    
    private Node <E> header; 
    private Node <E> trailer;
    private int size;
    
    public DoublyLinkedList(){ 
        header=new Node<>(null, null, null); 
        trailer=new Node<>(null, header, null); 
        header.setNext(trailer);
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    private void addBetween(E e ,Node <E> predecessor , Node <E> successor){
        Node <E> newest = new Node <> (e, predecessor, successor); 
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    
    /**
     * @param node
     * @return
     */
    private E remove(Node<E>node){
        Node<E> predecessor= node.getPrev(); 
        Node<E> successor= node.getNext();
        predecessor.setNext(successor); 
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    
    public void addFirst (E e){
        addBetween(e,header,header.getNext()); //place just after the header
    }
    
    public void addLast(E e){
        addBetween(e,trailer.getPrev(),trailer); //place just before the trailer
    }
    
    public E removeFirst(){ 
        if(isEmpty())
            return null; //nothing to remove
        return remove (header.getNext()); //first element is beyond header
    }
    
    public E removeLast(){ 
        if(isEmpty())
            return null; //nothing to remove
        return remove(trailer.getPrev()); //last element is before trailer
    }
    
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(3);
        list.addLast(4);
        
        System.out.println("List size: " + list.size);
        System.out.println("First element: " + list.removeFirst());
        System.out.println("Last element: " + list.removeLast());
        
        System.out.println("List size: " + list.size);
    }
    
}
