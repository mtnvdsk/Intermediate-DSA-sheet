  
import java.io.*;
static void printNthFromLast(Node head, int N)
{
    int i = 0;
 
    if (head == null)
        return;
    printNthFromLast(head.next, N);
 
    if (++i == N)
        System.out.print(head.data);
}