package fcstockers;


	import java.util.Scanner;

import fcstockers.BinarySearch;
import fcstockers.MergeSort;

	public class Stockers {
		
		double[] share_price;
		boolean[] price_track;
		double[] sorted_array;

		public void stock() {

			int N; // created a variable to store the no. companies
			int input;

			System.out.println("enter the no of companies");
			
			Scanner sc = new Scanner(System.in);
			
			N = sc.nextInt();
			
			share_price = new double[N];
			price_track = new boolean[N];
			sorted_array = new double[N];
			
			for (int i = 0; i < N; i++) {
				System.out.println("Enter current stock price of the company " + (i + 1));
				share_price[i] = sc.nextDouble(); // taking the input from the console
				System.out.println("Whether company's stock price rose today compare to yesterday?");
				price_track[i] = sc.nextBoolean();

			}
			sorted_array = MergeSort.sort(share_price, 0, share_price.length -1);
			
			System.out.println();
			
			while (true) {
				System.out.println("-----------------------------------------------");
				System.out.println("Enter the operation that you want to perform");
				System.out.println("1. Display the companies stock prices in ascending order");
				System.out.println("2. Display the companies stock prices in descending order");
				System.out.println("3. Display the total no of companies for which stock prices rose today");
				System.out.println("4. Display the total no of companies for which stock prices declined today");
				System.out.println("5. Search a specific stock price");
				System.out.println("6. Press 0 to exit");
				System.out.println("-----------------------------------------------");

				input = sc.nextInt();

				if (input == 1)
				{
					
						System.out.println("Stock prices in ascending order are :");
						MergeSort.printArray(sorted_array, 0, sorted_array.length - 1, input);
						System.out.println();
					
				}
				
				else if (input ==2) {
					System.out.println("Stock prices in descending order are :");
					MergeSort.printArray(sorted_array, 0, sorted_array.length - 1, input);
					System.out.println();
					System.out.println();
				}
				
				else if (input == 3) {
					
					int count = 0;

					// Display the total no of companies for which stock prices rose today
					
					for(int i = 0 ; i < price_track.length; i++)
					{
						if(price_track[i])
							count++;
					}
					
					System.out.println("Total no of companies whose stock price rose today : " + count);
	                 System.out.println();
				} 
				else if (input == 4) {

					// Display the total no of companies for which stock prices declined today
					
					int count = 0;
					
					for(int i = 0 ; i < price_track.length; i++)
					{
						if(!price_track[i])
							count++;
					}
					
					System.out.println("Total no of companies whose stock price declined today : " + count);
					System.out.println();
				}

				else if (input == 5) {

					// Search a specific stock price
					
					System.out.println("Enter the key value ");
					double key = sc.nextDouble();
					
			
					int result =  BinarySearch.binarySearchImplementation(sorted_array, 0, sorted_array.length, key);
					if(result >= 0) 
						System.out.println("Stock of value " + key + " is present");
					else //if(input == 0)
						System.out.println("Value not found");
						
					System.out.println();
					
				} 
				else if(input == 0) {
					
					System.out.println("Exited successfully");
					System.exit(0);
					// Press 0 to exit
				}
				
			}
		}


}
