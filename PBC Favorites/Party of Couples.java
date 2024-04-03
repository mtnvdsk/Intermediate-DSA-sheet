class Solution{
    static int findSingle(int n, int arr[]){
        int x=0;
        for(int i:arr){
            x^=i;
        }
        return x;
    }
}