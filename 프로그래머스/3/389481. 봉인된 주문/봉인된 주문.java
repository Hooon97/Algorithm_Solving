import java.util.*;

class Solution {
    /*
        bans가 사전순으로 정렬되어 있다고 할 때,
        각 bans의 요소가 사전의 몇 번째에 등장하는지 찾는다.
        n보다 앞서 등장하는 요소의 갯수를 센 뒤,
        등장 개수 + n의 위치에 등장하는 요소를 반환한다.
    */
    public String solution(long n, String[] bans) {
        String answer = "";
        long cnt = 0;
        
        Arrays.sort(bans, new Comparator<String>() {
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    for(int i = 0; i<o1.length(); i++){
                        if(o1.charAt(i) == o2.charAt(i)) continue;
                        return o1.charAt(i) - o2.charAt(i);
                    }
                    return 1;
                } else{
                    return o1.length() - o2.length();
                }   
            }
        });
        
        for(int i = 0; i<bans.length; i++){
            long idx = indexOfSpell(bans[i]);
            if(idx > 0 && idx <= n){
                n++;
            } else break;
        }
        return spellOfIndex(n);
    }
    
    public long indexOfSpell(String str){
        long idx = 0;
        char[] strArr = str.toCharArray();
        int size = strArr.length;
        for(int i = 1; i<=strArr.length; i++){
            idx += Math.pow(26, size-i) * ( strArr[i-1] - 'a' + 1 );
        }
        return idx;
    }
    
    public String spellOfIndex(long index){
        StringBuilder sb = new StringBuilder();
        char[] alphas = new char[26];
        // 자연스러운 사전순: 'a' ~ 'z'
        for (int i = 0; i < 26; i++) {
            alphas[i] = (char)('a' + i);
        }

        while (index > 0) {
            index--;
            char curChar = alphas[(int)(index % 26)];
            sb.append(curChar);
            index /= 26;
        }
        
        return sb.reverse().toString();
    }
}