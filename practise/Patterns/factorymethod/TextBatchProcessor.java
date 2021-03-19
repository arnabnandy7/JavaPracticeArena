package practise.Patterns.FactoryMethod;

import java.io.File;

public class TextBatchProcessor extends BatchProcessor{

	@Override
	public Parser createParser(File file) {
		// TODO Auto-generated method stub
		return new TextParser(file);
	}

}
