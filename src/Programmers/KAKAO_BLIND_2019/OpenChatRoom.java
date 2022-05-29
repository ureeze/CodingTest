package Programmers.KAKAO_BLIND_2019;

import java.util.*;

public class OpenChatRoom {
    public String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> nickMap = new HashMap<>();
        Queue<String[]> commandQueue = new LinkedList<>();
        StringTokenizer st;
        for (String log : record
        ) {
            st = new StringTokenizer(log);
            String command = st.nextToken();
            String uid = st.nextToken();
            String nickName;
            switch (command) {
                case "Enter":
                    nickName = st.nextToken();
                    nickMap.put(uid, nickName);
                    commandQueue.add(new String[]{uid, command});
                    break;
                case "Leave":
                    commandQueue.add(new String[]{uid, command});
                    break;
                case "Change":
                    nickName = st.nextToken();
                    nickMap.put(uid, nickName);
                    break;
            }
        }
        List<String> answerList = new ArrayList<>();
        for (String[] arr : commandQueue
        ) {
            switch (arr[1]) {
                case "Enter":
                    answerList.add(nickMap.get(arr[0]) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    answerList.add(nickMap.get(arr[0]) + "님이 나갔습니다.");
                    break;
            }
        }
        answer = answerList.toArray(new String[answerList.size()]);
        return answer;
    }

    public static void main(String[] args) {
        OpenChatRoom openChatRoom = new OpenChatRoom();
        String[] answer = openChatRoom.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        System.out.println(Arrays.toString(answer));
    }
}
