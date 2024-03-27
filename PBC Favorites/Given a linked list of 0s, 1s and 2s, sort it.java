class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        ArrayList<Integer> arr=new ArrayList<>();
     Node temp=head;
     while(temp!=null){
         arr.add(temp.data);
         temp=temp.next;
     }
     Collections.sort(arr);
     temp=head;
     for(int i=0;i<arr.size();i++){
         temp.data=arr.get(i);
         temp=temp.next;
     }
      return head;
    }
}