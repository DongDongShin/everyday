package programmers.BFS;

import javax.management.Query;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 카카오프렌즈컬러링북 {

    public static void main(String[] args) {


        int[][] picture=	{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution(6, 4, picture);

    }
    public static int[] move_x ={0,1,0,-1};
    public static int[] move_y ={-1,0,1,0};
    public static  boolean[][] visit;
    public static  int size=0;

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = -1;
        int maxSizeOfOneArea = -1;
        visit = new boolean[m][n];

        int[]arr = new int[1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {//가로임
                if (picture[i][j] == 0) {
                    continue;
                }
                if(!visit[i][j]){
                   maxSizeOfOneArea=Math.max(maxSizeOfOneArea,Bfs(i, j, picture[i][j], picture));
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = size;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }


    public static int Bfs(int y, int x,int num,int[][] picture) {
        Queue<xys> q = new LinkedList<>();
        size++;
        q.add(new xys(x, y));
        int cnt=1;
        visit[y][x]=true;
        while (!q.isEmpty()) {
            xys temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = temp.x+move_x[i];
                int y2 = temp.y+move_y[i];
                if(x2>=0&&y2>=0&&x2<picture[0].length&&y2<picture.length){
                    if(!visit[y2][x2]&&num==picture[y2][x2]){
                        q.add(new xys(x2,y2));
                        visit[y2][x2]=true;
                        cnt++;

                    }
                }
            }
        }

        return cnt;
    }
    public static class xys{
        int x;
        int y;
        public xys(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
}
