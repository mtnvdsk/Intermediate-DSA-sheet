import java.util.*;

class HelloWorld {
    public static void rec(List<Character> s, int i, Set<String> temp) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            for (char c : s) {
                sb.append(c);
            }
            temp.add(sb.toString());
            return;
        }
        s.set(i, '0');
        rec(s, i - 1, temp);
        s.set(i, '1');
        rec(s, i - 1, temp);
    }

    public static void main(String[] args) {
        int k = 5;
        List<Character> s = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            s.add('0');
        }
        Set<String> ans = new HashSet<>();
        rec(s, k - 1, ans);
        System.out.println(ans);
        System.out.println(ans.size());
    }
}
