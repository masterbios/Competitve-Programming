package Algo;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
 
class PhilospersStone {
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
		int dp[][];
		public void solve(InputReader in,PrintWriter out) {	
			int t = in.nextInt();
			while(t-->0) {
				int r = in.nextInt();
				int c = in.nextInt()+2;
				int a[][]=new int[r][c];
				for(int i=0;i<r;i++) {
					for(int j=1;j<=c-2;j++) {
						a[i][j]=in.nextInt();
					}
				}
				for(int i=1;i<r;i++) {
					for(int j=1;j<=c-2;j++) {
						a[i][j]+=Math.max(Math.max(a[i-1][j-1], a[i-1][j+1]), a[i-1][j]);
					}
				}
				int res = 0;
				for(int i=0;i<c;i++)res=Math.max(res, a[r-1][i]);
				out.println(res);
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
 

