import java.io.PrintWriter;
import java.util.Scanner;

public class RMQwithpointUpdate {

	static int tree[];
	static int a[];
  
	public static void main(String[] args) {
  
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int q = in.nextInt();
		a = new int[n];
		tree = new int[4*n];
    
		for(int i=0;i<n;i++)a[i] = in.nextInt();
		build(0,0,n - 1);
	
		for(int i=1;i<=q;i++) {
			char t = in.next().charAt(0);
			if(t=='u') {
				int idx = in.nextInt();
				int val = in.nextInt();
				update(0,0,n - 1,idx-1,val);
			} 
			else {
				int l = in.nextInt();
				int r = in.nextInt();
				out.println(query(0,0, n - 1, l-1,r - 1));
 			}
		}
		out.close();
	}
	public static void build(int node,int start,int end) {
		if(start==end) {
			tree[node] = a[start];
		}
		else {
			int mid = (start+end)/2;
			build(2*node + 1,start,mid);
			build(2*node+2,mid+1,end);
			tree[node] = Math.min(tree[node*2 + 1],tree[node*2+2]);
		}
	}
	public static void update(int node,int start,int end,int idx,int val) {
		if(start==end) {
			tree[node]=val;
			a[idx]=val;
		}
		else {
			 int mid = (start+end)/2;
			 if(start<=idx && idx<=mid) {
				 update(node*2 + 1,start,mid,idx,val);
			 }
			 else {
				 update(node*2+2,mid+1,end,idx,val);
			 }
			 tree[node] = Math.min(tree[2*node + 1],tree[2*node+2]);
		}
	}
	public static int query(int node,int start,int end,int l,int r) {
		if(r<start || l>end) {
			return Integer.MAX_VALUE;
		}
		if(l<=start && end<=r) {
			return tree[node];
		}
		int mid = (start+end)/2;
		int x = query(2*node +1,start,mid,l,r);
		int y = query(2*node+2,mid+1,end,l,r);
		return Math.min(x,y);
	}
}
