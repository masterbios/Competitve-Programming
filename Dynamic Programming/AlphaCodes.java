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
 
class AlphaCodes {
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
		public void solve(InputReader in,PrintWriter out) {	
			String s = in.next();
			while(!s.equals("0")) {
				char a[]=new char[s.length()+1];
				for(int i=1;i<=s.length();i++)a[i]=s.charAt(i-1);
				int dp[]=new int[s.length()+1];
				dp[0]=dp[1]=1;
				for(int i=2;i<s.length()+1;i++) {
					if(a[i]=='0') {
						dp[i]=dp[i-2];
					}
					else if(a[i]<='6') {
						if(a[i-1]=='1'||a[i-1]=='2')dp[i]=dp[i-1]+dp[i-2];
						else dp[i]=dp[i-1];
					}
					else {
						if(a[i-1]=='1'|| a[i-1]=='2')dp[i]=dp[i-1]+dp[i-2];
						else dp[i]=dp[i-1];
					}
				}
				out.println(dp[dp.length-1]);
				s = in.next();
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