import java.util.Stack;

public class prefixToPostfix {
  
  public static boolean isOperand(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  public static boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/');
  }
  
  public static String prefixToPostfix(String pre_exp) {
    Stack<String> s = new Stack<String>(); 
    // length of expression
    int length = pre_exp.length();
    // reading from right to left
    for(int i = length - 1; i >= 0; i--) {
      // check if symbol is operator
      if (isOperator(pre_exp.charAt(i))) {
        // pop two operands from stack
        String op1 = s.peek(); 
        s.pop();
        String op2 = s.peek(); 
        s.pop();
        // concat the operands and operator
        String temp = op1 + op2 + pre_exp.charAt(i);
        // Push String temp back to stack
        s.push(temp); 
      }
      // if symbol is an operand
      else {
        // push the operand to the stack 
        s.push(pre_exp.charAt(i) + "");
      } 
    }
    // stack contains only the Postfix expression
    return s.peek(); 
  }
  
  public static void main(String[] args) {
    String prefix = "*-A/BC-/AKL";
    System.out.println("Prefix Expression: " + prefix); 
    System.out.println("Postfix Expression: " + prefixToPostfix(prefix)); 
  }
}
