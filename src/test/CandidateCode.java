package test;

import java.util.Scanner;

public class CandidateCode {

	String str;
	int bulls;
	int cows;
	static int numberOfClues;
	static CandidateCode[] word;

	CandidateCode(String s, int b, int c) {
		str = s;
		bulls = b;
		cows = c;
	}

	public CandidateCode() {
	}

	boolean isCorrect(String str2) {
		int bulls2 = 0;
		int cows2 = 0;
		String str1 = str;

		for (int i = 0; i < 4; i++) {
			if (str1.charAt(i) == str2.charAt(i)) {
				bulls2++;
				str2 = deleteChar(str2, i);
				str1 = deleteChar(str1, i);
			}
		}

		for (int i = 0; i < 4; i++) {
			char ver = str1.charAt(i);
			int pos = str2.indexOf(ver);
			if (ver == '.')
				pos = -1;
			if (pos != -1) {
				cows2++;
				str2 = deleteChar(str2, pos);
				str1 = deleteChar(str1, i);
			}
		}
		return ((bulls == bulls2) && (cows == cows2));
	}

	String deleteChar(String str, int pos) {
		return (str.substring(0, pos) + "." + str.substring(pos + 1));
	}

	void checkParameter(String str) {
		boolean done = true;
		for (int i = 0; i < numberOfClues; i++) {
			if (!word[i].isCorrect(str)) {
				done = false;
			}
		}

		if (done) {
			System.out.println(str);
		}
	}

	void ghostProtocol(String str) {

		if (str.length() == 4) {
			checkParameter(str);
			return;
		}

		for (int i = 0; i < 4; i++)
			ghostProtocol(str + ((char) (i + 'A')));
	}

	void getData() {
		Scanner input = new Scanner(System.in);
		numberOfClues = input.nextInt();

		word = new CandidateCode[numberOfClues];

		String clueword;
		int BULL;
		int COW;
		for (int i = 0; i < numberOfClues; i++) {
			clueword = input.next();
			BULL = input.nextInt();
			COW = input.nextInt();
			word[i] = new CandidateCode(clueword, BULL, COW);
		}
		if (input != null)
			input.close();
	}

	public static void main(String[] s) {
		CandidateCode candidateCode = new CandidateCode();
		candidateCode.getData();
		candidateCode.ghostProtocol("");
	}
}
