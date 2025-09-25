package File;
import java.io.*;

public class FileWriterJava {
   

    public static void main(String[] args) throws IOException {
        
        FileWriter fw= new FileWriter("FileWriterJava.txt");
        fw.write("Hii! My name is mayur tetwar and Like coding.");
        fw.close();

    }
}
