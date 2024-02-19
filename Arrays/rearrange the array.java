class Solution {
    void rearrangeArray(int[] arr, int n) {
        Arrays.sort(arr);
        int[] ans = new int[arr.length];
        int low = 0, high = arr.length-1;
        int j = 0;
        while(low <=high) {
            ans[j++] = arr[low];
            if(j<n) {
                ans[j++] = arr[high];
            }
            low++;
            high--;
        }
        for(int i = 0; i<n; i++){
            arr[i] = ans[i];
        }
    }
}