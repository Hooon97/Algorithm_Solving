import java.util.*;

class Solution {
    static char[] number;
    static boolean[] visit;
    static int answer;
    static Set<Integer> set;
    public int solution(String numbers) {
        answer = 0;
        number = new char[numbers.length()];
        set = new HashSet<Integer>();
        Arrays.fill(number,'0');
        
        visit = new boolean[numbers.length()];
        perm(0,"",numbers.toCharArray());
        
        System.out.print(set);
        
        return set.size();
    }
    public static void perm(int depth, String curNum, char[] nums){
        if(depth > nums.length){
            return;
        }
        if(depth > 0){
            if(isPrime(Integer.valueOf(curNum))){
              set.add(Integer.valueOf(curNum));  
            } 
        }
        
        for(int i = 0; i<nums.length; i++){
            if(visit[i]) continue;
            visit[i] = true;
            StringBuilder sb = new StringBuilder();
            sb.append(curNum).append(nums[i]);
            perm(depth+1, sb.toString(), nums);
            visit[i] = false;
        }
    }
    
    private static boolean isPrime(int N){
        if(N <= 1) return false;
        for(int i = 2; i*i<=N; i++){
            if(N%i == 0) return false;
        }
        return true;
    }
}