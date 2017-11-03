/**
 * Name: Multiply Strings
 * Number: 43
 * Tag: tricky
 * Main Points: num1[i] * num2[j] will be placed at indices [i + j, i + j + 1]
   every sum is an adder, i + j + 1 pos is for last level's carry-in.
   i + j pos should be carry out, passing to future calculation.
 * Time Complexity: O(len1 * len2)
 * Space Complexity: O(len1 + len2)
**/
class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2.length() == 0 || num2 == null || num2.length() == 0) return "";
        int len1 = num1.length(), len2 = num2.length();
        int[] pos = new int[len1 + len2];
        
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + pos[i + j + 1];
                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}