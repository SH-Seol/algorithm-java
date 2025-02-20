package bj.dp;

import java.util.Scanner;

public class BOJ11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        result(arr);

    }
    public static void result(int[] arr) {
        //왼쪽에서 증가수열, 오른쪽에서 증가수열 구해서 각 idx 값 더하고 maxLength 구하기
        //단순 증가만 판단하면 됨
        int maxLength = 0;
        //길이 별로 값 저장 배열 (idx+1이 길이)
        int[] lDp = new int[arr.length];
        int[] rDp = new int[arr.length];

        //좌로 연산 시작
        for (int i = 0; i < arr.length; i++) {
            lDp[i] = 1;
            for(int j = 0; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    lDp[i] = Math.max(lDp[i], lDp[j] + 1);
                }
            }
        }

        //우로 연산 시작
        for(int i = arr.length - 1; i >= 0; i--) {
            rDp[i] = 1;
            for(int j = arr.length - 1; j > i; j--){
                if(arr[i] > arr[j]) {
                    rDp[i] = Math.max(rDp[i], rDp[j] + 1);
                }
            }
        }

        //maxLength 계산
        for(int i = 0; i < arr.length; i++) {
            maxLength = Math.max(maxLength, lDp[i] + rDp[i]);
        }

        //최종적으로 -1을 하는 이유는 12521 의 경우 3 + 3으로 중복된 연산결과가 존재하기 때문
        System.out.print(maxLength - 1);
    }
}
