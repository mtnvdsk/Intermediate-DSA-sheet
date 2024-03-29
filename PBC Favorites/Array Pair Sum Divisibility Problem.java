class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        if(nums.length%2==1) return false;
        int arr[]= new int[k];
        for(int i=0; i<nums.length; i++){
            arr[nums[i]%k]++;
        }
        int i=1;
        int j=k-1;
        if(arr[0]%2==1) // count is odd
        return false;
        while(i<=j){
            if(arr[i]!=arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}