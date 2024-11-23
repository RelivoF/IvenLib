package revilo.ivanlib.file;

import revilo.ivanlib.IvanLib;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class abstracts the default java class for easier use.
 */

@SuppressWarnings("all")
public class File {
    private final java.io.File file;

    public File(String path) {
        this.file = new java.io.File(path);
        if (this.file.isDirectory()) {
            IvanLib.LOGGER.info("We would recommend the Folder class for a directory.");
        }
    }

    public File(java.io.File file) {
        this.file = file;
        if (this.file.isDirectory()) {
            IvanLib.LOGGER.info("We would recommend the Folder class for a directory.");
        }
    }

    public void write(String data) {
        List<String> writeCache = new ArrayList<>();
        writeCache.add(data);
        write(writeCache);
    }

    public void write(List<String> data) {
        try {
            FileWriter writer = new FileWriter(file);
            for (String pieces : data) {
                writer.write(pieces);
            }
            writer.close();
            IvanLib.LOGGER.debug("Successfully wrote to {}.", file);
        } catch (IOException e) {
            IvanLib.LOGGER.error("Error occurred. {}", e.getMessage());
        }
    }

    public List<String> read() {
        try {
            Scanner scanner = new Scanner(file);
            List<String> data = new ArrayList<>();
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
            return data;
        } catch (FileNotFoundException e) {
            IvanLib.LOGGER.error("Error occurred. {}", e.getMessage());
            return null;
        }
    }

    public java.io.File getFile() {
        return file;
    }
}