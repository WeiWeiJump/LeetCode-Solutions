/**
 * Name: Compare Version Numbers
 * Number: 165
 * Tag: String
 * Main Point: compare levels: assumes that next level is zero if no mo levels in shorter version number
 * Time Complexity: O(max(version1.length, version2.length))
 * Space Complexity: O(version1.length + version2.length)
**/
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int len = Math.max(ver1.length, ver2.length);
        int res = 0;
        for (int i = 0; i < len; i++) {          
            Integer p1 = i < ver1.length ? Integer.parseInt(ver1[i]) : 0;
            Integer p2 = i < ver2.length ? Integer.parseInt(ver2[i]) : 0;
            res = p1.compareTo(p2);
            if (res != 0) {
                return res;    
            }  
        }
        return res;
    }
}