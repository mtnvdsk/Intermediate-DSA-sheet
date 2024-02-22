/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a=l1;
        ListNode b=l2;
        int c=0;
        ListNode r=null,p=null;
        while(a!=null || b!=null){
            int s=((a!=null)?a.val:0)+((b!=null)?b.val:0)+c;
            c=s/10;
            s=s%10;
            ListNode t=new ListNode(s);
            if(r==null) r=t;
            else p.next=t;
            p=t;
            if(a!=null) a=a.next;
            if(b!=null) b=b.next;
        }
        if(c>0) p.next=new ListNode(c);
        return r;
    }
}