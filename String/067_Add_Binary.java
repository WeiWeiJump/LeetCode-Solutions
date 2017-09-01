067_Add_Binary.java
/**
 * Name: Add Binary
 * Number: 67
 * Main Point: Adding from the last digits of two strings, keep tracking carry.
 * Build the StringBuilder from the last digit of the result, and finally reverse it.
 * Time Complexity: O(maxLenthOf(a, b));
 * Space Complexity: O(maxLenthOf(a, b));
**/
class Solution {
    public String addBinary(String a, String b) {
        if ((a == null && b == null) || (a.length() == 0 && b.length() == 0)) return "0";
        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;
        int carry = 0;
        StringBuilder sumStr = new StringBuilder();
        while (pointerA >=0 || pointerB >=0) {
            int sum = carry;
            if (pointerA >= 0) sum += a.charAt(pointerA--) - '0';
            if (pointerB >= 0) sum += b.charAt(pointerB--) - '0';
            sumStr.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sumStr.append(carry);
        return sumStr.reverse().toString();
    }
}