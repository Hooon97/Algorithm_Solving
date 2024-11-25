class Solution {
    public String solution(int a, int b) {
        // 1 ~ 11월
        int[] days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        String[] date = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int day = b;
        for(int i = 0; i<a; i++) day += days[i];
        return date[day%7];
    }
}