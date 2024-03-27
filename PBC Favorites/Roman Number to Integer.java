class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        int result = getValue(str.charAt(str.length() -1));
        for(int i = str.length() -2; i >=0 ; i--){
            
            if(getValue(str.charAt(i)) < getValue(str.charAt(i + 1))){
                 result -= getValue(str.charAt(i));
            }
            else{
                 result += getValue(str.charAt(i));
            }
        }
        return result;
    }
    
    public int getValue(char c){
        switch (c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
}