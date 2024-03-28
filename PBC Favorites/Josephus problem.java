class Solution
{
   public int josephus(int n, int k)
    {
        //Your code here
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        while(q.size() != 1){
            int x = k;
            while(x > 1){
                q.add(q.remove());
                x--;
            }
            q.remove();
        }
        return q.peek();
    }

}