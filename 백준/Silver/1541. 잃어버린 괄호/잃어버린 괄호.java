import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static String str;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		str = sc.next();
		int poNum = 0; int neNum = 0;
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == '-') {
				poNum = positive(i);
				neNum = negative(i);
				flag = true;
				break;
			}
		}
		if(flag)
		System.out.println(poNum-neNum);
		else {
			String[] arr = str.split("\\+");
			int sum = 0;
			for(int i = 0; i<arr.length; i++)
				sum += Integer.parseInt(arr[i]);
			System.out.println(sum);}

		sc.close();
	}
	public static int positive(int i) {
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j<i; j++)
			sb.append(str.charAt(j));
		
		String str2 = sb.toString();
		String[] arr = str2.split("\\+");
		for(int j = 0; j<arr.length; j++) {
			sum += Integer.parseInt(arr[j]);
		}
		return sum;
	}
	public static int negative(int i) {
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for(int j = i+1; j<str.length(); j++)
			sb.append(str.charAt(j));
		
		String minStr = sb.toString();
		String[] arr = minStr.split("\\+");
		for(int j = 0; j<arr.length; j++) {
			String[] arr2 = arr[j].split("-");
			for(int p = 0; p<arr2.length; p++) {
				sum += Integer.parseInt(arr2[p]);
			}
			
		}
		return sum;
	}
}
