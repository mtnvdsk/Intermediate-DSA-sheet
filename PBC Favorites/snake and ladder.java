class Qentry{
    int v;
    int dist;
}

class Solution{
    static int minThrow(int n, int arr[]){
        int moves[] = new int[31];
        
        Arrays.fill(moves,-1);
        for(int i=0;i<n;i++){
            moves[arr[2*i]] = arr[(2*i)+1];
        }
        Queue<Qentry> q = new LinkedList<>();
        boolean visited[] = new boolean[31];
        Qentry qe = new Qentry();
        qe.v = 1;
        qe.dist = 0;
        visited[1] = true;
        q.add(qe);
        while(!q.isEmpty()){
            qe = q.poll();
            int v = qe.v;
            if(v == 30){
                break;
            }
            for(int i=v+1;i<=v+6 && i<=30;i++){
                if(!visited[i]){
                    visited[i] = true;
                    Qentry val = new Qentry();
                    val.dist = qe.dist + 1;
                    if(moves[i]!=-1){
                        val.v = moves[i];
                    }else{
                        val.v = i;
                    }
                    q.add(val);
                }
            }
                
            
        }
        return qe.dist;
    }
}