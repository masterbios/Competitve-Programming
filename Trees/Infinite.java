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
public class Infinite{
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
		private static String s0 = "What are you doing at the end of the world? Are you busy? Will you save us?";
		private static String s1 = "What are you doing while sending \"";
		private static String s2 = "\"? Are you busy? Will you send \"";
		private static String s3 = "\"?";
		static long a[];
		static final int max = (int) 1e5+5;
		public static void solve(InputReader in,PrintWriter out) {	
			pre();
			int q = in.nextInt();
			while(q-->0) {
				int n = in.nextInt();
				long k = in.nextLong();
				out.print(ans(n,k-1));
			}
		}
		public static char ans(int n , long k) {
			if(k>=a[n]) return '.';
			if( n==0) return s0.charAt((int)k);
			
			if(k<s1.length())return s1.charAt((int)k);
			k-=s1.length();

			if(k<a[n-1])return ans(n-1,k);
			k-=a[n-1];

			if(k<s2.length())return s2.charAt((int)k);
			k-=s2.length();

			if(k<a[n-1])return ans(n-1,k);
			k-=a[n-1];

			if(k<s3.length())return s3.charAt((int)k);
			return '.';
		}
		public static void pre() {
			a=new long[max];
			a[0]=s0.length();
			for(int i=1;i<a.length;i++) {
				a[i] = Math.min((s1.length() + a[i-1] + s2.length() + a[i-1] + s3.length()), (long) 1e18);
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
