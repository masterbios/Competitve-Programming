
import java.util.List;
import java.util.ArrayList;

public class PermuteAnArray {

  static List<String> list = new ArrayList<>();

  public static void main(String args[]) {
	
    long start = System.currentTimeMillis();
		String str = "ABA";
		char []s = str.toCharArray();
		permute(s, 0, s.length);
		long e = System.currentTimeMillis() - start;
		for(String x: list) {
			System.out.println(x);
		}
		System.out.println(e + " ms");
	}
  
	public void permute(char a[], int l, int r) {
            if (l == r) {
                list.add(String.valueOf(a));
            } else {
                for (int i = l; i < r; i++) {
                    boolean check = shouldswap(a, l, i);
                    if (check) {
                        a = swap(a, l, i);
                        permute(a, l + 1, r);
                        a = swap(a, l, i);
                    }
                }
            }
        }

        public boolean shouldswap(char s[], int l, int r) {
            for (int i = l; i < r; i++) {
                if (s[i] == s[r]) return false;
            }
            return true;
        }

        public char[] swap(char s[], int l, int r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            return s;

        }
}
