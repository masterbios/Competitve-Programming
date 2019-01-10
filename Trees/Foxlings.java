package Algo;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
class Foxlings{
	public static void main(String[] args) throws java.lang.Exception{
		InputStream inputstream = System.in;
		OutputStream outputstream = System.out;
		InputReader in = new InputReader(inputstream);
		PrintWriter out = new PrintWriter(outputstream);
		Call one = new Call();
		one.solve(in,out);
		out.close();
	}
	static class Call {
		private Map<Integer,Integer> visit;
		private long co ;
		public void solve(InputReader in,PrintWriter out) {	
			visit=new HashMap<Integer,Integer>();
			int n = in.nextInt();
			int m = in.nextInt();
			 co = (long)n;
			for(int i=1;i<=m;i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				if(!visit.containsKey(a)) visit.put(a, a);
				if(!visit.containsKey(b)) visit.put(b, b);
				union(a,b);
			}
			out.println(co);
		}
		public int findroot(int node) {
			while(node!=visit.get(node)) {
				visit.put(node, visit.get(visit.get(node)));
				node=visit.get(node);
			}
			return node;
		}
		public void union(int a,int b) {
			int rootA=findroot(a);
			int rootB=findroot(b);
			if(rootA!=rootB) {
				co--;
				visit.put(rootB, rootA);
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
 
