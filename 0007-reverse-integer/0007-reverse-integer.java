class Solution {
    public int reverse(int x) {
        int temp = Math.abs(x);
        int count = 0;

        while(temp>0){
            temp = temp/10;
            count++;
        }
        
        temp = Math.abs(x);
        long num = 0;

        while(temp>0){
            num += (temp%10) * (long)Math.pow(10,count-1);
            temp = temp/10;
            count--;
        }

        if(x<0)
            num = num * (-1);

        if(num<Integer.MIN_VALUE || num>Integer.MAX_VALUE)
            return 0;

        return (int)num;
    }
}