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
 
class StringMerging {
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
				int n = in.nextInt();
				int m = in.nextInt();
				String one = in.next();
				String two = in.next();
				StringBuilder sb = new StringBuilder();
				sb.append(one.charAt(0));
				for(int i=1;i<n;i++)if(one.charAt(i)!=one.charAt(i-1))sb.append(one.charAt(i));
				one=sb.toString();
				//out.println(sb.toString());
				sb.setLength(0);
				sb.append(two.charAt(0));
				for(int j=1;j<m;j++)if(two.charAt(j)!=two.charAt(j-1))sb.append(two.charAt(j));
				two=sb.toString();
				//out.println(sb.toString());
				//out.print(one+" "+two);
				n=one.length();
				m=two.length();
				out.println(res(one,two,n,m));
			}
		}
		public int res(String s1,String s2,int n,int m) {
			dp=new int [n+1][m+1];
			for(int i=0;i<=n;i++) {
				for(int j=0;j<=m;j++) {
					if(i==0)dp[i][j]=j;
					else if(j==0)dp[i][j]=i;
					else if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=1+(Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]));
					else dp[i][j]=1+(Math.min(dp[i][j-1], dp[i-1][j]));
				}
			}
			return dp[n][m];
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
 
