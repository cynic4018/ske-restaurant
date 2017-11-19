package inside;
import java.util.Scanner;

/**
 * The Restaurant class.
 * 
 * @author Katapon Sinpunyawong
 */
public class Restaurant {
		
	static Scanner sc = new Scanner(System.in);
	static String Select;
	static int choice = 0;
	static int amount = 0;

	public static void interfaceChoice(){
		System.out.println("==========[ SKE-Menu ]==========");
		System.out.println("[o] Order");
		System.out.println("[p] Print order");
		System.out.println("[e] Exit");
		System.out.println("---------------------------------");
		System.out.println("");
	}
	public static void selectChoice(){
		
		
		do{
			interfaceChoice();
			System.out.print("Enter your Option: ");
			Select = sc.next();
			
			if(Select.equalsIgnoreCase("o"))
			{
				System.out.println("------------------------------");
				orderChoice();
				
			}
			else if(Select.equalsIgnoreCase("p"))
			{
				System.out.println("----------------------------------");
				RestaurantManager.printOrder();
				System.out.println("----------------------------------");
			}

			
		}while(!Select.equalsIgnoreCase("e"));
		System.out.print("===== Thank you =====");
	}
	
	public static void orderChoice(){
		RestaurantManager.menuList();
		System.out.println("------------------------------");
		System.out.println("");	
		while(true)
		{	
			System.out.print("Select menu: ");
			choice = sc.nextInt();
			
			System.out.print("Amount: ");
			amount = sc.nextInt();
			
			RestaurantManager.recordOrder(choice,amount);
			while(true){
				System.out.print("[R]esume or [E]xit: ");
				String eor = sc.next();
				if(eor.equalsIgnoreCase("R"))
				{
					break;
				}
				else if(eor.equalsIgnoreCase("E"))
				{
					return;
				}
			}
		}
		
	}
	
	public static void main(String[]args){
		RestaurantManager.readMenu();
		selectChoice();
	}
}
