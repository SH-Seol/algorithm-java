package programmers.array.MakingHamburger;

import java.util.ArrayList;

//1231 이었고
//ArrayList로 받아야하나
//그럼 1231로 다 들어오면
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // 문제 예시 1
        int[] ingredient1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int result1 = sol.solution(ingredient1);
        System.out.println("예시 1 결과: " + result1); // 기대값: 2

        // 문제 예시 2
        int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        int result2 = sol.solution(ingredient2);
        System.out.println("예시 2 결과: " + result2); // 기대값: 0
    }

    public int solution(int[] ingredient){
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : ingredient){
            list.add(i);
            if(i == 1){
                if(list.size() >= 4){
                    int res = check(list);
                    answer += res;
                    if(res == 1){
                        list.remove(list.size()-1);
                        list.remove(list.size()-1);
                        list.remove(list.size()-1);
                        list.remove(list.size()-1);
                    }
                }
            }
        }
        return answer;
    }

    public int check(ArrayList<Integer> ingredient){
        int idx = ingredient.size() - 1;
        if(ingredient.get(idx-1) == 3 && ingredient.get(idx-2) == 2 && ingredient.get(idx-3) == 1){
            return 1;
        }
        else{
            return 0;
        }
    }
}
