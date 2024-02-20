// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class LinkedList {
    static class Node { // Change to static

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head; // Add head declaration

    public void print(Node head) { // Remove static
        if (head == null) return;
        print(head.next);
        System.out.println(head.data + " ");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
        list.print(list.head); // Call print using list.head
    }
}
