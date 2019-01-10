
class Fenwick {

public static void main(String args[]){

    int n = in.nextInt();
    int a[] = new int[n+1];
    
    for(int i=1;i<=n;i++){
      a[i] = in.nextInt();
      update(i,a[i]);
    }
    
    int l = in.nextInt();
    int r = in.nextInt();
    
    out.println(query(r)-query(l-1));
  }
  
  public void update(int x,int val){
    for(;x<=n;x+=x&-x){
      bit[x]+=val;
    }
  }

  public int query(int x){
    int sum = 0;
     for(;x>0;x-=x&-x){
      sum+=bit[x];
    }
  }
  
}
