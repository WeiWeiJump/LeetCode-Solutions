/**
 * Name: Add Binary
 * Number: 67
 * Tag: tricky
 * Main Points: iterate through the string, keep two pointers pointing to the same index of two strings
   if one ptr go out of bound, just add what another ptr points to and carry
   update new carry, passing to next position
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ptrA = a.length() - 1, ptrB = b.length() - 1, carry = 0;
        while(ptrA >= 0 || ptrB >= 0) {
            int sum = carry;
            if (ptrA >= 0) {
                sum += a.charAt(ptrA) - '0';
                ptrA--;
            }
            if (ptrB >= 0) {
                sum += b.charAt(ptrB) - '0';
                ptrB--;
            }
            sb.append(sum % 2);
            carry = sum / 2;       
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}