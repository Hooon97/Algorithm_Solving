class Solution {
    public boolean solution(int num) {
        int div = 0;
        int x = num;
        while(x>0){
            div += x % 10;
            x /= 10;
        }
        return num%div == 0;
    }
}