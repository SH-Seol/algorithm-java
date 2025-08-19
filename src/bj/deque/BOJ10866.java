package bj.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String command = "";
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if(command.equals("push_back")){
                num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            }
            else if(command.equals("push_front")){
                num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            }
            else if(command.equals("pop_front")){
                num = deque.isEmpty()? -1: deque.pollFirst();
                sb.append(num).append("\n");
            }
            else if(command.equals("pop_back")){
                num = deque.isEmpty()? -1: deque.pollLast();
                sb.append(num).append("\n");
            }
            else if(command.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            else if(command.equals("empty")){
                num = deque.isEmpty() ? 1 : 0;
                sb.append(num).append("\n");
            }
            else if(command.equals("front")){
                num = deque.isEmpty()? -1: deque.peekFirst();
                sb.append(num).append("\n");
            }
            else if(command.equals("back")){
                num = deque.isEmpty()? -1: deque.peekLast();
                sb.append(num).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
