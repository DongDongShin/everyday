package programmers.Math;

import java.util.ArrayList;

public class n2배열자르기 {


    public static void main(String[] args) {

        solution(4, 7, 14);


    }



    public static int[] solution(int n, long left, long right) {
        int[] answer= new int[(int)(right-left+1)];
        int index=0;
        for (long i = left; i <= right; i++) {
            int temp=Math.max((int)(i/3),(int)(i%3))+1;

            answer[index]=temp;
            index++;

        }

        for (int temp : answer) {
            System.out.println(temp);
        }

        return answer;

    }

}
