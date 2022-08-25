package programmers.Hash;

import java.util.ArrayList;
import java.util.HashMap;

public class 문자열압축 {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        //논리를 생각해보자...배열을 계속 검사주는 거자나 그니깐 계속 검사해주고 수정해줄 필요는 없고
        //그냥 계속 map 값만 생각해주면 죄는 거자노
        for (String temp : record) {
            String[] sarr = temp.split(" ");
            if(!sarr[0].equals("Leave")){
                String key= sarr[1];
                String value = sarr[2];
                map.put(key, value);
            }
        }
        int idx=0;
        StringBuilder sb;
        for (String temp : record) {
            sb = new StringBuilder();
            String[] sarr = temp.split(" ");
            if(sarr[0].equals("Leave")){
                String key= sarr[1];
                sb.append(map.get(key)+"님이 나갔습니다.");
                list.add(sb.toString());
            }
            else if(sarr[0].equals("Enter")){
                String key= sarr[1];
                sb.append(map.get(key)+"님이 들어 왔습니다.");
                list.add(sb.toString());
            }
        }

        String[] strings = list.toArray(new String[list.size()]);
        System.out.println(list);


    }
}
