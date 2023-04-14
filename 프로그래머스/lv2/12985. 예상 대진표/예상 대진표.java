class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        if(a > b){
            int tmp = b;
            b = a;
            a = tmp;
        }
        
        while(a != b){
            if(a % 2 != 0) a++;
            if(b % 2 != 0) b++;
            a /= 2;
            b /= 2;
            answer++;
            if(a == b) break;
        }

        return answer;
    }
}