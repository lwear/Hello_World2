package HelloWorld;
/***************************************************************************
 Name: evenOddGame
 Author: Abou and Luca
 Date: Nov. 22, 2017
 Purpose: To reach either an even or odd number as the final number.
 ****************************************************************************/
import java.io.*;

public class Main {


    public static void main(String[] args) {

        int length = 0;
        String [] fileContents = getFileContents("nums.txt");
        for (int i = 0; i < fileContents.length; i++) {
            System.out.println(fileContents[i]);
        }
        writeArrayToFile("output.txt", fileContents);

    } // main

    //  reads fileName and returns the contents as String array
    //  with each line of the file as an element of the array
    public static String [] getFileContents(String fileName){

        String [] contents = null;
        int length = 0;
        try {

            // input
            //BufferedReader in = new BufferedReader(new FileReader(fileName));
            String resource = fileName;
            String folderName = ""; // if the file is contained in the same folder as the .class file, make this equal to the empty string

            // this is the path within the jar file
            InputStream input = Main.class.getResourceAsStream(folderName + resource);
            if (input == null) {
                // this is how we load file within editor (eg eclipse)
                input = Main.class.getClassLoader().getResourceAsStream(resource);
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(input));



            in.mark(Short.MAX_VALUE);  // see api

            // count number of lines in file
            while (in.readLine() != null) {
                length++;
            }

            in.reset(); // rewind the reader to the start of file
            contents = new String[length]; // give size to contents array

            // read in contents of file and print to screen
            for (int i = 0; i < length; i++) {
                contents[i] = in.readLine();
            }
            in.close();
        } catch (Exception e) {
            System.out.println("File Input Error");
        }

        return contents;

    } // getFileContents

    // writes the array a to fileName, one array element per line in the file
    public static void writeArrayToFile(String fileName, String [] a) {
        try {

            // output file pointer
            /*String resource = fileName;
            String folderName = ""; // if the file is contained in the same folder as the .class file, make this equal to the empty string

            // this is the path within the jar file
            OutputStream output = Main.class.getResourceAsStream(folderName + resource);
            if (output == null) {
                // this is how we load file within editor (eg eclipse)
                output = Main.class.getClassLoader().getResourceAsStream(resource);
            }
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(output));*/
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

            // write array to file
            for (int i = 0; i < a.length; i++) {
                out.write(a[i]+ "");
                out.newLine(); // adds new line to file
            } // for

            out.close();

        } catch (Exception e) {
            System.out.println("File Output Error");
        }

    } // writeArrayToFile


}  // FileInputOutput






