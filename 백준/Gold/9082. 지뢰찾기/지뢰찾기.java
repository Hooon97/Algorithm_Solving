import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<T; tc++) {
			int total = 0;
			int N = Integer.valueOf(br.readLine());
			String str = br.readLine();
			br.readLine();
			for(int i = 0; i<str.length(); i++)
				total += Integer.valueOf(str.charAt(i)-'0');
			//총합이 3의 배수이면 가운데에만 지뢰가 분포
			//총합이 3의 배수보다 1모자라면 양 끝에 1개 분포
			//총합이 3의 배수보다 1크면 양 끝에 2개 분포
			sb.append((total+2)/3+"\n");
		}
		System.out.print(sb);
	}
}
