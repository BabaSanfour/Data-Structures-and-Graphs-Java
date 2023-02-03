Package Java;
public class DoublePile {
    private int[] stack;
    private int size1;
    private int size2;
    
    /**
     * 
     */
    public DoublePile() {
        stack = new int[100];
        size1 = 0; // we start pile from 0
        size2 = 0; // 
    }
    
    /**
     * @return
     */
    public boolean full() {
        return size1+size2 == 100; // 0->49 for stack1 and 0->49 for stack2 +2
    }
    
    /**
     * @param one
     * @param elem
     * @return
     */
    public boolean push(boolean one, int elem) {
        if (one) { // for stack1
        if (!full()) { // if not full
            stack[size1++] = elem;
            return true;
        }
        } else { // for stack 2
        if (!full()) { // if not full
            size2++;
            stack[100-size2] = elem;
            return true;
        }
        }
        return false;
    }
    
    /**
     * @param one
     * @return
     */
    public int top(boolean one) {
        if (one) { // stack1
        if (size1 > 0) { // if not empty
            return stack[size1-1]; // get top
        }
        } else { // stack 2
        if (size2 > 0) { // if not empty
            return stack[100-size2]; // get top
        }
        }
        return -1;
    }
    
    /**
     * @param one
     * @return
     */
    public int pop(boolean one) {
        if (one) { // stack1
        if (size1 > 0) { // not empty
            return stack[--size1]; // return element + delete it by size = size-1
        }
        } else { // stack2
        if (size2 > 0) { // not empty
            --size2;
            return stack[100-size2]; //
        }
        }
        return -1;
    }
    
    public int length(boolean one) {
        if (one) {
        return size1;
        } else {
        return size2;
        }
    }
    
    public void print() {
        System.out.println("Stack1: ");
        for (int i = 0; i < size1; i++) {
        System.out.println(stack[i]);
        }
        System.out.println("Stack2: ");
        for (int i = 100-1; i > 100-size2-1; i--) {
        System.out.println(stack[i]);
        }
    }
    public static void main(String[] args) {
        DoublePile doublePile = new DoublePile();
    
        // Fill stack 1 with numbers from 1 to 60
        for (int i = 1; i <= 60; i++) {
            doublePile.push(true, i);
        }
    
        // Fill stack 2 with numbers from 161 to 200
        for (int i = 161; i <= 200; i++) {
            doublePile.push(false, i);
        }
    
        // Test the full function
        System.out.println("Is the pile full? " + doublePile.full());
    
        // Test the top function for stack 1
        System.out.println("Top of stack 1: " + doublePile.top(true));
    
        // Test the top function for stack 2
        System.out.println("Top of stack 2: " + doublePile.top(false));
    
        // Test the pop function for stack 1
        System.out.println("Popped from stack 1: " + doublePile.pop(true));
    
        // Test the pop function for stack 2
        System.out.println("Popped from stack 2: " + doublePile.pop(false));
    
        // Test the length function for stack 1
        System.out.println("Length of stack 1: " + doublePile.length(true));
    
        // Test the length function for stack 2
        System.out.println("Length of stack 2: " + doublePile.length(false));
    
        // Test the print function
        System.out.println("Printing the content of both stacks:");
        doublePile.print();
    }
    
}
      
