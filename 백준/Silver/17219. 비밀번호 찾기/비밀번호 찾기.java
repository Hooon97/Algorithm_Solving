import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> data = new HashMap<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		for(int i = 0; i<N; i++) {
			String domain = sc.next();
			String pw = sc.next();
			data.put(domain, pw);
		}
		for(int i = 0; i<M; i++) {
			String tmp = sc.next();
			System.out.println(data.get(tmp));
		}
		
		sc.close();
	}
}
