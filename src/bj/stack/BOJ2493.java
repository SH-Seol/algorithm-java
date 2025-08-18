package bj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int num = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek()[0] < num) {
                stack.pop();
            }
            if(stack.isEmpty()){
                sb.append(0).append(" ");
            }
            else{
                sb.append(stack.peek()[1]).append(" ");
            }
            stack.push(new int[]{num, i});
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
