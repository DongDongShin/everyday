package programmers.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {


    public static void main(String[] args) {

        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        solution(cacheSize, cities);

    }

    public static int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        if(cacheSize==0)
            return cities.length*5;
        int hit = 1;
        int miss = 5;
        int answer = 0;
        for (String temp : cities) {
            String key = temp.toLowerCase();
            if(q.contains(key)){//cache hit
                q.remove(key);
                answer= answer+hit;
                q.add(key);
            }
            else {//cache miss
                if(q.isEmpty()){
                    q.add(key);
                    answer+=miss;
                }
                else{
                    answer+=miss;
                    q.add(key);
                }
            }
            if (q.size() == cacheSize+1) {
                q.poll();
            }
        }

        System.out.println("answer = " + answer);
        return answer;
    }


}
