class LinkedList
{
    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
        Node t1=head1;
        Node t2=head2;
        Node ans=new Node(0);
        Node p=ans;
        while(t1!=null && t2!=null){
            if(t1.data>t2.data){
                p.next=new Node(t2.data);
                t2=t2.next;
            }
            else{
                p.next=new Node(t1.data);
                t1=t1.next;
            }
            p=p.next;
        }
        while(t1!=null){
           p.next=new Node(t1.data);
            t1=t1.next;
            p=p.next;
        }
        while(t2!=null){
            p.next=new Node(t2.data);
            t2=t2.next;
            p=p.next;
        }
        return ans.next;
   } 
}