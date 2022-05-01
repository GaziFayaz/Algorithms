import java.util.*;
import java.lang.*;

public class lcs {
	static void printLcs(char x[], char dir[][], int n1, int n2){
		    if(n1==0 || n2== 0)return;
		    else{
		        if(dir[n1][n2] == ' '){
		            printLcs(x, dir, n1-1, n2-1);
		            System.out.print(x[n1]+ " "); 
		         
		        }

		        else{
		            if(dir[n1][n2] == 'u'){
		                printLcs(x, dir, n1-1, n2);
		            }
		            else{
		                printLcs(x, dir, n1, n2-1);
		            }
		        }
		    }
		}
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

		    int n1, n2;
		    System.out.print("Enter the length of first string: ");
		    n1 = sc.nextInt();
		    System.out.print("Enter the length of second string: "); 
		    n2 = sc.nextInt();
		    char[] x = new char[n1+1];
		    char[] y = new char[n2+1];
		    x[0] = y[0] = 0;
		    System.out.print("Enter the characters of first string: ");
		    for(int i=1; i<=n1; i++){
		        x[i] = sc.next().charAt(0);
		    }
		    System.out.print("Enter the characters of second strings: ");
		    for(int i=1; i<=n2; i++){
		        y[i] = sc.next().charAt(0);
		    }
		    int[][] table = new int[n1+1][n2+1];
		    char[][] dir = new char[n1+1][n2+1];;
		    for(int i=0; i<=n1; i++){
		        table[i][0] = 0;
		        dir[i][0] = 0;
		    }
		    for(int i=0; i<=n2; i++){
		        table[0][i] = 0;
		        dir[0][i] = 0;
		    }

		    for(int i =1; i<=n1; i++){
		        for(int j=1; j<=n2; j++){
		            if(x[i] == y[j]){
		                table[i][j] = table[i-1][j-1] + 1;
		                dir[i][j] = ' ';
		            }

		            else{
		                if(table[i-1][j] >= table[i][j-1]){
		                    table[i][j] = table[i-1][j];
		                    dir[i][j] = 'u';
		                }
		                else{
		                    table[i][j] = table[i][j-1];
		                    dir[i][j] = 'l';
		                }
		            }
		        }
		    }
		    System.out.println("The longest common subsequence is: ");
		    printLcs(x, dir, n1, n2);

		}

}
