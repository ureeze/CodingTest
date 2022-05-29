package Programmers.BFSDFS;

public class Network {
    static int[][] computers2;
    static boolean[] visited;
    static int N;

    public int solution(int n, int[][] computers) {
        N = n;
        computers2 = computers;
        visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int n) {
        for (int i = 0; i < N; i++) {
            if (n != i && computers2[n][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Network network = new Network();
        System.out.println(network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}