import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        String s = "27776562222333333";
        char x = '2';
        char y = '3';
        HashMap<Character, Integer> temp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x || s.charAt(i) == y)
                temp.put(s.charAt(i), temp.getOrDefault(s.charAt(i), 0) + 1);
        }

        char ans = (temp.getOrDefault(x,0) > temp.getOrDefault(y,0)) ? x : y;
        System.out.print(ans);
    }
}
