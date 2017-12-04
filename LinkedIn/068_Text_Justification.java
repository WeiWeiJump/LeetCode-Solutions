/**
 * Main Points: 
   blue print: 
   variable startIndex, endIndex record the index of the start and end word of a line, last keep increasing
   at the same time, count the width of current line
   when we are at last line or only a word in a line, use left justified - a word a space, fill in right part with spaces
   when noe last line, and there are many words in a line, use middle justified
   first calculate the length of appending a word a pace one by one, 
   then calculate intervals between words to see how many spaces should add into the interval
 * Time Complexity: O(n)
 * Space Complexity: O(maxWidth)
**/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int startIndex = 0;
        
        while (startIndex < words.length) {
            int countWidth = words[startIndex].length();
            int lastInLine = startIndex + 1;
            while (lastInLine < words.length) {
                if (countWidth + 1 + words[lastInLine].length() > maxWidth) break;
                countWidth += words[lastInLine].length() + 1;
                lastInLine++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[startIndex]);
            //index = 0, lastInLine = 3, countWidth = 4 + 1 + 2 + 1 + 2 = 10
            int interval = lastInLine - startIndex - 1;
            
            //if last line or only one word in line, left-justified
            if (lastInLine == words.length || interval == 0) {
                for (int i = startIndex + 1; i < lastInLine; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                //fill all right part with spaces
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                //middle justified
                //(16 - 10) / 2 = 3   (15 - 10) 2 :: 3 | 2    8   3 :: 3 3 2
                int spacesOneInterval = (maxWidth - countWidth) / interval;
                int extra = (maxWidth - countWidth) % interval;
                for (int i = startIndex + 1; i < lastInLine; i++) {
                    for (int j = spacesOneInterval; j > 0; j--) {
                        sb.append(" ");
                    }
                    if (extra > 0) {
                        sb.append(" ");
                        extra--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            res.add(sb.toString());
            startIndex = lastInLine;
        }
        return res;
    }
}