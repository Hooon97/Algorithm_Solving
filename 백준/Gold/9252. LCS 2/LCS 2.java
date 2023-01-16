import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static long[][] dp;
	static char[] A;
	static char[] B;
	static ArrayList<Character> path; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		dp = new long[A.length +1][B.length + 1];
		path = new ArrayList<>();
		for(int i = 1; i<= A.length; i++) {
			for(int j = 1; j<=B.length; j++) {
				if(A[i-1] == B[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		sb.append(dp[A.length][B.length]+"\n");
		getText(A.length, B.length);
		for(int i = path.size()-1; i>=0; i--) {
			sb.append(path.get(i));
		}
		System.out.print(sb.toString());
	}
	static void getText(int r, int c) {
		if(r == 0 || c == 0) return;
		if(A[r-1] == B[c-1]) {
			path.add(A[r-1]);
			getText(r-1,c-1);
		}
		else {
			if(dp[r-1][c] > dp[r][c-1]) getText(r-1,c);
			else getText(r,c-1);
		}
	}
}
