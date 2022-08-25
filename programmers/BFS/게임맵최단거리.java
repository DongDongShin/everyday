package programmers.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

   static boolean visit[][];
   static int[] move_x = {0,1,0,-1};
    static int[] move_y = {-1,0,1,0};
    public static void main(String[] args) {
        int [][]arr={{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(arr));

    }
    public static int solution(int[][] map) {
        visit = new boolean[map.length][map.length];
        Queue<map> q = new LinkedList<>();
        q.add(new map(0,0,1));
        visit[0][0]=true;
        boolean flag= false;
        while(!q.isEmpty()) {
            map temp = q.poll();
            int x;
            int y;
            int cost = temp.cost;
            for (int i = 0; i < 4; i++) {
                x= temp.x+move_x[i];
                y= temp.y+move_y[i];
                if(x>=0&&y>=0&&x<map.length&&y<map.length){
                    if(!visit[x][y]&&map[x][y]==1){
                        q.add(new map(x,y,cost+1));
                        visit[x][y]=true;
                        if(x==map.length-1&&y==map.length-1){
                            return cost+1;
                        }
                    }
                }
            }
        }
        return -1;
    }
    static class map{
        int x;
        int y;
        int cost;

        public map(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
