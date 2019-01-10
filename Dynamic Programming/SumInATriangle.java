import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
 
class SumInATriangle {
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
				int a[][]= new int[n][n+2];
				for(int i=0;i<n;i++) {
					for(int j=1;j<=i+1;j++) {
						a[i][j]=in.nextInt();
					}
				}
				for(int i=1;i<n;i++) {
					for(int j=1;j<=n;j++) {
						a[i][j]+=Math.max(a[i-1][j], a[i-1][j-1]);
					}
				}
				int res = 0;
				for(int i=0;i<n+2;i++)res=Math.max(res, a[n-1][i]);
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
 
