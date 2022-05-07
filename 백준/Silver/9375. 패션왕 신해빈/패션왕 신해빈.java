import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int ans = 1;
			int n = sc.nextInt();
			HashMap<String, Integer> hm = new HashMap<>();
			for (int i = 0; i < n; i++) {
				sc.next();
				String option = sc.next();
				if (hm.containsKey(option)) {
					int tmp = hm.get(option) + 1;
					hm.put(option, tmp);
				} else {
					hm.put(option, 1);
				}
			}
			Collection<Integer> values = hm.values();
			Object[] nums = values.toArray();
			for (int i = 0; i < nums.length; i++) {
				ans *= (int) nums[i]+1;
			}
				System.out.println(ans-1);
		}
		sc.close();
	}
}
