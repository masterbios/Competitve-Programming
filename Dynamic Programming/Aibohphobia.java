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
 
class Aibohphobia {
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
		// LCS Based Solution (faster) (time-0.91)
		public void solve(InputReader in,PrintWriter out) {	
			int t = in.nextInt();
			while(t-->0) {
				String s = in.next();
				int len = s.length();
				StringBuilder sb = new StringBuilder(s);
				sb.reverse();
				String x = sb.toString();
				out.println(len-lcs(s.toCharArray(),x.toCharArray(),len));
			}
		}
		public int lcs(char a[],char b[],int len) {
			int dp[][] = new int[len+1][len+1];
			for(int i=0;i<=len;i++) {
				for(int j=0;j<=len;j++) {
					if(i==0||j==0)dp[i][j]=0;
					else if(a[i-1]==b[j-1])dp[i][j]=dp[i-1][j-1]+1;
					else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			return dp[len][len];
		}
		/* An normal dp table based solution (time-1.15sec)
		 * public void solve(InputReader in,PrintWriter out) {	
			int t = in.nextInt();
			while(t-->0) {
				String s = in.next();
				out.println(minchar(s.toCharArray()));
			}
		}
		public int minchar(char a[]) {
			int n = a.length;
			int i,j;
			int dp[][] = new int[n][n];
			for(int len=1;len<n;len++) {
				for(i=0,j=len;j<n;i++,j++) {
					if(a[i]==a[j])dp[i][j]=dp[i+1][j-1];
					else if(a[i]!=a[j])dp[i][j]=(Math.min(dp[i+1][j], dp[i][j-1])+1); 
				}
			}
			return dp[0][n-1];
		}*/
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