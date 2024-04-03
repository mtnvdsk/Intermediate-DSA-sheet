class Solution
{
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
            
        // Your code here        
         for(int i=0;i<32;i++)
           {
               int mask1=m&(1<<i);
               int mask2=n&(1<<i);

               if(mask1!=mask2)
               {
                   return i+1;
               }
           }
        return -1;    
    }
}