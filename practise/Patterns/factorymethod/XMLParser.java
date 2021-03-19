package practise.Patterns.FactoryMethod;

import java.io.File;
import java.util.List;

public class XMLParser extends TextParser {
	public XMLParser(File file){
		System.out.println("Created XML parser");
	}
	
	@Override
	public List<Record> parse(){
		System.out.println("Parsing XML and creating records");
		return null;
	}
}
