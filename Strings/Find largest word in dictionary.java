class Solution {
    static String findLongestWord(String S, List<String> d) {
        String w="";
        for(String word:d){
            int i=0;
            int j=0;
            while(i<word.length() && j<S.length()){
                if(word.charAt(i)==S.charAt(j)){
                    i++;
                    j++;
                }
                else{
                    j++;
                }
            }
            if(i==word.length() && word.length()>w.length()){
                w=word;
            }
            else if(i==word.length() && word.length()==w.length()){
                int k=0;
                while(k<word.length() && k<w.length()){
                    if((word.charAt(k)-'a')<(w.charAt(k)-'a')){
                        w=word;
                        break;
                    }
                    else if((word.charAt(k)-'a')>(w.charAt(k)-'a'))
                    break;
                    k++;
                }
            }
        }
        return w;
    }
}