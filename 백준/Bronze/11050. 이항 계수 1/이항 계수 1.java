import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String nums = br.readLine();
		StringTokenizer st = new StringTokenizer(nums);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); //스캐너 대신 버퍼드리더, 라이터를 써보고 싶었다.
		int mult = 1;
		int div = 1;
		if (N == K) {
			bw.write("1"); //nCk의 값을 구하려면, 두 값이 같을 때는 값이 언제나 1이다.
			bw.flush();
		} else {
			for (int i = 1; i <= K; i++) {
				mult *= (N-i+1); //분자
				div *= i; // 분모
			}
			System.out.println(mult/div);
			bw.flush();
		}

	}
}
