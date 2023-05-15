public class LinkedList {
    private Node head;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public void print() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int getMiddle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public void skipMDeleteN(int m, int n) {
        Node current = head;

        // Skip M nodes
        for (int i = 1; i < m && current != null; i++) {
            current = current.next;
        }

        // Delete N nodes
        while (current != null && current.next != null) {
            Node next = current;
            for (int i = 0; i < n && next != null; i++) {
                next = next.next;
            }
            if (next != null) {
                current.next = next.next;
            } else {
                current.next = null;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println("Original List:");
        list.print();

        System.out.println("List after skipping 2 nodes and deleting 3 nodes:");
        list.skipMDeleteN(2, 3);
        list.print();
    }
}
