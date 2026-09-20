class Solution {
    public int reverseDegree(String s) {
        char cc;
        int sum = 0;
        int cl = 0;
        for(int x = 0; x<s.length(); x++){
            cc = s.charAt(x);
            cl = (cc-97)+1;
            sum += ((27-cl)*(x+1));
        }
        return sum;
    }
}