package inside;
import java.util.Scanner;
import java.util.Arrays;
public class Restaurant {
	
	
	static Scanner a = new Scanner(System.in);
	static int option = 0;
	public static void Printdetail(int[] Select,int[] allprice){
		
		int totalSelect = Select[0]+Select[1]+Select[2]+Select[3];
		int totalprice = allprice[0]+allprice[1]+allprice[2]+allprice[3];
		
		if(Select[0]!=0)
		{
			System.out.printf("|%-18s|%9d|%11d|\n","Steak",Select[0],allprice[0]);
		}
		if(Select[1]!=0)
		{
			System.out.printf("|%-18s|%9d|%11d|\n","Pizza",Select[1],allprice[1]);
		}
		if(Select[2]!=0)
		{
			System.out.printf("|%-18s|%9d|%11d|\n","Chickens",Select[2],allprice[2]);
		}
		if(Select[3]!=0)
		{
			System.out.printf("|%-18s|%9d|%11d|\n","Coke",Select[3],allprice[3]);
		}
		System.out.println("+----------------------------+-----------+");
		System.out.printf("|%-18s|%9d|%11d|\n","Total",totalSelect,totalprice);
		
	}
	
	public static void Selectoption()
	{
		int[] totalcount = new int[4];
		
		totalcount[0] = 0;
		totalcount[1] = 0;
		totalcount[2] = 0;
		totalcount[3] = 0;
		
		int[] price = new int[4];
		
		int quan=0;
		
		int c = 1;	
		while(c > 0)
			{
				quan = 0;
				
				do{
					
					if(option == 1)
					{
						System.out.print("Enter Quantity: ");
						totalcount[0] += a.nextInt();
						price[0] = 400*totalcount[0];
						System.out.println("");
					}
					else if(option == 2)
					{
						System.out.print("Enter Quantity: ");
						totalcount[1] += a.nextInt();
						price[1] = 250*totalcount[1];
						System.out.println("");
					}
					else if(option == 3)
					{
						System.out.print("Enter Quantity: ");
						totalcount[2] += a.nextInt();
						price[2] = 120*totalcount[2];
						System.out.println("");
					}
					else if(option == 4)
					{
						System.out.print("Enter Quantity: ");
						totalcount[3] += a.nextInt();
						price[3] =  45*totalcount[3];
						System.out.println("");
					}
					
					else if(option == 5)
					{
						Print(totalcount,price);
					}
					
					skemenu();
					System.out.print("Enter your Option: ");
					option = a.nextInt();
					
				}while(option != 6);
				System.out.print("===== Thank you =====");
				break;
				
			}
	}
	

	
	public static void skemenu(){
		System.out.println("==========[ SKE-Menu ]==========");
		System.out.printf("1.) Steak\t %d  Bath.\n",400);
		System.out.printf("2.) Pizza\t %d Bath.\n",250);
		System.out.printf("3.) Chickens\t %d Bath.\n",120);
		System.out.printf("4.) Coke\t %d  Bath.\n",45);
		System.out.println("5.) Total ");
		System.out.println("6.) Exit ");
		System.out.printf("---------------------------------\n");
		System.out.println("");
	}
	
	public static void Print(int[] Select,int[] allprice)
	{
		System.out.println("+------ Menu ------+-- Qty --+-- Price --+");
		Printdetail(Select,allprice);
		System.out.println("+----------------------------+-----------+");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Selectoption();	
	}

}
