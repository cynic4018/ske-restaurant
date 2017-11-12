package inside;
import java.util.Scanner;
import java.time.LocalDate;


/**
 * Main class for SKE Restaurant order taking application.
 * It displays a menu and accepts items to order.
 * When done, it prints a receipt including the order total.
 * Use Array and LocalDate.
 *
 * @author Katapon Sinpunyawong
 */

public class RestaurantArrays {

	public static String[] menuItems = {"Steak","Pizza", "Chickens", "Coke"};
	public static double[] unitPrice = {400.0, 250.0, 120.0, 45.0};
	public static double[] quantities = new double[menuItems.length];
	public static double[] option = new double[menuItems.length];
	
	static Scanner a = new Scanner(System.in);
	static String Select;
	static double totalprice;
	static LocalDate today = LocalDate.now();

	
	public static void Printdetail(double[] count,double[] price){
		
		totalprice = price[0]+price[1]+price[2]+price[3];
		
		if(today.getMonthValue() == 2)
		{
			if(price[0]>0 && count[0]>0)
			{
				System.out.printf("|%-18s|%9.0f|%11.2f|\n",menuItems[0],count[0],price[0]);
			}
			if(price[1]>0 && count[1]>0)
			{
				System.out.printf("|%-18s|%9.0f|%11.2f|\n",menuItems[1],count[1],price[1]);
			}
			if(price[2]>0 && count[2]>0)
			{
				System.out.printf("|%-18s|%9.0f|%11.2f|\n",menuItems[2],count[2],price[2]);
			}
			if(price[3]>0 && count[3]>0)
			{
				System.out.printf("|%-18s|%9.0f|%11.2f|\n",menuItems[3],count[3],price[3]);
			}
			System.out.println("+----------------------------+-----------+");
			System.out.printf("|%-28s|%11.2f|\n","Total",totalprice);
			System.out.println("+----------------------------+-----------+");
			System.out.println("*** Valentine Promotion : Discount 50% ***");
			System.out.println("+----------------------------+-----------+");
			System.out.printf("|%-28s|%11.2f|\n","Total (Valentine Promotion)",totalprice/2);
			
		}
		else
		{
			if(price[0]>0 && count[0]>0)
			{
				System.out.printf("|%-18s|%9.0f|%11.2f|\n",menuItems[0],count[0],price[0]);
			}
			if(price[1]>0 && count[1]>0)
			{
				System.out.printf("|%-18s|%9.0f|%11.2f|\n",menuItems[1],count[1],price[1]);
			}
			if(price[2]>0 && count[2]>0)
			{
				System.out.printf("|%-18s|%9.0f|%11.2f|\n",menuItems[2],count[2],price[2]);
			}
			if(price[3]>0 && count[3]>0)
			{
				System.out.printf("|%-18s|%9.0f|%11.2f|\n",menuItems[3],count[3],price[3]);
			}
			System.out.println("+----------------------------+-----------+");
			System.out.printf("|%-28s|%11.2f|\n","Total",totalprice);
		}
		
	}
	
	public static void SummaryPay(double[] count,double[] price){
		System.out.println("=== Total List ===");
		System.out.println();
		Print(price,count);
		double amount = 0;
		double totalamount = 0;
		
		if(today.getMonthValue() == 2){
			double valentinetotalprice = totalprice/2;
			do{
				
				System.out.print("Enter the amount: ");
				amount = a.nextDouble();
				totalamount += amount;
				
			}while(totalamount<valentinetotalprice);
			
			System.out.printf("Your change: %.2f \n",totalamount-valentinetotalprice);
			System.out.print("===== Thank you =====");
			System.exit(0);
		}
		else
		{
			do{
				
				System.out.print("Enter the amount: ");
				amount = a.nextDouble();
				totalamount += amount;
				
			}while(totalamount<totalprice);
			
			System.out.printf("Your change: %.2f \n",totalamount-totalprice);
			System.out.print("===== Thank you =====");
			System.exit(0);
		}
	}
	
	public static void day(){
		System.out.println("today: "+today+"  ["+today.getDayOfWeek()+"]");	
		
		if(today.getMonthValue() == 2)
		{
			System.out.println("This month is Valentine!!");
			System.out.println("Promotion Discount 50%");
		}
	}
	

	
	public static void Selectoption()
	{
		double[] price = new double[4];
		double[] totalcount = new double[4];
	
				skemenu();
		
				do{
					
					System.out.print("Enter your Option: ");
					Select = a.next();
					
					if(Select.equals("1"))
					{
						System.out.print("Enter Quantity: ");
						totalcount[0] += a.nextInt();
						price[0] = unitPrice[0]*totalcount[0];
						System.out.println("");
						
					}
					else if(Select.equals("2"))
					{
						System.out.print("Enter Quantity: ");
						totalcount[1] += a.nextInt();
						price[1] = unitPrice[1]*totalcount[1];
						System.out.println("");
						
					}
					else if(Select.equals("3"))
					{
						System.out.print("Enter Quantity: ");
						totalcount[2] += a.nextInt();
						price[2] = unitPrice[2]*totalcount[2];
						System.out.println("");
						
					}
					else if(Select.equals("4"))
					{
						System.out.print("Enter Quantity: ");
						totalcount[3] += a.nextInt();
						price[3] = unitPrice[3]*totalcount[3];
						System.out.println("");
						
					}
					else if(Select.equals("p"))
					{
						Print(price,totalcount);
						
					}
					else if(Select.equals("t"))
					{
						SummaryPay(totalcount,price);
					}

					
				}while(!Select.equals("x"));
				System.out.print("===== Thank you =====");
				
				
			}

	

	
	public static void skemenu(){
		day();
		System.out.println("==========[ SKE-Menu ]==========");
		for(int i=0 ; i<menuItems.length; i++)
		{
			System.out.printf("[%d] %s\t %.2f  Bath.\n",i+1,menuItems[i],unitPrice[i]);
		}
		System.out.println("");
		System.out.println("[p] Print order ");
		System.out.println("[t] Total and Pay");
		System.out.println("[x] Exit ");
		System.out.printf("---------------------------------\n");
		System.out.println("");
	}
	
	public static void Print(double[] price,double[] count)
	{
		System.out.println("+------ Menu ------+-- Qty --+-- Price --+");
		Printdetail(count,price);
		System.out.println("+----------------------------+-----------+");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Selectoption();	
		
	}

}
