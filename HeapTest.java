package IFT2015;

public class HeapTest {
    public static void main(String[] args) {
        heap h = new heap();
        h.Heap(100);
        int[] arr = {5, 3, 8, 2, 6};

        // Test add and remove_min methods
        for (int i = 0; i < arr.length; i++) {
            h.add(arr[i], i);
        }
        System.out.println("length: "+h.length());
        while (h.length() > 0) {
            heap.Item min = h.remove_min();
        }
                // Test alter_heap and alter_heap_key methods
        h.add(5, 0);
        h.add(3, 1);
        h.add(8, 2);
        h.add(2, 3);
        h.add(6, 4);
        h.alter_heap(3, 9);
        h.alter_heap_key(2, 1);
        while (h.length() > 0) {
            heap.Item min = h.remove_min();
            if (min != null) {
                System.out.println(min.key + ", " + min.value);
            }
        }
        
        // Test heapify and buildHeap methods
        heap h2 = new heap();
        h2.Heap(100);

        h2.buildHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            heap.Item min = h2.remove_min();
            if (min != null) {
                System.out.println(min.key + ", " + min.value);
            }
        }
    }
}
