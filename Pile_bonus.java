
public class Pile_bonus<T> {
    private T[] stack; // declare the stack and the size
    private int size;

    /**
     * @param clazz
     * @param capacity
     */
    public Pile_bonus(Class<T> clazz, int capacity) { // create the pile with a specified capacity
      stack = (T[]) java.lang.reflect.Array.<T>newInstance(clazz, capacity);
      size = 0;
    }

    // push element and return stack if its full
    public void push(T elem) {
      if (size < stack.length) {
        stack[size++] = elem;
      } else {
        System.out.println("Stack is full");
      }
    }

    // get top element and return null if its empty
    public T top() {
      if (size > 0) {
        return stack[size - 1];
      }
      return null;
    }
    public T pop() {
      if (size > 0) {
        return stack[--size];
      }
      return null;
    }

    public int length() {
      return size;
    }
}
