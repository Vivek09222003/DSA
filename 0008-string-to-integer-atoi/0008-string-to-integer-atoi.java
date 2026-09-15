class Solution {
    public int myAtoi(String s) {
        String str="";
        char cc;
        long in = 0;
        for(int x = 0; x<s.length(); x++){
            cc = s.charAt(x);
            if(cc==32 && str.length()==0)
                continue;
            if(str.length()==0 && (cc==45 || cc==43))
            {
                str = str + cc;
            }
            else if(cc>=48 && cc<=57){
                str = str + cc;
            }
            else{
                break;
            }
        }
        if(str.equals("") || str.equals("+") || str.equals("-")){
            return 0;
        }
        boolean negative = false;
        int start = 0;

        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            start = 1;

            if(str.charAt(0) == '-')
                negative = true;
        }

        for(int i = start; i < str.length(); i++){

            int digit = str.charAt(i) - '0';

            if(in > Integer.MAX_VALUE / 10 ||
               (in == Integer.MAX_VALUE / 10 && digit > 7)) {

                if(negative)
                    return Integer.MIN_VALUE;

                return Integer.MAX_VALUE;
            }

            in = in * 10 + digit;
        }

        if(negative)
            in = -in;

        return (int)in;
    }
}