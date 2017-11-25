/**
 * Name: Trapping Rain Water
 * Number: 42
 * Tag: tricky
 * Main Points: 
   The idea is: I calculated the stored water at each index a and b in my code. 
   At the start of every loop, I update the current maximum height from left side (that is from A[0,1...a]) 
   and the maximum height from right side(from A[b,b+1...n-1]). if(leftmax<rightmax) then, 
   at least (leftmax-A[a]) water can definitely be stored no matter what happens between [a,b] 
   since we know there is a barrier at the rightside(rightmax>leftmax). 
   On the other side, we cannot store more water than (leftmax-A[a]) at index a 
   since the barrier at left is of height leftmax. 
   So, we know the water that can be stored at index a is exactly (leftmax-A[a]). 
   The same logic applies to the case when (leftmax>rightmax). 
   At each loop we can make a and b one step closer. 
 * Time Complexity: O(n)
 * Space Complexity:  O(1)
**/
class Solution {
    public int trap(int[] height) {
        int rain = 0;
        int leftMax = 0, rightMax = 0;
        int ptrA = 0, ptrB = height.length - 1;
        while (ptrA <= ptrB) {
            leftMax = Math.max(leftMax, height[ptrA]);
            rightMax = Math.max(rightMax, height[ptrB]);
            if (leftMax < rightMax) {
                rain += leftMax - height[ptrA];
                ptrA++;
            } else {
                rain += rightMax - height[ptrB];
                ptrB--;
            }
        }
        return rain;
    }
}