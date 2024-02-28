class Solution {
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if(S==null)return true;
        else if(isEqual(T,S))return true;
        else if(T==null)return false;
        else {
        return isSubtree(T.left, S) || isSubtree(T.right, S);
        }
        //return false;
    }
    public static boolean isEqual(Node T, Node S){
        
        if(T==null && S==null)return true;
        else if(T==null || S==null)return false;
        else if(T.data!=S.data)
            return false;
        else{
            boolean left=isEqual(T.left,S.left);
            boolean right=isEqual(T.right,S.right);
            if(left==true && right==true)
                    return true;
        }
        return false;
    }