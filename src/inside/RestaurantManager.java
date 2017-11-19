package inside;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManager {
	
static String menufile = "src/inside/data/menu.txt";
	
	static ArrayList<String> items = new ArrayList<>();
	static ArrayList<Double> prices = new ArrayList<>();
	static ArrayList<Object> menu = new ArrayList<>();
	static ArrayList<Integer> choicepool = new ArrayList<>();
	static ArrayList<Integer> quanpool = new ArrayList<>();
	static ArrayList<Object> order = new ArrayList<>();
	static double total;
	
	public static void readMenu(){
		 
		try 
		{
			Scanner reader = new Scanner(new File(menufile));
			int id = 1;
			while(reader.hasNextLine())
			{
				String[] tempfile = reader.nextLine().replaceAll(";", "  ").split("  ");
				if(!tempfile[0].isEmpty())
				{
					if(!tempfile[0].equals("#"))
					{
						menu.add(String.format("[%d] %12s | %10.2f |",id,tempfile[0],Double.parseDouble(tempfile[1])));
						items.add(tempfile[0]);
						prices.add(Double.parseDouble(tempfile[1]));
						id++;
					}
				}
			}
			
			reader.close();
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("Could not access file !!");
			System.exit(1);
		}
		
	}
	
	public static String[] getMenuItems(){
		String[] itemsinmenu  = new String[items.size()];
		
		for(int c=0 ; c<itemsinmenu.length ; c++)
		{
			itemsinmenu[c] = items.get(c); 
		}
		
		return itemsinmenu;
	}
	
	public static double[] getPrices(){
		
		double[] pricesinmenu = new double[prices.size()];
		
		for(int i=0 ; i<pricesinmenu.length ; i++)
		{
			pricesinmenu[i] = prices.get(i);
		}
		
		return pricesinmenu;
	}

	public static void recordOrder(int choice, int quan){
		String[] itemsMenu = getMenuItems();
		double[] pricesMenu = getPrices();
		
		boolean check = false;
		
		for(int c = 0 ; c<choicepool.size(); c++)
		{
			if(choicepool.get(c) == choice){
				int each = quanpool.get(c);
				quanpool.set(c,each+quan);
				order.set(c,String.format("| %12s | %4d | %8.2f |",itemsMenu[choice-1],quanpool.get(c),(pricesMenu[choice-1]*quanpool.get(c))));
				check = true;
				total += pricesMenu[choice-1]*quan;
			}
		}
		if(check == false){
			choicepool.add(choice);
			quanpool.add(quan);
			order.add(String.format("| %12s | %4d | %8.2f |",itemsMenu[choice-1],quan,(pricesMenu[choice-1]*quan)));
			total += pricesMenu[choice-1]*quan;
		}
	}

	public static void menuList(){

		for(int c=0 ; c<menu.size() ; c++)
		{
			System.out.println(menu.get(c));
		}
		
	}
	
	public static void printOrder(){
		for(int c=0 ; c<order.size() ; c++)
		{
			System.out.println(order.get(c));
		}
		System.out.printf("| %12s |  %14.2f |\n","Total",total);
	}


}
