class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int n = cookie.length;
        
        // 누적합 배열 생성 (길이 n+1)
        int[] accSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            accSum[i] = accSum[i - 1] + cookie[i - 1];
        }

        // m을 기준으로 왼쪽과 오른쪽 부분을 나누는 방식
        for (int m = 0; m < n - 1; m++) {  // m은 기준점 (0부터 n-2까지)
            int left = m, right = m + 1;

            while (left >= 0 && right < n) {
                int leftSum = accSum[m + 1] - accSum[left];   // [left, m] 구간 합
                int rightSum = accSum[right + 1] - accSum[m + 1]; // [m+1, right] 구간 합

                if (leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                }

                // leftSum과 rightSum을 조정하면서 확장
                if (leftSum <= rightSum && left > 0) {
                    left--;
                } else if (rightSum <= leftSum && right < n - 1) {
                    right++;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}
