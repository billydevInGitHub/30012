package billydev.Exp026_FractionalKnapSack;

import java.util.Arrays;

public class FractionalKnapSack {
	
	
	
	class Item implements Comparable<Item>{		
		int value; 
		int weight; 
		Item(int v, int w){
		  value=v;
		  weight=w; 
		}
		@Override
		public int compareTo(Item item) {
			double r1=value*1.0/weight;
			double r2=item.value*1.0/item.weight;
			return  r1>r2?1:-1; 
		}
		
	}
	
	
	Item[] items={ new Item(100,20), new Item(60,10),new Item(120,30)};; 
    final static int  CAPACITY=50; 	


	FractionalKnapSack(){
		
	}
	
	public static void main(String[] args) {

		FractionalKnapSack napSack= new FractionalKnapSack(); 
		
		Arrays.sort(napSack.items);
		
		int tmpWeight=0; 
		int leftRoom=CAPACITY; 
		double totalValue=0;
		double tmpValue=0; 
		
		for(int i=napSack.items.length-1;i>=0;i--){
			
			tmpWeight=napSack.items[i].weight;
			tmpValue=napSack.items[i].value; 
			if(leftRoom>tmpWeight){
				totalValue+=tmpValue; 
				leftRoom-=tmpWeight; 
				System.out.println("item weight: "+tmpWeight+" item value: "+tmpValue);
			}else{
				totalValue+=leftRoom*tmpValue/tmpWeight; 
				System.out.println("item weight: "+tmpWeight+" item value: "+tmpValue+"   partially loaded!");
				break; 
			}
		}
		
		System.out.println("The total value of knapsack is:"+ totalValue) ; 

	}

}
