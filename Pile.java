class Pile {
    private int[] stack;
    private int size;
    
    public Pile() {
      stack = new int[100];
      size = 0;
    }
    
    public void push(int elem) {
      if (size < 100) {
        stack[size++] = elem;
      }
      else {
        System.out.println("Stack is full");
      }
    }
    
    public int top() {
      if (size > 0) {
        return stack[size - 1];
      }
      return -1;
    }
    
    public int pop() {
      if (size > 0) {
        return stack[--size];
      }
      return -1;
    }
    
    public int length() {
      return size;
    }
    public static void main(String[] args) {
        Pile pile = new Pile();
        
        System.out.println("Length: " + pile.length());
        System.out.println("Pop: " + pile.pop());
        
        pile.push(5);
        pile.push(9);
        pile.push(8);
        
        System.out.println("Length: " + pile.length());
        
        System.out.println("Pop: " + pile.pop());
        System.out.println("Pop: " + pile.pop());
        
        pile.push(4);
        
        System.out.println("List: ");
        for (int i = 0; i < pile.length(); i++) {
          System.out.println(pile.stack[i]);
        }
      }
      
  }