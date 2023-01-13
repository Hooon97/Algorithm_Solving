import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int T = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] D = new int[51];
		for(int i = 0; i<M; i++) {
			D[i] = Integer.parseInt(st.nextToken());
			T += D[i];
		}
		int K = Integer.parseInt(br.readLine());
		
		double ans = 0.0;
		double[] probability = new double[51]; 
		for(int i = 0; i<M; i++) {
			if(D[i] >= K) {
				probability[i] = 1.0;
				for(int k = 0; k<K; k++) {
					probability[i] *= (double) (D[i]-k)/(T-k);
				}
				ans += probability[i];
			}
		}
		System.out.print(ans);
	}
}
