class Solution {
    public int findPeakElement(int[] nums) {
        int ans=-1;
        int n=nums.length;
        int i=1;
        while(i<n-1){
            if(nums[i]>nums[i+1] && nums[i]>nums[i-1]){
                ans=i;
                break;
            }
            i++;
        }
        if(n==1) return 0;
        if(ans==-1){
            if(nums[0]>nums[1]) return 0;
            else if(nums[n-1]>nums[n-2]) return n-1;
        }
        return ans;
    }
}

//solution2
class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }
        
        int low = 1;
        int high = n - 2;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid+1]) {
                return mid;
            } else if (arr[mid] < arr[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}