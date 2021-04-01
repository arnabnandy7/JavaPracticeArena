package test.oldCompetitivePrograms;

/* package codechef; // don't place package name! */

import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Test1
{
	@SuppressWarnings("unused")
	private void shuffle(int arr[]) {
		Random random = new Random();
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			int j = random.nextInt(arr.length);
			temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
		}
	}

	@SuppressWarnings("unused")
	private void shuffle(long arr[]) {
		Random random = new Random();
		long temp = 0;
		for (int i = 0; i < arr.length; i++) {
			int j = random.nextInt(arr.length);
			temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
		}
	}

	public static class Print {
		private final BufferedWriter bw;

		public Print() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void println(int object[]) throws IOException {
			print(Arrays.toString(object));
			bw.append("\n");
		}

		public void print(int object[]) throws IOException {
			print(Arrays.toString(object));
		}

		public void println(long object[]) throws IOException {
			print(Arrays.toString(object));
			bw.append("\n");
		}

		public void print(long object[]) throws IOException {
			print(Arrays.toString(object));
		}

		public void println(boolean object[]) throws IOException {
			print(Arrays.toString(object));
			bw.append("\n");
		}

		public void print(boolean object[]) throws IOException {
			print(Arrays.toString(object));
		}

		public void println(Object object[]) throws IOException {
			print(Arrays.deepToString(object));
			bw.append("\n");
		}

		public void print(Object object[]) throws IOException {
			print(Arrays.deepToString(object));
		}

		public void close() throws IOException {
			bw.close();
		}
	}

	static class Scan {
		private byte[] buf = new byte[1024 * 1024 * 4];
		private int index;
		private InputStream in;
		private int total;

		public Scan() {
			in = System.in;
		}

		public int scan() throws IOException {
			if (total < 0)
				throw new InputMismatchException();
			if (index >= total) {
				index = 0;
				total = in.read(buf);
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}

		public int nextInt() throws IOException {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public double nextDouble() throws IOException {
			double doub = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n) && n != '.') {
				if (n >= '0' && n <= '9') {
					doub *= 10;
					doub += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			if (n == '.') {
				n = scan();
				double temp = 1;
				while (!isWhiteSpace(n)) {
					if (n >= '0' && n <= '9') {
						temp /= 10;
						doub += (n - '0') * temp;
						n = scan();
					} else
						throw new InputMismatchException();
				}
			}
			return doub * neg;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			long c = scan();
			while (c <= ' ') {
				c = scan();
			}

			boolean neg = (c == '-');
			if (neg) {
				c = scan();
			}

			do {
				ret = ret * 10 + c - '0';
			} while ((c = scan()) >= '0' && c <= '9');

			if (neg) {
				return -ret;
			}
			return ret;
		}

		public String next() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n) || n == ' ') {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		public void next(int arr[]) throws IOException {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = nextInt();
			}
		}

		public void next(long arr[]) throws IOException {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = nextLong();
			}
		}

		public char[] next(char c) throws IOException {
			char arr[] = next().toCharArray();
			return arr;
		}

		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scan scan = new Scan();
		Print print = new Print();
		Test1 o = new Test1();
		o.solve(scan, print);
		print.close();
	}
	
	private void solve(Scan scan, Print print) throws Exception {
		int T = scan.nextInt();
		while (T-- > 0) {
			int N=scan.nextInt();
			int arr[][]=new int[N][N];
			int odd_count=1;
			int even_count=2;
			for(int i=1;i<(N+N);i++)
			{
				int s=Math.max(0,i-N);
				int count=Math.min(i,Math.min(N-s,N));
				for(int j=0;j<count;j++)
				{
					if((i&1)==1)
					{
						arr[Math.min(N,i)-j-1][s+j]=odd_count;
						odd_count+=2;
					}
					else
					{
						arr[Math.min(N,i)-j-1][s+j]=even_count;
						even_count+=2;
					}
				}
			}
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					print.print(arr[i][j]+" ");
				}
				print.println("");
			}
		}
	}
}

