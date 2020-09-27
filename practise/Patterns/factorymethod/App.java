package practise.Patterns.FactoryMethod;

/**
 * Reference : https://www.youtube.com/watch?v=EdIwFK0gCm4
 * 
 * @author arnab
 *
 */

public class App {
	public static void main(String[] args) {
		BatchProcessor batchProcessor = createBatchProcessor("text");
		batchProcessor.processBatch("fileabc");
		System.out.println("done");
		batchProcessor = createBatchProcessor("csv");
		batchProcessor.processBatch("fileabc");
		System.out.println("done");
		batchProcessor = createBatchProcessor("xml");
		batchProcessor.processBatch("fileabc");
		System.out.println("done");
	}

	private static BatchProcessor createBatchProcessor(String arg) {
		if (arg.equals("text"))
			return new TextBatchProcessor();
		if (arg.equals("csv"))
			return new CSVBatchProcessor();
		if (arg.equals("xml"))
			return new XMLBatchProcessor();
		return null;
	}
}
