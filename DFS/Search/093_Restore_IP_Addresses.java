/**
 * Name: Restore IP Address
 * Number: 93
 * Main Point:
   Figure Out 3 points:
   (1) what should we do at this level?
   (2) what is the relationship between this level and next level? (what value to convey?)
   (3) what is the condition of return?
   Ans: 
   (1) extract valid substring (0-255)
   (2) where should the extraction start? (start point)
   (3) the number of ips == 4 && startIdx reach the end of the string. (So we should keep track of the number of ips that have already been put into res)
   Note that when we encounter numbers like250325...., we should deal with it by comparing it to 10^n, for example, 02 should be compared to 10^1, if 02 < 10^1, then 02 is invalid.
 * Time Comlexity:
 * Space Complexity:
**/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<Integer> tempIP = new LinkedList<>();
        DFSHelper(0, s, tempIP, res);
        return res;
    }
    private void DFSHelper(int startIdx, String s, List<Integer> tempIP, List res) {    
        if (tempIP.size() == 4 && startIdx == s.length()) {
            //transform linkedlist to string 
            StringBuilder sb = new StringBuilder();
            for (int i : tempIP) {
                sb.append(Integer.toString(i)).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        if (tempIP.size() >= 4) {
            return;
        }
        for (int i = startIdx; i < startIdx + 3 && i < s.length(); i++) {
            String stringOfIP = s.substring(startIdx, i + 1);
            if (stringOfIP.charAt(0) == '0' && stringOfIP.length() > 1) break;
            int partOfIP = Integer.parseInt(stringOfIP);
            if (partOfIP >= 0 && partOfIP <= 255) {
                tempIP.add(partOfIP);
                DFSHelper(i + 1, s, tempIP, res);
                tempIP.remove(tempIP.size() - 1);
            }    
        }
    } 
}