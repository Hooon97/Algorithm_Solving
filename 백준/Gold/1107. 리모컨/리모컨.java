import java.util.Scanner;

public class Main {
	static int goal, T, ans;
	static boolean[] malf;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		goal = sc.nextInt();
		T = sc.nextInt();
		malf = new boolean[10];
		
		for(int i = 0; i<T; i++) malf[sc.nextInt()] = true;
		ans = Math.abs(100-goal);
		
		//되는 것들만 모아놓고 확인해서 풀기
		//BF로 풀자...경우 나누지 말고
		String strGoal = String.valueOf(goal);
		for(int i = 0; i<=1000000; i++) {
			if(ableToUse(i)) {
				String leng = String.valueOf(i); // 누른 횟수
				int count = Math.abs(goal-i); // + - 눌러야 하는 횟수
				ans = Math.min(ans, count+leng.length()); //최솟값 갱신
			}
		}
		System.out.println(ans);
		sc.close();
	}
	
	public static boolean ableToUse(int i) {
		if(i == 0 && malf[i]) return false;
		
		while(i > 0) {
			int rest = i % 10;
			if(malf[rest]) return false;
			i /= 10;
		}
		return true;
	}
}
