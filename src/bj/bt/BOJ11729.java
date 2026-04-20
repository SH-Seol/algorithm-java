package bj.bt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11729 {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 2, 3);
        System.out.println(result);
        System.out.println(sb);
    }
    static void hanoi(int n, int start, int mid, int end){
        if(n == 1){
            sb.append(start).append(" ").append(end).append('\n');
            result++;
            return;
        }
        hanoi(n - 1, start, end, mid);
        //나를 옮기는 작업
        sb.append(start).append(" ").append(end).append('\n');
        result++;
        hanoi(n - 1, mid, start, end);
    }
}
