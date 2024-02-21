/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution{
    //Function to rotate a linked list.
  public Node rotate(Node head, int k) {
        ArrayList<Integer>arrayList = new ArrayList<>();
        Node a = head;
        while(a!=null)
        {
            arrayList.add(a.data);
            a = a.next;
        }
        for(int i=0; i<k; i++)
        {
            int t = arrayList.remove(0);
            arrayList.add(arrayList.size(),t);
        }
        Node b = head;
        while(b!=null)
        {
            b.data = arrayList.remove(0);
            b = b.next;
        }
        return head;
    }
}