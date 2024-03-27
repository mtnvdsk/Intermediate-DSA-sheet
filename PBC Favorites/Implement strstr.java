class GfG {
    // Function to locate the occurrence of the string x in the string s.
    boolean rec(String s, String x, int i, int j) {
        if (j == x.length()) {
            return true;
        }
        if (i >= s.length()) {
            return false;
        }
        if (s.charAt(i) != x.charAt(j)) {
            return false;
        }
        return rec(s, x, i + 1, j + 1);

    }

    int strstr(String s, String x) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x.charAt(0)) {
                if (rec(s, x, i, 0)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
