
import com.lexicalscope.jewel.cli.CliFactory;
import java.io.*;
public class Main{
    
    public static void main(String[] args) {

        CommandLine result = CliFactory.parseArguments(CommandLine.class, args);


        String entityName = result.getEntity();       // girilen entity name'i okuyor mention mi hastag mi?
        System.out.println("Entity is : " + entityName);

        int numberOfEntity = result.getNumber();
        System.out.println("Number of entity is : " + numberOfEntity + "\n"); // girilen entity sayısı 10,20,30 vs. ?

        boolean bol = result.isReverse();           // Tersten mi değil mi ?
        System.out.println("Is reversed ? : " + bol);

        boolean bol2 = result.isIgnore();          // Büyük-küçük olayı görmezden gelinsin mi gelinmesin mi ?
        System.out.println("Is ignored : ? " + bol2);

        String fileName = result.fileName();       // Bu da en son okuyacağımız text dosyasının adını dönderiyor.
         System.out.println("filename is : " + fileName);


        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line+"\n");
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }


    }

}
