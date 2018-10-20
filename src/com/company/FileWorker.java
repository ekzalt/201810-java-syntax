package com.company;

import java.io.*;

public class FileWorker {
    private String filePath;

    FileWorker(String filePath) {
        this.filePath = filePath;
    }

    public void writeFile() {
        PrintWriter writer = null;

        try {
            File file = new File(filePath);

            if(!file.exists()) file.createNewFile();

            writer = new PrintWriter(file);
            writer.println("first line");
            writer.println("last line");
            writer.close();
        } catch (IOException error) {
            System.out.println(error);
        } finally {
            if (writer != null) writer.close();
        }
    }

    public void readFile() {
        FileReader fReader = null;
        BufferedReader bReader = null;

        try {
            fReader = new FileReader(filePath);
            bReader = new BufferedReader(fReader);

            String line;

            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException error) {
            System.out.println(error);
        } finally {
            try {
                if (fReader != null) fReader.close();
                if (bReader != null) bReader.close();
            } catch (IOException error) {
                System.out.println(error);
            }
        }
    }
}
