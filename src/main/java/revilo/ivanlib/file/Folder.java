package revilo.ivanlib.file;

import revilo.ivanlib.IvanLib;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("all")
public class Folder {
    private File folder;

    public Folder(String path) {
        if (new File(path).getFile().isDirectory()) {
            folder = new File(path);
        } else {
            IvanLib.LOGGER.error("File is not a folder!");
        }
    }

    public Folder(File file) {
        if (file.getFile().isDirectory()) {
            folder = file;
        } else {
            IvanLib.LOGGER.error("File is not a folder!");
        }
    }

    public java.io.File[] getContained() {
        return folder.getFile().listFiles();
    }

    public File getFolder() {
        return folder;
    }

    public void addNewFile(String name) {
        try {
            java.io.File file = new java.io.File(folder.getFile().getPath(), name);
            file.createNewFile();
        } catch (IOException e) {
            IvanLib.LOGGER.error("Failed to create file!");
        }
    }

    public void addNewFile(String name, List<String> data) {
        try {
            File file = new File(new java.io.File(folder.getFile().getPath(), name));
            file.getFile().createNewFile();
            file.write(data);
        } catch (IOException e) {
            IvanLib.LOGGER.error("Failed to create file!");
        }
    }
}
