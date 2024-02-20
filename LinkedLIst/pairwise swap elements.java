public static void pairWiseSwap(Node head)
{
    if (head != null && head.next != null) {
        int temp = head.data;
        head.data = head.next.data;
        head.next.data = temp;
        pairWiseSwap(head.next.next);
    }
}