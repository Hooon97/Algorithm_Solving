import java.util.Scanner;
import java.util.TreeMap;

/***
 * 1. 트리 순회의 경우, 재귀 함수 코드 순서 설정을 통해 전위, 중위, 후위 순회가 가능하다.
 * 2. 가장 관건이 되는 포인트는
 * 2.1 어떻게 노드를 입력받을 것인가?
 * 2.2 어떤 자료구조를 통해 부모 자식 노드의 관계를 표현할 것인가?
 * 3. 정석적이라면 Tree class를 생성하고 Node 안에 Node를 선언하고 입력해주면 되지만..
 * 4. 이 문제에 한해서는 좀 더 편하게 할 수 있을 것 같다.
 * @author HoonD
 *
 */

public class Main {
	public static class Node{
		String left;
		String right;
		Node(String left, String right){
			this.left = left;
			this.right = right;
		}
	}
	
	static TreeMap<String, Node> treeMap;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		treeMap = new TreeMap<>();
		int N = sc.nextInt();
		for(int i = 0; i<N; i++) {
			String parent = sc.next();
			String left = sc.next();
			String right = sc.next();
			treeMap.put(parent, new Node(left, right));
		}
		
		preOrder("A");
		sb.append("\n");
		
		inOrder("A");
		sb.append("\n");
		
		postOrder("A");
		
		System.out.println(sb.toString());
		sc.close();
	}
	// root -> left -> right
	public static void preOrder(String parent) {
		if(!parent.equals(".")) sb.append(parent);
		
		if(treeMap.containsKey(parent)) {
			String left = treeMap.get(parent).left;
			if(!left.equals(".")) preOrder(left);
			
			String right = treeMap.get(parent).right;
			if(!right.equals(".")) preOrder(right);
			
		}
	}
	public static void inOrder(String parent) {
		if(treeMap.containsKey(parent)) {
			
			String left = treeMap.get(parent).left;
			if(!left.equals(".")) inOrder(left);

			if(!parent.equals(".")) sb.append(parent);

			String right = treeMap.get(parent).right;
			if(!right.equals(".")) inOrder(right);
			
		}
	}
	public static void postOrder(String parent) {
		if(treeMap.containsKey(parent)) {
			
			String left = treeMap.get(parent).left;
			if(!left.equals(".")) postOrder(left);

			
			String right = treeMap.get(parent).right;
			if(!right.equals(".")) postOrder(right);
			
			if(!parent.equals(".")) sb.append(parent);
		}
	}
}
