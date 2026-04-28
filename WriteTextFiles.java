
package project.h;

import java.io.*;
import java.util.*;

public class WriteTextFiles {

    private Formatter output;

    public void openFile(String fileName) {
        try {
            output = new Formatter(fileName);
        } catch (SecurityException ex) {
            System.err.println("You do not have write access to this file.");

        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");

        }
    }
    public void writeFile(Media a) {

        try {
            output.format(a.toString() + "\n----------------------------\n");
        } catch (FormatterClosedException ex) {
            System.err.println("Error writing to file");
        }
    }

    public void closeFile() {
        if (output != null) {
            output.close();

        }

    }

}
