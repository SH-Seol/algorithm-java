package programmers.kakao.stringcompression;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        StringBuilder sb;
        StringBuilder tsb;
        //정해진 길이 개수 i개 정하면서 진행
        for(int i = 1; i <= s.length() / 2; i++){
            String prev = "";
            sb = new StringBuilder();
            tsb = new StringBuilder();
            //개수 i가 정해진 상황, i만큼 tsb에 쌓을 것
            int cnt = 0;
            for(int j = 0; j < s.length(); j++){
                //tsb에 정해진 개수만큼 쌓기
                tsb.append(s.charAt(j));
                //정해진만큼 쌓인 경우
                if(tsb.length() == i){

                    if(prev.equals("")){
                        cnt = 1;
                        prev = tsb.toString();
                    }

                    else{

                        if(prev.equals(tsb.toString())){
                            cnt++;
                        }

                        else{

                            if(cnt > 1){
                                sb.append(cnt);
                            }

                            sb.append(prev);
                            prev = tsb.toString();
                            cnt = 1;
                        }
                    }
                    tsb = new StringBuilder();
                }
            }
            //남은 개수가 있을 경우 그것들만 sb에 그대로 넣기
            if(!prev.equals("")){
                if(cnt > 1){
                    sb.append(cnt);
                }
                sb.append(prev);
            }
            if(tsb.length() != 0){
                sb.append(tsb);
            }

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}