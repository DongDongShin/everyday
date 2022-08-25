package programmers.BFS;

import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 프렌즈4블록 {

    public static void main(String[] args) {
        String [] arr =	{"CCBDE", "AAADE", "AAABF", "CCBBF"};
        solution(4,5,arr);


    }

    static char [][]carr;


    public static int solution(int m, int n, String[] board) {
        int answer=0;
        carr = new char[m][n];//(x,y)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                carr[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            boolean[][] visit = new boolean[m][n];
            boolean flag = false;
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(carr[i][j]=='-')
                        continue;
                    char key= carr[i][j];
                    if(carr[i][j+1]==key&&carr[i+1][j]==key&&carr[i+1][j+1]==key){
                        visit[i][j]=true;
                        visit[i][j+1]=true;
                        visit[i+1][j]=true;
                        visit[i+1][j+1]=true;
                        flag=true;
                    }
                }
            }
            if(!flag)
                break;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(visit[i][j])
                    {
                        answer++;
                        carr[i][j]='-';
                    }
                }
            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(carr[i][j]=='-'){
                        
                    }

                }
            }




        }

        return answer;
    }

}
