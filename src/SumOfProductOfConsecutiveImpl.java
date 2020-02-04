import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;


public class SumOfProductOfConsecutiveImpl {
	
	char[] sumArr=new char[20];
	static long sum=0;
	static int divisor=0;
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
		BigInteger product=BigInteger.ONE;
		for (int i=n-1; i>=n-C&&i>0; i--){
			product=product.multiply(BigInteger.valueOf(i));
		}
		if(product.toString().length()>1.4*d)
			divisor=product.toString().length() - (int)Math.round(1.2*d);
		add(product.toString());
		//System.out.println("divisor : "+divisor);
		for (int i=n-1; i>1; i--){
			product=product.divide(BigInteger.valueOf(i));
			if(i>C){
				product=product.multiply(BigInteger.valueOf(i-C));
			}
			if(!add(product.toString())){
				break;
			}	
		}
		/*if(sum.toString().length()<=d){
			return sum.toString();
		}
		else{	*/
			return String.valueOf(sum).substring(0,d);
		//}
	}
	
	private static boolean add(String product){
		int length=product.length();
		if(length>divisor){
			sum = sum + Long.parseLong(product.substring(0,length-divisor));
			//System.out.println("sum : "+sum);
			return true;
		}else{
			return false;
		}
		
	}
}
