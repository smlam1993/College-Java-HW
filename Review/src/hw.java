
public class hw {
	public static void main(String[] args){
		for(int i = 10; i > 0; i = i - 2){
			System.out.println(" ");
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
