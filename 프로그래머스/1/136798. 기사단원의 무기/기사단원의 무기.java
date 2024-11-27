import java.util.*;
class Solution {
    /*
        1. 1 -> number까지 순회하며 약수의 개수를 계산한다.
        2. 약수의 개수는 1 ~ Math.sqrt(number)까지 순회하며 나머지가 0인 개수를 찾는다.
            또는, 에라토스테네스의 체를 구현한다.
        3. 이 경우 O(n log(n))의 시간 복잡도를 지닌다.
        4. 기준치를 초과하는 경우는 limit으로, 나머지는 공격력의 합을 구하여 반환한다.
    */
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] rawPower = new int[number+1];
        for(int i = 1; i<=number; i++){
            for(int j = 1; j<=number/i; j++){
                rawPower[i*j]++;
            }
        }
        for(int i = 1; i<=number; i++){
            answer += rawPower[i] > limit ? power : rawPower[i];
        }
        return answer;
    }
}