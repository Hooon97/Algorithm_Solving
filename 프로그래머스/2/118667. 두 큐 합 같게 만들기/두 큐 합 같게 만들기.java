import java.util.*;

class Solution {
    /*
        두 큐에 대해 원소를 빼고 넣고를 끝까지 가면,
        queue1 <-> queue2인 셈.
        
        queue 이므로 선형적 변화가 발생함.
        전체 합에서 넣고 뺄 때 합의 변화를 검사하며, 투포인터로 구현이 가능할 것으로 보임.
        
        검사는 Greedy 하게..? 큰 쪽을 빼서 작은 쪽으로 넣어보기.
        (왜냐면 1번에서 먼저 빼나 2번에서 먼저 빼나 상관 없기 때문)
        
        case 1
        (0, 14), (0, 16)
        (0, 18), (1, 12)
        (1, 15), (1, 15) --- 답안
        
        case 2
        (0, 6), (0, 14)
        (0, 7), (1, 13) 1
        (0, 17), (2, 3) 2
        (1, 16), (3, 4) 3
        (2, 14), (3, 6) 4
        (3, 13), (3, 7) 5
        (4, 11), (3, 9) 6
        (5, 10), (3, 10) 7
        
        case 3
        (0, 2), (0, 6)
        (0, 3), (1, 5)  1
        (0, 8), (2, 0)  2
        (1, 7), (2, 1)  3
        (2, 6), (2, 2)  4
        ===> 두 배열의 요소 구성이 동일하므로 불가능한 케이스.
        ===> 사이클이 형성되면 불가능..?
        
        
        case 4
        [a, b, c] 길이 : n
        [d, e, f] 길이 : n
        
        [c], [d, e, f, a, b] n-1번
        [c, d, e, f, a], [b] n-1 + n-1
        [a], [b, c, d, e, f] n-1 + n-1 + n-1
        [a, b] [c, d, e, f] n-1 + n-1 + n-1(최대)
        ...
        원소의 순환이 반복되며 최초 자기 자신의 원소를 가진 배열이 되려면
        4*n 미만의 원소 교환이 발생함.
    */
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        
        for(int i = 0; i<queue2.length; i++){
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        if(sum1 == sum2) return 0;
        int leng = (queue1.length + queue2.length) * 2;
        while(!q1.isEmpty() && !q2.isEmpty()){
            if(answer >= leng){
                break;
            }
            if(sum1 == sum2) return answer;
            
            if(sum1 > sum2){
                int num = q1.poll();
                q2.add(num);
                sum1 -= num;
                sum2 += num;
            } else{
                int num = q2.poll();
                q1.add(num);
                sum1 += num;
                sum2 -= num;
            }
            
            answer++;
        }
        
        return -1;
    }
}