package programmers.문자열;

public class 이진변환반복하기 {

    public static void main(String[] args) {
        String s="110010101001";
        solution(s);
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int delete_zero=0;
        int cnt=0;
        while (!s.equals("1")) {
            int idx=0;
            int idx2=0;
            int len = s.length();
            while (idx < len) {
                if(s.charAt(idx2)=='0'){
                    String str =s.substring(0,idx2);
                    String str2 = s.substring(idx2+1,s.length());
                    s = str+str2;
                    delete_zero++;
                }
                else idx2++;
                idx++;
            }
            s = Integer.toBinaryString(s.length());//이거 개꿀이
            cnt++;
        }

        answer[0]=delete_zero;
        answer[1]=cnt;
        return answer;
    }
}
