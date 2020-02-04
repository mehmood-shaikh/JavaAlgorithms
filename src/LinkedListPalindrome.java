
public class LinkedListPalindrome {
	static class Node{
		char data;
		Node next;
		public Node(char data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		
	}
	static Node head;
	static Node left;
	public static void main(String[] args) {
		Node head= new Node('R',null);
		head.next=new Node('a',null);
		head.next.next=new Node('a',null);
		head.next.next.next=new Node('R',null);
		//head.next.next.next.next=new Node('R',null);
		LinkedListPalindrome.head=head;
		System.out.println(isPalindrome(head));

	}

	private static boolean isPalindrome(Node right){
		System.out.println("Right :  "+right.data);
		if(right.next!=null)
			if(!isPalindrome(right.next))
				return false;
		System.out.println("Checking "+head.data+" and "+right.data);
		if(head.data==right.data){
			head=head.next;
		}else
			return false;
		
		return true;
	}

}
