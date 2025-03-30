package bj.bt;

import java.util.Scanner;

public class BOJ15650 {
    static int length, count;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        count = sc.nextInt();
        arr = new int[count];
        visited = new boolean[length];

        backtracking(0, 0);
    }

    static void backtracking(int start, int cnt){
        if(cnt == count){
            for(int val : arr){
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }

        //시작지점을 주고 추가하거나 안하거나, visited를 true로 하고 추가, 그리고 넘어가고 그 이후에는 visited false로 백트래킹
        for(int i = start; i < length; i++){
            visited[i] = true;
            arr[cnt] = i+1;
            backtracking(i+1, cnt+1);
            visited[i] = false;
        }

    }
}
