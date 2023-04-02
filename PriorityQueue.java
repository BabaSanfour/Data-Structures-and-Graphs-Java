public class PriorityQueue {


    public class Node{
        int key, value;
        Node next = null;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        public void add_last(Node i){
            if (next == null)
                next = i;
            else 
                next.add_last(i);
        }
    }

    Node queue = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);

    public boolean is_empty(){
        return queue == null;
    }
    public void add(int key, int value){
        Node n = new Node(key, value);
        queue.add_last(n);
    }

    public int len(){
        int i = 0;
        Node current = queue;
        while (current != null){
            i++;
            current = current.next;
        }
        return i;
    }

    public Node find_min(){
        if (is_empty()){
            System.out.println("Empty");
            return null;
        }
        Node smallest = queue;
        Node current = queue.next;
        while(current != null){
            if (current.key<smallest.key)
                smallest = current;
            current = current.next;
        }
        return smallest;
    }

    public Node remove_min(){
        if (is_empty()){
            System.out.println("Empty");
            return null;
        }
        Node smallest_parent = null;
        Node smallest = queue;

        Node current_parent = queue;
        Node current = queue.next;

        while(current != null){
            if (current.key<smallest.key){
                smallest = current;
                smallest_parent = current_parent;
            }

            current_parent = current;
            current = current.next;
        }

        if (smallest_parent == null){
            queue = smallest.next;
            return smallest;
        }
        smallest_parent.next = smallest.next;
        return smallest;
    }

    //sort using priority queue
    public int[] pq_sort(int[] list){

        PriorityQueue pq = new PriorityQueue();

        for (int i : list)
            pq.add(i, i);
        for (int i=0; i<list.length; i++)
            list[i] = pq.remove_min().value;
        return list;
    }
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        // Test is_empty()
        System.out.println(pq.is_empty());  // false
        
        // Test add()
        pq.add(3, 30);
        pq.add(2, 20);
        pq.add(1, 10);
        System.out.println(pq.len());  // 4
    
        // Test find_min()
        System.out.println(pq.find_min().value);  // 10
    
        // Test remove_min()
        System.out.println(pq.remove_min().value);  // 10
        System.out.println(pq.len());  // 3
        System.out.println(pq.remove_min().value);  // 20
        System.out.println(pq.remove_min().value);  // 30
        System.out.println(pq.remove_min().value);  // +00
        System.out.println(pq.is_empty());  // true

        // Test pq_sort()
        int[] list = {5, 3, 8, 1, 2};
        int[] sorted = pq.pq_sort(list);
        for (int i : sorted) {
            System.out.print(i + " ");  // 1 2 3 5 8
        }
    }
    
}
