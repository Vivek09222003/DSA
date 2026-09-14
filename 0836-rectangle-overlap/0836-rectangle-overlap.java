class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean x_check = false;
        boolean y_check = false;

        
        int x_min = Math.min(rec1[0],rec2[0]); 
        int x_max = Math.max(rec1[2],rec2[2]);
        int y_min = Math.min(rec1[1],rec2[1]);
        int y_max = Math.max(rec1[3],rec2[3]);

        int x_range_min = Math.max(rec1[0],rec2[0]);
        int x_range_max = Math.min(rec1[2],rec2[2]);
        int y_range_min = Math.max(rec1[1],rec2[1]);
        int y_range_max = Math.min(rec1[3],rec2[3]);

        if((x_range_min < x_range_max && x_min > x_max)||(x_range_min > x_range_max && x_min < x_max)){
            return false;
        }
        if((y_range_min < y_range_max && y_min > y_max)||(y_range_min > y_range_max && y_min < y_max)){
            return false;
        }

        if(rec1[0]==rec2[2]||rec2[0]==rec1[2]){
            return false;
        }
        if(rec1[1]==rec2[3]||rec2[1]==rec1[3]){
            return false;
        }

        if(x_range_min>=x_min && x_range_max<=x_max){
            x_check = true;
        }
        if(y_range_min>=y_min && y_range_max<=y_max){
            y_check = true;
        }

        if(x_check && y_check){
            return true;
        }

        return false;

    }
}