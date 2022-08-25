package programmers.문자열;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 영어_끝말잇기 {


    public static void main(String[] args) {
        String[] arr = {"qwe", "eqwe", "eqwe"};
        solution(2, arr);

    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];//가장 먼저 탈락하는 사람이랑 그 사람이 자신의 몇번째 차례에 탈락하는지
        boolean done = false;
        Map<String,Integer> map = new HashMap<>();
        int ans=0;
        Double ans2;
        char lastchar=' ';
        int index=0;
        boolean flag = false;
        while(index< words.length){
            if(index==0){
                map.put(words[index],1);//무조건 처음에는 가져가줌
                lastchar = words[index].charAt(words[index].length()-1);
                index++;
                continue;
            }
            if (words[index].charAt(0) != lastchar) {//이러면 끝
                flag=true;
                break;
            }
            if(map.containsKey(words[index])){
                flag=true;

                break;
            }
            map.put(words[index],1);//무조건 처음에는 가져가줌
            lastchar = words[index].charAt(words[index].length()-1);
            index++;
        }

        index++;

        if(!flag){
            answer[0]=0;
            answer[1]=0;
            return answer;
        }
        if(index<=n){
            answer[0]=index;
            answer[1]=1;
            return answer;

        }
        //전체 몇 바퀴 돌았는지 확인이됨
        double cp = index;
        ans = index%n;
        ans2= cp/n;
        if(ans==0){
            ans+=n;
        }
        answer[0]=ans;
        answer[1]=(int)Math.ceil(ans2);

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }

}
