package bj.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //덱 초기화
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;

        for(int i = 0; i < m; i++){
            int idx = search(deque, arr[i]);
            if(idx <= deque.size()/2){
                for(int j = 0; j < idx; j++){
                    deque.addLast(deque.removeFirst());
                    ans++;
                }
            }
            else{
                for(int j = 0; j < deque.size() - idx; j++){
                    deque.addFirst(deque.removeLast());
                    ans++;
                }
            }
            deque.removeFirst();
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
    public static int search(Deque<Integer> deq, int num){
        int idx = 0;
        for(int n : deq){
            if(n == num){
                return idx;
            }
            idx++;
        }
        return -1;
    }

}
