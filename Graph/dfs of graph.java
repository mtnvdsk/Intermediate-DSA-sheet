class Solution {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean  vis[]= new boolean[V];
        ArrayList<Integer> ans= new ArrayList<>();
        
        
        dfs(0,adj,vis,ans);
        
        return ans;
    }
    
    
    public void dfs(int v, ArrayList<ArrayList<Integer>> anj, boolean arr[], ArrayList<Integer> ans){
        arr[v]=true;
        ans.add(v);
        for(Integer nei:anj.get(v)){
            if(!arr[nei]){
                dfs(nei,anj,arr,ans);
            }
        }
        
    }
}