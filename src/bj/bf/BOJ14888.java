package bj.bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14888 {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] pmmd = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            pmmd[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> arr = new ArrayList<>();
        solution(nums, pmmd, arr, 1, nums[0]);
        arr.sort(Integer::compareTo);


        System.out.println(arr.get(arr.size() - 1));
        System.out.println(arr.get(0));
    }
    public static void solution(int[] nums, int[] pmmd,ArrayList<Integer>arr, int idx, int result){
        if(idx == nums.length -1){//끝 인덱스에 도착한 경우
            for(int i = 0; i < 4; i++){
                if(pmmd[i] == 1){
                    if(i == 0){
                        arr.add(result + nums[idx]);
                    }
                    else if(i == 1){
                        arr.add(result - nums[idx]);
                    }
                    else if(i == 2){
                        arr.add(result * nums[idx]);
                    }
                    else{
                        arr.add(result / nums[idx]);
                    }
                }
            }
        }
        //넘기고 계산하고 idx가 마지막으로 도달하면 그냥 반환하고
        else if(idx < nums.length -1){//끝 인덱스에 도착하지 못한 경우
            for (int i = 0; i < 4; i++) {
                if (pmmd[i] > 0) {
                    pmmd[i]--;
                    if (i == 0) { // 덧셈
                        solution(nums, pmmd, arr, idx + 1, result + nums[idx]);
                    } else if (i == 1) { // 뺄셈
                        solution(nums, pmmd, arr, idx + 1, result - nums[idx]);
                    } else if (i == 2) { // 곱셈
                        solution(nums, pmmd, arr, idx + 1, result * nums[idx]);
                    } else { // 나눗셈
                        solution(nums, pmmd, arr, idx + 1, result / nums[idx]);
                    }
                    pmmd[i]++; // 연산자 개수 복원
                }
            }
        }
    }
}
