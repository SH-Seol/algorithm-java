package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        //이 문제의 어려운 점은 정렬에서이지 greedy에서가 어려운게 아님
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2]; // [n][0]은 시작시간, [n][1]은 끝시간
        int result = 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int[] hand = arr[0]; //{0, 6}

        for (int i = 1; i < n; i++) {
            if(hand[1] > arr[i][1]){//hand의 끝나는 시간보다 뒤 요소가 더 빨리 끝나는 경우 hand 변경
                hand = arr[i];
            }
            else if(hand[1] <= arr[i][0]){//hand가 끝나고나서 뒤 요소가 시작되는 경우 추가하고 hand 변경
                result++;
                hand = arr[i];
            }
        }
        System.out.println(result);
    }
}
