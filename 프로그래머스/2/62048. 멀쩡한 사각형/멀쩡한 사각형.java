class Solution {
    public long solution(int w, int h) {
        long k = gcd(w, h);
        return ((long) w*h - ((w/k)+(h/k)-1)*k);
    }
    public int gcd(int x, int y){
        while(y != 0){
            int r = x%y;
            
            x = y;
            y = r;
        }
        return x;
    }
}