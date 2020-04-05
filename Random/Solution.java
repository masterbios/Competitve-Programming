import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author masterbios
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            char ans[] = new char[n];
            int a[][] = new int[n][3];
            for (int i = 0; i < n; i++) {
                a[i][0] = in.nextInt(); // start time
                a[i][1] = in.nextInt(); // end time
                a[i][2] = i;
            }
            Arrays.sort(a, (o1, o2) -> o1[1] - o2[1]); // sort by ascending order of end time
            int cend = Integer.MIN_VALUE, jend = -1;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int curs = a[i][0];
                if (curs >= cend && curs >= jend) {
                    if (cend > jend) {
                        cend = a[i][1];
                        ans[a[i][2]] = 'C';
                    } else {
                        jend = a[i][1];
                        ans[a[i][2]] = 'J';
                    }
                } else if (curs >= cend) {
                    cend = a[i][1];
                    ans[a[i][2]] = 'C';
                } else if (curs >= jend) {
                    jend = a[i][1];
                    ans[a[i][2]] = 'J';
                } else {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            } else {
                out.print("Case #" + testNumber + ": ");
                for (char c : ans) out.print(c);
                out.println();
            }
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

    }
}

