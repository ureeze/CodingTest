package SSG;

import java.util.ArrayList;
import java.util.Collections;

public class TEST1 {

    public int solution(int[] v, int a, int b) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < v.length; i++) {
            list.add(v[i]);
        }

        while (true) {
            if (!check(list, a, b)) {
                break;
            }
//            if (!checkA(list, a)) {
//                break;
//            }
//            if (!checkB(list, b)) {
//                break;
//            }
            list.sort(Collections.reverseOrder());
            for (int i = 0; i < list.size(); i++) {
                int value = list.get(i);
                if (i == 0) {
                    list.set(i, value - a);
                } else {
                    list.set(i, value - b);
                }
            }
            answer++;
        }


        return answer;
    }

    private boolean check(ArrayList<Integer> list, int a, int b) {
        int cntA = 0, cntB = 0;
        for (int num : list) {
            if (num >= a) {
                cntA++;
            }
            if (num < b) {
                cntB++;
            }
        }
        if (cntA == 0) {
            return false;
        }
        if (cntB > 0) {
            return false;
        }
        return true;
    }

//    private boolean checkA(ArrayList<Integer> list, int a) {
//        long cnt = list.stream().filter(integer -> integer >= a).count();
//        return (cnt == 0) ? false : true;
//    }
//
//    private boolean checkB(ArrayList<Integer> list, int b) {
//        long cnt = list.stream().filter(integer -> integer < b).count();
//        return (cnt > 0) ? false : true;
//    }

    public static void main(String[] args) {
        TEST1 t = new TEST1();
        System.out.println(t.solution(new int[]{4, 5, 5}, 2, 1));
        System.out.println(t.solution(new int[]{4, 4, 3}, 2, 1));
    }
}
