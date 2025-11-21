package programmers.implement.thatsong;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        StringBuilder sb;
        int t = 0;
        for(String music : musicinfos){
            String[] infos = music.split(",");
            String[] start = infos[0].split(":");
            String[] end = infos[1].split(":");
            //재생 시간
            int min = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) - (Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));
            //재생 파트
            sb = new StringBuilder();
            //여기서 # 고려해서 추가해야함
            int idx = 0;
            int time = 0;
            while(time < min){
                char code = infos[3].charAt(idx % infos[3].length());
                sb.append(code);
                if(infos[3].charAt((idx + 1) % infos[3].length()) == '#'){
                    sb.append('#');
                    idx++;
                }
                idx++;
                time++;
            }
            //#고려해서 파악해야함
            String muinfo = sb.toString();
            for(int i = 0; i <= muinfo.length() - m.length(); i++){
                if(i != muinfo.length() - m.length()){
                    if(muinfo.charAt(i + m.length()) == '#'){
                        continue;
                    }
                }
                boolean flag = true;
                for(int j = 0; j < m.length(); j++){
                    //#도 고려해야하니까 i+j가 info의 마지막이 아니면 다음까지 판단해서 #인지 파악 #이면 그냥 넘기면 되고 # 아니면 찾은거임
                    if(muinfo.charAt(i + j) != m.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    if(t < min){
                        t = min;
                        answer = infos[2];
                    }
                }
            }
        }
        return answer;
    }
}
