import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
 
class RangeUpdateMinquerywithLAZY{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskAA solver = new TaskAA();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class TaskAA {
    	static long tree[];
    	static long lazy[];
    	static long a[];
    	@SuppressWarnings("unchecked")
        public void solve(int testNumber, InputReader in, PrintWriter out) {
        	int n = in.nextInt();
    		int q = in.nextInt();
    		a = new long[n];
    		tree = new long[3*n];
    		lazy = new long[3*n];
    		Arrays.fill(tree, Long.MAX_VALUE);
    		for(int i=0;i<n;i++)a[i] = in.nextLong();
    		build(0,0,n - 1);
    	
    		for(int i=1;i<=q;i++) {
    			char t = in.next().toCharArray()[0];
    			if(t=='u') {
    				int l = in.nextInt();
    				int r = in.nextInt();
    				long val = in.nextLong();
    				update(0,0,n - 1,l-1,r-1,val);
    			} 
    			else {
    				int l = in.nextInt();
    				int r = in.nextInt();
    				out.println(query(0,0, n - 1, l-1,r - 1));
     			}
    		}
    		out.close();
    	}
 
    	public static void build(int node,int start,int end) {
    		if(start==end) {
    			tree[node] = a[start];
    		}
    		else {
    			int mid = start+(end-start)/2;
    			build(2*node+1,start,mid);
    			build(2*node+2,mid+1,end);
    			tree[node] = Math.min(tree[node*2+1],tree[node*2+2]);
    		}
    	}
    	public static void update(int node,int start,int end,int l,int r,long val) {
    		if(lazy[node]!=0) {
    			tree[node]+=lazy[node];
    			if(start!=end) {
    				lazy[2*node+1]+=lazy[node];
    				lazy[2*node+2]+=lazy[node];
    			}lazy[node]=0;
    		}
    		if(start>end || start>r || end<l || start>end || l>r)return;
    		if(start>=l && end<=r) {
        		tree[node]+=val;
        		if(start!=end) {
        			lazy[2*node+1]+=val;
       				lazy[2*node+2]+=val;
       			}
       			return;
    		}
    		
            int mid = start+(end-start)/2;
            update(2*node+1,start,mid,l,r,val);
    		update(2*node+2,mid+1,end,l,r,val);
    		tree[node]= Math.min(tree[node*2+1],tree[node*2+2]);
    	}
    	public static long query(int node,int start,int end,int l,int r) {
    		if(lazy[node]!=0) {
    			tree[node]+=lazy[node];
    			if(start!=end) {
    				lazy[2*node+1]+=lazy[node];
    				lazy[2*node+2]+=lazy[node];
    			}lazy[node]=0;
    		}
    		if(l>r || start>end || r<start || l>end) {
    			return Integer.MAX_VALUE;
    		}
    		if(l<=start && end<=r || start==end) {
    			return tree[node];
    		}
    		int mid = start+(end-start)/2;
    		long x = query(2*node+1,start,mid,l,r);
    		long y = query(2*node+2,mid+1,end,l,r);
    		return Math.min(x,y);
    	}
    }
    
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
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
