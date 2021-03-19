package test.oldCompetitivePrograms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class TestClass implements Runnable {

	private boolean testCases = false;
	private RobustInput in;
	private PrintWriter out;
	
	public static void main(String[] args) throws Exception {
		new TestClass().run();
	}
	
	@Override
	public void run() {
		try {
			InputStream inputStream = System.in;
			OutputStream outputStream = System.out;
			out = new PrintWriter(outputStream);
			in = new RobustInput(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int t = testCases ? in.ni() : 1;
		while (t-- > 0) {
			findSolution();
			out.flush();
		}
	}

	public void findSolution() {

		int n = in.ni();
		long[] arr = new long[n];

		for (int i = 0; i < n; ++i) {
			arr[i] = in.nl();
		}

		int ans = 0;

		for (int i = 31; i >= 0; --i) {

			int temp = ans | (1 << i);
			int cnt = 0;
			for (int j = 0; j < n; ++j) {
				if ((temp & arr[j]) == temp) {
					cnt++;
				}
			}

			if (cnt >= 2) {
				ans = ans | (1 << i);
			}
		}

		out.println(ans);

	}

	static class RobustInput {
		InputStream obj;

		public RobustInput(InputStream obj) {
			this.obj = obj;
		}

		byte inbuffer[] = new byte[1024];
		int lenbuffer = 0, ptrbuffer = 0;

		int readByte() {
			if (lenbuffer == -1)
				throw new InputMismatchException();
			if (ptrbuffer >= lenbuffer) {
				ptrbuffer = 0;
				try {
					lenbuffer = obj.read(inbuffer);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
			}
			if (lenbuffer <= 0)
				return -1;
			return inbuffer[ptrbuffer++];
		}

		String ns() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) 
			{
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		int ni() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1
					&& !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		long nl() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1
					&& !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10L + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		boolean isSpaceChar(int c) {
			return (!(c >= 33 && c <= 126));
		}

		int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		float nf() {
			return Float.parseFloat(ns());
		}

		double nd() {
			return Double.parseDouble(ns());
		}

		char nc() {
			return (char) skip();
		}
	}

}
