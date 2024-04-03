class Solution
{
    //Function to check if the number is sparse or not.
    public static boolean isSparse(int n)
    {
        String bit=Integer.toBinaryString(n);
        for(int i=0;i<bit.length()-1;i++){
            if(bit.charAt(i)=='1' && bit.charAt(i+1)=='1')return false;
        }
        return true;
    }
    
}