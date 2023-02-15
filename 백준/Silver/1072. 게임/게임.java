import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.valueOf(st.nextToken());
		long Y = Integer.valueOf(st.nextToken());
		long Z = (Y*100)/(X);
		if(Z >= 99) System.out.println("-1");
		else {
			long ratio = 0;
			long left = 1;
			long right = X;
			long mid = 0;
			while(left <= right) {
				mid = (left+right)/2;
				ratio = (Y+mid)*100/(X+mid);
				if(ratio > Z) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}
			System.out.print(left);
		}
	}
}
