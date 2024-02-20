class Solution
{
    int getMiddle(Node head)
    {
        if(head==null) return 0;
         Node slow=head;
         Node fast=head;
         while(fast!=null && fast.next!=null){
             slow=slow.next;
             fast=fast.next.next;
         }
         return slow.data;
    }
}
