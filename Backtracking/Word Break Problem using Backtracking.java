class Solution{
    static void PrintAll(List<String> l,String str,String ans,List<String> dict){
        if(str.length() == 0){
            l.add(ans.trim());
            return;
        }
        for(int i = 0; i <= str.length() - 1; i++){
            String left = str.substring(0,i+1);
            if(dict.contains(left)){
                String right = str.substring(i+1);
                PrintAll(l,right,ans+left+" ",dict);
            }
        }
    }
    static List<String> wordBreak(int n, List<String> dict, String s){
        // code here
       List<String> ans = new ArrayList<>();
       PrintAll(ans,s,"",dict);
       return ans;
    }
}