class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();
        int sr = 0;
        int sc = 0;
        int litter = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(classroom[i].charAt(j) == 'S'){
                    sr = i;
                    sc = j;
                }
                if(classroom[i].charAt(j) == 'L'){
                    litter++;
                }
            }
        }
        int[][] id = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                id[i][j] = -1;
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(classroom[i].charAt(j) == 'L'){
                    id[i][j] = count;
                    count++;
                }
            }
        }
        int all = (1 << litter) - 1;
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        q.add(new int[]{sr, sc, energy, 0, 0});
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litter];
        visited[sr][sc][energy][0] = true;
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            int mask = curr[3];
            int moves = curr[4];

            if(mask == all){
                return moves;
            }

            for(int k = 0; k < 4; k++){

                int nr = r + row[k];
                int nc = c + col[k];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n){
                    continue;
                }
                if(classroom[nr].charAt(nc) == 'X'){
                    continue;
                }

                if(e == 0){
                    continue;
                }
                int newEnergy = e - 1;

                if(classroom[nr].charAt(nc) == 'R'){
                    newEnergy = energy;
                }
                int newMask = mask;

                if(classroom[nr].charAt(nc) == 'L'){
                    int litterNumber = id[nr][nc];
                    newMask = mask | (1 << litterNumber);
                }
                if(!visited[nr][nc][newEnergy][newMask]){

                    visited[nr][nc][newEnergy][newMask] = true;

                    int[] next = {
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        moves + 1
                    };

                    q.add(next);
                }
            }
        }
        return -1;
    }
}