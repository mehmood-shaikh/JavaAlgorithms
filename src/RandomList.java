import java.util.Random;


public class RandomList {

	public static void main(String[] args) {
		int[] arr={1, 2,3,4,5};
		int n=5;
		int[] fin=getR(arr,n);
		for(int i=0;i<n;i++){
			System.out.print(fin[i]+"  ");
		}
	

	}

	public static int[] getR(int[] arr,int n){
		int[] finalArr=new int[n];
		int max,min=0,l=arr.length;
		Random r= new Random();
		for(int i=0;i<n;i++){
			 max=l-n+i;
			min=(int)(r.nextInt(max-min+1))+min;
			finalArr[i]=arr[min];
			min++;
		}
		return finalArr;
	}
}
