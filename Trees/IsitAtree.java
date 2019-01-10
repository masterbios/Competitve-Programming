package Algo;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
class IsitAtree{
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
		private static int V;
		private static LinkedList<Integer> adj[];
		public static void solve(InputReader in,PrintWriter out) {	
			int node = in.nextInt();
			int edge = in.nextInt();
			Graph g = new Graph(node);
			for(int i=0; i<edge ; i++) {
				int v = in.nextInt();
				int w = in.nextInt();
				added(v,w);
			}
			if(isTree())
				out.println("YES");
			else
				out.println("NO");
			
		}
		public static void added(int v,int w) {
			adj[v-1].add(w-1);
			adj[w-1].add(v-1);
		}	
		public static Boolean isTree() {
			Boolean visited[]=new Boolean[V];
			Arrays.fill(visited, false);
			if(isCycle(0,visited,-1)) return false;
			for(int i=0; i<V; i++) {
				if(!visited[i]) return false;
			}
			return true;
		}
		public static Boolean isCycle(int v, Boolean visited[], int parent) {
			visited[v]=true;
			Integer i;
			Iterator<Integer> it = adj[v].iterator();
			while(it.hasNext()) {
				i=it.next();
				if(!visited[i]) {
					if(isCycle(i,visited,v)) return true;
				}
				else if(i!=parent)	return true;
			}
			return false;
		}
		
		static class Graph{
			
			Graph(int v){
				V=v;
				adj=new LinkedList[v];
				for(int i=0 ; i<v ; i++) {
					adj[i]=new LinkedList();
				}
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