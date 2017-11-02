/**
 * I V X L C D M
**/
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch(c) {
                case 'I': res += (res >= 5 ? -1 : 1);
                          break;
                case 'V': res += 5;
                          break;
                case 'X': res += 10 * (res >= 50 ? -1 : 1);
                          break;
                case 'L': res += 50;
                          break;
                case 'C': res += 100 * (res >= 500 ? -1 : 1);
                          break;
                case 'D': res += 500;
                          break;
                case 'M': res += 1000;
                          break;
            }
        }
        return res;
    }
}