class StackUsingLinkedlist { 
  
    Node head;
    class Node {
        int data;
        Node next;
        Node (int v) {
            data = v;
            next = null;
        }
    }
  
    public void display() 
    { 
        System.out.println("\n");

        Node temp = head; 
        while (temp != null) { 

            // print node data 
            System.out.printf( temp.data+ " "); 

            // assign temp next to temp 
            temp = temp.next; 
        } 
        
    }

    public void push(int value) {
        Node new_Node = new Node(value);

        //while (list.head != null) 
        new_Node.next = head;
        head = new_Node;
    }

    public int pop() {
        if (head == null) {
            System.out.println("[ERROR --> EMPTY]");
        }
        int top = head.data;
        head = head.next;
        
        return top;
    }

} 



public class LlStack { 
    public static void main(String[] args) 
    { 
        // create Object of Implementing class 
        StackUsingLinkedlist obj = new StackUsingLinkedlist(); 
        // insert Stack value 
        obj.push(10); 
        obj.push(20); 
        obj.push(30); 
        obj.push(40); 
  
        // print Stack elements 
        obj.display(); 
  
        
  
        // Delete top element of Stack 
        obj.pop(); 
        
        // pritn Stack elements 
        obj.display(); 
        
        
        obj.pop(); 
  
        // pritn Stack elements 
        obj.display(); 
  
        
    } 
} 
