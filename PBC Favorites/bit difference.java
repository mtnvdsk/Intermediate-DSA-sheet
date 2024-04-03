class Solution{
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        int ans=0;
        for(int i=0;i<32;i++){
            int m1=a&(1<<i);
            int m2=b&(1<<i);
            if(m1!=m2){
                ans++;
            }
        }
        return ans;
    }
}