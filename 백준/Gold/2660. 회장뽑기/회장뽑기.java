import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static int[] membersScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int member = Integer.parseInt(br.readLine());
        graph = new List[member];
        membersScore = new int[member];
        for (int i = 0; i < member; i++) {
            graph[i] = new ArrayList<>();
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int member1 = Integer.parseInt(st.nextToken());
            int member2 = Integer.parseInt(st.nextToken());

            if (member1 == -1 || member2 == -1) {
                break;
            }

            graph[member1 - 1].add(member2 - 1);
            graph[member2 - 1].add(member1 - 1);
        }

        int answerMin = member;
        for (int i = 0; i < member; i++) {
            boolean[] visited = new boolean[member];
            int[] relationship = new int[member];

            visited[i] = true;
            relationship[i] = 0;

            int bfsMax = bfs(i, visited, relationship);
            answerMin = Math.min(answerMin, bfsMax);
            membersScore[i] = bfsMax;
        }

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < member; i++) {
            if (membersScore[i] == answerMin) {
                answerList.add(i + 1);
            }
        }

        System.out.println(answerMin + " " + answerList.size());
        for (int i = 0; i < answerList.size(); i++) {
            System.out.print(answerList.get(i) + " ");
        }
    }

    static int bfs(int start, boolean[] visited, int[] relationship) {
        Deque<Integer> queue = new ArrayDeque<>();
        int max = 0;

        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 0; i < graph[curr].size(); i++) {
                int friend = graph[curr].get(i);

                if (!visited[friend]) {
                    visited[friend] = true;
                    relationship[friend] = relationship[curr] + 1;
                    queue.add(friend);
                    max = Math.max(max, relationship[friend]);
                }
            }
        }

        return max;
    }
}
