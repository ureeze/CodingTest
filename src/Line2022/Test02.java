package Line2022;

import java.util.StringTokenizer;

public class Test02 {
    public String solution(int k, String[] dic, String chat) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(chat);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.contains(".")) {
                //점 포함

            } else {
                //점 미포함
                for (int i = 0; i < dic.length; i++) {
                    if (s.equals(dic[i])) {
                        //비속어

                    }else{
                        //비속어 아님
                    }
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.solution(2, new String[]{"slang", "badword"}, "badword ab.cd bad.ord .word sl.. bad.word"));
    }
}
