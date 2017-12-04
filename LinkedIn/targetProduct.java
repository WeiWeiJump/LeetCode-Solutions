package Linkedin;
import java.util.*;
public class targetProduct {
    /**
     * given an array and the target, find the subarray with the product equals to the target number.
     * If yes, return true; else return false;
     */
    public static boolean targetProduct(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int start = 0, end = 0;
        int totalProduct = nums[0]; //product
        while (end < nums.length && start <= end) {
            if (totalProduct == target) {
                return true;
            }
            if (Math.abs(totalProduct) < Math.abs(target)) {
                end++;
                if (end < nums.length) {
                    totalProduct *= nums[end];
                }
            } else {
                totalProduct /=  nums[start];
                start++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 4, -5, 6};
        System.out.println(targetProduct(nums, 12));
        System.out.println(targetProduct(nums, 10));
        System.out.println(targetProduct(nums, -10));
        System.out.println(targetProduct(nums, 20));
        System.out.println(targetProduct(nums, -20));
    }
}
