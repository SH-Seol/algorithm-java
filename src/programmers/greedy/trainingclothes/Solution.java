package programmers.greedy.trainingclothes;

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];

        //체육복을 잃어 버린 경우 해당 넘버의 학생은 옷이 없음을 표시 (-1)
        for(int i = 0; i < lost.length; i++) {
            arr[lost[i]-1] = -1;
        }

        //여분의 체육복을 가지고 있는 학생의 경우 해당 넘버의 학생은 옷이 추가로 있음을 표시 (+1)
        //잃어버렸고 여분의 옷이 있는 경우 0 으로 변경됨
        for(int i = 0; i < reserve.length; i++) {
            arr[reserve[i]-1] += 1;
        }

        //앞에서부터 채워야하기에 lost의 순서를 정렬
        Arrays.sort(lost);

        for(int i = 0; i < lost.length; i++) {
            //옷을 잃어버린 인물이 여벌의 옷이 없었던 경우
            if(arr[lost[i] - 1] == -1){
                //이 학생이 1번 학생인 경우 2번 학생이 여분의 옷이 있는지 검증
                if(lost[i] == 1){
                    if(arr[1] == 1){
                        arr[0] += 1;
                        arr[1] -= 1;
                    }
                }
                //학생이 2~ n-1인 경우
                else if(lost[i] < n){
                    if(arr[lost[i]-2] == 1){
                        arr[lost[i]-2] -= 1;
                        arr[lost[i]-1] += 1;
                    }
                    else if(arr[lost[i]] == 1){
                        arr[lost[i]] -= 1;
                        arr[lost[i]-1] += 1;
                    }
                }
                //마지막 학생이 체육복이 없는 경우 바로 앞에 학생이 여분의 체육복이 있는지 검증
                else{
                    if(arr[n-2] == 1){
                        arr[n-1] += 1;
                        arr[n-2] -= 1;
                    }
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]  >= 0){
                answer += 1;
            }
        }
        return answer;
    }
}
