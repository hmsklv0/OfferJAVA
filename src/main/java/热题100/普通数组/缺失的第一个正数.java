package 热题100.普通数组;

import java.util.Arrays;

public class 缺失的第一个正数 {
    public static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 8, 9, 11, 12};
        int[] nums1 = new int[]{1,2,0};
        int[] nums2 = new int[]{3,4,-1,1};
        int[] nums3 = new int[]{1,1};

        // System.out.println(firstMissingPositive(nums));
        // System.out.println(firstMissingPositive(nums1));
        System.out.println(firstMissingPositive(nums3));
    }

    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (nums[i] > 0 && nums[i] < length && nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) {
                // nums[nums[i] - 1] = nums[i];
                swap(nums, i, nums[i] - 1);
            } else {
                i = i + 1;
            }
            System.out.println(Arrays.toString(nums));
        }

        for (int j = 0; j < length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return length + 1;
    }
}
