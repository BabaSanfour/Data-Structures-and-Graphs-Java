import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Bucket_Sort {
    static void bucketSort(float arr[], int n){
        if (n<= 0)
            return;
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];

        for (int i = 0; i < n; i++){
            buckets[i] = new Vector<Float>();
        } 

        for (int i=0; i < n; i++){
            float idx = arr[i] * n;
            buckets[(int)idx].add(arr[i]);
        }

        for (int i = 0; i<n; i++){
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < buckets[i].size(); j++){
                arr[index++] = buckets[i].get(j);
            }
        }
    }
    public static void main(String[] args) {
        float[] arr = {0.5f, 0.2f, 0.7f, 0.1f, 0.9f, 0.3f};
        int n = arr.length;

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        Bucket_Sort.bucketSort(arr, n);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));

}
}
