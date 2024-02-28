class pair{
    int height;
    int diameter;
     pair(int height, int diameter){
         this.height=height;
         this.diameter=diameter;
     }
    
}
 class Solution {
    // Function to return the diameter of a Binary Tree.
    
    
    int diameter(Node root) {
        // Your code here
        pair p=helper(root);
        
        return p.diameter;
    }
    
    public static pair helper(Node root){
        if(root== null){
            int height=0;
            int diameter=0;
            pair ans= new pair(height,diameter);
            return ans;
        }
        pair lo= helper(root.left);
        
        pair ro= helper(root.right);
        
        int height= 1+ Math.max(lo.height,ro.height);
        
        int op1= 1+ lo.height+ ro.height;
        
        int op2= lo.diameter;
        
        int op3= ro.diameter;
        
        int diameter= Math.max(op1,Math.max(op2,op3));
        
        pair ans= new pair(height,diameter);
        return ans;
    }
}