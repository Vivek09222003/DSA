class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max_count = 0;
        for(int x = 0; x<s.length(); x++){
            if(s.charAt(x)=='('){
                count = count + 1;
                max_count = Math.max(count, max_count);
            }
            else if(s.charAt(x)==')'){
                count = count - 1;
            }
        }
        return max_count;
    }
}