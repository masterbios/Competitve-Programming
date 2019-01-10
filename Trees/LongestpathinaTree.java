package Algo;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
class LongestpathinaTree {
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
		static boolean visited[];
		private static LinkedList<Integer>adj[];
		static int m1;
		static int m2;
		static int total;
		public void solve(InputReader in,PrintWriter out) {	
			int nodes = in.nextInt();
			int edge = nodes-1;
			visited = new boolean [nodes];
			Graph g = new Graph(nodes);
			for(int i=1;i<=edge;i++) {
				int v = in.nextInt();int w = in.nextInt();
				adj[v-1].add(w-1);adj[w-1].add(v-1);
			}
			for(int i=0;i<nodes;i++) {
				out.println(adj[i]);
			}
			dfs(0);
			out.println(total);
		}
		public int dfs(int node) {
			int m ,m1=-1,m2=-1;
			visited[node]=true;
			Iterator<Integer>it = adj[node].iterator();
			Integer i;
			while(it.hasNext()) {
				i=it.next();
				if(!visited[i]) {
				m=dfs(i);
				
				System.out.println(i+" "+m);
				if(m>=m1) {
					m2=m1;
					m1=m;
				}
				else if(m>m2) {
					m2=m;
				}
			}
		}
		total=Math.max(total, m1+m2+2);
		return m1+1;
	}
		
		static class Graph{
			Graph(int v){
				V = v;
				adj=new LinkedList[v];
				for(int i=0;i<V;i++)adj[i] = new LinkedList();
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