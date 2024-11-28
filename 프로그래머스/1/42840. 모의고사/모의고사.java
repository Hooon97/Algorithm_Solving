import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] s1 = { 1, 2, 3, 4, 5 };        
        int[] s2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] s3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int n1 = s1.length;
        int n2 = s2.length;
        int n3 = s3.length;
        int[] score = new int[3];
        int max = 0;
        for(int i = 0; i<answers.length; i++){
            int curAns = answers[i];
            if(curAns == s1[ i % n1 ]) score[0]++;
            if(curAns == s2[ i % n2 ]) score[1]++;
            if(curAns == s3[ i % n3 ]) score[2]++;
            max = Math.max(Math.max(score[0], score[1]), score[2]);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<3; i++){
            if(score[i] == max) ans.add(i+1);
        }
        answer = new int[ans.size()];
        for(int i = 0; i<answer.length; i++) answer[i] = ans.get(i);

        return answer;
    }
}