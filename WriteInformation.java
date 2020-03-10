import java.util.*;
import java.io.*;
import java.awt.*;

public class WriteInformation {
   public static void main(String[] args) throws FileNotFoundException, IOException {
      Scanner input = new Scanner(System.in);
      introMessage();
      File file = new File("C:\\Program Files\\VeraCrypt\\VeraCrypt.exe");
      Desktop.getDesktop().open(file);
      String fileName = getFileName(input);
      PrintStream output = new PrintStream(new File(fileName));
      ArrayList<String> entries = getDetails(input, output);
      outputTo(entries, output);
   }
   
   public static void introMessage() {
      System.out.println("Important information entered here will be stored");
      System.out.println("in a txt file in a secure location.");
      System.out.println("** enter 's' in both field name and detail for that field to exit **");
      System.out.println();
   }
   
   public static String getFileName(Scanner input) {
      System.out.print("Enter output file name (excluding .txt): ");
      String fileName = input.nextLine();
      fileName = "X:\\" + fileName + ".txt";
      return fileName;
   }
   
   public static ArrayList<String> getDetails(Scanner input, PrintStream output) {
      ArrayList<String> entries = new ArrayList<String>();
      System.out.print("Enter a field name (s to stop): ");
      String field = input.nextLine();
      System.out.print(field + ": ");
      String detail = input.nextLine();
      addToArray(field, detail, entries);
      while (!(field.equalsIgnoreCase("s")) || !(detail.equalsIgnoreCase("s"))) {
         System.out.print("Enter a field name (s to stop): ");
         field = input.nextLine();
         System.out.print(field + ": ");
         detail = input.nextLine();
         addToArray(field, detail, entries);
      }
      return entries;
   }
   
   public static void addToArray(String field, String detail, ArrayList<String> entries) {
      entries.add(field);
      entries.add(detail);
   }
   
   public static void outputTo(ArrayList<String> entries, PrintStream output) {
      for (int i = 0; i < entries.size() - 2; i++) {
         output.println(entries.get(i));
      }
   }
}