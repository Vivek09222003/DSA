class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int start =0, end = 0;
        int right = s.length()-1;
        int l1=0, r1=0;
        boolean check = false;
        while(left<s.length()){
            if(left>=right){
                left++;
                right = s.length()-1;
            }
                l1=left;
                r1=right;
                while(l1<=r1){
                    if(s.charAt(l1)==s.charAt(r1)){
                        l1++;
                        r1--;
                    }
                    else{
                        break;
                    }
                    if(l1>r1){
                        if (right - left > end - start) {
                            start = left;
                            end = right;
                        }
                    }
                }
            right--;
        }
        return s.substring(start, end + 1);
    }
}