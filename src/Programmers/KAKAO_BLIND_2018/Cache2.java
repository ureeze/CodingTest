package Programmers.KAKAO_BLIND_2018;

import java.util.LinkedList;

public class Cache2 {
    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.remove(city)) {
                //hit
                cache.addLast(city);
                answer += CACHE_HIT;
            } else {
                //miss
                if (cache.size() == cacheSize) {
                    cache.pollFirst();
                }
                cache.addLast(city);
                answer += CACHE_MISS;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Cache2 c = new Cache2();
        System.out.println(c.solution(3,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(c.solution(3,
                new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(c.solution(2,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(c.solution(5,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(c.solution(2,
                new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(c.solution(0,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}
