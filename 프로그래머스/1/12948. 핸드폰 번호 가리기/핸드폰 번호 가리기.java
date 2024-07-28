class Solution {
    public String solution(String phone_number) {
        char[] phone = phone_number.toCharArray();
        for(int i = 0; i<phone.length-4; i++)
            phone[i] = '*';
        return new String(phone);
    }
}