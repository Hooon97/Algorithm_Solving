import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] x = new long[N+1];
		long[] y = new long[N+1];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		x[N] = x[0];
		y[N] = y[0];
		double result = 0;
		for(int i = 0; i<N; i++) {
			result += (x[i] * y[i+1]) - (x[i+1] * y[i]);
		}
		String ans = String.format("%.1f", Math.abs(result)/2.0);
		System.out.println(ans);
	}
}
