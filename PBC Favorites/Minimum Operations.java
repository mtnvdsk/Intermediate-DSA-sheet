class Solution
{
    public int minOperation(int n)
    {
        //code here.
         int count=0;
        for(int i=n;i>0;){
            if(i%2==0) {
                count++;
                i /= 2;
        }
             else{
                 count++;
                 i -= 1;  
             }   
        }   
         return count;
    }
}