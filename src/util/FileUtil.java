package util;
import java.util.*;
import java.io.*;

public class FileUtil {
    //Reading file
    public static List<String> readFile(String fn) {
        List<String> lines=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(fn));) {   
            for(String line=br.readLine(); line!=null; line=br.readLine()) {
                lines.add(line);
            }
        }
        catch(IOException e) {
            System.out.println("Error reading the line" +fn);
        }
        return lines;
    } 
    //Writing file
    public static void writeFile(String fn, List<String> lines) {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fn))) {
            for(String sr:lines) {
                bw.write(sr);
                bw.newLine();
            }
        }
        catch(IOException e) {
            System.out.println("Error wiriting the files" +fn);
        }
    }
    //Appending file
    public static void appendFile(String fn, String line) {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fn, true))) {
            bw.write(line);
            bw.newLine();
        }
        catch(IOException e) {
            System.out.println("Error appending the files" +fn);
        }
    }
}
