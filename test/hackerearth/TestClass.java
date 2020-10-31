package test.hackerearth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class TestClass implements Runnable {

	private RobustInput in;
	private PrintWriter out;
	private boolean testCases = false;

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
		int t = testCases ? in.getInt() : 1;
		while (t-- > 0) {
			findSolution();
			out.flush();
		}

	}

	public void findSolution() {

		int min;
		int t = in.getInt();
		while (t-- > 0) {
			min = Integer.MAX_VALUE;
			int n = in.getInt();
			int k = in.getInt();
			for (int i = 0; i < n; ++i) {
				int temp = in.getInt();
				if (temp < min)
					min = temp;
			}
			min = k - min;
			if (min < 0)
				min = 0;
			System.out.println(min);
		}
	}

	public int findGcd(int a, int b) {
		if (a == 0)
			return b;
		return findGcd(b % a, a);
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

		String getString() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		int getInt() {
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

		long getLong() {
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

		float getFloat() {
			return Float.parseFloat(getString());
		}

		double getDouble() {
			return Double.parseDouble(getString());
		}

		char getChar() {
			return (char) skip();
		}

		void deepToString(Object... o) {
			System.out.println(Arrays.deepToString(o));
		}

		int[] getIntArray(int index) {
			int[] arr = new int[index];
			for (int i = 0; i < index; i++)
				arr[i] = getInt();
			return arr;
		}

	}

}
