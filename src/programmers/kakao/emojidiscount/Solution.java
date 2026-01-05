package programmers.kakao.emojidiscount;

class Solution {
    int[] answer = new int[2];
    int[] rates = {10, 20, 30, 40};
    int[][] users;
    int[] emoticons;
    public int[] solution(int[][] us, int[] emoti) {
        users = us;
        emoticons = emoti;
        recursive(0, new int[emoticons.length]);
        return answer;
    }

    public void recursive(int depth, int[] arr){
        if(depth >= arr.length){
            calc(arr);
            return;
        }
        for(int i = 0; i < 4; i++){
            arr[depth] = rates[i];
            recursive(depth + 1, arr);
        }
    }

    public void calc(int[] arr){
        //arr안에는 할인율이 들어가 있음
        int emo = 0;
        int tp = 0;
        for(int i = 0; i < users.length; i++){
            int price = 0;
            for(int j = 0; j < arr.length; j++){
                //할인율이 소비자의 비율보다 크거나 같으면 구입
                if(arr[j] >= users[i][0]){
                    price += emoticons[j] * (100 - arr[j]) / 100;
                }
            }
            if(price >= users[i][1]){
                emo++;
            }
            else{
                tp += price;
            }
        }
        if(emo > answer[0]){
            answer[0] = emo;
            answer[1] = tp;
        }
        else if(emo == answer[0]){
            answer[1] = answer[1] > tp ? answer[1] : tp;
        }
    }
}
