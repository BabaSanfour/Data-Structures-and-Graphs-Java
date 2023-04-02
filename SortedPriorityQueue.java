public class SortedPriorityQueue {


    public class Node{
        int key, value;
        Node next = null;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node queue = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);

    public boolean is_empty(){
        return queue == null;
    }
    public void add_sorted(int key, int value){
        Node newest = new Node(key, value);
        Node current = queue;
        Node parent = null;
        while (newest.key>=current.key){
            parent = current;
            current = current.next;

            if (current == null)
                break;
        }

        if (parent == null){
            newest.next = queue;
            queue = newest;
            return;
        }
        parent.next = newest;
        newest.next = current;
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

    public Node remove_min_sorted(){
        if (is_empty()){
            System.out.println("Empty");
            return null;
        }
        Node tmp = queue;
        queue = queue.next;
        return tmp;
    }

    //sort using priority queue
    public int[] pq_sort(int[] list){

        SortedPriorityQueue pq = new SortedPriorityQueue();

        for (int i : list)
            pq.add_sorted(i, i);
        for (int i=0; i<list.length; i++)
            list[i] = pq.remove_min_sorted().value;
        return list;
    }
    public static void main(String[] args) {
        SortedPriorityQueue pq = new SortedPriorityQueue();

        // Test is_empty()
        System.out.println(pq.is_empty());  // false
        
        // Test add()
        pq.add_sorted(3, 30);
        pq.add_sorted(2, 20);
        pq.add_sorted(1, 10);
        System.out.println(pq.len());  // 4
    
        // Test find_min()
        System.out.println(pq.find_min().value);  // 10
    
        // Test remove_min()
        System.out.println(pq.remove_min_sorted().value);  // 10
        System.out.println(pq.len());  // 3
        System.out.println(pq.remove_min_sorted().value);  // 20
        System.out.println(pq.remove_min_sorted().value);  // 30
        System.out.println(pq.remove_min_sorted().value);  // +00
        System.out.println(pq.is_empty());  // true

        // Test pq_sort()
        int[] list = {5, 3, 8, 1, 2};
        int[] sorted = pq.pq_sort(list);
        for (int i : sorted) {
            System.out.print(i + " ");  // 1 2 3 5 8
        }
    }
    
}
