class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean x_check = false;
        boolean y_check = false;

        int x_range_min = Math.max(rec1[0],rec2[0]);
        int x_range_max = Math.min(rec1[2],rec2[2]);
        int y_range_min = Math.max(rec1[1],rec2[1]);
        int y_range_max = Math.min(rec1[3],rec2[3]);

        
        return x_range_min < x_range_max && y_range_min < y_range_max;

    }
}