//package March16;	

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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
5
-1 0 0 1 1
1

 */
public class leafcountandformingtree {
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
		static Node root;
		public void solve(InputReader in,PrintWriter out) {	
			Call tree = new Call();
			int n = in.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)a[i]=in.nextInt();
			int delete = in.nextInt();
			a[delete]=-2;
			int search = delete;
			Queue<Integer> q = new LinkedList<>();
			q.add(delete);
			while(q.size()>0) {
				for(int i=0;i<n;i++) {
					if(a[i]==q.peek()) {
						q.add(i);
						a[i]=-2;
					}
				}
				q.poll();
			}
			Node node = tree.createtree(a);
			out.println(getleaf());
		}
		public int getleaf() {
			return getleaf(root);
		}
		public int getleaf(Node node) {
			if(node==null)return 0;
			if(node.left==null && node.right==null)return 1;
			else return getleaf(node.left)+getleaf(node.right);
		}
		Node createtree(int parent[]) {
			Node created[]=new Node[parent.length];
			for(int i=0;i<parent.length;i++)created[i]=null;
			for(int i=0;i<parent.length;i++) {
				if(parent[i]!=-2)createNode(parent,i,created);
			}
			
			return  root;
		}
		public void createNode(int parent[],int i,Node created[]) {
			if(created[i]!=null )return;
			created[i]=new Node(i);
			if(parent[i]==-1) {
				root=created[i];
				return;
			}
			if(created[parent[i]]==null) {
				createNode(parent,parent[i],created);
			}
			Node p = created[parent[i]];
			if(p.left==null)p.left=created[i];
			else p.right=created[i];
		}
		static class Node{
			int key;
			Node left;
			Node right;
			public Node(int key) {
				this.key = key;
				left = right = null;
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
