package IFT2015;

public class heap {
    public class Item{
        int key, value;
        Item(int k, int v){
            key = k;
            value = v;
        }
    }

    Item[] elements;
    int MAX_SIZE;
    int count;

    void Heap(int size){
        MAX_SIZE = size;
        elements = new Item[size];
    }

    public int length(){
        return count;
    }

    public int parent(int j){
        return(j-1)/2;
    }

    public int left(int j){
        return 2*j+1;
    }
    public int right(int j){
        return 2*j+2;
    }
    public void swap(int i, int j){
        Item tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }
    // make sure heap properity is maintained: 
    // if an element violates it is exchanged with its parent untill the property is restored
    public void upheap(int j){
        if (j<-0) return;

        int parent = this.parent(j);
        if (elements[j].key < elements[parent].key){
            swap(j, parent);
            upheap(parent);
        }
    }

    public void downheap(int j){
        int left = left(j);
        int right = right(j);
        int smallest;
        if (left<count){
            if (right<count){
                smallest = elements[left].key<elements[right].key ? left :right;
            } else {
                smallest = left;
            }
        } else if (right<count){
            smallest = right;
        } else {
            return;
        }
        if (elements[j].key>elements[smallest].key){
            swap(j, smallest);
            downheap(smallest);
        }
    }
    public void add(int key, int value){
        if(count >= MAX_SIZE)
            return;

        elements[count]= new Item(key, value);
        upheap(count);
        count++;
    }
    public Item min(){
        if (count==0){
            System.out.println("Empty Heap!!");
            return null;
        }
        return elements[0];
    }
    // remove the min element of a min-heap
    public Item remove_min(){
        if (count==0){
            System.out.println("Empty Heap!!");
            return null;
        }
        swap(0, count-1);
        Item tmp = elements[count-1];
        elements[count-1] = null;
        count--;
        downheap(0);
        return tmp;
    }


    // a list to a max-heap
    public void heapify(int[] list, int i){
        int n = list.length;

        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if (left<n){
            if (list[largest]<list[left]){
                largest = left;
            }
        }
        if (right<n){
            if (list[largest]<list[right]){
                largest = right;
            }
        }

        if (largest != i){
            int swap = list[i];
            list[i] = list[largest];
            list[largest] = swap;
            heapify(list, largest);
        }


    }

    public void buildHeap(int arr[]){
        int N =arr.length;
        int startIdx = (N/2)-1; //last non-leaf

        for (int i = startIdx; i>= 0; i--){
            heapify(arr, i);
        }
    }

    public void alter_heap(int i, int v){
        if (count==0){
            System.out.println("Empty Heap!!");
            return;
        }
        if (i>count-1){
            System.out.println("Not in heap!!");
            return;
        }
        elements[i].value = v;
    }
    public void alter_heap_key(int i, int k){
        if(count==0){
            System.out.println("Empty Heap!!");
            return;
        }
        if (i>count-1){
            System.out.println("Not in heap!!");
            return;
        }
        int old_key = elements[i].key;
        elements[i].key = k;
        if(k<old_key){
            upheap(i);
        }
        else{
            downheap(i);
        }
    }


}
