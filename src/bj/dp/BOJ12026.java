package bj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ12026 {
    public static void main(String[] args) throws Exception {
        int n;
        char[] arr;
        int[][] nums;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = br.readLine()
                .toCharArray();

        nums = new int[n][n];
        int[] cnt = new int[n];
        //배열 값 넣기
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == 'B' && arr[j] == 'O') {
                    nums[i][j] = (j - i) * (j - i);//i에서 j로 갈 때 5 to 7이면, 0에서 5로 간 거리 + 5에서 7로 간 거리랑 기존 cnt[7]이랑 비교하면 됨
                    if (i == 0) {
                        cnt[j] = nums[i][j];
                    }
                }
                else if (arr[i] == 'O' && arr[j] == 'J') {
                    nums[i][j] = (j - i) * (j - i);
                }
                else if (arr[i] == 'J' && arr[j] == 'B') {
                    nums[i][j] = (j - i) * (j - i);
                }

                if (cnt[j] == 0 && cnt[i] != 0 && nums[i][j] != 0) {//이어져 있는데, 아직 j로 도달한 적 없어요
                    cnt[j] = cnt[i] + nums[i][j];
                }
                else if (cnt[i] != 0 && cnt[j] != 0 && nums[i][j] != 0) {//이어져 있고 j로 가봤어요
                    cnt[j] = Math.min(cnt[j], cnt[i] + nums[i][j]);
                }


            }
        }
        System.out.println(cnt[n-1] != 0 ? cnt[n-1] : -1);
    }
}