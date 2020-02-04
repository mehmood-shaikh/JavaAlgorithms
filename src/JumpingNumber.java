import java.util.LinkedList;
import java.util.Queue;


public class JumpingNumber {

	public static void main(String[] args) {
		int n= 2000;
		Queue<Integer> q=new LinkedList<Integer>();
		System.out.print(0+ " ");
		for(int i=1;i<=n && i<=9;i++){
			q.add(i);
			System.out.print(i+ " ");
		}
		if(n>=10){
			while(!q.isEmpty()){
				int i = q.remove();
				int jn;
				if(i%10==9){
					jn=i*10+8;
					if(jn<n){
						q.add(jn);
						System.out.print(jn+ " ");
					}
				}
				else{
					if(i%10!=0){
						jn=i*10+i%10-1;
						if(jn<n){
							q.add(jn);
							System.out.print(jn+ " ");
						}
					}
					jn=i*10+i%10+1;
					if(jn<n){
						q.add(jn);
						System.out.print(jn+ " ");
					}		
				}
			}
		}
	}

}
