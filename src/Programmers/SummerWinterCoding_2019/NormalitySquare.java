package Programmers.SummerWinterCoding_2019;

public class NormalitySquare {
    public long solution(int w, int h) {
        long answer;
        long gcd = GCD(w, h);
        answer = (long) w * h - (gcd * (w / gcd + h / gcd - 1));

        return answer;
    }

    private int GCD(int a, int b) { // 최대공약수
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        NormalitySquare n = new NormalitySquare();
        System.out.println(n.solution(8, 12));
    }
}
