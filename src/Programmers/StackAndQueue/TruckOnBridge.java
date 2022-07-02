package Programmers.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int remainW = weight;
        int nowTime = 0;
        Queue<Truck> wait = new LinkedList<>();
        Queue<Truck> onBridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            wait.offer(new Truck(truck_weights[i], 0));
        }

        while (true) {
            nowTime++;
            if (!onBridge.isEmpty() && onBridge.peek().endTime == nowTime) {
                //트럭나오는시간됨
                Truck exit = onBridge.poll();
                remainW += exit.weight;
            }

            if (onBridge.isEmpty() && wait.isEmpty()) {
                //트럭모두 지나감
                break;
            }

            if (onBridge.size() < bridge_length) {
                //다리 위에 트럭 진입 가능한 공간 존재
                if (!wait.isEmpty() && remainW >= wait.peek().weight) {
                    // 다리 위 하중 양호
                    Truck truck = wait.poll();
                    remainW -= truck.weight;
                    truck.endTime = nowTime + bridge_length;
                    onBridge.offer(truck);
                }
            } else {
                //다리 위에 트럭 진입 가능한 공간 없음
                continue;
            }
        }

        return nowTime;
    }

    public static void main(String[] args) {
        TruckOnBridge t = new TruckOnBridge();
        System.out.println(t.solution(2, 10, new int[]{7, 4, 5, 6}) == 8);
        System.out.println(t.solution(100, 100, new int[]{10}) == 101);
        System.out.println(t.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}) == 110);
    }
}

class Truck {
    int weight;
    int endTime;

    public Truck(int weight, int endTime) {
        this.weight = weight;
        this.endTime = endTime;
    }
}