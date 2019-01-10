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
 
class PrincessFarida {
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
		// MAX SUM WITH NO ADJACENT ELEMENTS
		public void solve(InputReader in,PrintWriter out) {	
			int t = in.nextInt();
			for(int j=1;j<=t;j++) {
				int n = in.nextInt();
				int a[] = new int[n+1];
				for(int i=0;i<n;i++)a[i]=in.nextInt();
				long inc = (long)a[0];
				long exe = 0;
				long temp = 0;
				for(int i=1;i<n;i++) {
					temp = inc;
					inc = Math.max(a[i]+exe, inc);
					exe = temp;
				}
				out.println("Case "+j+": "+inc);
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
 
