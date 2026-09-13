class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int left = 0;
        int right = 0;
        while(left<g.length && right<s.length){
            if(g[left]<=s[right]){
                count++;
                left++;
            }
            right++;
            
        }
        return count;    
    }   
}