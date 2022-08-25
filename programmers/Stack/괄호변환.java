package programmers.Stack;

import java.util.Stack;

public class 괄호변환 {


    public static void main(String[] args) {
        System.out.println(solution(")()(()"));
    }

    public static String solution(String p) {
        String answer = "";
        if (p.equals("")) return "";

        if(is_correct(p)) return p;

         else {
            //균형이 맞을때까지 u와 v를 분리해주는 것임 더 이상 분리가 안된다 == 처음으로 균형을 맞췄을때가 거기서 끝내야 하는 것임!1
            StringBuilder u = new StringBuilder();
            StringBuilder v = new StringBuilder();
            int cnt = 0;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '(') cnt++;
                else cnt--;
                if (cnt == 0) {//처음으로 같아 졌을 때
                    u.append(p.substring(0, i+1));
                    v.append(p.substring(i + 1, p.length()));
                    if (is_correct(u.toString())) {
                        return u+solution(v.toString());//v로 다시 시작
                    }
                    else{
                        StringBuilder sb = new StringBuilder();

                        sb.append('(');
                        sb.append(solution(v.toString()));
                        sb.append(')');
                        String str = u.substring(1,u.length());
                        str= str.substring(0,str.length()-1);
                        StringBuilder sb2 = new StringBuilder(str);
                        for (int k = 0; k < str.length(); k++) {
                            if (sb2.charAt(k) == '(') {
                                sb2.setCharAt(k,'(');
                            }
                            else sb2.setCharAt(k,')');
                        }
                        sb.append(sb2);
                        return sb.toString();

                    }

                }
            }


        }
        return answer;
    }


    public static boolean is_correct(String p) {//올바른 문자열이면 true를 리턴을 합니다..
        Stack<Character> stack = new Stack<>();
        for (int i=0; i < p.length(); i++) {
            if (p.charAt(i)=='(') {
                stack.add('(');
            }
            else {
                if(stack.isEmpty())   return  false;
                stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return  false;
    }
}
