package com.lm.utils;

import com.lm.DirectoryProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileFunctions {

    private DirectoryProperties directory;

    @Autowired
    public void setDirectory(DirectoryProperties directory) {
        this.directory = directory;
    }

    public String testReadFile() {
        StringBuilder result = null;
        String fileName = directory.getRoot() + "\\filename.txt";
        BufferedReader br = null;
        FileReader fr = null;
        try {
            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                result.append(sCurrentLine);
                result.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }
}
