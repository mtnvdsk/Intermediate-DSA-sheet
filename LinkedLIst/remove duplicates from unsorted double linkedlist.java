// Java implementation to remove duplicates 
// from an unsorted doubly linked list
import java.util.*;

public class GFG 
{

// a node of the doubly linked list
static class Node
{
	int data;
	Node next;
	Node prev;
};

// Function to delete a node in a Doubly Linked List.
// head_ref --> pointer to head node pointer.
// del --> pointer to node to be deleted.
static Node deleteNode(Node head_ref, Node del)
{
	// base case
	if (head_ref == null || del == null)
		return null;

	// If node to be deleted is head node
	if (head_ref == del)
		head_ref = del.next;

	// Change next only if node to be deleted 
	// is NOT the last node
	if (del.next != null)
		del.next.prev = del.prev;

	// Change prev only if node to be deleted 
	// is NOT the first node
	if (del.prev != null)
		del.prev.next = del.next;

	return head_ref;
}

// function to remove duplicates from
// an unsorted doubly linked list
static Node removeDuplicates(Node head_ref)
{
	// if doubly linked list is empty
	if ((head_ref) == null)
		return null;

	// unordered_set 'us' implemented as hash table
	HashSet<Integer> us = new HashSet<>();

	Node current = head_ref, next;

	// traverse up to the end of the list
	while (current != null)
	{

		// if current data is seen before
		if (us.contains(current.data)) 
		{

			// store pointer to the node next to 
			// 'current' node
			next = current.next;

			// delete the node pointed to by 'current'
			head_ref = deleteNode(head_ref, current);

			// update 'current'
			current = next;
		}
		else
		{

			// insert the current data in 'us'
			us.add(current.data);

			// move to the next node
			current = current.next;
		}
	}
	return head_ref;
}

// Function to insert a node at the 
// beginning of the Doubly Linked List
static Node push(Node head_ref, 
				int new_data)
{
	// allocate node
	Node new_node = new Node();

	// put in the data
	new_node.data = new_data;

	// since we are adding at the beginning,
	// prev is always null
	new_node.prev = null;

	// link the old list of the new node
	new_node.next = (head_ref);

	// change prev of head node to new node
	if ((head_ref) != null)
		(head_ref).prev = new_node;

	// move the head to point to the new node
	(head_ref) = new_node;
	return head_ref;
}

// Function to print nodes in a given doubly 
// linked list
static void printList(Node head)
{
	// if list is empty
	if (head == null)
		System.out.print("Doubly Linked list empty");

	while (head != null)
	{
		System.out.print(head.data + " ");
		head = head.next;
	}
}

// Driver Code
public static void main(String[] args) 
{
	Node head = null;

	// Create the doubly linked list:
	// 8<->4<->4<->6<->4<->8<->4<->10<->12<->12
	head = push(head, 12);
	head = push(head, 12);
	head = push(head, 10);
	head = push(head, 4);
	head = push(head, 8);
	head = push(head, 4);
	head = push(head, 6);
	head = push(head, 4);
	head = push(head, 4);
	head = push(head, 8);

	System.out.println("Original Doubly linked list:");
	printList(head);

	/* remove duplicate nodes */
	head = removeDuplicates(head);

	System.out.println("\nDoubly linked list after " + 
							"removing duplicates:");
	printList(head);
}
}
