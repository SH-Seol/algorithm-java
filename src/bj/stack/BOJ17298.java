package bj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        Arrays.fill(arr, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek()[0] < num) {
                int idx = stack.pop()[1];
                arr[idx] = num;
            }
            stack.push(new int[]{num, i});
        }

        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
