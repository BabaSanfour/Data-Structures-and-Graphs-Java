import java.util.LinkedList;

public class Merge_Sort_Fusion {
    public static LinkedList<Integer> mergeSort(LinkedList<Integer> list) {
        int n = list.size();

        if (n < 2) {
            return list;
        }

        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        for (int i = 0; i < n / 2; i++) {
            left.add(list.removeFirst());
        }

        while (!list.isEmpty()) {
            right.add(list.removeFirst());
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
        LinkedList<Integer> result = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.peek() <= right.peek()) {
                result.add(left.removeFirst());
            } else {
                result.add(right.removeFirst());
            }
        }

        while (!left.isEmpty()) {
            result.add(left.removeFirst());
        }

        while (!right.isEmpty()) {
            result.add(right.removeFirst());
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(8);
        list.add(4);
        list.add(2);
        list.add(6);
        list.add(5);

        System.out.println("Original list: " + list);

        LinkedList<Integer> sortedList = mergeSort(list);

        System.out.println("Sorted list: " + sortedList);
    }
}
