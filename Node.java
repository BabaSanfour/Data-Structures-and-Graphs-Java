public class Node {
    private int value;
    private Node next = null;

    public Node(int value){
        this.value = value;
    }

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public void addValue(int value){
        if (this.next == null) // check if we are at the end of the list
            { // if yes the current node is the last       
            // create a new node and make it the last
            Node newN = new Node(value); 
            this.next = newN;
            }
        else
        { // else, apply the recursive call to the next node
            this.next.addValue(value);   
        }
    }
    public void addNode(Node next){
        if (this.next == null) // check if we are at the end of the list
            { // if yes the current node is the last       
            // create a new node and make it the last
            this.next = next;
            }
        else
        { // else, apply the recursive call to the next node
            this.next.addNode(next);   
        }
    }
    public void removeLast() {
        // first condition: out list is already empty
        if (this.next == null) 
        {
            return;
        }
        // if we reach the 2nd laast element
        else if (this.next.next == null)
        { // set the next to null: remove the last
            // and make the 2nd last as the final element
            this.next = null;
        } else 
        {
            // otherwise keep iterating through the list by applying the function to the next elemt
            this.next.removeLast();
        }
    }


    public void removeValue(int value){
        // first the current node ==value
        if (this.value == value) 
        { // this will point at the next node
            // check if the we are in the last node or no
            if (this.next == null){ // if yes we just use remove last to remove this node
                removeLast();
            }
            else
            {// if no, change current node to next
            this.value = this.next.value;
            this.next = this.next.next;
            }
        }
        else if (this.next == null)
        {// we reached last element with nothing more to do
            return;
        }
        else
        {
            // otherwise keep iterating through the list by applying the function to the next elemt
            this.next.removeValue(value);
        }
    }
    

    public int length_iteratif(){
        int length =0; // length counter
        Node curr=this; // Node pointing at this 
        while (curr!=null){
            length++; // length+1
            curr = curr.next; // move to next node
        }
        return length;
    }

    public int length_recurssion(){
        if (this == null) 
        {
            return 0;
        }
        else
        {
            return 1 + this.length_recurssion();
        }
    }

    public int returnNlast(int nLast){
        // get length of the list
        int length = length_iteratif();
        // get the number of element we want to skip until we reach Nlast
        int nSkip = length - nLast;
        // skip length-Nlast element
        Node curr = this;
        while (nSkip != 0)
            {
                nSkip--;
                curr = curr.next;
            }
        // return nLast
        int n = this.value;
        return n;
    }

    public void addValue_ordered(int value){
        // if we are at the end of the list we add the value in the end
        if (this.next == null )
        {
            this.addValue(value);
        }
        // else we find that the next value is superior to our value, we insert value between current and next
        else if (this.next.value> value)
        {
            Node newN = new Node(value, this.next); 
            this.next = newN;
        }
        // else we keep going
        else
        {
            this.next.addValue_ordered(value);
        }
    }

    public void insertSort(){
        // length to loop over it
        int length_loop1 = length_iteratif();
        // create a curr node and save the current node in it
        Node curr = this;
        while (length_loop1!=0) 
        {
            // add curr node value in its place using addValue_ordered
            this.addValue_ordered(curr.value);
            //move to the next node
            curr = curr.next;
            // increment
            length_loop1--;
        }
        
    }
    public static void main(String[] args) {
        Node node1 = new Node(10);
        node1.addValue(20);
        node1.addValue(30);
        node1.addValue(40);
        node1.addValue(50);
        System.out.println("Length (iterative): " + node1.length_iteratif());
        System.out.println("Length (recursive): " + node1.length_recurssion());
        System.out.println("3rd last value: " + node1.returnNlast(3));
        node1.removeValue(30);
        System.out.println("After removing value 30: ");
        System.out.println("Length (iterative): " + node1.length_iteratif());
        System.out.println("Length (recursive): " + node1.length_recurssion());
        node1.removeLast();
        System.out.println("After removing last: ");
        System.out.println("Length (iterative): " + node1.length_iteratif());
        System.out.println("Length (recursive): " + node1.length_recurssion());
        node1.addValue_ordered(35);
        System.out.println("After adding 35 (ordered): ");
        System.out.println("Length (iterative): " + node1.length_iteratif());
        System.out.println("Length (recursive): " + node1.length_recurssion());
        node1.insertSort();
        System.out.println("After sorting: ");
        System.out.println("Length (iterative): " + node1.length_iteratif());
        System.out.println("Length (recursive): " + node1.length_recurssion());
    }
    
}
