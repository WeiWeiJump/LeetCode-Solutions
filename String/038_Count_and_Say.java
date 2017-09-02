/**
 * Name: Count and Say
 * Number: 38
 * Tag: String
 * Outloop: record last say; 
 * Innerloop: select the first char as a key and then count the number of same chars following it.
**/
class Solution {
    public String countAndSay(int n) {
        StringBuilder prev = new StringBuilder("1");
        StringBuilder cur = prev;
        
        for (int i = 1; i < n; i++) {
            cur = new StringBuilder();
            char say = prev.charAt(0);
            int count = 0;
            for (int j = 0, len = prev.length(); j < len; j++) {
                if (say != prev.charAt(j)) {
                    cur.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else {
                    count++;
                }
            }
            cur.append(count).append(say);
            prev = cur;
        }
        return cur.toString();
    }
}