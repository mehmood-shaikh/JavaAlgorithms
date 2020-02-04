import java.util.LinkedList;
import java.util.Queue;


public class AVL {
	Node root;
	
	class Node{
		Node left;
		Node right;
		int x,y;
		int key;
		int height;
		Node(int key){
			this.key=key;
			height=1;
		}
		@Override
		public String toString() {
			return "Node [left=" + left + ", right=" + right + ", x=" + x
					+ ", y=" + y + ", key=" + key + ", height=" + height + "]";
		}
		
	}
	void addNode(int key){

		
		if(root == null){
			root=new Node(key);
		}
		else{
			display();
			root=addNode(root,key);
		}
	}
	Node addNode(Node parent,int key){
		if(parent.key<key){
			if(parent.right!=null)
				parent.right=addNode(parent.right,key);
			else
				parent.right=new Node(key);
			parent.height=getHeight(parent);
		}
		else if(parent.key>key){
			if(parent.left!=null)
				parent.left=addNode(parent.left,key);
			else
				parent.left=new Node(key);
			parent.height=getHeight(parent);	
		}
		else if(parent.key==key){
			return parent;
		}
				
		if(isBal(parent)>=2){
			if(isBal(parent.right)>=1)
				return rotateLeft(parent);
			else if(isBal(parent.right)<=-1){
				parent.right= rotateRight(parent.right);
				return rotateLeft(parent);
			}
		}
		else if(isBal(parent)<=-2){
			if(isBal(parent.left)<=-1)
				return rotateRight(parent);
			else if(isBal(parent.left)>=1){
				parent.left=rotateLeft(parent.left);
				//display();
				return rotateRight(parent);
			}
		}
		return parent;
	}
	
	Node rotateLeft(Node y){
		Node x=y.right;
		Node t=x.left;
		x.left=y;
		y.right=t;
		y.height=getHeight(y);
		x.height=getHeight(x);
		return x;
	}
	
	Node rotateRight(Node y){
		Node x=y.left;
		Node t=x.right;
		y.left=t;
		x.right=y;
		y.height=getHeight(y);
		x.height=getHeight(x);
		return x;
	}
	
	int getHeight(Node root){
		int l=0,r=0;
		if(root.left!=null)
			l=root.left.height;
		if(root.right!=null)
			r=root.right.height;
		return Math.max(l, r)+1;
	}
	
	int isBal(Node root){
		int l=0,r=0;
		if(root.left!=null)
			l=root.left.height;
		if(root.right!=null)
			r=root.right.height;
		return r-l;
	}
	
	void display(){
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		System.out.println("root : "+root);
		int d=root.height*4;
		System.out.println();
		int[][] pr=new int[root.height][d];
		root.x=0;
		root.y=(int)root.height*3/2;
		pr[0][root.y]=root.key;
		while(!q.isEmpty()){
			Node n=q.poll();
			pr[n.x][n.y]=n.key;
			
			if(n!=null && n.left!=null){
				n.left.x=n.x+1;
				n.left.y=n.y-n.left.height;
				q.add(n.left);
			}
			if(n!=null && n.right!=null){
				n.right.x=n.x+1;
				n.right.y=n.y+n.right.height;
				q.add(n.right);
			}
			
		}
		for(int i=0;i<root.height;i++){
			for(int j=0;j<d;j++){
				if(pr[i][j]==0)
					System.out.print("  ");
				else{
					if(pr[i][j]<10)
						System.out.print(" ");
					System.out.print(pr[i][j]);
				}
					
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		AVL a=new AVL();
		a.addNode(6);
		a.addNode(3);
		a.addNode(8);
		a.addNode(2);
		a.addNode(1);
		a.addNode(4);
		a.addNode(9);
		a.addNode(12);
		a.addNode(7);
		a.addNode(1);
		a.addNode(21);
		a.addNode(11);
		a.addNode(15);
		a.addNode(62);
		a.addNode(32);
		try{
		a.display();
		}catch(Exception e ){
			e.printStackTrace();
			System.out.println(a.root);
		}

	}

}
