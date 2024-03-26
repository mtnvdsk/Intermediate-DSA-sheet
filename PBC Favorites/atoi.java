class Solution
{
    int atoi(String s) {
        int idx = 0;
        if(s.charAt(0) == '-'){
           idx = 1;
        }
        int num = 0;
        for( int i = idx; i<s.length(); i++){
            if(s.charAt(i)-0 >= 48 && s.charAt(i)-0 <= 57 ){
                num = num*10 + (s.charAt(i)-48);
                
            }else{
               num = -1;
                break;
            }
            
            
        }
        
        if( idx == 1 && num != -1){
             return -1*num;
        }
        return num;
        

    }
}