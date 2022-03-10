package streams.zip.files;

import java.io.IOException;
import java.util.List;
import java.util.zip.ZipFile;
import static java.util.stream.Collectors.*;

public class Program {
	//NB not bundled with project to minimise file size
	private static final String PATH_TO_DOCS = "/tmp/jdk-8u101-docs-all.zip";

	public static void main(String[] args) {
		List<String> results = null;
		
		try(ZipFile zip = new ZipFile(PATH_TO_DOCS)) {
			results = zip.stream()
						 .filter(entry -> entry.getName().startsWith("docs/api/java"))
						 .filter(entry -> entry.getName().contains("Builder"))
						 .map(entry -> entry.getName().replaceFirst(".*/", ""))
						 .map(name -> name.substring(0,name.length() - 5))
						 .collect(toList());
		} catch(IOException ex) {
			System.err.println("Whoops! " + ex.getMessage());
		}
		System.out.printf("There are %d JSE types containing the word 'Builder':\n", results.size());
		for(String result : results) {
			System.out.printf("\t%s\n", result);
		}
	}
}
