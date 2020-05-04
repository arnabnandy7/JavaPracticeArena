package practise.Patterns.factorymethod;

import java.io.File;
import java.util.List;

public class CSVParser extends TextParser {
	public CSVParser(File file){
		System.out.println("Created CSV parser");
	}
	
	@Override
	public List<Record> parse(){
		System.out.println("Parsing CSV values");
		return null;
	}
}
