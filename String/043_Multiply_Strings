/**
 * Name: Multiply Strings
 * Number: 43
 * Tag: String
 * Main Point: Start from right to left, perform multiplication on every pair of digits, and add them together.
 * Time Comlexity: O(num1.length * num2.length)
 * Space Compexity: O(num1.length + num2.length)
**/
class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {            
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];             
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;           
            }
        }
        StringBuilder sb = new StringBuilder();
        //the first digit could be zero and no need to be appended
        for (int digit : pos) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
        
    }
}