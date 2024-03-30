class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here
        Arrays.sort(A1);
        
        int[] res = new int[N];
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int x : A1){
            hm.put(x, hm.getOrDefault(x, 0)+1);
        }
        int index = 0;
        for(int i = 0;i<M;i++){
            int num = A2[i];
            if(hm.containsKey(num)){
                Arrays.fill(res, index, index + hm.get(num), num);
                //System.out.println(Arrays.toString(res));
                index = index + hm.get(num);
                hm.put(num, 0);
            }
        }
        for(int i = 0;i<N;i++){
            if(hm.get(A1[i])!=0){
                res[index] = A1[i];
                index++;
            }
        }
        return res;
    }
}