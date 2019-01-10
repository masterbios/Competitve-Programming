import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

class RangeMaxQuerywithRangeUpdate {
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
    	static final int max= (int)1e6*2+1;
    	static int tree[];
    	static int a[];
        public void solve(int testNumber, InputReader in, PrintWriter out) {
        	tree = new int[max];
        	int n = in.nextInt();
        	a = new int[n];
        	for(int i=0;i<n;i++)a[i]=in.nextInt();
        	build(0,0,n-1);
        	int q = in.nextInt();
        	for(int i=1;i<=q;i++) {
        		int type = in.nextInt();
        		if(type==0) {
        			int l = in.nextInt()-1;
        			int r = in.nextInt()-1;
        			int val = in.nextInt();
        			update(0,0,n-1,l,r,val);
        		}
        		else {
        			int l = in.nextInt()-1;
        			int r = in.nextInt()-1;
        			int rews = query(0,0,n-1,l,r);
        			out.println(rews);
        		}
        	}
        	for(int i=0;i<n*5;i++)out.print(tree[i]+" ");
        }
        public void build(int node,int start,int end) {
        	if(start ==end) {
        		tree[node]=a[start];
        	}
        	else {
        		int mid = (start+end)>>1;
        		build(2*node+1,start,mid);
        		build(2*node+2,mid+1,end);
        		tree[node]= Math.max(tree[2*node+1], tree[2*node+2]);
        	}
        }
        public int query(int node,int start,int end,int l,int r) {
        	if(start>end|| start>r || end<l )return Integer.MIN_VALUE;
        	if(start>=l && end<=r)return tree[node];
        	int mid = (start+end)>>1;
        	int x = query(2*node+1,start,mid,l,r);
        	int y = query(2*node+2,mid+1,end,l,r);
        	return Math.max(x, y);
        }
        public void update(int node,int start,int end,int l,int r,int val) {
        	if(start>r || end<l  || start>end)return;
        	if(start>=l && end<=r) {
        		tree[node]=val;
        		if(start!=end) {
        			tree[2*node+1]=val;
        			tree[2*node+2]=val;
        		}
        		return;
        	}
        	int mid = (start+end)>>1;
        	update(2*node+1,start,mid,l,r,val);
        	update(2*node+2,mid+1,end,l,r,val);
        	tree[node] = Math.max(tree[2*node+1], tree[2*node+2]);
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
