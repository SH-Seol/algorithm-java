package bj.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int num = 0;

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            if (queue.size() == 1) {
                sb.append(queue.poll());
            }
            else{
                queue.poll();
                num = queue.poll();
                queue.add(num);
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
