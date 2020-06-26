package cz.cvut.fit.plyskand.main.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    private String fileName;

    public InputReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> read (){
        List<String> lines = new ArrayList<String>();
        try {
            InputStream input = new FileInputStream(fileName);
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                lines.add(line);
            }
        }  catch (IOException e){
            System.out.println("Invalid input! " + e.getMessage());
        }

        return lines;
    }
}
