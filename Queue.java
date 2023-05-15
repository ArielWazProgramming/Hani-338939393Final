public class Queue {
    private int[] data;
    private int front;
    private int rear;

    public Queue(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void enqueue(int value) {
        if (rear == data.length - 1) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            data[rear] = value;
        }
    }

    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int value = data[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            return value;
        }
    }

    public int peek() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return data[front];
        }
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == data.length - 1;
    }

    public void print() {
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.print();

        System.out.println("Dequeue: " + queue.dequeue());

        queue.print();

        System.out.println("Peek: " + queue.peek());
    }
}
