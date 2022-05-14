import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] map = new int[T][T];
		
		for(int i = 0; i<T; i++) {
			for(int j = 0; j<T; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		for(int i = 0; i<T; i++) { // 행
			for(int j = 0; j<T; j++) { // 시작 노드
				for(int p = 0; p<T; p++) { // 도착 노드
					if(map[j][i] == 1 && map[i][p] == 1)
						map[j][p] = 1;
				}
			}
		}
		
		for(int i = 0; i<T; i++) {
			for(int j = 0; j<T; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
