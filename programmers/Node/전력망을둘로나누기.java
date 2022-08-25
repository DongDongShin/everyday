package programmers.Node;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을둘로나누기 {


    static boolean[][] link ;

    public static void main(String[] args) {
        int[][] wires = {{1,3},
                {2,3},{3,4},{4,5},{4,6},
        {4,7},{7,8},{7,9}};

        solution(9, wires);


    }

    public static  int solution(int n, int[][] wires) {
        int answer=n;
        link = new boolean[n + 1][n + 1];
        for(int i=0;i<wires.length;i++){
            int idx1 =wires[i][0];//연결된 애의 인덱스
            int idx2 =wires[i][1];
            link[idx1][idx2]=true;
            link[idx2][idx1]=true;
        }


        for(int i=0;i<wires.length;i++){
            int idx1 =wires[i][0];//연결된 애의 인덱스
            int idx2 =wires[i][1];
            link[idx1][idx2]=false;
            link[idx2][idx1]=false;
            answer = Math.min(answer, bfs(n, idx1));
            link[idx1][idx2]=true;
            link[idx2][idx1]=true;
        }


        return answer;
    }

    public static int bfs(int n, int start) {//차이가 가장 작은 얘를 return
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        int cnt=1;
        visit[start]= true;
        q.add(start);
        while (!q.isEmpty()) {
            int index=q.poll();
            for (int i = 1; i <= n; i++) {
                if(link[index][i]&&!visit[i]){//연결이 되었고 방문을 하지 않았음!
                    visit[i]=true;
                    q.add(i);
                    cnt++;
                }
            }
        }

        //cnt는 이제 갈 수 있는 데를 다 간데자나

        return Math.abs(cnt-(n-cnt));

    }
}
