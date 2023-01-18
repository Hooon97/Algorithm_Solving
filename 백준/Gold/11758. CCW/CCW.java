import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] x = new int[3];
		int[] y = new int[3];
		for(int i = 0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		int result = (x[0] * y[1] + x[1] * y[2] + x[2] * y[0]) - (x[1]*y[0] + x[2]*y[1] + x[0]*y[2]);
		int ans = 0;
		if(result > 0) ans = 1;
		else if (result == 0) ans = 0;
		else ans = -1;
		System.out.println(ans);
	}
}
