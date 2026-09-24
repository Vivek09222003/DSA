class Solution {
    public int smallestIndex(int[] nums) {
        int sum=0;
        int temp = 0;
        for(int x = 0; x<nums.length; x++){
            temp = nums[x];
            while(temp>0){
                sum = sum + (temp%10);
                temp = temp/10;
            }
            if(sum==x){
                return x;
            }
            sum=0;
        }
        return -1;
    }
}