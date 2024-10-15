package programmers.sort.h_index;
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        sorting(citations);
        int answer = result(0, citations);
        return answer;
    }
    public void sorting(int[] citations){
        Arrays.sort(citations);
    }
    public int result(int idx, int[] arr){//idx 는 0부터 시작
        if(idx >= arr.length){
            return arr[idx-1];
        }
        else if(arr[idx] > arr.length - idx){
            return arr.length - idx;
        }
        else{
            return result(idx + 1, arr);
        }
    }
}//01456도 3을 반환해야하는 것. 그러니까 arr[idx]값이 arr.length - idx 보다 크면 arr.length-idx를 반환해야 하는 것임 그니까 9000 ~ 10000 이어도 논문이 1000편이기 때문에 1000번 이상 인용 논문이 1000편 이상인 것이니까
