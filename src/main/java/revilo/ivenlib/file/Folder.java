package revilo.ivenlib.file;

import revilo.ivenlib.IvenLib;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("all")
public class Folder {
    private File folder;

    public Folder(String path) {
        if (new File(path).getFile().isDirectory()) {
            folder = new File(path);
        } else {
            IvenLib.LOGGER.error("File is not a folder!");
        }
    }

    public Folder(File file) {
        if (file.getFile().isDirectory()) {
            folder = file;
        } else {
            IvenLib.LOGGER.error("File is not a folder!");
        }
    }

    public Folder(java.io.File file) {
        if (file.isDirectory()) {
            folder = new File(file);
        } else {
            IvenLib.LOGGER.error("File is not a folder!");
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
            IvenLib.LOGGER.error("Failed to create file!");
        }
    }

    public void addNewFile(String name, List<String> data) {
        try {
            File file = new File(new java.io.File(folder.getFile().getPath(), name));
            file.getFile().createNewFile();
            file.write(data);
        } catch (IOException e) {
            IvenLib.LOGGER.error("Failed to create file!");
        }
    }
}
