import java.util.*;
import java.lang.*;

public class Knapsack01 {
	public static void main(String[] args) {
		System.out.println("Enter the capacity of the knapsack: ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		//System.out.println("Size is " + size);
		System.out.println("Enter the number of items: ");
		int n= sc.nextInt();
		//System.out.println("Number of item is "+ n);
		int[] valueArr = new int[n+1];
		valueArr[0] = 0;
		int[] weightArr = new int[n+1];
		weightArr[0] = 0;
		
		for(int i=1; i<=n; i++) {
			System.out.println("Enter the value of item no."+ i+": ");
			valueArr[i] = sc.nextInt();
			System.out.println("Enter the weight of the item: ");
			weightArr[i] = sc.nextInt();
		}
		int[][] solTable = new int[(n+1)][(size+1)]; 
		//System.out.println("The size of the solTable " + solTable.length);
		for(int i=0; i<=size; i++) {
			solTable[0][i] = 0;
		}
		for(int i=0; i<= n; i++) {
			solTable[i][0] = 0;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j= 0; j<=size; j++) {
				if(weightArr[i]<= j) {
					if(valueArr[i] + solTable[i-1][j-weightArr[i]] > solTable[i-1][j]) {
						solTable[i][j] = valueArr[i]+ solTable[i-1][j-weightArr[i]];
					}
					
					else {
						solTable[i][j] = solTable[i-1][j];
					}
				}
				else {
					solTable[i][j] = solTable[i-1][j];
				}
			}
		}
		
		for(int i =0; i<=n; i++) {
			for(int j=0; j<=size ; j++) {
				String text = String.format("%2d", solTable[i][j]);
				System.out.print(text + " ");
			}
			System.out.println();
		}
	}
}
