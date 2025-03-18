package bj.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {
    public static void main(String[] args) {
        int subin;
        int young;

        Scanner sc = new Scanner(System.in);
        subin = sc.nextInt();
        young = sc.nextInt();

        System.out.println(bfs(subin, young));

    }
    static int bfs(int n, int k){
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        queue.add(new int[]{n,0});
        visited[n] = true;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            //수빈이의 위치가 동생과 같은 위치의 경우 result를 리턴한다.
            if(temp[0] == k){
                result = temp[1];
                break;
            }

            int numA = temp[0] - 1;
            int numB = temp[0] + 1;
            int numC = temp[0] * 2;

            if(numA >= 0 && !visited[numA]){
                visited[numA] = true;
                queue.add(new int[]{temp[0] - 1, temp[1] + 1});
            }

            if(numB <= 100000 && !visited[numB]){
                visited[numB] = true;
                queue.add(new int[]{temp[0] + 1, temp[1] + 1});
            }

            if(numC <= 100000 && !visited[numC]){
                visited[numC] = true;
                queue.add(new int[]{temp[0] * 2, temp[1] + 1});
            }
        }
        return result;
    }
}
