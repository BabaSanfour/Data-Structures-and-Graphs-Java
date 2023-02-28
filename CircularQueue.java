public class CircularQueue {
    public int[] elements;
    public int start;
    public int end;
    
    public CircularQueue(){
        elements = new int[100];
        start = -1;
        end = -1;
        return;
    }

    public void push(int element){
        // implemented based on slide 44 from demo
        end++;
        if (end % 100 == start) 
        {
            // Queue is full, do not add element
            System.out.println("Circular Queue is Full");
        }
        if (end == 100)
        {
            end = 0;
        }
        if (start == -1)
        {
            start=0;
        }
        elements[end]=element;

    }

    public int pop(){
        // implemented based on slide 45 from demo
        if (start==-1)
        {
            System.out.println("Circular Queue is Empty");
        }
        int element = elements[start];
        if (start==end)
        {
            start=-1;
            end=-1;
        }
        else 
        {
            start++;
            if (start==100)
            {
                start=0;
            }
        }
        return element;
    }

    public int length(){
        if (start==-1)
        {
            return 0;
        }
        return (end - start + 1)%100;
    }

    public void print(){
        int size = length();
        if (size==0) // empty queue
        {
            System.out.println("()");
            return;
        }
        // start clone will itert over the positions in the queue
        int start_clone = start;
        System.out.print("(");
        while (size!=0)
        {
            int element = elements[start_clone];
            System.out.print(element);
            size--;
            if (size>0)
            {
                System.out.print(", ");
                start_clone = (start_clone+1)%100;
            }
        }
        System.out.println(")");
        return;
   
    }
    // I    changed how to call this functions because we have no idea what element to compare
    public boolean search(int element){
        int size = length();
        if (size==0) // empty queue, return false
        {
            return false;
        }
        int start_clone = start;
        // iterate over queue elements
        while (size!=0)
        {
            // if we find the element return true
            if (element==elements[start_clone])
            {
                return true;
            }
            start_clone = (start_clone+1)%100;
            size--;
        }
        return false;
    }

    public void remove(int value){

        int size = length();
        if (size==0) // empty queue, return false
        {
            System.out.println("Empty Queue.");
            return;
        }
        int start_clone = start;
        // iterate over queue elements
        int idx=-1;
        while (size!=0)
        {
            size--;
            // if we find the element return true
            if (value==elements[start_clone])
            {
                while (start_clone!=end)
                {
                    elements[start_clone]=elements[(start_clone+1)%100];
                    start_clone = (start_clone+1)%100;
                }
                if (start==end)
                {
                    start=-1;
                    end=-1;
                }
                else
                {
                    end--;
                }
                return;
        
            }
            start_clone = (start_clone+1)%100;
            size--;

        }
        System.out.println("Value not found in the Queue.");
        return ;
    }        
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        
        System.out.println("Push elements to the queue");
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.print();
        
        System.out.println("Pop an element from the queue");
        int poppedElement = queue.pop();
        System.out.println("Popped element: " + poppedElement);
        queue.print();
        
        System.out.println("Push elements to the queue");
        queue.push(4);
        queue.push(5);
        queue.print();
        
        System.out.println("Check the length of the queue");
        int length = queue.length();
        System.out.println("Length: " + length);
        
        System.out.println("Search for an element in the queue");
        boolean found = queue.search(4);
        System.out.println("Found: " + found);
        
        System.out.println("Remove an element from the queue");
        queue.remove(4);
        queue.print();
    }
    
}
