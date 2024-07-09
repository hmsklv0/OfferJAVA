package 热题100.普通数组;

// https://leetcode.cn/problems/product-of-array-except-self/solutions/272369/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/?envType=study-plan-v2&envId=top-100-liked
// 官方题解思路
public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];

        int[] res = new int[length];
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[length - 1] = 1;
        for (int i = length - 1; i > 0; i--) {
            R[i - 1] = nums[i] * R[i];
        }

        for (int i = 0; i < length; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;

        int[] res = new int[length];
        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R = nums[i] * R;
        }

        return res;
    }
}
