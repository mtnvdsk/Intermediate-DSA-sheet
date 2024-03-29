class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++)
            if(!vis[i] && dfs(i,-1,vis,adj)) return true;
        return false;
    }
       private boolean dfs(int current,int parent,boolean vis[],ArrayList<ArrayList<Integer>> adj){
        vis[current]=true;
        for(int child : adj.get(current))
            if(!vis[child]){
                if(dfs(child,current,vis,adj)) return true;
            }
            else if(child != parent) return true;
        return false;
    }
}