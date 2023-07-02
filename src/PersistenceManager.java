// import java.io.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class PersistenceManager {
    private final String PERSISTENCE_FILE_PATH = "Resources/PersistenceConfig.txt";


    public PersistenceManager() {

    }

    // Reads a file, returns a string of read data. Does not account for new lines. Catches errors
    private String readFile(String fileToRead) {
        // Initialize Temporary Variables
        int ch;
        String out = "";
        FileReader reader = null;

        // Read File, Catch Errors
        try {
            reader = new FileReader(fileToRead);

            while ((ch=reader.read())!=-1) {
                out += (char)(ch);
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }

        // Return string of read chars;
        return out;
    }

    // Writes specified text to specified file. Catches errors
    private void writeFile(String fileToWrite, String textToWrite) {
        // Initialize Temporary Variables
        int ch;

        // Write to File, Catch Errors
        try {
            FileWriter writer = new FileWriter(fileToWrite);

            for (int i = 0; i < textToWrite.length(); i++) {
                writer.write(textToWrite.charAt(i));
            }

            writer.flush();
            writer.close();
        } catch (FileNotFoundException notFound) {

        } catch (IOException ioExec) {

        }
    }

    // Clears a file, catches errors
    private void clearFile(String fileToClear) {
        try{
            FileWriter fw = new FileWriter(fileToClear, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
        } catch(IOException exc){

        }
    }

}
