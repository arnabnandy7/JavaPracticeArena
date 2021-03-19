package practise.Patterns.FactoryMethod;

import java.io.File;
import java.util.List;

public abstract class BatchProcessor {
	public final void processBatch(String fileName){
		File file = openFile(fileName);
		Parser parser = createParser(file);//Factory method
		List<Record> records=parser.parse();
		processRecords(records);
		writeSummary();
		closeFile(file);
	}

	// FACTORY METHOD
	public abstract Parser createParser(File file);

	private void closeFile(File file) {
		System.out.println("Closed file");
	}

	private void writeSummary() {
		System.out.println("Wrote batch summary - 0 failed.");
	}

	private void processRecords(List<Record> records) {
		System.out.println("Processing each record..db calls, etc.");
	}

	private File openFile(String fileName) {
		System.out.println("Opened file..");
		return null;
	}
	
	
}
