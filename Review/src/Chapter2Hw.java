import java.util.Scanner;
public class Chapter2Hw {
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		String firstName, middleName, lastName;
		char firstInitial, middleInitial, lastInitial;
		
		System.out.println("First Name? ");
		firstName = kb.nextLine();
		System.out.println("Middle Name? ");
		middleName = kb.nextLine();
		System.out.println("Last Name? ");
		lastName = kb.nextLine();
		
		firstInitial = firstName.charAt(0);
		middleInitial = middleName.charAt(0);
		lastInitial = lastName.charAt(0);
		System.out.println(firstName + " " + middleName + " " + lastName + "\n" + firstInitial + middleInitial + lastInitial);
	}
}