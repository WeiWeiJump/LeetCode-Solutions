/**
 * Name: Read N Characters Given Read4 II - Call multiple times
 * Number: 158
 * Tag: API implement
 * Main Points: 
   use a buffer(of length 4) to store read4's output
   use buffCnt to count where are we at read4's output -> buff[4]
   set a bufferPtr and ptr to indicate which char in the buffer we are transering to which index in buf
   when buffer Ptr reach 4, reset it to 0
   when buffer count < 4, we've done
 * Time Complexity: O(n)
 * Space Complexity: O(1)
**/
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int buff4Cnt;
    private int buff4Ptr;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buff4Ptr == 0) {
                buff4Cnt = read4(buff);
            }
            while (ptr < n && buff4Ptr < buff4Cnt) {
                buf[ptr++] = buff[buff4Ptr++];
            }
            if (buff4Ptr == buff4Cnt) {
                buff4Ptr = 0;
            }
            if (buff4Cnt < 4) break;
        }
        return ptr;
    }
}