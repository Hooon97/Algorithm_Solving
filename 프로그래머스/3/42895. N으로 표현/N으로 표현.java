import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        
        Set<Integer>[] setArr = new Set[9];
        for(int i = 1; i<9; i++){
            setArr[i] = new HashSet<>();
        }
        
        setArr[1].add(N);
        int n = N;
        for(int i = 2; i<9; i++){
            n = n*10 + N;
            setArr[i].add(n);
        }
        
        for(int i = 1; i<=8; i++){
            Set<Integer> pro = setArr[i];
            for(int j = 1; j<i; j++){
                Set<Integer> cur = setArr[j];
                Set<Integer> prev = setArr[i-j];
                pro.addAll(getSet(cur,prev));
            }
        }
        
        for(int i = 1; i<9; i++){
            if(setArr[i].contains(number)) return i;
        }
        return -1;
    }
    
    public Set<Integer> getSet(Set<Integer> pro, Set<Integer> pre){
        Set<Integer> result = new HashSet<>();
        for(int a : pro){
            for(int b : pre){
                if(b != 0) result.add(a/b);
                if(a != 0) result.add(b/a);
                result.add(a*b);
                result.add(a-b);
                result.add(b-a);
                result.add(a+b);
            }
        }
        
        return result;
    }
}