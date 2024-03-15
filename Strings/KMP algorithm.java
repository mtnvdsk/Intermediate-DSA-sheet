class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        int pie[]=lps(pat);
        
        int first=0, second=0;
        int n=txt.length();
        int m=pat.length();
        
        while(first<n){
            
            if(txt.charAt(first)==pat.charAt(second)){
                first++;
                second++;
                 
                
                if(second==m){
                    ans.add(first-second+1);
                    first=(first-second+1);
                     second=0;
                }
            }else{
                if(second==0){
                    first++;
                }else{
        
                    second=pie[second-1];
                }
            }
        
        }
        return ans;
        
    }
    int[] lps(String s) {
        // code here
        
        int pie[]=new int [s.length()];
        
        int pre=0,suf=1;
        
        while(suf<s.length()){
            if(s.charAt(pre)==s.charAt(suf)){
                pie[suf]=pre+1;
                pre++;
                suf++;
            }else{
                if(pre==0){
                    pie[suf]=0;
                    suf++;
                }else{
                    pre=pie[pre-1];
                }
            }
        }
        
        return pie;
        
    }

}