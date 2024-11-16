import java.util.*;

class Solution {
    public int solution(String word, String[] pages) {
        int answer = 0;
        float[][] baseScore = new float[pages.length][2];
        Map<String, Integer> linksIndex = new HashMap<>();
        List<Integer>[] externalLinks = new ArrayList[pages.length];
        for(int i = 0; i<pages.length; i++) 
            externalLinks[i] = new ArrayList<Integer>();
        
        sb = new StringBuilder();
        
        for(int i = 0; i<pages.length; i++){
            String page = pages[i];
            int headStart = page.indexOf("<head>");
            int headEnd = page.indexOf("</head>");
            String head = page.substring(headStart, headEnd);
            String addr = getAddress(head);
            // 주소 - 인덱스 매핑
            linksIndex.put(addr, i);
        }
        
        for(int i = 0; i<pages.length; i++){
            String page = pages[i];
            int bodyStart = page.indexOf("<body>");
            int bodyEnd = page.indexOf("</body>");
            String body = page.substring(bodyStart, bodyEnd);
            
            // 기본 점수 추출
            baseScore[i][0] = getBaseScore(body, word);
            
            // 외부 링크 추출
            List<String> list = getExternalLinks(body);
            // 외부 링크 점수 저장
            baseScore[i][1] = baseScore[i][0] / list.size();

            // 본인 참조 페이지의 인덱스 저장
            for(String str : list){
                int externalIndex = linksIndex.getOrDefault(str, -1);
                if(externalIndex < 0) continue;
                externalLinks[externalIndex].add(i);
            }
        }
        
        float resultScore = -100;
        for(int i = 0; i<pages.length; i++){
            // 점수 계산
            float curResultScore = baseScore[i][0];
            for(int extIdx : externalLinks[i]) curResultScore += baseScore[extIdx][1];
            if(resultScore < curResultScore){
                resultScore = curResultScore;
                answer = i;
            }
        }
        
        return answer;
    }
    
    StringBuilder sb;
    public String getAddress(String page){
        sb.setLength(0);
        int left = 0;
        int right = 0;
        int mid = 0;
        while(mid <= left) {
            left = page.indexOf("<meta", left+1);
            right = page.indexOf(">", left);
            mid = page.lastIndexOf("https://", right);
        }
        right = page.indexOf("\"", mid);
        String url = page.substring(mid, right);
        return url;
    }
    
    public int getBaseScore(String body, String word){
        body = body.toLowerCase();
        word = word.toLowerCase();
        int cnt = 0;
        
        body = body.replaceAll("<a.*?</a>","");
        String[] splitByWord = body.split("[^A-Za-z]+");
        for(String splited : splitByWord) if(word.equals(splited)) cnt++;
        
        return cnt;
    }
    
    public List<String> getExternalLinks(String body){
        List<String> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        while(body.contains("<a href=\"")) {
            left = body.indexOf("<a href=\"");
            right = body.indexOf("\">",left);
            list.add(body.substring(left+9, right));
            body = body.substring(right);
        }
        return list;
    }
    
    public String extractAddr(String body, int index){
        sb.setLength(0);
        while(body.charAt(index) != '"'){
            sb.append(body.charAt(index++));
        }
        return sb.toString();
    }
}