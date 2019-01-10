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
 
class LongestPalindromicSubstring {
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
			int n = in.nextInt();
			String s = in.next();
			out.println(res(s,n));
		}
		public int res(String s,int n ) {
			dp=new int[n][n];
			for(int i=0;i<n;i++)dp[i][i]=1;
			for(int length=2;length<=n;length++) {
				for(int i=0;i<n-length+1;i++) {
					int j=i+length-1;
					if(s.charAt(i)==s.charAt(j)&& length==2) {
						dp[i][j]=2;
					}
					else if(s.charAt(i)==s.charAt(j)) {
						dp[i][j]=dp[i+1][j-1]+2;
					}
					else {
						dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
					}	
				}
			}
			return dp[0][n-1];
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
 

