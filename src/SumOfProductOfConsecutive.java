import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;


public class SumOfProductOfConsecutive {
	public static void main(String args[]){
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		/*System.out.println("What is the value of n? ");
		int n=scanner.nextInt();
		System.out.println("What is the value of C? ");
		int C= scanner.nextInt();
		System.out.println("What is the number of digits? ");
		int d= scanner.nextInt();*/ 
		long time = System.nanoTime();
		String result=sum(10000000,200,10);
        time = System.nanoTime() - time;
        System.out.println("Result: " + result + "\nTime in nanoseconds: " + time);
		
		scanner.close();
	}

	private static String sum(int n, int C, int d) {
		BigInteger sum, product=BigInteger.ONE;
		
		//find the value product function for nth integer
		for (int i=n-1; i>=n-C&&i>0; i--){
			product=product.multiply(BigInteger.valueOf(i));
		}
		sum=product;
		for (int i=n-1; i>1; i--){
			//divide by index as the product should be of C preceding elements
			product=product.divide(BigInteger.valueOf(i));
			if(i>C){//check if index is greater than  C
				//multiply by index-Cth element 
				product=product.multiply(BigInteger.valueOf(i-C));
			}
			sum=sum.add(product);			
		}
		if(sum.toString().length()<=d){
			return sum.toString();
		}
		else{	
			return sum.toString().substring(0,d);
		}
	}
}
