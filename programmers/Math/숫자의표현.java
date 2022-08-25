package programmers.Math;

public class 숫자의표현 {

    public static void main(String[] args) {

        int ans = solution(15);
        System.out.println(ans);

    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum=0;
            for (int j = i; j <= n; j++) {
                sum+=j;
                if (sum == n) {
                    answer++;
                    break;
                }
                if (sum > n) {
                    break;
                }

            }
        }
        return answer;
    }
}
