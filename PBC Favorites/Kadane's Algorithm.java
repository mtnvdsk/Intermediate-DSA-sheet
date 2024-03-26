class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        
      long max=Long.MIN_VALUE;
      long sum=0;
      for(int i=0;i<=arr.length-1;i++)
      {
          sum=sum+arr[i];
          if(sum>max)
          {
              max=sum;
          }
          if(sum<0)
          {
              sum=0;
          }
          
      }
      return max;
        
    }
    
}