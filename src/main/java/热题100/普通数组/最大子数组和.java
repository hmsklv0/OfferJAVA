package 热题100.普通数组;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        // 一个简单的思想，如果 前缀 + 当前值 小于 当前值本身，那么重新开始记录子数组和
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        // 动态规划思想
        // 1 dp 记录以 i 结尾的最大连续子数组和
        int[] dp = new int[nums.length];

        // 2 递推公式
        // int i;
        // dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);

        // 3 初始化
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] < 0 ? nums[i] : nums[i] + dp[i - 1];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        ;
    }
}
