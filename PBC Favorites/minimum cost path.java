class Solution{
    class pair{
        int r,c; //vertex in form of (a,b) cartesian point
        int weight;
        pair(int r,int c,int weight){
            this.r=r;
            this.c=c;
            this.weight=weight;
        }
    }
    
    public int minimumCostPath(int[][] grid){
        int r=grid.length,c=grid[0].length;
        PriorityQueue<pair> pq=new PriorityQueue<pair>((a,b)->a.weight-b.weight);
        int[][] dist=new int[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        pq.add(new pair(0,0,grid[0][0]));
        dist[0][0]=grid[0][0];
        
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};
        
        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int r1=curr.r,c1=curr.c,w=curr.weight;
            
            for(int i=0;i<4;i++){
                int x=r1+dx[i];
                int y=c1+dy[i];
                if(x>=0 && y>=0 && x<r && y<c){
                    if(dist[x][y]>dist[r1][c1]+grid[x][y]){
                        dist[x][y]=dist[r1][c1]+grid[x][y];
                        pq.add(new pair(x,y,dist[x][y]));
                    }
                }
            }
        }
        
        return dist[r-1][c-1];
        
    }
}