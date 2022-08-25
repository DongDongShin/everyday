package programmers.Dfs;

public class 피로도 {


    public static void main(String[] args) {
        int arr[][] = {{40, 20}, {10, 10},{10, 10 },{10, 10},{10, 10}};
        solution(40, arr);

    }

    static boolean[] visit;
    static int[][] cp;
    static int answer = -1;
    public static int solution(int k, int[][] dungeons) {

        visit = new boolean[dungeons.length];
        cp= dungeons;
        for(int i=0;i<dungeons.length;i++){
            if (dungeons[i][0] <= k) {
                visit[i]=true;
                dfs(i,1,k-dungeons[i][1]);
                visit[i]=false;
            }
        }
        System.out.println(answer);
        return answer;
    }


    public static void dfs(int index,int cnt,int current) {
        answer=Math.max(cnt,answer);
        for (int i = 0; i < visit.length; i++) {
            if(!visit[i]&&current>=cp[i][0]){
                visit[i]=true;
                dfs(i,cnt+1,current-cp[i][1]);
                visit[i]=false;
            }
        }

        return;
    }


}
