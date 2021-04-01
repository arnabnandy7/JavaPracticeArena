package practise.CompetitiveAPIs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileType {
	public static void main(String[] args) throws IOException{
		System.out.println("hello");
		
		Path target = Paths.get("F://planes.xml");
		System.out.println("File content type  = " +Files.probeContentType(target)); // Output is text/xml
		         
		/*target = Paths.get("C://Tulips.jpg");
		System.out.println("File content type  = " +Files.probeContentType(target)); // Output is image/jpeg
		          
		target = Paths.get("C://q.ppt");
		System.out.println("File content type  = " +Files.probeContentType(target)); // Output is application/vnd.ms-powerpoint
		         
		target = Paths.get("C://v.mp3");
		System.out.println("File content type  = " +Files.probeContentType(target)); // Output is audio/mpeg
		         
		target = Paths.get("C://s.doc");
		System.out.println("File content type  = " +Files.probeContentType(target)); // Output is application/msword
*/	}

}
