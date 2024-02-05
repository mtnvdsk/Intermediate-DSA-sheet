class Solution {
    public int[] searchRange(int[] nums, int k) {
       int first = -1;
        int last = -1;

        int si = 0;
        int ei = nums.length - 1;

        // To find first position
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == k) {
                first = mid;
                ei = mid - 1;
            } else if (nums[mid] < k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        si = 0;
        ei = nums.length - 1;

        // To find last position
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == k) {
                last = mid;
                si = mid + 1;
            } else if (nums[mid] < k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return new int[]{first,last};
    }
}