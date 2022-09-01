package programmers.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐같게하기 {

    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};


        solution(queue1,queue2);

    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int cnt=0;
        int midcnt=0;
        for(int temp:queue1){
            q1.add(temp);
            midcnt+=temp;
        }
        for(int temp:queue2){
            q2.add(temp);
            midcnt+=temp;
        }
        midcnt = midcnt/2;
        if(midcnt%2==1){//둘의 합이 2로 나누어지지 않으면 -1을 리턴
            return -1;
        }

        return answer;
    }


    public static  Long sum(Queue<Integer> q){
        Long answer= 0L;
        for(Integer temp:q){
            answer+= temp.longValue();
        }

        return answer;
    }
}
