package inside;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class RestaurantManager {
	
static final String menufile = "data/Menu.txt";
	
	static LocalDate today = LocalDate.now();
	static LocalTime time = LocalTime.now();
	static ArrayList<String> items = new ArrayList<String>();
	static ArrayList<Double> prices = new ArrayList<Double>();
	
	public static String[] getMenuItems(){
		String[] itemsinmenu  = items.toArray(new String[items.size()]);
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

	public static void recordOrder(int[] order, double total){
		String[] menulist = getMenuItems();
		String pattern = null;
		
		int c=0;
		for(String eachmenu : menulist)
		{
			if(order[c] != 0)
			{
				pattern += String.format("|%-18s|%9.0f|\n",menulist[c],order[c]);
			}
			c++;
		}
		return String.format("Date [ "+today.getDayOfMonth()+"/"+today.getMonthValue()+"/"+today.getYear()+" ]");
		System.out.println("Date [ "+today.getDayOfMonth()+"/"+today.getMonthValue()+"/"+today.getYear()+" ]");
		System.out.println("Time [ "+time.getHour()+":"+time.getMinute()+" ]");
	}

}
