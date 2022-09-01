package programmers.Dfs;

import java.util.*;

public class 메뉴리뉴얼 {


    public static void main(String[] args) {

        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};

        solution(orders, course);



    }
    public static HashMap<String,Integer> map;
    public static String[] solution(String[] orders, int[] course) {

        int[]max= new int[course.length];
        ArrayList<String> list = new ArrayList<>();
        map = new LinkedHashMap<>();
        Arrays.sort(orders);
        for (int i = 0; i < orders.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int temp : course) {//temp lenggh만큼 재귀를 해서 그 return 값을 가져가는 거지..!!

                combi(orders[i], sb, 0, 0, temp);
            }
        }
        Iterator<String> it = map.keySet().iterator();
        int idx=0;
        for(int temp:course){
            it = map.keySet().iterator();
            while (it.hasNext()){//얘를 이용해서 뭐 어쩌구 하고 싶은데.....
                String key = it.next();
                if(key.length()==temp){
                    if(max[idx]<map.get(key)){
                        max[idx]=map.get(key);
                    }
                }
            }
            idx++;
        }
        idx=0;
        for(int temp:course){
            it = map.keySet().iterator();
            while (it.hasNext()){//얘를 이용해서 뭐 어쩌구 하고 싶은데.....
                String key = it.next();
                if(max[idx]<=map.get(key)&&key.length()==temp&&2<=map.get(key)){
                    list.add(key);
                }
            }
            idx++;
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        idx=0;
        for (String temp : list) {
            answer[idx]=temp;
            idx++;
        }
        return answer;
    }

    public static void combi(String str,StringBuilder sb,int index,int current,int length){ //dfs를 하는거자너
        if(sb.length()==length){
            char[] key = sb.toString().toCharArray();
            Arrays.sort(key);
            System.out.println(key);
            map.put(String.valueOf(key),map.getOrDefault(String.valueOf(key),0)+1);
            return;
        }
        if(index>=str.length())
            return;
        sb.append(str.charAt(index));
        combi(str,sb,index+1,current+1,length);
        sb.deleteCharAt(current);
        combi(str,sb,index+1,current,length);

    }
}
