package programmers.array.PickingDolls;

import java.util.ArrayList;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> basket = new ArrayList<>();
        for(int i = 0; i < moves.length; i++) {
            int doll = 0;
            for(int j = 0; j < board.length; j++) {
                //인형 값 설정
                doll = board[j][moves[i] - 1];
                //인형을 잡은 경우
                if(doll != 0){
                    //바구니에 무언가 있고, 그것이 잡은 인형과 같은 인형인 경우 바구니 제일 위 인형과 잡은 인형을 없앤다. answer += 2
                    if(!basket.isEmpty() && basket.get(basket.size() - 1).equals(doll)){
                        basket.remove(basket.size() - 1);
                        answer += 2;
                    }
                    //그 외의 경우 바구니에 인형을 담는다.
                    else{
                        basket.add(doll);
                    }
                    //인형이 있던 곳은 0으로 초기화 하고 더 이상 내려가지 못하도록 한다.
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
