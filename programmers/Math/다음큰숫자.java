package programmers.Math;

public class 다음큰숫자 {
    public static void main(String[] args) {
            solution(15);
    }


    public static int solution(int n) {
        int cnt_digit = cnt_digit(n);

        System.out.println(cnt_digit);
        int answer = n+1;
        while(true){
            if(cnt_digit==cnt_digit(answer)){
                break;
            }
            answer++;
        }
        System.out.println(answer);
        return answer;
    }

    public static int cnt_digit(int n) {
        StringBuilder sb = new StringBuilder();
        int cnt_one = 0;
        while(n>=1){
            sb.append(n%2);
            if(n%2==1)
                cnt_one++;
            n= n/2;
        }
        return cnt_one;
    }



}
