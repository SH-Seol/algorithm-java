package bj.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int top = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                top = Integer.parseInt(st.nextToken());
                queue.add(top);
            }
            else if(command.equals("front")){
                int num = queue.isEmpty() ? -1 : queue.peek();
                sb.append(num).append("\n");
            }
            else if(command.equals("back")){
                int num = queue.isEmpty() ? -1 : top;
                sb.append(num).append("\n");
            }
            else if(command.equals("size")){
                sb.append(queue.size()).append("\n");
            }
            else if(command.equals("empty")){
                int num = queue.isEmpty() ? 1 : 0;
                sb.append(num).append("\n");
            }
            else if(command.equals("pop")){
                int num = queue.isEmpty() ? -1 : queue.poll();
                sb.append(num).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
