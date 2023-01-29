package n4MedianofTwoSortedArrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(Solution.findMedianSortedArrays(nums1, nums2));
    }
}





class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] resultArray = new int[nums1.length+nums2.length];
        System.arraycopy(nums1, 0, resultArray, 0, nums1.length);
        System.arraycopy(nums2, 0, resultArray, nums1.length, nums2.length);
        Arrays.sort(resultArray);
        System.out.println(Arrays.toString(resultArray));
        if (resultArray.length%2!=0) {
            return resultArray[resultArray.length/2];
        } else {
            return (double) (resultArray[(resultArray.length/2)-1] + resultArray[resultArray.length/2])/2;
        }
    }
}
