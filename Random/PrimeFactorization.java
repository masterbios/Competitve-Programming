import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class PrimeFactorization {
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
		int primelist[];
		public void solve(InputReader in,PrintWriter out) {	
			long s = System.currentTimeMillis();
			Seive();
			int number = 0;
			int i = 1;
			while(factorization(number)<500) {
				number+=i;
				i++;
			}
			out.println(number);
			long e = System.currentTimeMillis();
			out.println(e-s+"ms");
		}
		public int factorization(int num) {
			int n = 1;
			int pow;
			int remain = num;
			for(int i=0;i<primelist.length;i++) {
				if(primelist[i]*primelist[i]>num)return n*2;
				pow = 1;
				while(remain%primelist[i]==0) {
					pow++;
					remain/=primelist[i];
				}
				n*=pow;
				if(remain == 1)return n;
			}
			return n;
		}
		public int divisor(int num) {
			int count = 0;
			int sqrt = (int)Math.sqrt(num);
			for(int i=1;i<=sqrt;i++) {
				if(num%i==0)count+=2;
			}
			if(sqrt*sqrt==num)count--;
			
			return count;
		}
		public void Seive() {
			boolean prime[]=new boolean[750001];
			Arrays.fill(prime, true);
			for(int i=2;i*i<=75000;i++) {
				if(prime[i]==true) {
					for(int j=i*2;j<=75000;j+=i) {
						prime[j]=false;
					}
				}
			}
			List <Integer> list = new ArrayList<>();
			for(int i=2;i<=75000;i++) {
				if(prime[i]==true) {
					list.add(i);
				}
			}
			int v = 0;
			int n = list.size();
			primelist = new int[n];
			for(Integer x:list) {
				primelist[v] = x;
				v++;
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
