package PRO2022_2;

public class TEST1 {
    public int solution(int[] grade) {
        int sum = 0;
        for (int i = grade.length - 1; i >= 1; i--) {
            if (grade[i - 1] > grade[i]) {
                sum += (grade[i - 1] - grade[i]);
                grade[i - 1] = grade[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TEST1 t = new TEST1();
        System.out.println(t.solution(new int[]{2, 1, 3})); //1
        System.out.println(t.solution(new int[]{1, 2, 3})); //0
        System.out.println(t.solution(new int[]{3, 2, 3, 6, 4, 5}));//3
        System.out.println(t.solution(new int[]{3, 2, 3, 6, 2, 5}));//6
    }
}

