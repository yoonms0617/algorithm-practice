class Solution {
    
    private boolean isUppercase(char c) {
        return c >= 65 && c <= 90;
    }

    private boolean isLowercase(char c) {
        return c >= 97 && c <= 122;
    }

    private boolean isSpace(char c) {
        return c == 32;
    }
    
    public String solution(String s) {
        char[] chars = s.toCharArray();
        if (isLowercase(chars[0])) {
            chars[0] = (char) (chars[0] - 32);
        }
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (isSpace(chars[i - 1])) {
                if (isLowercase(c)) {
                    chars[i] = (char) (c - 32);
                }
            } else {
                if (isUppercase(c)) {
                    chars[i] = (char) (c + 32);
                }
            }
        }
        return String.valueOf(chars);
    }
    
}
