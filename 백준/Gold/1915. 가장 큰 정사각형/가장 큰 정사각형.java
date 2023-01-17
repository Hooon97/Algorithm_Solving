import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		long[][] D = new long[1001][1001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long max = 0;
		for(int i = 0; i<n; i++) {
			String mline = br.readLine();
			for(int j = 0; j<m; j++) {
				D[i][j] = Long.parseLong(String.valueOf(mline.charAt(j)));
				if(D[i][j] == 1 && j > 0 && i > 0) {
					D[i][j] = Math.min(D[i-1][j], Math.min(D[i][j-1], D[i-1][j-1]))+D[i][j];
				}
				if(max < D[i][j]) max = D[i][j];
			}
		}
		System.out.println(max * max);
	}
}
