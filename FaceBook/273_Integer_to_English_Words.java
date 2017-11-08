/**
 * Name: Integer to English Words
 * Number: 273
 * Tag: DFS
 * Main Points: 
   1. num < 20 ---> 单独输出
   2. 20 < num < 100 ---> 单独输出 
   3. 1 hundred < num < 1 thousand ---> compare with 100
   4. 1 thoudsand < num < 1 million ---> compare with 1000
   5. 1 million < num < 1 billion ---> compare with 1000,000
   6. num > 1 billion ---> compare with 1000,000,000
   if we can print out 123, then we can recursively call it to print larger number
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
class Solution {
    String[] lessThan20Words = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
                                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
                                "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tyWords = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] dexWords = {"Billion", "Million", "Thousand", "Hundred"};
    int[] radix = {1000000000, 1000000, 1000, 100};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < radix.length; i++) {
            count = num / radix[i];
            if (count == 0) continue;
            sb.append(numberToWords(count) + " ");
            sb.append(dexWords[i] + " ");
            num = num % radix[i];
        }
        if (num < 20) {
            sb.append(lessThan20Words[num]);
        } else {
            sb.append(tyWords[num / 10 - 2] + " ");
            sb.append(lessThan20Words[num % 10]);
        }
        return sb.toString().trim();
        
    }
}