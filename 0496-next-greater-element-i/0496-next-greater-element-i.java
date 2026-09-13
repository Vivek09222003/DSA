class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length];
        int left = 0;
        int x = 0;
        while(x<nums1.length){
            if(nums1[x]==nums2[left])
            {
                for(int y = left; y<nums2.length ;y++){
                    if(nums2[y]>nums2[left]){
                        arr[x]=nums2[y];
                        break;
                    }
                }
                if(arr[x]==0){
                    arr[x]=-1;
                }
                x++;
                left=0;
            }
            else{
                left++;
            }
            
        }
        return arr;
    }
}