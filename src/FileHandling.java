import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class FileHandling {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);

			System.out.println("Enter File name to create file:");
			String fileName=sc.nextLine();
			
			Path path = Paths.get("./"+fileName);
			if(Files.exists(path))
				System.out.println("File already presnt with specified name in directory, you can directly append text");
			else {
			  Files.createFile(path);
			  System.out.println("File created at "+path);
			}
			
			System.out.println("\nEnter Test to append in file");
			String textToAppend =sc.nextLine();
			Files.write(path, textToAppend.getBytes(), StandardOpenOption.APPEND); 
			
			System.out.println("\nReading content of file");
			List<String> contents = Files.readAllLines(path);
			 
			for(String content:contents){
				System.out.println(content);
			}
			
			System.out.println("-------------------------------------------------------------------");
			System.out.println();
	}
}
