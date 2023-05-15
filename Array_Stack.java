public class Array_Stack {  
  
    class Stack {  
      int top;   
      int maxsize = 10;  
      int[] arr = new int[maxsize];   
      Stack() {
        top = -1; 
      }
      
      public void push(int element) {
        arr[++top] = element;
      }
      
      public int pop() {
        if (top == -1) {
            System.out.println("[ERROR --> EMPTY STACK]");
        }
        return arr[top--];
      }
      
      public void display() {
        if (top == -1) {
            System.out.println("[ERROR --> EMPTY STACK]");
        }
        for (int i = top; i >= 0; i--) {
          System.out.println(arr[i]);
        }
      }
    }
  
    public static void main(String[] args) {  
        Array_Stack as = new Array_Stack();
        Stack s = as.new Stack();    
            
      s.push(1);
      s.push(2);
      s.push(3);
      s.push(4);
                    
      s.pop(); 
      s.pop(); 
        
      s.display(); 
    }  

  
  import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((top == '(' && ch != ')') || (top == '[' && ch != ']') || (top == '{' && ch != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression = "{()}[]";
        if (isBalanced(expression)) {
            System.out.println(expression + " is balanced");
        } else {
            System.out.println(expression + " is not balanced");
        }
    }
}

