
package project.h;

import java.io.*;
import java.util.*;

public class ReadTextFiles {

    private Scanner input;

    public void openFile(String fileName) {
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file");
        }
    }

    public void readFile() {
        try {
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        } catch (NoSuchElementException ex) {
            System.err.println("File improperly formed");
            input.close();
        } catch (IllegalStateException ex) {
            System.err.println("Error reading from file");
             }
    }

    public void closeFile() {
        if (input != null) {
            input.close();
 

}
        }
    }


    
    
    
    
    
    

