import java.util.LinkedList;

public class Quick_sort {
    public static LinkedList<Integer> quick_sort(LinkedList<Integer> list){
        int n = list.size();

        if (n<2) return list;

        int pivot = list.getFirst();

        LinkedList<Integer> list_lower = new LinkedList<>();
        LinkedList<Integer> list_equal = new LinkedList<>();
        LinkedList<Integer> list_greater = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int value = list.removeFirst();
            if (value < pivot)
                list_lower.add(value);
            else if (value == pivot)
                list_equal.add(value);
            else
                list_greater.add(value);
        }

        list_lower = quick_sort(list_lower);
        list_greater = quick_sort(list_greater);

        LinkedList<Integer> result = new LinkedList<>();
        result.addAll(list_lower);
        result.addAll(list_equal);
        result.addAll(list_greater);

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

        LinkedList<Integer> sortedList = Quick_sort.quick_sort(list);

        System.out.println("Sorted list: " + sortedList);
    }

}
