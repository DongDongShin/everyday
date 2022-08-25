package programmers.문자열;

import java.util.Stack;

public class 괄호회전하기 {

    public static void main(String[] args) {
        System.out.println(solution("[)(]"));

    }

    public static int solution(String s) {
        int answer = 0;
        if (is_right(s)) {
            answer++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(1, s.length()));
            sb.append(s.charAt(0));
            System.out.println(sb.toString());
            s = sb.toString();
            if (is_right(s)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean is_right(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'))
                return false;//빼박 틀린거임!
            else {
                if ((s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['))
                    stack.push(s.charAt(i));
                else {//그게 아니라면
                    char test = stack.peek();
                    char test2 = s.charAt(i);

                    if (stack.peek() == '[' && s.charAt(i) == ']') {
                        stack.pop();
                    } else if (stack.peek() == '(' && s.charAt(i) == ')') {
                        stack.pop();
                    } else if (stack.peek() == '{' && s.charAt(i) == '}') {
                        stack.pop();
                    } else
                        return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

}
