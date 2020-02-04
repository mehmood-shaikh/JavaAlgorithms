import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;


public class IncrSumOfProductOfConsecutive {
	public static void main(String args[]){
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		/*System.out.println("What is the value of n? ");
		int n=scanner.nextInt();
		System.out.println("What is the value of C? ");
		int C= scanner.nextInt();
		System.out.println("What is the number of digits? ");
		int d= scanner.nextInt();*/ 
		long time = System.nanoTime();
		String result=sum(1,1,10);
        time = System.nanoTime() - time;
        System.out.println("Result: " + result + "\nTime in nanoseconds: " + time);
		
		scanner.close();
	}

	private static String sum(int n, int C, int d) {
		BigInteger sum=BigInteger.ZERO, product=BigInteger.ONE;
		
		if(C<1){
			return("0");
		}
		
		for (int i=1; i<n; i++){	
			if(i>C){//check if index is greater than  C
				//divide by index-Cth element as the product should be of C preceding elements
				product=product.divide(BigInteger.valueOf(i-C));
			}
			//multiply by index 
			product=product.multiply(BigInteger.valueOf(i));
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
