class Clone {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and insert it next to the original node.
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }

        // Step 2: Update the random pointers of the copied nodes.
        temp = head;
        while (temp != null) {
            if (temp.arb != null) {
                temp.next.arb = temp.arb.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the original list and the copied list.
        Node original = head;
        Node copy = head.next;
        Node result = head.next; // Save the head of the copied list.

        while (original != null) {
            original.next = original.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            original = original.next;
            copy = copy.next;
        }

        return result;
    }
}
