package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExec {

	public static void main(String[] args) {
		ProcessBuilder processBuilder = new ProcessBuilder();
		StringBuilder cmdSb=new StringBuilder();
		cmdSb.append("python3 test.py '");
		String json="{\"server_ip\":\"123\",\"action\":\"stop\"}";
		cmdSb.append(json);
		cmdSb.append("'");

		processBuilder.command("bash", "-c", cmdSb.toString());

		try {
			Process process = processBuilder.start();
			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println(output);
				System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}