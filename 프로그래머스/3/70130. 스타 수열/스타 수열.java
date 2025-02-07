class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] count = new int[a.length];
        for(int i = 0; i<a.length; i++) count[a[i]]++;
        
        for(int i = 0; i<count.length; i++){
            if(count[i] <= answer) continue;
            
            int curLen = 0;
            for(int j = 0; j<a.length-1; j++){
                if(i != a[j] && i != a[j+1]) continue;
                if(a[j] == a[j+1]) continue;
                
                curLen++;
                j++;
            }
            answer = Math.max(answer, curLen);
        }
        
        return answer*2;
    }
}