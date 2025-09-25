package File;
import java.io.*;

public class FileReaderJava {
    public static void main(String[] args) throws IOException {
      FileReader fr=new FileReader("FileWriterJava.txt");
      int i;
      while((i=fr.read())!= -1){
        System.out.print((char)i);
      }
      fr.close();
    }
}
