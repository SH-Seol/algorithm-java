package bj.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ14002 {
    public static void main(String[] args) {
        //값을 받아들이기 위한 scanner
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //arr의 크기 설정, 0번째 인덱스는 사용하지 않기 위해 n+1로 크기 설정
        int[] arr = new int[n+1];
        //값 저장
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        //결과를 도출하기 위한 함수 호출
        result(arr);
    }
    public static void result(int[] arr){
        //최대 길이 저장하기 위함
        int maxLength = 0;
        int maxIndex = 0;
        int[] dp = new int[arr.length];//배열길이
        int[] prev = new int[arr.length];//직전 값의 idx
        ArrayList<Integer> result = new ArrayList<>();
        //arr 각 인덱스에 값이 존재
        Arrays.fill(prev, -1);

        for(int i = 1; i < arr.length; i++){
            dp[i] = 1;
            for(int j = 1; j < i; j++){
                //dp값 갱신할 경우 prev도 동시에 변경
                if(arr[i] > arr[j]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        prev[i] = j;
                    }
                }
            }
            //값이 최대일 경우 maxLength 변경
            if(dp[i] > maxLength){
                maxLength = dp[i];
                maxIndex = i;
            }
        }



        //결과 출력
        System.out.println(maxLength);
        //역순으로 값에 접근할 수 밖에 없는 구조이기에 이를 다시 재정렬해야함
        while(maxIndex!=-1){
            result.add(arr[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        for(int i = result.size() - 1; i >= 0; i--){
            System.out.print(result.get(i) + " ");
        }
    }
}
