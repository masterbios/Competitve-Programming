package dfs;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
public class Dsu{
	public static void main(String[] args) throws java.lang.Exception{
		InputStream inputstream = System.in;
		OutputStream outputstream = System.out;
		InputReader in = new InputReader(inputstream);
		PrintWriter out = new PrintWriter(outputstream);
		Call one = new Call();
		one.solve(1,in,out);
		out.close();
	}
	static class Call {
		private int distinct[];
		private int size[];
		//private int min[];
		public void solve(int testNumbers, InputReader in,PrintWriter out) {	
			int n = in.nextInt();
			int m = in.nextInt();
			long sum = 0;
			distinct = new int[n+1];
			size= new int [n+1];
		//	min = new int[n+1];
			initialize(n);
			/*for(int i=1;i<=n;i++ ) {
				min[i]=in.nextInt();
			}*/
			for(int i=1;i<=m;i++) {
				union(in.nextInt(),in.nextInt());
			}
			for(int i=1;i<=n;i++) {
				//out.print(distinct[i]+" ");
				if(distinct[i]==i)sum+=1;
			}
			out.println(sum);
		}
		public void union(int nodeA,int nodeB) {
			int rootA=findRoot(nodeA);
			int rootB=findRoot(nodeB);
			if(rootA!=rootB) {
				if(size[rootA]<size[rootB]) {
					size[rootB]+=size[rootA];
					distinct[rootA]=distinct[rootB];
					//min[rootB]=Math.min(min[rootA], min[rootB]);
				}
				else{
					size[rootA]+=size[rootB];
					distinct[rootB]=distinct[rootA];
					//min[rootA]=Math.min(min[rootA], min[rootB]);
				}
			}
		}
		public int findRoot(int node) {
			while(node!=distinct[node]) {
				distinct[node]=distinct[distinct[node]];
				node=distinct[node];
			}
			return node;
		}
		public void initialize(int n) {
			for(int i=1;i<=n;i++) {
				distinct[i]=i;
				size[i]=1;
			}
		}
	}
		
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader (stream),32768);
			tokenizer = null;
		}
		public String next() {
				while(tokenizer == null || !tokenizer.hasMoreElements()) {
					try {
						tokenizer = new StringTokenizer(reader.readLine());
					}
					catch(IOException e) {
						throw new RuntimeException(e);
					}
				}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}


