package programmers.Math;

public class 삼각달팽이 {

    public static int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] arr = new int[n][n];

        int cnt = 1;
        int x = -1;
        int y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //세로는 x++ 가로는 y++ 대각선은 x-- y-- (x,y)
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;

                } else {//대각선으로 갈때..
                    x--;
                    y--;
                }
                arr[x][y] = cnt;
                cnt++;
            }
        }
        System.out.println();
        cnt = 0;
        x = -1;
        y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if(arr[i][j]!=0){
                   answer[cnt]=arr[i][j];
                   cnt++;
               }
            }
        }
        for(int temp:answer)
            System.out.print(temp+" ");
        return answer;
    }

    public static void main(String[] args) {

        solution(4);

    }

}
