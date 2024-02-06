class Solution{
    public static int partition(int arr[], int low, int high) {
        int pivot=arr[high];
        int pivotloc=low;
        for(int i=low;i<=high;i++){
            if(arr[i]<pivot){
                int temp=arr[i];
                arr[i]=arr[pivotloc];
                arr[pivotloc]=temp;
                pivotloc++;
            }
        }
        int temp=arr[pivotloc];
        arr[pivotloc]=arr[high];
        arr[high]=temp;
        return pivotloc;
    }
    public static int quickSort(int arr[], int low, int high,int k) {
        int partition=partition(arr, low, high);
        if(partition==k-1) return arr[partition];
        else if(partition<k-1) return quickSort(arr,partition+1,high,k);
        else return quickSort(arr, low, partition-1,k);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{9,8,7,6,5,4,};
        int k=3;
        int ele=quickSort(arr, 0,arr.length-1, k);
        System.out.println(ele);
    }
}