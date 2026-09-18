class Solution {
    public double myPow(double x, int n) {
        double xx = helper(x, Math.abs(n));
        if(n<0)
            return 1/xx;
        return xx;
    }
    public double helper(double x, int n){
        if(n==0){
            return 1.0;
        }
        if(n==1){
            return x;
        }
        double pro = helper(x, n/2);
        if(n%2==0)
            return pro * pro;
        return pro * pro * x;
    }
}