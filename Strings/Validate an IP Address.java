class Solution {
    public boolean isValid(String s) {
        String[] parts = s.split("\\.");
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
                if (part.length() > 1 && part.charAt(0) == '0') {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (s.charAt(s.length() - 1) == '.') {
            return false;
        }
        return true;
    }
}