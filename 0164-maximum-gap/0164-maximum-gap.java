class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        int gap = (int)Math.ceil((double)(max - min) / (n - 1));
        int[] bucketMin = new int[n];
        int[] bucketMax = new int[n];
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            int index = (nums[i] - min) / gap;

            if (!used[index]) {
                bucketMin[index] = nums[i];
                bucketMax[index] = nums[i];
                used[index] = true;
            } else {
                bucketMin[index] = Math.min(bucketMin[index], nums[i]);
                bucketMax[index] = Math.max(bucketMax[index], nums[i]);
            }
        }
        int ans = 0;
        int prevMax = min;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                continue;
            }
            ans = Math.max(ans, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        return ans;
    }
}