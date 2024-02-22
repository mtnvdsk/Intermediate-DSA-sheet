
/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol {
    public static Node findUnion(Node head1, Node head2) {
        Node temp = head1;
        Node temp2 = head2;
        HashSet<Integer> set = new HashSet<>();

        while (temp != null) {
            set.add(temp.data);
            temp = temp.next;
        }

        while (temp2 != null) {
            set.add(temp2.data);
            temp2 = temp2.next;
        }

        java.util.List<Integer> sortedList = new java.util.ArrayList<>(set);
        Collections.sort(sortedList);
        Node ans = new Node(0); 
        Node p = ans;
        for (int i : sortedList) {
            p.next = new Node(i);
            p = p.next;
        }

        return ans.next;
    }
}

//solution2
class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedListUnion {

	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}
	public static void printLinkedList(Node head) {
	Node temp = head;
	while (temp != null) {
		System.out.print(temp.data + "-->");
		temp = temp.next;
	}
	System.out.print("None");
}

	static Node getUnion(Node ll1, Node ll2) {
		Node tail = null;
		Node head = null;
		while (ll1 != null || ll2 != null) {
			if (ll1 == null) {
				if (tail == null) {
					tail = new Node(ll2.data);
					head = tail;
				} else {
					tail.next = new Node(ll2.data);
					tail = tail.next;
				}
				ll2 = ll2.next;
			} else if (ll2 == null) {
				if (tail == null) {
					tail = new Node(ll1.data);
					head = tail;
				} else {
					tail.next = new Node(ll1.data);
					tail = tail.next;
				}
				ll1 = ll1.next;
			} else {
				if (ll1.data < ll2.data) {
					if (tail == null) {
						tail = new Node(ll1.data);
						head = tail;
					} else {
						tail.next = new Node(ll1.data);
						tail = tail.next;
					}
					ll1 = ll1.next;
				} else if (ll1.data > ll2.data) {
					if (tail == null) {
						tail = new Node(ll2.data);
						head = tail;
					} else {
						tail.next = new Node(ll2.data);
						tail = tail.next;
					}
					ll2 = ll2.next;
				} else {
					if (tail == null) {
						tail = new Node(ll1.data);
						head = tail;
					} else {
						tail.next = new Node(ll1.data);
						tail = tail.next;
					}
					ll1 = ll1.next;
					ll2 = ll2.next;
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Node head1 = new Node(10);
		head1.next = new Node(20);
		head1.next.next = new Node(30);
		head1.next.next.next = new Node(40);
		head1.next.next.next.next = new Node(50);
		head1.next.next.next.next.next = new Node(60);
		head1.next.next.next.next.next.next = new Node(70);

		// create second linked list
		Node head2 = new Node(10);
		head2.next = new Node(30);
		head2.next.next = new Node(50);
		head2.next.next.next = new Node(80);
		head2.next.next.next.next = new Node(90);

		Node head = getUnion(head1, head2);
		printLinkedList(head);
		System.out.println();
	}
}
