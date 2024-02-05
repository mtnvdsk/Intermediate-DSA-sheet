class Solution {
    static int maxSum(int arr[], int n)
    {
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++)
    {
        int curr_sum = 0;
        for (int j = 0; j < n; j++)
        {
            int index = (i + j) % n;
            curr_sum += j * arr[index];
        }
        res = Math.max(res, curr_sum);
    }
     
    return res;
    }
}

//solution2

class GFG {
     
    static int maxSum(int arr[], int n)
    {
        int cum_sum = 0;
        for (int i = 0; i < n; i++)
            cum_sum += arr[i];
        int curr_val = 0;
        for (int i = 0; i < n; i++)
            curr_val += i * arr[i];
        int res = curr_val;
        for (int i = 1; i < n; i++)
        {
            int next_val = curr_val - (cum_sum -
                          arr[i-1]) + arr[i-1] *
                          (n-1);
            curr_val = next_val;
            res = Math.max(res, next_val);
        }
        return res;
    }
}