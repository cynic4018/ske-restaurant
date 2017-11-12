package inside;
import java.util.Scanner;

/**
 * The Restaurant class.
 * @author Katapon Sinpunyawong
 */
public class Restaurant {
		
		static Scanner a = new Scanner(System.in);
		static	int choice=0;
		static  String sc;
		static	int quan;
		static	int quan2;
		static	int quan3;
		static	int quan4;
		static	int cp=0;
		static	int cch=0;
		static	int cc=0; 
		static 	int cs=0;
		static	int spizza=0;
		static	int schick=0;
		static	int scoke=0;
		static 	int ssteak=0; 
	

		
		public static int Pizza(){
			spizza = cp*250;
			return spizza;
		}
		public static int Chickens(){
			schick = cch*120;
			return schick;
		}
		public static int Coke(){
			scoke = cc*45;
			return scoke;
		}
		public static int Steak(){
			ssteak = cs*400;
			return ssteak;
		}
		

		public static void Cal(){
			int psteak = Steak();
			int ppizza = Pizza();
			int pchick = Chickens();
			int pcoke = Coke();
			
			
			if(psteak!=0)
			{
				System.out.printf("|%-18s|%9d|%11d|\n","Steak",cs,psteak);
			}
			if(ppizza!=0)
			{
				System.out.printf("|%-18s|%9d|%11d|\n","Pizza",cp,ppizza);
			}
			if(pchick!=0)
			{
				System.out.printf("|%-18s|%9d|%11d|\n","Chickens",cch,pchick);
			}
			if(pcoke!=0)
			{
				System.out.printf("|%-18s|%9d|%11d|\n","Coke",cc,pcoke);
			}
			
			System.out.println("+----------------------------+-----------+");
			System.out.printf("|%-28s|%11d|\n","Total",pcoke+pchick+ppizza+psteak);
			System.out.println("+----------------------------+-----------+");
		}

		public static void sker(){
			System.out.println("==========[ optin ]==========");
			System.out.printf("1.) Steak\t %d Bath.\n",400);
			System.out.printf("2.) Pizza\t %d Bath.\n",250);
			System.out.printf("3.) Chickens\t %d  Bath.\n",120);
			System.out.printf("4.) Coke\t %d  Bath.\n",45);
			System.out.println("5.) Total ");
			System.out.println("6.) Exit ");
			System.out.printf("-----------------------------------------------\n");
			System.out.println("");
		}
		public static void main(String[] args) {		
			System.out.println("--------- Welcome to SKE Restaurant ---------");
			System.out.println("");
			
			do{
				
				if(choice==1)
				{
					System.out.print("Enter Quantity: ");
					quan = a.nextInt();
					cs+=quan;
					ssteak = Steak();
					System.out.println("");
				}	
				if(choice==2)
				{
					System.out.print("Enter Quantity: ");
					quan2 = a.nextInt();
					cp+=quan2;
					spizza = Pizza();
					System.out.println("");
				}
				else if(choice==3)
				{
					System.out.print("Enter Quantity: ");
					quan3 = a.nextInt();
					cch+=quan3;
					schick = Chickens();
					System.out.println("");
				}
				else if(choice==4)
				{
					System.out.print("Enter Quantity: ");
					quan4 = a.nextInt();
					cc+=quan4;
					scoke = Coke();
					System.out.println("");
				}
				else if(choice==5)
				{
					System.out.println("+------ Menu ------+-- Qty --+-- Price --+");
					Cal();
					System.out.println("");
				}
				sker();
				System.out.print("Enter your Option: ");
				choice = a.nextInt();
				
			}while(choice!=6);
			System.out.print("===== Thank you =====");
		}
	

}
