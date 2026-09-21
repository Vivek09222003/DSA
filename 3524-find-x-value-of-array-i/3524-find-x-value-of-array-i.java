class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] dp = new long[k];
        long[] result = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];
            int rem = num % k;
            newDp[rem]++;
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRem = (int)(((long) r * num) % k);
                    newDp[newRem] += dp[r];
                }
            }

            dp = newDp;
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}